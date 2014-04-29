package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import fr.tingo.istudent.calendrier.CalendarActivity;
<<<<<<< HEAD
import fr.tingo.istudent.cours.CoursActivity;
=======
import fr.tingo.istudent.social.DialogContact;
>>>>>>> 23d807182476563cc71813bc9b64abd23f8c40fb
import fr.tingo.istudent.social.SocialActivity;

@SuppressLint({"ViewConstructor"})
public class MainLayout extends ScrollView implements View.OnClickListener
{
	  public static int height;
	  public static int width;
	  public Activity activity;
	  public ButtonStudent buttonAgenda;
	  public ButtonStudent buttonEmploiDuTemps;
	  public ButtonStudent buttonMesCours;
	  public ButtonStudent buttonQuitter;
	  public ButtonStudent buttonSocial;
	  public RelativeLayout layout;
	  public LinearLayout.LayoutParams scrollParams;
	
<<<<<<< HEAD
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
		    this.buttonSocial = new ButtonStudent(paramActivity);
		    this.buttonAgenda = new ButtonStudent(paramActivity);
		    this.buttonMesCours = new ButtonStudent(paramActivity);
		    this.buttonEmploiDuTemps = new ButtonStudent(paramActivity);
		    this.buttonQuitter = new ButtonStudent(paramActivity);
		    
		    this.layout = new RelativeLayout(paramActivity);
		    this.scrollParams = new LinearLayout.LayoutParams(-2, -1);
		    this.setLayoutParams(this.scrollParams);
		    this.setBackgroundColor(17170445);
		    this.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
		    this.setFillViewport(true);
		    this.setScrollBarStyle(0);
		    
		    this.buttonSocial.setText("Social");
		    this.buttonAgenda.setText("Agenda");
		    this.buttonMesCours.setText("Mes cours");
		    this.buttonEmploiDuTemps.setText("Emploi du temps");
		    this.buttonQuitter.setText("Quitter");
		    
		    int i = height / 8;
		    this.buttonSocial.setHeight(i);
		    this.buttonAgenda.setHeight(i);
		    this.buttonMesCours.setHeight(i);
		    this.buttonEmploiDuTemps.setHeight(i);
		    this.buttonQuitter.setHeight(i);
		    
		    int j = 4 * (width / 5);
		    this.buttonSocial.setWidth(j);
		    this.buttonAgenda.setWidth(j);
		    this.buttonMesCours.setWidth(j);
		    this.buttonEmploiDuTemps.setWidth(j);
		    this.buttonQuitter.setWidth(j);
		    
		    this.buttonSocial.setX(j / 8);
		    this.buttonAgenda.setX(j / 8);
		    this.buttonMesCours.setX(j / 8);
		    this.buttonEmploiDuTemps.setX(j / 8);
		    this.buttonQuitter.setX(j / 8);
		    
		    int k = i / 4;
		    this.buttonSocial.setY(i / 2);
		    this.buttonAgenda.setY(k + (i + i / 2));
		    this.buttonMesCours.setY(i / 2 + 2 * (i + k));
		    this.buttonEmploiDuTemps.setY(i / 2 + 3 * (i + k));
		    this.buttonQuitter.setY(height - 2.5F * i);
		    
		    this.layout.addView(this.buttonSocial);
		    this.layout.addView(this.buttonAgenda);
		    this.layout.addView(this.buttonMesCours);
		    this.layout.addView(this.buttonEmploiDuTemps);
		    this.layout.addView(this.buttonQuitter);
		    this.addView(this.layout);
		    
		    this.buttonSocial.setOnClickListener(this);
		    this.buttonMesCours.setOnClickListener(this);
		    this.buttonQuitter.setOnClickListener(this);
		    this.buttonAgenda.setOnClickListener(this);
		    this.buttonEmploiDuTemps.setOnClickListener(this);
	  }
	
	  public void onClick(View v)
	  {
		    if (v.equals(this.buttonQuitter))
		    {
		      this.activity.onBackPressed();
		    }
		    else if(v.equals(this.buttonSocial))
		    {
		        Intent intent = new Intent();
		        intent.setClass(getContext(), SocialActivity.class);
		        this.activity.startActivity(intent);
		    }
		    
		    else if(v.equals(this.buttonAgenda))
		    {
		        Intent intent = new Intent();
		        intent.setClass(getContext(), CalendarActivity.class);
		        this.activity.startActivity(intent);
		    }
		    
		    else if(v.equals(this.buttonEmploiDuTemps))
		    {
		    	//TODO emploi du temps
		    }
		    
		    else if(v.equals(this.buttonMesCours))
		    {
			      Intent intent = new Intent();
			      intent.setClass(getContext(), CoursActivity.class);
			      this.activity.startActivity(intent);
		    }
		    
		    else if(v.equals(this.buttonAgenda))
		    {
		    	
		    }    
	  }
	  
=======
	public RelativeLayout layout;
	public MainButton buttonSocial;
	public MainButton buttonNotes;
	public MainButton buttonAgenda;
	public MainButton buttonEmploiDuTemps;
	public MainButton buttonQuitter;
	
	public static int width;
	public static int height;
	
	public LinearLayout.LayoutParams scrollParams;
	public Activity activity;
	
	@SuppressWarnings("deprecation")
	@SuppressLint({ "ResourceAsColor", "NewApi" })
	public MainLayout(Activity context) {
		super(context);

		Display display = context.getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);

		MainLayout.width = size.x;
		MainLayout.height = size.y;

		this.activity = context;

		
		/** Initialisation des objets */
        this.buttonSocial  = new MainButton(context);
        this.buttonAgenda  = new MainButton(context);
        this.buttonNotes  = new MainButton(context);
        this.buttonEmploiDuTemps  = new MainButton(context);
        this.buttonQuitter  = new MainButton(context);
		this.layout = new RelativeLayout(context);
		this.scrollParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);


		/** configuration scrollview */
		this.setLayoutParams(scrollParams);
		this.setBackgroundColor(android.R.color.transparent);
		this.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        this.setFillViewport(true);
		this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		
		
		/** configuration des boutons */
		//On definit le texte
		this.buttonSocial.setText("Social");
		this.buttonAgenda.setText("Agenda");
		this.buttonNotes.setText("Mes notes");
		this.buttonEmploiDuTemps.setText("Emploi du temps");
		this.buttonQuitter.setText("Quitter");
		
		/** hauteur bouton */
		int buttonHeight = MainLayout.height / 8;
		this.buttonSocial.setHeight(buttonHeight);
		this.buttonAgenda.setHeight(buttonHeight);
		this.buttonNotes.setHeight(buttonHeight);
		this.buttonEmploiDuTemps.setHeight(buttonHeight);
		this.buttonQuitter.setHeight(buttonHeight);

		/** Largeur bouton */
		int buttonWidth = MainLayout.width / 5 * 4;
		this.buttonSocial.setWidth(buttonWidth);
		this.buttonAgenda.setWidth(buttonWidth);
		this.buttonNotes.setWidth(buttonWidth);
		this.buttonEmploiDuTemps.setWidth(buttonWidth);
		this.buttonQuitter.setWidth(buttonWidth);

		/** Position X des boutons */
		this.buttonSocial.setX(buttonWidth / 8);
		this.buttonAgenda.setX(buttonWidth / 8);
		this.buttonNotes.setX(buttonWidth / 8);
		this.buttonEmploiDuTemps.setX(buttonWidth / 8);
		this.buttonQuitter.setX(buttonWidth / 8);
		
		/** Position Y des boutons */
		int unit = buttonHeight / 4;
		this.buttonSocial.setY(buttonHeight / 2);
		this.buttonAgenda.setY(buttonHeight / 2 + buttonHeight + unit);
		this.buttonNotes.setY(buttonHeight / 2 + (buttonHeight + unit) * 2);
		this.buttonEmploiDuTemps.setY(buttonHeight / 2 + (buttonHeight + unit) * 3);
		this.buttonQuitter.setY(MainLayout.height - buttonHeight * 2.5f);
		
		
		
		/** configuration du layout */
        this.layout.addView(this.buttonSocial);
        this.layout.addView(this.buttonAgenda);
        this.layout.addView(this.buttonNotes);
        this.layout.addView(this.buttonEmploiDuTemps);
        this.layout.addView(this.buttonQuitter);
		
        
        
		/** Ajout du Layout au scrollview */
		this.addView(layout);
		
		/** configuration des écouteurs de click */
		this.buttonSocial.setOnClickListener(this);
		this.buttonQuitter.setOnClickListener(this);
		this.buttonAgenda.setOnClickListener(this);
		this.buttonEmploiDuTemps.setOnClickListener(this);
		
		
	}

	/** Lorsqu'n click sur un composant de la vue */
	@Override
	public void onClick(View v) 
	{
		/** Si on clique sur le bouton quitter */
		if(v.equals(this.buttonQuitter))
		{
			this.activity.onBackPressed(); // On similue l'appuie de la touche "back"
		}
		else if(v.equals(this.buttonSocial))
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), SocialActivity.class);
			activity.startActivity(intent);
		}
		else if(v.equals(this.buttonAgenda)) //On ouvre le calendrier
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), CalendarActivity.class);
			activity.startActivity(intent);
		}
		else if(v.equals(this.buttonEmploiDuTemps)) //Lorsqu'on click sur le bouton contact
		{
			DialogContact d = new DialogContact(this.activity);
			d.show();
		}
	}

    

>>>>>>> 23d807182476563cc71813bc9b64abd23f8c40fb
}
