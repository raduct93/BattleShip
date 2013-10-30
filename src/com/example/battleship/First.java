package com.example.battleship;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class First extends Activity {

	
	final Context context = this;
	private Button rules;
	private Button start;
	private Button exit;
	private EditText name;
	
	String playername;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		start = (Button) findViewById(R.id.start);
		exit = (Button) findViewById(R.id.exit);
		name = (EditText) findViewById(R.id.edit_text);
		rules = (Button) findViewById(R.id.rules);
		 
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			    playername = name.getText().toString();
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				intent.putExtra("playername", playername);
        		startActivity(intent);
        		
				
				
			}
		});
		
		// add button listener
		rules.setOnClickListener(new OnClickListener() {
 
		  @Override
		  public void onClick(View arg0) {
 
			// custom dialog
			final Dialog dialog = new Dialog(context);
			dialog.setContentView(R.layout.custom1);
			dialog.setTitle("Rules");
 
			// set the custom dialog components - text, image and button
			TextView text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Android custom dialog example!");
 
			Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
 
			dialog.show();
		  }
		});
		
		
		
	    exit.setOnClickListener(new OnClickListener() {

	        @Override
	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	        	
	        	
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.exit);
				dialog.setTitle("Exit");
				final Button exitOK = (Button) dialog.findViewById(R.id.exitOK);
	        	final Button exitNO = (Button) dialog.findViewById(R.id.exitNO);
	 
				
				TextView text = (TextView) dialog.findViewById(R.id.text_exit);
				text.setText("Are you sure?");
	 
				exitNO.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				}); 
				
				exitOK.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						finish();
			            System.exit(0);
					}
				});
	 
				dialog.show();
			  }
	        	
	        
	        });
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
