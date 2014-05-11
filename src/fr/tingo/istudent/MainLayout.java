package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.text.Html;
import android.text.Spanned;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr.tingo.istudent.calendrier.CalendarActivity;
import fr.tingo.istudent.cours.CoursActivity;
import fr.tingo.istudent.social.SocialActivity;
import fr.tingo.istudent.util.Util;

@SuppressLint({"ViewConstructor"})
public class MainLayout extends RelativeLayout implements View.OnClickListener
{
	  public static int height;
	  public static int width;
	 
	  public Activity activity;
	  public LinearLayout.LayoutParams layoutParam;
	  
	  public ButtonLogo buttonSocial;
	  public ButtonLogo buttonAgenda;
	  public ButtonLogo buttonMesCours;
	  public ButtonLogo buttonMesNotes;
	  public ButtonLogo buttonEmploiDuTemps;
	  public ButtonLogo buttonQuitter;
	
	  @SuppressLint({"ResourceAsColor", "NewApi"})
	  public MainLayout(Activity paramActivity)
	  {
		    super(paramActivity);
		    
		    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
		    Point localPoint = new Point();
		    localDisplay.getSize(localPoint);
		    
		    width = localPoint.x;
		    height = localPoint.y;
		    
		    this.activity = paramActivity;

		    /** Titre */
		    TextView title = new TextView(paramActivity);
		    Spanned text = Html.fromHtml("<strong>iStudent</strong>");
		    title.setText(text);
		    title.setWidth(width);
		    title.setTextSize(width / (text.length() * 2));
		    title.setGravity(Gravity.CENTER);
		    title.setHeight(height / 4);
		    
		    
		    /** On prépare les variables pour placer les boutons en fonction de la résolution de l'écarn (en pixel) */
		    int cote_bouton = width / 4; 
		    int posX = width / 6;
		    int posX2 = 2  * posX + cote_bouton;
		    int posY = height / 4;
		    
		    
		    /** Bouton social */
		    this.buttonSocial = new ButtonLogo(paramActivity, R.drawable.my_button_social, cote_bouton, posX, posY);
		    this.buttonAgenda = new ButtonLogo(paramActivity, R.drawable.my_button_agenda, cote_bouton, posX2, posY);
		    
		    posY += cote_bouton + height / 16;
		    this.buttonMesCours = new ButtonLogo(paramActivity, R.drawable.my_button_cours, cote_bouton, posX, posY);
		    this.buttonMesNotes = new ButtonLogo(paramActivity, R.drawable.my_button_social, cote_bouton, posX2, posY);
		    
		    posY += cote_bouton + height / 16;
		    this.buttonEmploiDuTemps = new ButtonLogo(paramActivity, R.drawable.my_button_timetable, cote_bouton, posX, posY);
		    this.buttonQuitter = new ButtonLogo(paramActivity, R.drawable.my_button_social, cote_bouton, posX2, posY);

		    
		    /** On ajoute toutes les vues au layout */
		    this.addView(title); //Ajout du titre
		    this.addView(this.buttonSocial); //Du bouton social
		    this.addView(this.buttonAgenda); //Du bouton agenda
		    this.addView(this.buttonMesCours); //Du bouton mes Cours
		    this.addView(this.buttonMesNotes); //Du bouton mes notes
		    this.addView(this.buttonEmploiDuTemps); //Du bouton Emploi du temps
		    this.addView(this.buttonQuitter); //Du bouton quitter
		    
		    /** On prépare les écouteurs de clique sur les boutons */
		    this.buttonSocial.setOnClickListener(this); //La méthode setOnClickListener prends comme paramètre cet objet (this), car cet objet implémente l'interface "OnClickListener" (cet objet est un Ecouteur de Click)
		    this.buttonMesCours.setOnClickListener(this);
		    this.buttonQuitter.setOnClickListener(this);
		    this.buttonAgenda.setOnClickListener(this);
		    this.buttonEmploiDuTemps.setOnClickListener(this);
	  }
	
	  
	  @Override //Sinon que l'on recupere la méthode d'une implementation ou d'une extension (ici de l'interface OnClickListener)
	  public void onClick(View v)
	  {
		  if(v.equals(this.buttonQuitter)) //Si on appuie sur le bouton quitter
		  {
			  this.activity.onBackPressed(); //On Simule l'appuie sur le bouton retour du telephone
		  }
		  else if(v.equals(this.buttonSocial)) //Si on appuie sur le bouton social
		  {
			  Util.startActivity(getContext(), SocialActivity.class); //Demarre une nouvelle activité
		  }
		  else if(v.equals(this.buttonAgenda))
		  {
			  Util.startActivity(getContext(), CalendarActivity.class); //Demarre une nouvelle activité
		  }
		  else if(v.equals(this.buttonEmploiDuTemps))
		  {
		    	//TODO emploi du temps
		  }
		  else if(v.equals(this.buttonMesCours))
		  {
			  Util.startActivity(getContext(), CoursActivity.class); //Demarre une nouvelle activité
		  }
	  }
}