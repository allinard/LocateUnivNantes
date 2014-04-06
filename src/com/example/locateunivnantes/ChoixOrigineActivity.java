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

/**
 * Activity pour le choix de la salle d'origine
 * @author Alex
 *
 */
public class ChoixOrigineActivity extends Activity {

	/**
	 * Bouton pour le choix de la localisation via QRCode
	 */
	Button buttonQRCode;
	
	/**
	 * Bouton pour le choix de la localisation via choix dans liste salle
	 */
	Button buttonSalle;
	
	/**
	 * Affichage de la salle de destination en rappel
	 */
	TextView salleDestination;
	
	TextView textView1;
	
	/**
	 * Salle selectionnee
	 */
	private String salleSelected;
	
	private boolean destinationPresente=true;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//on choisit le layout activity_choix_origine.xml
		setContentView(R.layout.activity_choix_origine);
		//on ajoute les listener sur les boutons
		addListenerOnButtonQRCode();
		addListenerOnButtonSalle();
		
		//on récupère l'info de la salle de destination depuis l'activity précédente
		Bundle b = getIntent().getExtras();
		setSalleSelected(b.getString("destinationSalle"));
		salleDestination = (TextView) findViewById(R.id.salleDestination);
		salleDestination.setText(getSalleSelected());
		if (b.containsKey("destinationPresente"))destinationPresente = b.getBoolean("destinationPresente");
		salleDestination.setText(getSalleSelected());
		textView1 = (TextView) findViewById(R.id.textView1);
		if (!destinationPresente){
			salleDestination.setVisibility(View.INVISIBLE);
			textView1.setVisibility(View.INVISIBLE);
		}
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
			return true;
		case R.id.item7:
			return true;
		case R.id.item8:
			return true;
		case R.id.item9:
			return true;
		case R.id.item6:
			Intent intent = new Intent(ChoixOrigineActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	/**
	 * Listener sur le bouton QRCode
	 */
	public void addListenerOnButtonQRCode() {
		buttonQRCode = (Button) findViewById(R.id.btnQRCode);
		buttonQRCode.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//Quand on clique sur le bouton, on bascule sur l'activity ChoixOrigineQRCodeActivity pour flasher le code de la salle d'origine
				Intent intent = new Intent(ChoixOrigineActivity.this,
						ChoixOrigineQRCodeActivity.class);
				//On spécifie a l'activity cible la salle de destination
				intent.putExtra("destinationSalle", getSalleSelected());
				startActivity(intent);
			}

		});
	}
	
	/**
	 * Listener sur le bouton salle
	 */
	public void addListenerOnButtonSalle() {
		buttonSalle = (Button) findViewById(R.id.btnSalle);
		buttonSalle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//Quand on clique sur le bouton, on bascule sur l'activity ChoixOrigineBatimentActivity pour choisir la salle d'origine dans une liste
				Intent intent = new Intent(ChoixOrigineActivity.this,
						ChoixOrigineBatimentActivity.class);
				//On spécifie a l'activity cible la salle de destination
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
