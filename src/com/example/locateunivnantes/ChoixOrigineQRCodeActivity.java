package com.example.locateunivnantes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.zxing.Result;
import com.example.locateunivnantes.qr.*;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/**
 * Activity pour le choix de la salle d'origine par lecture d'un QRCode
 * @author Alex
 *
 */
public class ChoixOrigineQRCodeActivity extends DecoderActivity {

	private static final String TAG = ChoixOrigineQRCodeActivity.class
			.getSimpleName();
	private TextView statusView = null;
	private View resultView = null;
	private boolean inScanMode = false;
	private String salleDestination;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		//on spécifie le layout capture
		setContentView(R.layout.capture);
		Log.v(TAG, "onCreate()");

		resultView = findViewById(R.id.result_view);
		statusView = (TextView) findViewById(R.id.status_view);

		inScanMode = false;

		Bundle b = getIntent().getExtras();
		setSalleDestination(b.getString("destinationSalle"));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.v(TAG, "onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG, "onPause()");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (inScanMode)
				finish();
			else
				onResume();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * Methode declenchée lorsque le QRCode est lu
	 */
	@Override
	public void handleDecode(Result rawResult, Bitmap barcode) {
		drawResultPoints(barcode, rawResult);
		//on bascule sur ItineraireActivity
		Intent intent = new Intent(ChoixOrigineQRCodeActivity.this,
				ItineraireActivity.class);
		//on spécifie à l'activity cible la salle d'origine et de destination
		intent.putExtra("destinationSalle", getSalleDestination());
		intent.putExtra("origineSalle", rawResult.getText());
		startActivity(intent);
	}

	protected void showScanner() {
		inScanMode = true;
		resultView.setVisibility(View.GONE);
		statusView.setText(R.string.msg_default_status);
		statusView.setVisibility(View.VISIBLE);
		viewfinderView.setVisibility(View.VISIBLE);
	}

	protected void showResults() {
		inScanMode = false;
		statusView.setVisibility(View.GONE);
		viewfinderView.setVisibility(View.GONE);
		resultView.setVisibility(View.VISIBLE);
	}

	public String getSalleDestination() {
		return salleDestination;
	}

	public void setSalleDestination(String salleDestination) {
		this.salleDestination = salleDestination;
	}
}
