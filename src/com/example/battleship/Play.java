package com.example.battleship;


import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Play extends Activity implements OnClickListener {
	final Context context = this;
	int i,j,pozi,pozj,contP=0,contC=0;
	Button matrixP[][] = new Button[4][4];
	Button matrixC[][] = new Button[4][4];
	int auxP[] = new int[16];
	int auxC[] = new int[16];
	int player[][] = new int[4][4];
	int computer[][] = new int[4][4];
	String playername;
	TextView text_player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		Bundle extras = getIntent().getExtras(); 
		auxP= extras.getIntArray("player");
		auxC= extras.getIntArray("computer");
	    playername = extras.getString("playername");
	    text_player = (TextView) findViewById(R.id.textView2);
	    text_player.setText(playername);
		
		
		for(i=0;i<4;++i)
        	for(j=0;j<4;++j){
        		player[i][j] = auxP[4*i+j];
        		computer[i][j] = auxC[4*i+j];
        	}
	    
		for(i=0;i<4;++i)
        	for(j=0;j<4;++j){
        		matrixP[i][j]=(Button) findViewById(R.id.b11+i*4+j);
        		matrixP[i][j].setEnabled(false);
        		if(player[i][j]==1) 
        			matrixP[i][j].setBackgroundColor(-16776961);
        		matrixC[i][j]=(Button) findViewById(R.id.a11+i*4+j);
        		matrixC[i][j].setTag(R.id.coord_x, i);
        		matrixC[i][j].setTag(R.id.coord_y, j);
        		matrixC[i][j].setOnClickListener(this);
        	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	
	 @Override
	    public void onClick(View v) {
		 	pozi = (Integer) v.getTag(R.id.coord_x);
		 	pozj = (Integer) v.getTag(R.id.coord_y);
		 	if(computer[pozi][pozj]==1){
		 		matrixC[pozi][pozj].setBackgroundColor(-16711936);
		 		matrixC[pozi][pozj].setEnabled(false);
		 		++contP;
		 		if(contP == 5){
		 		//	Toast toast=Toast.makeText(getApplicationContext(),"You Won! Game Over!",Toast.LENGTH_LONG);
        		//	toast.show();
        			for(i=0;i<4;++i)
        	        	for(j=0;j<4;++j)
        	        		matrixC[i][j].setEnabled(false);
		 			final Dialog dialog = new Dialog(context);
		 			dialog.setContentView(R.layout.custom);
		 			dialog.setTitle("Congrats !");
		 			
		 			TextView text = (TextView) dialog.findViewById(R.id.win_text);
		 			text.setText(playername + " won!");
		 			Button win_btn = (Button) dialog.findViewById(R.id.win_btn);
		 			
		 			win_btn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
		 			dialog.show();
		 		}
		 	}
		 	else{
		 		matrixC[pozi][pozj].setBackgroundColor(-65536);
		 		matrixC[pozi][pozj].setEnabled(false);
		 	}
		 	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	Random rand = new Random();
    		int nx = rand.nextInt(100) % 4, ny = rand.nextInt(100) % 4;
    		while(player[nx][ny]!=1&&player[nx][ny]!=0){
    			nx = rand.nextInt(100) % 4; ny = rand.nextInt(100) % 4;
    		}
    			
    		if(player[nx][ny]==1){
		 		matrixP[nx][ny].setBackgroundColor(-16711936);
		 		player[nx][ny]=2;
		 		++contC;
		 		if(contC == 5){
		 			
		 			//Toast toast=Toast.makeText(getApplicationContext(),"Computer Won! Game Over!",Toast.LENGTH_LONG);
        			//toast.show();
        			for(i=0;i<4;++i)
        	        	for(j=0;j<4;++j)
        	        		matrixC[i][j].setEnabled(false);
		 			final Dialog dialog = new Dialog(context);
		 			dialog.setContentView(R.layout.custom);
		 			dialog.setTitle("Poor you!");
		 			
		 			TextView text = (TextView) dialog.findViewById(R.id.win_text);
		 			text.setText("Computer won!");
		 			Button win_btn = (Button) dialog.findViewById(R.id.win_btn);
		 			
		 			win_btn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					}); 
		 			dialog.show();
		 			
		 		}
		 	}
		 	else
		 		if(player[nx][ny]==0){
		 			matrixP[nx][ny].setBackgroundColor(-65536);
		 			player[nx][ny]=3;
		 		}
		 }


}
