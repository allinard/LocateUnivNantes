package com.example.locateunivnantes;

import com.example.locateunivnantes.utils.LoginCASUnivNantes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
				EditText login = (EditText) findViewById(R.id.editTextLogin);
				EditText password = (EditText) findViewById(R.id.editTextPassWd);
				
				LoginCASUnivNantes loginCASUnivNantes = LoginCASUnivNantes.getInstance();
				if(loginCASUnivNantes.logIn(login.getText().toString(), password.getText().toString())){
					Intent intent = new Intent(LoginActivity.this,
							ChoixDestinationActivity.class);
					startActivity(intent);
				}
				else{
					login.setText("");
					password.setText("");
					Toast toast = Toast.makeText(getApplicationContext(),"Login et Mdp éronnés : veuillez ressaisir les champs", Toast.LENGTH_LONG);
					toast.show();
				}
			}

		});
	}
	
}


