package com.bernard.myfruitapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//no need to save state infromation this time
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void DisplayFruitInfo(View view){
		
		//intent to open fruit info screen activity
		Intent intent = new Intent(this, FruitInfoScreen.class);
		
		//int to store fruit selected
		int fruit;
		
		//switch statement based on which button was pressed
		switch(view.getId()){
		case R.id.apple_button:
			//handle apple
			fruit = 1;
			break;
		case R.id.orange_button:
			//handle orange
			fruit = 2;
			break;
		case R.id.pear_button:
			//handle pear
			fruit = 3;
			break;
		default:
			throw new RuntimeException("Unknown button Pressed");
		}
		
		
		// Store which fruit was selected
				intent.putExtra("fruitselected", fruit);
		// startActivity causes the Activity to start
				startActivity(intent);
				
		
		}
		
		
		
		
}


