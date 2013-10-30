package com.example.battleship;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	int i,j;
	int pozi=0,pozj=0;
	int player[][] = new int[4][4];
	int computer[][] = new int[4][4];
	Button matrix[][] = new Button[4][4];
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button v2 = (Button) findViewById(R.id.button1);
        final Button o2 = (Button) findViewById(R.id.button2);
        final Button v3 = (Button) findViewById(R.id.button3);
        final Button o3 = (Button) findViewById(R.id.button4);
        final Button go = (Button) findViewById(R.id.GO);
        for(i=0;i<4;++i)
        	for(j=0;j<4;++j){
        		matrix[i][j]=(Button) findViewById(R.id.a11+i*4+j);
        		matrix[i][j].setTag(R.id.coord_x, i);
        		matrix[i][j].setTag(R.id.coord_y, j);
        		matrix[i][j].setOnClickListener(this);
        	}
        go.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Random rand = new Random();
        		int nx = rand.nextInt(100) % 4, ny = rand.nextInt(100) % 4, or = rand.nextInt(100) % 2;
        		while(true){
        			if(or==0 && computer[nx][ny]==0 && ny<3 && computer[nx][ny+1]==0){
        				computer[nx][ny]=1; 
        				computer[nx][ny+1]=1;
        				break;
        			}
        			if(or==1 && computer[nx][ny]==0 && nx<3 && computer[nx+1][ny]==0){
        				computer[nx][ny]=1; 
        				computer[nx+1][ny]=1;
        				break;
        			}
        			nx = rand.nextInt(100) % 4;
        			ny = rand.nextInt(100) % 4;	
        			or = rand.nextInt(100) % 2;
        				
        		}
        		nx = rand.nextInt(100) % 4;
    			ny = rand.nextInt(100) % 4;	
    			or = rand.nextInt(100) % 2;
        		while(true){
        			if(or==0 && computer[nx][ny]==0 && ny<2 && computer[nx][ny+1]==0 && computer[nx][ny+2]==0){
        				computer[nx][ny]=1; 
        				computer[nx][ny+1]=1;
        				computer[nx][ny+2]=1;
        				break;
        			}
        			if(or==1 && computer[nx][ny]==0 && nx<2 && computer[nx+1][ny]==0 && computer[nx+2][ny]==0){
        				computer[nx][ny]=1; 
        				computer[nx+1][ny]=1;
        				computer[nx+2][ny]=1;
        				break;
        			}
        			nx = rand.nextInt(100) % 4;
        			ny = rand.nextInt(100) % 4;	
        			or = rand.nextInt(100) % 2;
        		}
        		
        		Intent intent = new Intent(getApplicationContext(), Play.class);
        		int[] auxP = new int[16];
        		int[] auxC = new int[16];
        		for(i=0;i<4;++i)
                	for(j=0;j<4;++j){
                		auxP[4*i+j] = player[i][j];
                		auxC[4*i+j] = computer[i][j];
                	}
        		Bundle extras = getIntent().getExtras(); 
        		String playername = extras.getString("playername");
        		
        		intent.putExtra("player", auxP);
        		intent.putExtra("computer", auxC);
        		intent.putExtra("playername", playername);
        		
        		startActivity(intent);
        	}
        });
        
        v2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		if(player[pozi][pozj]==1 || pozi==3 || player[pozi+1][pozj]==1){
        			Toast toast=Toast.makeText(getApplicationContext(),"Invalid click",Toast.LENGTH_LONG);
        			toast.show();
        			
        		}
        		else{
        			player[pozi][pozj]=1;
        			player[pozi+1][pozj]=1;
        			matrix[pozi][pozj].setBackgroundColor(-16776961);
        			matrix[pozi+1][pozj].setBackgroundColor(-16776961);
        			v2.setEnabled(false);
        			o2.setEnabled(false);
        		}
        			
        	}
        });
        
        o2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		if(player[pozi][pozj]==1 || pozj==3 || player[pozi][pozj+1]==1){
        			Toast toast=Toast.makeText(getApplicationContext(),"Invalid click",Toast.LENGTH_LONG);
        			toast.show();
        		}
        		else{
        			player[pozi][pozj]=1;
        			player[pozi][pozj+1]=1;
        			matrix[pozi][pozj].setBackgroundColor(-16776961);
        			matrix[pozi][pozj+1].setBackgroundColor(-16776961);
        			v2.setEnabled(false);
        			o2.setEnabled(false);
        		}
        			
        	}
        });
        
        v3.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		if(player[pozi][pozj]==1 || pozi>=2 || player[pozi+1][pozj]==1 || player[pozi+2][pozj]==1){
        			Toast toast=Toast.makeText(getApplicationContext(),"Invalid click",Toast.LENGTH_LONG);
        			toast.show();
        		}
        		else{
        			player[pozi][pozj]=1;
        			player[pozi+1][pozj]=1;
        			player[pozi+2][pozj]=1;
        			matrix[pozi][pozj].setBackgroundColor(-16776961);
        			matrix[pozi+1][pozj].setBackgroundColor(-16776961);
        			matrix[pozi+2][pozj].setBackgroundColor(-16776961);
        			v3.setEnabled(false);
        			o3.setEnabled(false);
        		}
        			
        	}
        });
        
        o3.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		if(player[pozi][pozj]==1 || pozj>=2 || player[pozi][pozj+1]==1 || player[pozi][pozj+2]==1){
        			Toast toast=Toast.makeText(getApplicationContext(),"Invalid click",Toast.LENGTH_LONG);
        			toast.show();
        		}
        		else{
        			player[pozi][pozj]=1;
        			player[pozi][pozj+1]=1;
        			player[pozi][pozj+2]=1;
        			matrix[pozi][pozj].setBackgroundColor(-16776961);
        			matrix[pozi][pozj+1].setBackgroundColor(-16776961);
        			matrix[pozi][pozj+2].setBackgroundColor(-16776961);
        			v3.setEnabled(false);
        			o3.setEnabled(false);
        		}
        			
        	}
        });
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onClick(View v) {
    	pozi = (Integer) v.getTag(R.id.coord_x);
    	pozj = (Integer) v.getTag(R.id.coord_y);

    }
}
