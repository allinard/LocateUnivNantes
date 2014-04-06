package com.example.locateunivnantes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.locateunivnantes.utils.LoginCASUnivNantes;

public class LoginActivity extends Activity {


	Button buttonLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		addListenerOnButtonLogin();
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
			Intent intent1 = new Intent(LoginActivity.this,
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
			return true;
		case R.id.item8:
			return true;
		case R.id.item9:
			return true;
		case R.id.item6:
			Intent intent = new Intent(LoginActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
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
							ChoixActionActivity.class);
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


