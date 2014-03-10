package com.example.locateunivnantes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Button buttonEntrer;
	Button buttonQuitter;
	Button buttonAide;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		addListenerOnButtonEntrer();
		addListenerOnButtonQuitter();
		addListenerOnButtonAide();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
	public void addListenerOnButtonEntrer() {
		buttonEntrer = (Button) findViewById(R.id.btnEntrer);
		buttonEntrer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//TODO ce qui se passe qd on clique
			}
 
		});
	}
	
	
	public void addListenerOnButtonQuitter() {
		buttonQuitter = (Button) findViewById(R.id.btnQuitter);
		buttonQuitter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
				System.exit(0);
			}
 
		});
	}
	
	
	public void addListenerOnButtonAide() {
		buttonAide = (Button) findViewById(R.id.btnAide);
		buttonAide.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//TODO ce qui se passe qd on clique
			}
 
		});
	}
	
}
