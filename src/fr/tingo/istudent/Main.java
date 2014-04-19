package fr.tingo.istudent;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.util.Date;

public class Main extends Activity {

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		final MainLayout layout = new MainLayout(this); //On instancie le layout qui sera affich� � la fin de l'animation
		final TextView textView; // "iStudent, conneting people...
		
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
				setContentView(layout); // On d�finit le contenu de la vue par le menu princiapal
			}

			@Override
			public void onAnimationRepeat(Animation animation) {}
			
		});
		
		textView.setAnimation(anim); //On ajoute l'animation au textview
		this.addContentView(textView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)); // On ajoute le text � la vue
	
	}

    
	/** Appel� lorsque le bouton back du t�l�phone (hardware) est press� */
    public void onBackPressed() 
    {
    	super.onBackPressed();
    	Toast.makeText(this, this.getRandomMessage(), Toast.LENGTH_LONG).show(); // On affiche un Toast (pop - up) avec un message al�atoire
    }

    
    
    /** Generes un message d'aurevoir al�atoire */
	private CharSequence getRandomMessage() 
	{
		CharSequence msg = "";
		Random rand = new Random();
		int alea = rand.nextInt(2);
		
		if(alea == 0) // Alors on affiche un message neutre
		{
			switch(rand.nextInt(3))
			{
				case 0: msg = "Merci d'avoir utilis� l'application, � bientot.";
					break;
			
				case 1: msg = "N'oublies pas de faire tes devoirs!";
					break;
				
				case 2: msg = "0100000101110101011100100110010101110110011011110110100101110010 (Aurevoir)";
					break;
				
				case 3: msg = "Tu retournes sur un de tes jeux idiots c'est �a? :(";
					break;
			}
		}
		else // On affiche un message en fonction du mois.
		{
			Date today = Date.getTodayDate();
			if(today.getMois() == 1 || today.getMois() == 12 || today.getMois() == 11) // Si on est en janvier ou en decembre ou en novembre
			{
				alea = rand.nextInt(6);

				switch(alea)
				{
					case 0 : msg = "Je deteste le mois de Janvier! Retournes travailler!";
						break;
					
					case 1 : msg = "Tu ferai mieux de travailler, il fait froid dehors!";
						break;
					
					case 2 : msg = "Je deteste le mois de Janvier! Retournes travailler!";
						break;
						
					case 3 : msg = "L'hiver... la p�riode la plus longue de l'ann�e.";
						break;
					
					case 4 : msg = "Et si tu m'achetais une nouvelle coque pour l'hiver?";
						break;
						
					case 5 : msg = "Vas - t'il neiger cette ann�e? Avec un peu de chance tu louperas des cours... :p";
						break;
				}
			}
			else if(today.getMois() == 6 || today.getMois() == 5) // Si on est en juin ou en mai
			{
				alea = rand.nextInt(6);

				switch(alea)
				{
					case 0 : msg = "Il fait chaud, c'est la fin de l'ann�e... Aller, fais une pause!";
						break;
					
					case 1 : msg = "Tu as raison, avec ce soleil tu ferais mieux de t'amuser dehors!";
						break;
					
					case 2 : msg = "La fin des cours arrive bientot! Encore moins d'un mois!";
						break;
						
					case 3 : msg = "C'est la derniere ligne droite avant la fin de l'ann�e!";
						break;
					
					case 4 : msg = "Il serait peut �tre temps d'arr�ter de jouer et de commencer � r�viser...";
						break;
					
					case 5 : msg = "Les beaux jours ne veulent pas dire repos! Penses � tes examens si tu en as cette ann�e.";
						break;
				}
			}
			else if(today.getMois() == 9 || today.getMois() == 10) // Si on est en septembre ou octobre (d�but ann�e)
			{
				alea = rand.nextInt(5);

				switch(alea)
				{
					case 0 : msg = "C'est reparti pour une ann�e! Je serai ton compagnon de classe :)";
						break;
					
					case 1 : msg = "J'espere t'aider au cours de cette nouvelle ann�e!";
						break;
					
					case 2 : msg = "Ca se passe bien la rentr�? Pense � te faire de nouveaux amis!";
						break;
						
					case 3 : msg = "Aller, encore au moins 8 mois de travail :p";
						break;
						
					case 4 : msg = "L'ann�e ne fait que commencer! Pense � travailler regulierement";
						break;
				}
			}
			else if(today.getMois() == 8 || today.getMois() == 7) // Si on est en Juillet ou Aout
			{
				alea = rand.nextInt(2);

				switch(alea)
				{
					case 0 : msg = "C'est les vacaaaaaaances! Quittes l'applicaiton et va te baigner!";
						break;
					
					case 1 : msg = "Arr�tes de travailler et vas bronzer!";
						break;
				}
			}
			else
			{
				alea = rand.nextInt(3);

				switch(alea)
				{
					case 0 : msg = "Pense � respecter tes camarades, tu te feras de nouveaux amis!";
						break;
					
					case 1 : msg = "L'entraide au sein d'une classe est la base du progr�s!";
						break;
						
					case 2 : msg = "Cette application a �t� fait dans le cadre d'un projet de BAC!";
						break;
				}
			}
		}
		
		
		return msg;
	}
    
	

}
	
	