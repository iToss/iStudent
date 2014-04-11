package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import fr.tingo.calendrier.CalendarActivity;
import fr.tingo.istudent.actualite.ActualiteActivity;
import fr.tingo.istudent.options.OptionActivity;

@SuppressLint("ViewConstructor")
public class MainLayout extends ScrollView implements OnClickListener {
	
	public LinearLayout layout;
	public MainButton buttonActualite;
	public MainButton buttonNotes;
	public MainButton buttonAgenda;
	public MainButton buttonContact;
	public MainButton buttonQuitter;
	
	public int width;
	public int height;
	
	public LinearLayout.LayoutParams scrollParams;
	public Activity activity;
	
	@SuppressWarnings("deprecation")
	@SuppressLint({ "ResourceAsColor", "NewApi" })
	public MainLayout(Activity context) {
		super(context);

		this.width = context.getWindowManager().getDefaultDisplay().getWidth(); // On recupere la largeur de l'ecran
		this.height = context.getWindowManager().getDefaultDisplay().getHeight(); //On recupere la hauteutr de l'ecran

		this.activity = context;

		/** Initialisation des objets */
        this.buttonActualite  = new MainButton(context);
        this.buttonAgenda  = new MainButton(context);
        this.buttonNotes  = new MainButton(context);
        this.buttonContact  = new MainButton(context);
        this.buttonQuitter  = new MainButton(context);
		this.layout = new LinearLayout (context);
		this.scrollParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);


		/** configuration scrollview */
		this.setLayoutParams(scrollParams);
		this.setBackgroundColor(android.R.color.transparent);
		this.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        this.setFillViewport(true);
		this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		
		
		/** configuration des boutons */
		//On definit le texte
		this.buttonActualite.setText("Actualités");
		this.buttonAgenda.setText("Agenda");
		this.buttonNotes.setText("Mes notes");
		this.buttonContact.setText("Mes contacts");
		this.buttonQuitter.setText("Quitter");
		
		// Taille des boutons
		this.buttonActualite.setHeight(this.height / 6);
		this.buttonAgenda.setHeight(this.height / 6);
		this.buttonNotes.setHeight(this.height / 6);
		this.buttonContact.setHeight(this.height / 6);
		this.buttonQuitter.setHeight(this.height / 6);

		

		/** configuration du layout */
		this.layout.setOrientation(LinearLayout.VERTICAL);
        this.layout.addView(this.buttonActualite);
        this.layout.addView(this.buttonAgenda);
        this.layout.addView(this.buttonNotes);
        this.layout.addView(this.buttonContact);
        this.layout.addView(this.buttonQuitter);
		
        
        
		/** Ajout du Layout au scrollview */
		this.addView(layout);
		
		/** configuration des écouteurs de click */
		this.buttonActualite.setOnClickListener(this);
		this.buttonQuitter.setOnClickListener(this);
		this.buttonAgenda.setOnClickListener(this);
		this.buttonContact.setOnClickListener(this);
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
		else if(v.equals(this.buttonActualite))
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), ActualiteActivity.class);
			activity.startActivity(intent);
		}
		else if(v.equals(this.buttonAgenda)) //On ouvre le calendrier
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), CalendarActivity.class);
			activity.startActivity(intent);
		}
		else if(v.equals(this.buttonContact)) //Lorsqu'on click sur le bouton contact
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), OptionActivity.class);
			activity.startActivity(intent);
		}
	}

    

}
