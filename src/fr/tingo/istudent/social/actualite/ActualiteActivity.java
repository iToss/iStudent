package fr.tingo.istudent.social.actualite;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import fr.tingo.istudent.iStudentActivity;

public class ActualiteActivity extends iStudentActivity {


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



}
