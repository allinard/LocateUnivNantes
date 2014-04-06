package com.example.locateunivnantes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.example.locateunivnantes.qr.*;
import com.example.locateunivnantes.qr.result.ResultHandler;
import com.example.locateunivnantes.qr.result.ResultHandlerFactory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChoixOrigineQRCodeActivity extends DecoderActivity {

	private static final String TAG = ChoixOrigineQRCodeActivity.class
			.getSimpleName();
	private static final Set<ResultMetadataType> DISPLAYABLE_METADATA_TYPES = EnumSet
			.of(ResultMetadataType.ISSUE_NUMBER,
					ResultMetadataType.POSSIBLE_COUNTRY);

	private TextView statusView = null;
	private View resultView = null;
	private boolean inScanMode = false;
	private String salleDestination;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
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

	@Override
	public void handleDecode(Result rawResult, Bitmap barcode) {
		drawResultPoints(barcode, rawResult);
		Intent intent = new Intent(ChoixOrigineQRCodeActivity.this,
				ItineraireActivity.class);
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
