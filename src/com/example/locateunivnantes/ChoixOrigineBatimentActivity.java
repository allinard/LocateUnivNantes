package com.example.locateunivnantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.locateunivnantes.adapters.ExpandableListAdapter;
import com.example.locateunivnantes.utils.ListDataUtil;

import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

/**
 * Activity pour le choix de la salle d'origine
 * @author Alex
 *
 */
public class ChoixOrigineBatimentActivity extends Activity {

	/**
	 * Bouton OK
	 */
	Button buttonOK;
	
	/**
	 * Adapteur pour la liste deroulante des salles
	 */
	ExpandableListAdapter listAdapter;
	
	/**
	 * Liste deroulante des salles
	 */
	ExpandableListView listBatimentsSalles;
	
	/**
	 * Header pour liste des salles (= Batiments)
	 */
	List<String> listDataHeader = new ArrayList<String>();
	HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();
	private String salleSelected;
	private String salleDestination;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choix_origine_batiment);

		// get the listview
		listBatimentsSalles = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		ListDataUtil.prepareListData(listDataHeader, listDataChild);

		listAdapter = new ExpandableListAdapter(this, listDataHeader,
				listDataChild);

		// setting list adapter
		listBatimentsSalles.setAdapter(listAdapter);

		//on ajoute les listener
		addListenerOnButtonOK();
		addListenerOnListBatimentsSalles();

		//on récupère la salle de destination depuis l'activity précedente
		Bundle b = getIntent().getExtras();
		setSalleDestination(b.getString("destinationSalle"));
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
		Configuration c = new Configuration(getResources()
				.getConfiguration());
		switch (item.getItemId()) {
		case R.id.item1:
			Intent intent1 = new Intent(ChoixOrigineBatimentActivity.this,
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
			Intent intent = new Intent(ChoixOrigineBatimentActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Listener sur bouton OK
	 */
	public void addListenerOnButtonOK() {
		buttonOK = (Button) findViewById(R.id.btnOK);
		buttonOK.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//si aucune salle sélectionnée, on affiche un toast disant qu'il faut sélectionner une salle !
				if (null == getSalleSelected()) {
					Toast.makeText(getApplicationContext(),
							"Vous devez sélectionner une salle!",
							Toast.LENGTH_LONG).show();
				}
				//sinon, on démarre une nouvelle activity (ItineraireActivity)
				else {
					Intent intent = new Intent(
							ChoixOrigineBatimentActivity.this,
							ItineraireActivity.class);
					//on spécifie a l'activity cible la salle d'origine et de destination
					intent.putExtra("destinationSalle", getSalleDestination());
					intent.putExtra("origineSalle", getSalleSelected());
					startActivity(intent);
				}

			}

		});
	}

	/**
	 * Listener sur la liste des salles
	 */
	public void addListenerOnListBatimentsSalles() {
		listBatimentsSalles = (ExpandableListView) findViewById(R.id.lvExp);
		listBatimentsSalles.setOnChildClickListener(new OnChildClickListener() {

			View currentSelected = null;

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				if (null != currentSelected) {
					currentSelected.setSelected(false);
					currentSelected
							.setBackgroundResource(android.R.color.transparent);
				}

				v.setSelected(true);
				v.setBackgroundResource(android.R.color.holo_blue_light);
				currentSelected = v;

				setSalleSelected(listDataChild.get(
						listDataHeader.get(groupPosition)).get(childPosition));

				return false;
			}
		});

	}

	public String getSalleSelected() {
		return salleSelected;
	}

	public void setSalleSelected(String salleSelected) {
		this.salleSelected = salleSelected;
	}

	public String getSalleDestination() {
		return salleDestination;
	}

	public void setSalleDestination(String salleDestination) {
		this.salleDestination = salleDestination;
	}
}