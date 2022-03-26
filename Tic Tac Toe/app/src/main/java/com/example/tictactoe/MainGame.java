package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainGame extends AppCompatActivity implements View.OnClickListener{

    private TextView playerOneScore, playerTwoScore, playerStatus,playerOneName, playerTwoName;
    private Button[] buttons = new Button[9];
    private Button resetGame;

    private int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    String p1_name_label;
    String p2_name_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        getSupportActionBar().hide(); //hide action bar

        playerOneScore = (TextView) findViewById(R.id.playerOneScore);
        playerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
        playerStatus = (TextView) findViewById(R.id.playerStatus);

        playerOneName = (TextView) findViewById(R.id.playerOne);
        playerTwoName = (TextView) findViewById(R.id.playerTwo);

        resetGame = (Button) findViewById(R.id.resetGame);

        //getting the names from Player_info
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            p1_name_label = (String) b.get("p1_name");
            p2_name_label = (String) b.get("p2_name");

            playerOneName.setText(p1_name_label);
            playerTwoName.setText(p2_name_label);
        }

        for(int i = 0; i < buttons.length; i++){
            String buttonId = "btn_" + i;
            int resourceId = getResources().getIdentifier(buttonId, "id", getPackageName());
            buttons[i] =  (Button) findViewById(resourceId);
            buttons[i].setOnClickListener(this);
        }

        roundCount = 0;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        activePlayer = true;

    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1, buttonID.length()));

        if(activePlayer){
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#F0A500"));
            gameState[gameStatePointer] = 0;
        }else{
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#D885A3"));
            gameState[gameStatePointer] = 1;
        }
        roundCount++;

        if(checkWinner()){
            if(activePlayer){
                playerOneScoreCount++;
                updatePlayerScore();
                Toast.makeText(this,p1_name_label +" Won!", Toast.LENGTH_SHORT).show();
                playAgain();
            }else{
                playerTwoScoreCount++;
                updatePlayerScore();
                Toast.makeText(this,p2_name_label+" Won!", Toast.LENGTH_SHORT).show();
                playAgain();
            }
        }else if (roundCount == 9){
            playAgain();
            Toast.makeText(this,"Draw!", Toast.LENGTH_SHORT).show();
        }else{
            activePlayer = !activePlayer;
        }

        if(playerOneScoreCount > playerTwoScoreCount){
            playerStatus.setText(p1_name_label +" is Winning!");
        }else if(playerTwoScoreCount > playerOneScoreCount){
            playerStatus.setText(p2_name_label +" is Winning!");
        }else{
            playerStatus.setText("");
        }

        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
                playerOneScoreCount = 0;
                playerTwoScoreCount = 0;
                playerStatus.setText("");
                updatePlayerScore();
            }
        });
    }

    public boolean checkWinner(){
        boolean winnerResult = false;

        for(int [] winningPosition: winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2) {
                winnerResult = true;
            }
        }
        return winnerResult;
    }

    public void updatePlayerScore(){
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void playAgain(){
        roundCount = 0;
        activePlayer = true;
        for(int i = 0; i< buttons.length; i++){
            gameState[i] = 2;
            buttons[i].setText("");
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setIcon(R.drawable.ic_action_warning)
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(MainGame.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }).create().show();
    }
}
