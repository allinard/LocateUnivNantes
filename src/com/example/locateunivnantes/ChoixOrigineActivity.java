package com.example.locateunivnantes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
