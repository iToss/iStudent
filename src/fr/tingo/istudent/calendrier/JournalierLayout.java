package fr.tingo.istudent.calendrier;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.calendrier.blague.Blague;
import fr.tingo.istudent.calendrier.blague.Citation;
import fr.tingo.istudent.calendrier.blague.DialogCalendar;
import fr.tingo.istudent.calendrier.blague.Savoir;
import fr.tingo.istudent.util.Color;
import fr.tingo.istudent.util.Date;
import fr.tingo.istudent.util.Sauvegarde;

@SuppressLint("ViewConstructor") //Signalisation qu'on n'utilise pas le constructeur par défaut de l'objet 
public class JournalierLayout extends RelativeLayout implements OnClickListener, OnLongClickListener {

	private Button boutonSave; // le bouton de sauvegarde des devoirs
	private TextView textViewDate; // l'affichage texte de la date
	private Button boutonBlague; // le bouton blague
	private EditText editText;
	private Button boutonPrecedent; //Bouton pour passer au jour precedent
	private Button boutonSuivant; //Bouton pour passer au jour suivant
	
	private Date date; //Date correspond à la date en cours d'edition

	@SuppressLint("NewApi")
	public JournalierLayout(Context context, Date d) {
		super(context);

		this.date = d;
		
		this.textViewDate = new TextView(context); // Initialisation du Titre, (mois + année)
		this.boutonSave = new Button(context); 
		this.boutonBlague = new Button(context); 
		this.editText = new EditText(context);
		this.boutonSuivant = new Button(context); 
		this.boutonPrecedent = new Button(context); 

		int hauteur = MainLayout.height / 6;	// hauteur de départ (1/6 de l'écran)	
		
		this.boutonPrecedent.setText("<-");
		this.boutonPrecedent.setWidth(MainLayout.width / 5);
		this.boutonPrecedent.setX(MainLayout.width / 100);
		this.boutonPrecedent.setGravity(Gravity.CENTER);
		this.boutonPrecedent.setY(MainLayout.height / 6 - MainLayout.height / 100);
		
		this.boutonSuivant.setText("->");
		this.boutonSuivant.setWidth(MainLayout.width / 100 * 20);
		this.boutonSuivant.setX(MainLayout.width - MainLayout.width / 100 * 21);
		this.boutonSuivant.setGravity(Gravity.CENTER);
		this.boutonSuivant.setY(MainLayout.height / 6 - MainLayout.height / 100);		
		
		this.textViewDate.setTypeface(null, Typeface.BOLD); // Configuration de la date affiché
		this.textViewDate.setTextColor(Color.GRAY);
		this.textViewDate.setTextSize(24.0F);
		this.textViewDate.setX(MainLayout.width / 4);
		this.textViewDate.setWidth(MainLayout.width / 2);
		this.textViewDate.setY(hauteur);
		this.textViewDate.setGravity(Gravity.CENTER);
		
		hauteur += 200;
		this.editText.setY(hauteur);
		this.editText.setWidth(MainLayout.width - MainLayout.width / 100 * 8);
		this.editText.setMinimumHeight(MainLayout.height / 3);
		this.editText.setX(MainLayout.width / 100 * 4);
		this.editText.setTextColor(Color.GRAY);
		
		hauteur += MainLayout.height / 3 + 100;
		this.boutonSave.setText("Sauvegarder les devoirs"); // Configuration du bouton sauvegarder
		this.boutonSave.setY(hauteur);
		this.boutonSave.setWidth(MainLayout.width / 2);
		this.boutonSave.setX(MainLayout.width / 4);
		this.boutonSave.setGravity(Gravity.CENTER);
		this.boutonSave.setHeight(MainLayout.height / 10);
		
		this.boutonBlague.setText("?");
		this.boutonBlague.setX(MainLayout.width / 4 + MainLayout.width / 2);
		this.boutonBlague.setY(hauteur + MainLayout.height / 80);
		this.boutonBlague.setWidth(MainLayout.width / 8);
		this.boutonBlague.setGravity(Gravity.CENTER);
		this.boutonBlague.setHeight(MainLayout.height / 20);


        this.setInformations(); // On definit les informations de la page.

		
		/** Création des écouteurs de click */
		this.boutonPrecedent.setOnClickListener(this);
		this.boutonSave.setOnClickListener(this);
    	this.boutonSuivant.setOnClickListener(this);		
    	this.boutonBlague.setOnClickListener(this);

    	
		/** Création de l'écouteur du click long sur le bouton precedent */
		this.boutonPrecedent.setOnLongClickListener(this);
		this.boutonSuivant.setOnLongClickListener(this);

        
        //On ajoute tout le contenu crée au Layout
        this.addView(this.textViewDate);
        this.addView(this.boutonBlague);
        this.addView(this.boutonSave);
        this.addView(this.editText);
        this.addView(this.boutonSuivant);
        this.addView(this.boutonPrecedent);
	}

	/** Lorsqu'on clique sur un composant sous écouteur de clique... */
	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.boutonSave))
		{
			Sauvegarde.saveString(this.date.getId(), editText.getText().toString(), this.getContext()); // On sauvegarde le contenu de chaque editText des Spinner
			Toast.makeText(this.getContext(), "Les devoirs ont été sauvegardés", Toast.LENGTH_SHORT).show(); // On affiche un message de sauvegarde.
		}
		else if(v.equals(this.boutonPrecedent))
		{
			this.date.previousDay(); //On recupere la date
			this.setInformations(); //On reinitnialise le contenu à cette date
		}
		else if(v.equals(this.boutonSuivant))
		{
			this.date.nextDay(); //On avance la date
			this.setInformations(); //On reinitnialise le contenu à cette date
		}
		else if(v.equals(this.boutonBlague))
		{
			Random rand = new Random(); // Objet random qui servira à diverses opérations

			
			int alea = (int) (System.currentTimeMillis() % 3); // Variable aléatoire de 0 à 2
			DialogCalendar dialog = null;
			
			switch(alea)
			{
				case 0: //S'il s'agit de 0, on affiche une Blague
					Blague question = new Blague(this.getContext(), rand);
					dialog = new DialogCalendar(this.getContext(), question); // On crée une nouvelle boite de dialogue
					dialog.show(); // On l'affiche
					break;
					
				case 1: //S'il s'agit de 1, un texte de type "Le savais - tu ? "
					Savoir savoir = new Savoir(rand);
					dialog = new DialogCalendar(this.getContext(), savoir); // On crée une nouvelle boite de dialogue
					dialog.show(); // On l'affiche
					break;
					
				case 2: //S'il s'agit de 2, alors on affiche une citation
					Citation citation = new Citation(rand);
					dialog = new DialogCalendar(this.getContext(), citation); // On crée une nouvelle boite de dialogue
					dialog.show(); // On l'affiche
					break;	
					
			}
		}
	}

	
	/** Lorsqu'on appuie longtemps sur un composant sous écouteur de clique ... */
	@Override
	public boolean onLongClick(View v) 
	{
		if(v.equals(this.boutonPrecedent))
		{
			date.previousWeek(); //On avance la date	
			setInformations(); //On reinitnialise le contenu de cette classe
			return true;
		}
		else if(v.equals(this.boutonSuivant))
		{
			this.date.nextWeek(); //On avance la date
			this.setInformations(); //On reinitnialise le contenu de cette classe
			return true;
		}
		
		
		return false;
	}

	
	/** On modifie les informations présentes sur la page (date, devoirs) */
	private void setInformations()
	{
		String date_str = this.date.jourString + " " + this.date.jour + " \n" + //String contenant la date sous la forme: Samedi 27 Janvier 2014
						this.date.moisString + " " + this.date.annee;
		
		this.textViewDate.setText(date_str); // On modifie l'affichage de la date 
		this.editText.setText(this.date.getDevoir(this.getContext()));
	}
	
	
}

