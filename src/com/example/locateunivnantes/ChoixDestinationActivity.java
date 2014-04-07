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
 * Activity pour le choix de la destination
 * @author Alex
 *
 */
public class ChoixDestinationActivity extends Activity {
	
	/**
	 * Bouton OK
	 */
	Button buttonOK;
	
	/**
	 * Adapteur pour liste des batiments et salles
	 */
	ExpandableListAdapter listAdapter;
	
	/**
	 * Liste des batiments et salles
	 */
	ExpandableListView listBatimentsSalles;
	
	/**
	 * Header pour liste des batiments et salles (= noms des batiments)
	 */
	List<String> listDataHeader = new ArrayList<String>();
	
	HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();
	
	/**
	 * La salle selectionnée
	 */
	private String salleSelected;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//on choisit le layer activity_choix_destination.xml
		setContentView(R.layout.activity_choix_destination);

		// get the listview
		listBatimentsSalles = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		ListDataUtil.prepareListData(listDataHeader,listDataChild);

		listAdapter = new ExpandableListAdapter(this, listDataHeader,
				listDataChild);

		// setting list adapter
		listBatimentsSalles.setAdapter(listAdapter);

		//ajout des listeners sur les boutons
		addListenerOnButtonOK();
		addListenerOnListBatimentsSalles();
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
			Intent intent1 = new Intent(ChoixDestinationActivity.this,
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
			Intent intent2 = new Intent(ChoixDestinationActivity.this,
					AideActivity.class);
			startActivity(intent2);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Listener sur le bouton ok
	 */
	public void addListenerOnButtonOK() {
		buttonOK = (Button) findViewById(R.id.btnOK);
		buttonOK.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//si on na pas de salle selectionnee, on affiche un toast disant qu'il faut en selectionner une
				if(null == getSalleSelected()){
					Toast.makeText(
							getApplicationContext(),"Vous devez sélectionner une salle!", Toast.LENGTH_LONG).show();
				}
				//sinon on bascule sur ChoixOrigineActivity pour choisir l'origine de l'itinéraire
				else{
					Intent intent = new Intent(ChoixDestinationActivity.this,
							ChoixOrigineActivity.class);
					intent.putExtra("destinationSalle", getSalleSelected());
					startActivity(intent);
				}
				
			}

		});
	}

	/**
	 * Listener sur la liste expandable
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

				//on sette et sauvegarde la salle selectionnee
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

}
