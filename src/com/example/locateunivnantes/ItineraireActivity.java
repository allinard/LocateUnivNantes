package com.example.locateunivnantes;

import java.util.List;

import com.example.locateunivnantes.utils.ListDataUtil;
import com.example.locateunivnantes.utils.beans.Batiment;
import com.example.locateunivnantes.utils.beans.Salle;

import pl.polidea.view.ZoomView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity pour l'affichage de l'itineraire
 * @author Alex
 *
 */
public class ItineraireActivity extends Activity {

	/**
	 * Texte a afficher rappelant la destination
	 */
	TextView txtDestination;
	
	/**
	 * Texte a afficher rappelant l'origine
	 */
	TextView txtOrigine;
	
	/**
	 * Image du batiment
	 */
	ImageView imageView;
	
	/**
	 * Vue pour zoomer
	 */
	ZoomView zoomView;
	
	/**
	 * Layout de l'itineraire
	 */
	RelativeLayout itineraire;
	
	/**
	 * Bouton pour switcher de batiment
	 */
	Button buttonChangeBat;

	int imagePathDestination;
	int imagePathOrigine;
	boolean onOrigine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//on choisit le layout activity_itineraire.xml
		setContentView(R.layout.activity_itineraire);
		
		//on ajoute un listener
		addListenerOnButtonChangeBat();

		Bundle b = getIntent().getExtras();

		//on récupère les salle de destination et d'origine
		String destination = b.getString("destinationSalle");
		String origine = b.getString("origineSalle");
		
		//on récupère l'image correspondant au batiment d'origine et de destination
		imagePathDestination = choixImages(destination);
		imagePathOrigine = choixImages(origine);

		//texte qui rappelle à l'utilisateur la salle de destination
		txtDestination = (TextView) findViewById(R.id.txtDestination);
		txtDestination.setText(destination);
		txtDestination.setVisibility(View.INVISIBLE);

		//texte qui rappelle à l'utilisateur la salle d'origine
		txtOrigine = (TextView) findViewById(R.id.txtOrigine);
		txtOrigine.setText(origine);
		txtOrigine.setVisibility(View.INVISIBLE);

		//On permet de zoomer et de scroller sur la carte
		itineraire = (RelativeLayout) findViewById(R.id.activity_itineraire2);
		View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
				.inflate(R.layout.zoomableview, null, false);
		v.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		zoomView = new ZoomView(this);
		zoomView.addView(v);
		HorizontalScrollView hscrollView = new HorizontalScrollView(this);
		hscrollView.addView(zoomView);
		ScrollView vscrollView = new ScrollView(this);
		vscrollView.addView(hscrollView);
		itineraire.addView(vscrollView);

		// choix de la bonne carte
		LayerDrawable ld = (LayerDrawable) getResources().getDrawable(
				R.drawable.layers);
		Drawable replace = (Drawable) getResources().getDrawable(
				imagePathOrigine);
		boolean testfactor = ld.setDrawableByLayerId(R.id.layerBat, replace);
		ImageView layoutlist1 = (ImageView) findViewById(R.id.imgBat);
		layoutlist1.setImageDrawable(ld);

		// bon positionnement du marqueur depart
		// ld = (LayerDrawable) getResources().getDrawable(R.drawable.layers);
		// replace = (Drawable) getResources().getDrawable(R.drawable.depart);
		// replace.setBounds(getPosLeft(origine), getPosTop(origine), 0, 0);
		// testfactor = ld.setDrawableByLayerId(R.id.layerPointDepart, replace);
		// layoutlist1 = (ImageView)findViewById(R.id.imgBat);
		// layoutlist1.setImageDrawable(ld);

		onOrigine = true;
		String toast = "Vous souhaitez aller de ";
		toast = toast.concat(destination);
		toast = toast.concat(" à ");
		toast = toast.concat(origine);
		
		Toast.makeText(this,toast, Toast.LENGTH_LONG ).show();
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
			return true;
		case R.id.item7:
			return true;
		case R.id.item8:
			return true;
		case R.id.item9:
			return true;
		case R.id.item6:
			Intent intent = new Intent(ItineraireActivity.this,
					AideActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private int choixImages(String salle) {
		int s = 0;
		boolean bool = false;
		List<Batiment> listeBat = ListDataUtil.getListBatiments();
		for (Batiment bat : listeBat) {
			for (Salle sa : bat.getSalles()) {
				if (sa.getNom().equals(salle)) {
					if (bat.getNumero().equals("14") && sa.getEtage() == 2) {
						s = R.drawable.bat14e2;
					} else if (bat.getNumero().equals("14")
							&& sa.getEtage() == 1) {
						s = R.drawable.bat14e1;
					} else if (bat.getNumero().equals("14")
							&& sa.getEtage() == 0) {
						s = R.drawable.bat14e0;
					} else if (bat.getNumero().equals("15")
							&& sa.getEtage() == 1) {
						s = R.drawable.bat15e1;
					} else if (bat.getNumero().equals("15")
							&& sa.getEtage() == 0) {
						s = R.drawable.bat15e0;
					} else if (bat.getNumero().equals("15")
							&& sa.getEtage() == -1) {
						s = R.drawable.bat15ss;
					} else {
						s = R.drawable.bat14e1;
					}
					bool = true;
					break;
				}
			}
			if (bool) {
				break;
			}
		}
		return s;
	}

	/**
	 * Pour changer de vue de batiment
	 */
	public void addListenerOnButtonChangeBat() {
		buttonChangeBat = (Button) findViewById(R.id.btnChangeBat);
		buttonChangeBat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (onOrigine) {
					LayerDrawable ld = (LayerDrawable) getResources()
							.getDrawable(R.id.layerBat);
					Drawable replace = (Drawable) getResources().getDrawable(
							imagePathDestination);
					boolean testfactor = ld.setDrawableByLayerId(R.id.layerBat,
							replace);
					ImageView layoutlist1 = (ImageView) findViewById(R.id.imgBat);
					layoutlist1.setImageDrawable(ld);
					onOrigine = false;
				} else {
					LayerDrawable ld = (LayerDrawable) getResources()
							.getDrawable(R.id.layerBat);
					Drawable replace = (Drawable) getResources().getDrawable(
							imagePathOrigine);
					boolean testfactor = ld.setDrawableByLayerId(R.id.layerBat,
							replace);
					ImageView layoutlist1 = (ImageView) findViewById(R.id.imgBat);
					layoutlist1.setImageDrawable(ld);
					onOrigine = true;
				}
			}

		});
	}

}
