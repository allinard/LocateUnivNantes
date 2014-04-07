package com.example.locateunivnantes;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Activity pour l'affichage de l'aide
 * @author Alex
 *
 */
public class AideActivity extends Activity{
	
	ListView vue;
	String[] info = new String[]{"Version 1.0", "Signaler un problème"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //on choisit le layout activity_aide.xml
        setContentView(R.layout.activity_aide);
        
        vue = (ListView) findViewById(R.id.listViewInfo);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, info);
        vue.setAdapter(adapter);
		
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
		Configuration c = new Configuration(getResources()
				.getConfiguration());
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
		}
		return super.onOptionsItemSelected(item);
	}


}
