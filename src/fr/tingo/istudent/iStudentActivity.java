package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

@SuppressLint("Registered")
public class iStudentActivity extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);	//on affiche el bouton back en haut à gauche de l'écran
	}

	

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
	    int itemId = item.getItemId();
	    
	    switch(itemId) {
	    case android.R.id.home:
	    	this.onBackPressed();
	        break;
	    }
	    return true;
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	  
	  /** Demarres une nouvelle activité (une vue sur l'écran) */
	  public static void startActivity(Context p_context, Class<?> p_classe)
	  {
		  Intent intent = new Intent();
		  intent.setClass(p_context, p_classe);
		  p_context.startActivity(intent);
	  }

}
