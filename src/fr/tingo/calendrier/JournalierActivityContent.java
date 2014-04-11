package fr.tingo.calendrier;

import java.util.Random;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.calendrier.blague.Blague;
import fr.tingo.istudent.calendrier.blague.Citation;
import fr.tingo.istudent.calendrier.blague.DialogCalendar;
import fr.tingo.istudent.calendrier.blague.Savoir;
import fr.tingo.istudent.util.Color;
import fr.tingo.istudent.util.Date;
import fr.tingo.istudent.util.Sauvegarde;

public class JournalierActivityContent extends ActivityContent {
	
	private Random rand = new Random(); // Objet random qui servira à diverses opérations
	
	private Button boutonSave; // le bouton de sauvegarde des devoirs
	private TextView textViewDate; // l'affichage texte de la date
	private Button imageButtonBlague; // le bouton blague
	private EditText editText;


	
	public JournalierActivityContent(CalendarActivity baseActivity, Date pDate) 
	{
		super(baseActivity, pDate);
	}

	/** Initialise tous les objets dont on aura besoin */
	public void init() 
	{
		super.init();
		this.textViewDate = new TextView(this.getActivity()); // Initialisation du Titre, (mois + année)
		this.boutonSave = new Button(this.getActivity()); 
		this.imageButtonBlague = new Button(this.getActivity()); 
		this.editText = new EditText(this.getActivity());
	}


	/** Initialise tout le contenu du layout et le configure*/
	@SuppressLint("NewApi")
	public void configure()
	{
		super.configure();
		
		int hauteur = this.getActivity().getHeight() / 6;		
		
		this.textViewDate.setTypeface(null, Typeface.BOLD); // Configuration de la date affiché
		this.textViewDate.setTextColor(Color.GRAY);
		this.textViewDate.setTextSize(24.0F);
		this.textViewDate.setX(this.getActivity().getWidth() / 4);
		this.textViewDate.setWidth(this.getActivity().getWidth() / 2);
		this.textViewDate.setY(hauteur);
		this.textViewDate.setGravity(Gravity.CENTER);
		
		hauteur += 200;
		this.editText.setY(hauteur);
		this.editText.setWidth(this.getActivity().getWidth() - (this.getActivity().getuWidth() * 8));
		this.editText.setMinimumHeight(this.getActivity().getHeight() / 3);
		this.editText.setX(this.getActivity().getuWidth() * 4);
		this.editText.setTextColor(Color.GRAY);
		
		hauteur += this.getActivity().getHeight() / 3 + 100;
		this.boutonSave.setText("Sauvegarder les devoirs"); // Configuration du bouton sauvegarder
		this.boutonSave.setY(hauteur);
		this.boutonSave.setWidth(this.getActivity().getWidth() / 2);
		this.boutonSave.setX(this.getActivity().getWidth() / 4);
		this.boutonSave.setGravity(Gravity.CENTER);
		this.boutonSave.setHeight(this.getActivity().getHeight() / 10);
		
		this.imageButtonBlague.setText("?");
		this.imageButtonBlague.setX(this.getActivity().getWidth() / 4 + this.getActivity().getWidth() / 2 + this.getActivity().getuWidth() * 2);
		this.imageButtonBlague.setY(hauteur + this.getActivity().getHeight() / 80);
		this.imageButtonBlague.setWidth(this.getActivity().getWidth() / 8);
		this.imageButtonBlague.setGravity(Gravity.CENTER);
		this.imageButtonBlague.setHeight(this.getActivity().getHeight() / 20);


        this.setInformations(); // On definit les informations de la page.

        
        
        /** Ecouteur de cliques pour sauvegarder les devoirs */
        this.boutonSave.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v)  // lorsqu'on clique sur le bouton save ...
			{
				Sauvegarde.saveString(getDate().getId(), editText.getText().toString(), activity); // On sauvegarde le contenu de chaque editText des Spinner
				Toast.makeText(getActivity(), "Les devoirs ont été sauvegardés", Toast.LENGTH_SHORT).show(); // On affiche un message de sauvegarde.
			}
        	
        });
        
        
        // Ecouteur de clique de l'ImageButton (pour les blagues, citations ...
        this.imageButtonBlague.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View v) {
				int alea = rand.nextInt(3); // Variable aléatoire de 0 à 2
				DialogCalendar dialog = null;
				
				switch(alea)
				{
					case 0: 
						Blague question = new Blague(getActivity(), rand);
						dialog = new DialogCalendar(getActivity(), question); // On crée une nouvelle boite de dialogue
						dialog.show(); // On l'affiche
						break;
						
					case 1: 
						Savoir savoir = new Savoir(rand);
						dialog = new DialogCalendar(getActivity(), savoir); // On crée une nouvelle boite de dialogue
						dialog.show(); // On l'affiche
						break;
						
					case 2: 
						Citation citation = new Citation(rand);
						dialog = new DialogCalendar(getActivity(), citation); // On crée une nouvelle boite de dialogue
						dialog.show(); // On l'affiche
						break;	
				}				
			}
        	
        });
        
                
		/** Création de l'écouteur du click sur le bouton suivant */
    	this.getBoutonSuivant().setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().nextDay(); //On avance la date
				configure(); //On reinitnialise le contenu de cette classe
			}
			
		});		
		
    	
		/** Création de l'écouteur du click long sur le bouton suivant */
		this.getBoutonSuivant().setOnLongClickListener(new OnLongClickListener()
		{

			@Override
			public boolean onLongClick(View v) 
			{
				
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().nextWeek(); //On avance la date
				configure(); //On reinitnialise le contenu de cette classe
				
				return false;
			}
			
		});	
		
		
		/** Création de l'écouteur du click sur le bouton precedent */
		this.getBoutonPrecedent().setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{	
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().previousDay(); //On avance la date
				configure(); //On reinitnialise le contenu de cette classe
			}
			
		});
		
		
		/** Création de l'écouteur du click long sur le bouton precedent */
		this.getBoutonPrecedent().setOnLongClickListener(new OnLongClickListener() 
		{

			@Override
			public boolean onLongClick(View v)
			{	
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().previousWeek(); //On avance la date	
				configure(); //On reinitnialise le contenu de cette classe
				return false;
			}
			
		});
		
        
        //On ajoute tout le contenu crée au Layout
        this.getContentList().add(this.textViewDate);
        this.getContentList().add(this.imageButtonBlague);
        this.getContentList().add(this.boutonSave);
        this.getContentList().add(this.editText);



        super.addContentToActivity();
	}
	
	
	/** On modifie les informations présentes sur la page */
	private void setInformations()
	{
		this.textViewDate.setText(this.getDate().getSpaceDate()); // On modifie l'affichage de la date 
		this.editText.setText(this.getDate().getDevoir(this.getActivity()));
	}
	
	

	


	
}
