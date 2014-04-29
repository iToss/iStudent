package fr.tingo.istudent.social.actualite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import fr.tingo.istudent.R;

public class ActualiteActivity extends Activity {


	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		/** Création et ajout du nouveau layout */		
		ActualiteScrollView layout = new ActualiteScrollView(this);
		this.setContentView(layout);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}




}
