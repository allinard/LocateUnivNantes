package com.example.locateunivnantes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ItineraireActivity extends Activity{

	TextView txtDestination;
	TextView txtOrigine;
	
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


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
	
}
