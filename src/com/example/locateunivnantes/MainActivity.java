package com.example.locateunivnantes;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Button buttonEntrer;
	ImageView imageLogo;
	ImageView imageName;

	private final int DISPLAY_LENGTH = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		

		/* New Handler to start the Menu-Activity
		* and close this Splash-Screen after DISPLAY_LENGTH/1000 seconds.*/
		new Handler().postDelayed(new Runnable(){

		@Override
		public void run() {
		/* Create an Intent that will start the Main-Activity. */
		Intent mainIntent = new Intent(MainActivity.this,LoginActivity.class);
		MainActivity.this.startActivity(mainIntent);
		MainActivity.this.finish();
		}}, DISPLAY_LENGTH);
		}
	
	

	private Menu m = null;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		m = menu;

		m.findItem(R.id.item1).setEnabled(false);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			return true;
		case R.id.item2:
			return true;
		case R.id.item3:
			return true;
		case R.id.item4:
			return true;
		case R.id.item5:
			Intent intent = new Intent(MainActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



}
