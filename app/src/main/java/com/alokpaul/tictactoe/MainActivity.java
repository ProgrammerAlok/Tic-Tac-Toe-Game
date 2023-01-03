package com.alokpaul.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.textView2)).setText("X's turn");

    }


    /*
        2 = null
        1 = X
        0 = O
     */

    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] WinPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int activeplayer = 1;
    boolean gameisactive = true;
    int c=0;

    public void Player(View view){
        if(gameisactive){
            ImageView imageView = (ImageView) view;
            int index = Integer.parseInt(imageView.getTag().toString());
            if(gamestate[index]==2){
                gamestate[index] = activeplayer;
                imageView.setTranslationY(-1000f);
                if(activeplayer==1){
                    activeplayer=0;
                    imageView.setImageResource(R.drawable.x);
                    TextView status = findViewById(R.id.textView2);
                    status.setText("O's turn");
                }
                else {
                    activeplayer=1;
                    imageView.setImageResource(R.drawable.o);
                    TextView status = findViewById(R.id.textView2);
                    status.setText("X's turn");
                }
                imageView.animate().translationYBy(1000f).setDuration(300);

                for (int[] winposition: WinPositions) {
                    if((gamestate[winposition[0]] == gamestate[winposition[1]]) && (gamestate[winposition[2]] == gamestate[winposition[1]]) && gamestate[winposition[1]] != 2){
                        if(gamestate[winposition[0]]==0){
                            ((TextView)findViewById(R.id.textView2)).setText("O has won the game");
                        }
                        else {
                            ((TextView)findViewById(R.id.textView2)).setText("X has won the game");
                        }
                        gameisactive=false;
                    }
                }
                
                
                c++;
                if(c>8){
                    gameisactive=false;
                }

            }
            else {
                Toast.makeText(this, "This is already filled", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Reset for play again", Toast.LENGTH_SHORT).show();
        }
    }

    public void gameReset(View view){
        Toast.makeText(this, "Resetting game....", Toast.LENGTH_SHORT).show();
        gameisactive = true;
        c=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

    }

}