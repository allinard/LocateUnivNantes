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
import android.widget.TextView;

public class ChoixOrigineActivity extends Activity {

	Button buttonRetour;
	Button buttonQRCode;
	Button buttonSalle;
	
	TextView salleDestination;
	
	private String salleSelected;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choix_origine);
		addListenerOnButtonRetour();
		addListenerOnButtonQRCode();
		addListenerOnButtonSalle();
		
		Bundle b = getIntent().getExtras();
		setSalleSelected(b.getString("destinationSalle"));
		salleDestination = (TextView) findViewById(R.id.salleDestination);
		salleDestination.setText(getSalleSelected());
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
			Intent intent1 = new Intent(ChoixOrigineActivity.this,
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
			Intent intent = new Intent(ChoixOrigineActivity.this,
					AideActivity.class);
			startActivity(intent);
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
	
	public void addListenerOnButtonQRCode() {
		buttonQRCode = (Button) findViewById(R.id.btnQRCode);
		buttonQRCode.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ChoixOrigineActivity.this,
						ChoixOrigineQRCodeActivity.class);
				intent.putExtra("destinationSalle", getSalleSelected());
				startActivity(intent);
			}

		});
	}
	
	public void addListenerOnButtonSalle() {
		buttonSalle = (Button) findViewById(R.id.btnSalle);
		buttonSalle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ChoixOrigineActivity.this,
						ChoixOrigineBatimentActivity.class);
				intent.putExtra("destinationSalle", getSalleSelected());
				startActivity(intent);
			}

		});
	}

	public String getSalleSelected() {
		return salleSelected;
	}

	public void setSalleSelected(String salleSelected) {
		this.salleSelected = salleSelected;
	}
}
