package com.bernard.myfruitapp;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.support.v4.app.NavUtils;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;

public class FruitInfoScreen extends Activity {
	
	//declare necessary elements
	TextView firstLetter;
	TextView description;
	ImageView image;
	View root;
	int FruitSelected;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fruit_info_screen);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//get the intent which started this activity
		Intent myIntent = getIntent();
		
		//get which fruit was selected
		FruitSelected = myIntent.getIntExtra("fruitselected", 0);
		
	
		firstLetter = (TextView) findViewById(R.id.fruitLetter);
		
		//set a new font to description text
		Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");  
		description = (TextView) findViewById(R.id.fruitDescription);
		description.setTypeface(font); 
		
		//get image to allow it to be changed programatically
		image = (ImageView) findViewById(R.id.fruitPicture);
		
		//this root view is used to change the background colour of the screen depending on fruit
		root = firstLetter.getRootView();
		
		//set up local variable
		String mystring;
		
		//spannablestring is an android class which allows more control of string formatting
		SpannableString text; 
		
		//switch statement which determines what is displayed based on the int sent from the main activity
		//same code in each so only apple will be commented
		switch(FruitSelected){
		case 1:
			//get string from resources
			mystring = getString(R.string.apple_start);
			//create new spannable string based on it
			text = new SpannableString(mystring);  
			  
		    // make first character colour from resources  
		    text.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), 0, 1, 0);  
		  
		    // make first character 4 times bigger than remaining 
		    text.setSpan(new RelativeSizeSpan(4.0f), 0, 1, 0);  
			
		    //set the appropriate textview using this text
			firstLetter.setText(text,BufferType.SPANNABLE);
			
			//set the decription text view using text from resources
			description.setText(R.string.apple_description);
			
			//set the imageview to the appropriate image
			image.setImageResource(R.drawable.apple);
			
			//set the colour of the background
			root.setBackgroundColor(getResources().getColor(R.color.apple_comp));
			break;
		case 2:
			mystring = getString(R.string.orange_start);
			text = new SpannableString(mystring);  
			  
		    text.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange)), 0, 1, 0);  
		  
		    text.setSpan(new RelativeSizeSpan(4.0f), 0, 1, 0);  
			
		    
			firstLetter.setText(text,BufferType.SPANNABLE);
			description.setText(R.string.orange_description);
			image.setImageResource(R.drawable.orange);
			root.setBackgroundColor(getResources().getColor(R.color.orange_comp));
			break;
		case 3:
			mystring = getString(R.string.pear_start);
			text = new SpannableString(mystring);  
			  
		    text.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green)), 0, 1, 0);  
		  
		    text.setSpan(new RelativeSizeSpan(4.0f), 0, 1, 0);  
			
		    
			firstLetter.setText(text,BufferType.SPANNABLE);
			description.setText(R.string.pear_description);
			image.setImageResource(R.drawable.pear);
			root.setBackgroundColor(getResources().getColor(R.color.pear_comp));
			break;
		}

		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fruit_info_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
