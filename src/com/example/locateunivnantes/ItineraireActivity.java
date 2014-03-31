package com.example.locateunivnantes;

import pl.polidea.view.ZoomView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ItineraireActivity extends Activity{

	TextView txtDestination;
	TextView txtOrigine;
	ImageView imageView;
	ZoomView zoomView;	
	RelativeLayout itineraire;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itineraire);
        
        Bundle b = getIntent().getExtras();
		b.getString("destinationSalle");
		b.getString("origineSalle");
		
		txtDestination = (TextView) findViewById(R.id.txtDestination);
		txtDestination.setText(b.getString("destinationSalle"));
		
		txtOrigine = (TextView) findViewById(R.id.txtOrigine);
		txtOrigine.setText(b.getString("origineSalle"));
		
		imageView = (ImageView) findViewById(R.id.imgBat);
		
		
		itineraire = (RelativeLayout) findViewById(R.id.activity_itineraire);
		View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.zoomableview, null, false);
		v.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		zoomView = new ZoomView(this);
		zoomView.addView(v);
		HorizontalScrollView hscrollView = new HorizontalScrollView(this);
		hscrollView.addView(zoomView);
		ScrollView vscrollView = new ScrollView(this);
		vscrollView.addView(hscrollView);
		itineraire.addView(vscrollView);
		
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
			Intent intent1 = new Intent(ItineraireActivity.this,
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
			Intent intent = new Intent(ItineraireActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    
	
}
