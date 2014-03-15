package com.example.locateunivnantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.locateunivnantes.adapters.ExpandableListAdapter;
import com.example.locateunivnantes.utils.ListDataUtil;

import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class ChoixOrigineBatimentActivity extends Activity {

	Button buttonRetour;
	Button buttonOK;
	ExpandableListAdapter listAdapter;
	ExpandableListView listBatimentsSalles;
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

		addListenerOnButtonRetour();
		addListenerOnButtonOK();
		addListenerOnListBatimentsSalles();

		Bundle b = getIntent().getExtras();
		setSalleDestination(b.getString("destinationSalle"));
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

	public void addListenerOnButtonOK() {
		buttonOK = (Button) findViewById(R.id.btnOK);
		buttonOK.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (getSalleSelected().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							"Vous devez sélectionner une salle!",
							Toast.LENGTH_LONG).show();
				} else {
					Intent intent = new Intent(
							ChoixOrigineBatimentActivity.this,
							ItineraireActivity.class);
					intent.putExtra("destinationSalle", getSalleDestination());
					intent.putExtra("origineSalle", getSalleSelected());
					startActivity(intent);
				}

			}

		});
	}

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