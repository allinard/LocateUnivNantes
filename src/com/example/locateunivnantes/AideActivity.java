package com.example.locateunivnantes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AideActivity extends Activity{
	
	Button buttonRetour;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aide);
		addListenerOnButtonRetour();
    }


	private Menu m = null;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		m = menu;
		
		m.findItem(R.id.item5).setEnabled(false);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			Intent intent = new Intent(AideActivity.this,
					MainActivity.class);
			startActivity(intent);
			return true;
		case R.id.item2:
			return true;
		case R.id.item3:
			return true;
		case R.id.item4:
			return true;
		case R.id.item5:
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    
	public void addListenerOnButtonRetour() {
		buttonRetour = (Button) findViewById(R.id.btnRetour);
		buttonRetour.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
 
		});
	}

}
