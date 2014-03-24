package com.example.locateunivnantes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class ItineraireActivity extends Activity{

	TextView txtDestination;
	TextView txtOrigine;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itineraire);
        
        Bundle b = getIntent().getExtras();
		b.getString("destinationSalle");
		b.getString("origineSalle");
		
		txtDestination = (TextView) findViewById(R.id.txtDestination);
		txtDestination.setText(b.getString("destinationSalle"));
		
		txtOrigine = (TextView) findViewById(R.id.txtOrigine);
		txtOrigine.setText(b.getString("origineSalle"));


    }


	private Menu m = null;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		m = menu;
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			Intent intent1 = new Intent(ItineraireActivity.this,
					MainActivity.class);
			startActivity(intent1);
			return true;
		case R.id.item2:
			return true;
		case R.id.item3:
			return true;
		case R.id.item4:
			return true;
		case R.id.item5:
			Intent intent = new Intent(ItineraireActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    
	
}
