package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.util.Util;

@SuppressLint("NewApi")
public class Main extends Activity implements TabListener {

	public static boolean animation_deja_jouer;
	
	
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle b) 
	{
		super.onCreate(b);
				
		final MainLayout layout = new MainLayout(this); //On instancie le layout qui sera affiché à la fin de l'animation
			
		if(animation_deja_jouer) //S'il y un intent de back, on ne redessine pas l'animation de départ
		{
			this.setContentView(layout);
		}
		else //Si on ouvr el'application
		{
			animation_deja_jouer = true;
			final TextView textView; // "iStudent, conneting people...
			
			ImageView image = new ImageView(this);
			image.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			image.setImageResource(R.drawable.student);
			this.addContentView(image, image.getLayoutParams());
			  
			textView = new TextView(this); // On instancie le nouveau textview
			textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL); //On le centre
			textView.setText("iStudent, connecting people..."); //On definit son message
			
			Animation anim = AnimationUtils.loadAnimation(this, R.anim.main); // On charge une animation
			anim.setAnimationListener(new AnimationListener() {
	
				@Override
				public void onAnimationStart(Animation animation) {}
	
				@Override
				public void onAnimationEnd(Animation animation)  // Lorsque l'animation se fini
				{
					textView.setText("");
					setContentView(layout); // On définit le contenu de la vue par le menu princiapal
				}
	
				@Override
				public void onAnimationRepeat(Animation animation) {}
				
			});
	
			textView.setAnimation(anim); //On ajoute l'animation au textview
			this.addContentView(textView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)); // On ajoute le text à la vue
		}
	}

    
	/** Appelé lorsque le bouton back du téléphone (hardware) est pressé */
	@Override
    public void onBackPressed() 
    {
    	super.onBackPressed();
    	Toast.makeText(this, Util.getRandomMessage(), Toast.LENGTH_LONG).show(); // On affiche un Toast (pop - up) avec un message aléatoire
    }

    
    /** On crée le menu d'option */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main, menu);
    	
    	return true;
    } 
    
    /** Lorsqu'on selectionne un objet du menu d'option */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
      switch(item.getItemId())
      {
        case R.id.action_settings:
          return true;
      }
      
      return super.onOptionsItemSelected(item);
    }


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
    
	

}
	
	