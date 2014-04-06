package com.example.locateunivnantes;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChoixActionActivity extends Activity {
	
	Button buttonAllerVers;
	Button buttonOuSuisJe;
	private boolean destinationPresente=false;
	@SuppressWarnings("unused")
	private Menu m = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choix_action);
		addListenerOnButtonAllerVers();
		addListenerOnButtonOuSuisJe();
		//TextView texteView = (TextView) findViewById(R.id.custom_font);
		//Typeface font = Typeface.createFromAsset(getAssets(), "lcallig.ttf");
		//texteView.setTypeface(font);
		
	}

	
	private void addListenerOnButtonAllerVers() {
		buttonAllerVers = (Button) findViewById(R.id.btnAller);
		
		buttonAllerVers.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(ChoixActionActivity.this,
						ChoixDestinationActivity.class);
				startActivity(intent);
			}

			

		});
		
	}

	private void addListenerOnButtonOuSuisJe() {
		buttonOuSuisJe = (Button) findViewById(R.id.btnOu);
		
		buttonOuSuisJe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(ChoixActionActivity.this,
						ChoixOrigineActivity.class);
				intent.putExtra("destinationPresente", getDestinationPresente());
				startActivity(intent);
			}
		});
		
	}
	
	private boolean getDestinationPresente() {
		return destinationPresente;
	}
	

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
			Intent intent1 = new Intent(ChoixActionActivity.this,
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
			return true;
		case R.id.item7:
			return true;
		case R.id.item8:
			return true;
		case R.id.item9:
			return true;
		case R.id.item6:
			Intent intent = new Intent(ChoixActionActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
