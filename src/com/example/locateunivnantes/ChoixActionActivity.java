package com.example.locateunivnantes;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Activity pour choisir l'action que l'utilisateur veut effectuer (localisation
 * ou navigation)
 * 
 * @author Alex
 * 
 */
public class ChoixActionActivity extends Activity {

	/**
	 * Bouton aller vers (= choix navigation)
	 */
	Button buttonAllerVers;

	/**
	 * Bouton Ou suis-je (= choix localisation)
	 */
	Button buttonOuSuisJe;

	private boolean destinationPresente = false;

	/**
	 * 
	 */
	private Menu m = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Choix du layou activity_choix_action.xml
		setContentView(R.layout.activity_choix_action);
		// déclaration des listeners
		addListenerOnButtonAllerVers();
		addListenerOnButtonOuSuisJe();
	}

	/**
	 * Listener sur le bouton aller vers
	 */
	private void addListenerOnButtonAllerVers() {
		buttonAllerVers = (Button) findViewById(R.id.btnAller);

		buttonAllerVers.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Lorsque clique sur le bouton Aller vers, on démarre une
				// nouvelle activity (ChoixDestination), pour choisir la
				// destination voulue
				Intent intent = new Intent(ChoixActionActivity.this,
						ChoixDestinationActivity.class);
				startActivity(intent);
			}

		});

	}

	/**
	 * 
	 */
	private void addListenerOnButtonOuSuisJe() {
		buttonOuSuisJe = (Button) findViewById(R.id.btnOu);

		buttonOuSuisJe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Lorsque clique sur le bouton ou suis je, on démarre une
				// nouvelle activity (ChoixActionActivity), pour demarrer la
				// localisation
				Intent intent = new Intent(ChoixActionActivity.this,
						ChoixOrigineActivity.class);
				// on donne aussi comme information que l'on ne donne pas de
				// destination (= ce n'est pas un calcul d'itinéraire)
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
		Configuration c = new Configuration(getResources()
				.getConfiguration());
		switch (item.getItemId()) {
		case R.id.item1:
			Intent intent1 = new Intent(ChoixActionActivity.this,
					MainActivity.class);
			startActivity(intent1);
			return true;
		case R.id.item2:
			return true;
		case R.id.item3:
			Toast.makeText(this,"Not implemented yet!", Toast.LENGTH_LONG ).show();
			return true;
		case R.id.item4:
			Toast.makeText(this,"Not implemented yet!", Toast.LENGTH_LONG ).show();
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
			Intent intent = new Intent(ChoixActionActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
