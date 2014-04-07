package com.example.locateunivnantes;

import java.util.Locale;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

/**
 * MAIN ACTIVITY
 * @author Alex
 *
 */
public class MainActivity extends Activity {

	Button buttonEntrer;
	ImageView imageLogo;
	ImageView imageName;

	/**
	 * Temps d'affichage du logo
	 */
	private final int DISPLAY_LENGTH = 2500;

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
		Configuration c = new Configuration(getResources()
				.getConfiguration());
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
			return true;
		case R.id.item7:
			c.locale = Locale.FRENCH;
			getResources().updateConfiguration(c,
					getResources().getDisplayMetrics());
			return true;
		case R.id.item8:
			c.locale = Locale.ENGLISH;
			getResources().updateConfiguration(c,
					getResources().getDisplayMetrics());
			return true;
		case R.id.item9:
			c.locale = new Locale("es");
			getResources().updateConfiguration(c,
					getResources().getDisplayMetrics());
			return true;
		case R.id.item10:
			c.locale = new Locale("zh");
			getResources().updateConfiguration(c,
					getResources().getDisplayMetrics());
			return true;
		case R.id.item11:
			c.locale = new Locale("pt");
			getResources().updateConfiguration(c,
					getResources().getDisplayMetrics());
			return true;
		case R.id.item6:
			Intent intent = new Intent(MainActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



}
