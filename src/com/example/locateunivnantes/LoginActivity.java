package com.example.locateunivnantes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	Button buttonRetour;
	Button buttonLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		addListenerOnButtonRetour();
		addListenerOnButtonLogin();
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

	public void addListenerOnButtonLogin() {
		buttonLogin = (Button) findViewById(R.id.btnLogin);
		buttonLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//TODO le login
				EditText login = (EditText) findViewById(R.id.editTextLogin);
				EditText password = (EditText) findViewById(R.id.editTextPassWd);
				
				Context context = getApplicationContext();
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, "login: "+login.getText().toString()+"\npassword: "+password.getText().toString(), duration);
				toast.show();
			}

		});
	}
	
}


