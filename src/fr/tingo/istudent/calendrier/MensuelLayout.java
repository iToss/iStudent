package fr.tingo.istudent.calendrier;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.util.Date;

@SuppressLint("ViewConstructor") //Le constructeur par défaut n'est pas utilisé
public class MensuelLayout extends RelativeLayout implements OnClickListener, OnLongClickListener {

	private Date date;
	private Button boutonPrecedent; //Bouton mois précèdent
	private Button boutonSuivant; //Bouton mois suivant
	private TextView titre; // Titre, mois + année
	private TextViewDate dates[]; // TextViewDate de tous les jours du mois
	private TextView textViewJour[]; // TextView des 7 premiers jour du mois (Lun, Mar, Mer...)
	private CalendarActivity activity;

	/** Constructeur: contient le Context et la Date (pour savoir le mois et l'année concerné */
	@SuppressLint("NewApi") //Signale que la version d'android doit être supérieur à Android 7 (version très ancienne)
	public MensuelLayout(CalendarActivity c, Date d) 
	{
		super(c);
		this.date = d;
		this.activity = c;
		
		this.boutonPrecedent = new Button(c); //On instancie le bouton précèdent
		this.boutonSuivant = new Button(c); //On instancie le bouton suivant

		/** Configuration des boutons ... */
		this.boutonPrecedent.setText("<-");
		this.boutonPrecedent.setWidth(MainLayout.width / 5);
		this.boutonPrecedent.setX(MainLayout.width / 100);
		this.boutonPrecedent.setGravity(Gravity.CENTER);
		this.boutonPrecedent.setY(MainLayout.height / 6 - MainLayout.height / 100);
		this.boutonPrecedent.setOnClickListener(this);
		this.boutonPrecedent.setOnLongClickListener(this);

		this.boutonSuivant.setText("->");
		this.boutonSuivant.setWidth(MainLayout.width / 100 * 20);
		this.boutonSuivant.setX(MainLayout.width - MainLayout.width / 100 * 21);
		this.boutonSuivant.setGravity(Gravity.CENTER);
		this.boutonSuivant.setY(MainLayout.height / 6 - MainLayout.height / 100);	
		this.boutonSuivant.setOnClickListener(this);
		this.boutonSuivant.setOnLongClickListener(this);
		
		this.titre = new TextView(this.getContext()); // Initialisation du titre
		
		this.textViewJour = new TextView[7]; // Initialisation des TextView des 7 premiers jour du mois (Lun, Mar, Mer...)
		for(int i = 0; i < textViewJour.length; i++)
		{
			this.textViewJour[i] = new TextView(this.getContext());
		}
		
		this.dates = new TextViewDate[31]; // Initialisation des TextViewDate de tous les jours du mois (textview ayant une Date lié)
		for(int i = 0; i < 31; i++)
			this.dates[i] = new TextViewDate(this.activity, null);
		
		this.addView(this.boutonPrecedent);
		this.addView(this.boutonSuivant);
		
		int hauteur = MainLayout.height / 6;
		int decalage = hauteur * 2;
		
		// Definition du titre
		this.titre.setTypeface(null, Typeface.BOLD);	
		this.titre.setTextColor(Color.GRAY);
		this.titre.setTextSize(24.0F);
		this.titre.setText(this.date.getMoisEtAnnee());
		this.titre.setWidth(MainLayout.width);
		this.titre.setY(hauteur);
		this.titre.setGravity(Gravity.CENTER);
		this.addView(this.titre);

		

		// Dessin de tout les jours du mois
		for(int i = 0; i < this.date.getTotalDayInMonth(); i++) // Tous les jours du mois sont dessinées à la suite des autres
		{
			Date newDate = new Date(i + 1, this.date.getMois(), this.date.getAnnee());
			
			
			if(i % 7 == 0) // Si on est au rang 7, 14, 21 ou 28
			{
				decalage += MainLayout.height / 12;
			}
			
			this.dates[i] = new TextViewDate(this.activity, newDate);
			this.dates[i].setTextSize(16.0F);
			this.dates[i].setX(MainLayout.width / 50 + (MainLayout.width - MainLayout.width / 25) / 7 * ((i) % 7));
			this.dates[i].setY(decalage);
			this.dates[i].setLayoutParams(new LayoutParams(MainLayout.width / 7, MainLayout.height / 18));
			this.dates[i].setText(String.valueOf(i + 1));
			this.dates[i].setGravity(Gravity.CENTER);
			this.addView(this.dates[i]);

		} // Fin du for qui ajoute tous les jours de 1 à 31
		
		
		for(int i = 0; i < 7; i++) // Diminutif des jours
		{
			this.textViewJour[i].setX(MainLayout.width / 25 + (MainLayout.width - MainLayout.width / 50) / 7 * ((i) % 7));
			this.textViewJour[i].setY(hauteur * 2);
			this.textViewJour[i].setTextSize(16.0F);
			this.textViewJour[i].setTextColor(Color.GRAY);
			this.textViewJour[i].setText(dates[i].getDate().getDayDiminutif());
			this.textViewJour[i].setGravity(Gravity.CENTER);
			this.textViewJour[i].setTypeface(null, Typeface.BOLD);	
			this.addView(this.textViewJour[i]);
		}
		
	}


	/** Lorsqu'on clique... */
	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.boutonPrecedent)) //Sur le bouton précèdent
		{
			this.date.previousMonth(); //On passe au mois précèdent
			this.setContent();
		}
		else if(v.equals(this.boutonSuivant)) //Sur le bouton suivant 
		{
			this.date.nextMonth(); //On passe au mois suivant
			this.setContent();
		}
	}


	/** Lorsqu'on clique longtemps... */
	@Override
	public boolean onLongClick(View v) 
	{
		if(v.equals(this.boutonPrecedent)) //Sur le bouton précèdent
		{
			this.date.nextMonth();
			this.date.previousYear(); //On passe à l'année précèdente
			this.setContent();
		}
		else if(v.equals(this.boutonSuivant))//Sur le bouton suivant
		{
			this.date.previousMonth();
			this.date.nextYear(); //On passe à l'année suivante
			this.setContent();
		}

		return false;
	}


	/** definit les informations des composants de la page (nombre de jours, mois, année correspondants à la date */
	@SuppressLint("NewApi")
	private void setContent() 
	{
		
		for(int i = 0; i < this.date.getTotalDayInMonth(); i++) // Tous les jours du mois sont dessinées à la suite des autres
		{
			Date newDate = new Date(i + 1, this.date.getMois(), this.date.getAnnee());

			this.dates[i].setDate(newDate);
			this.dates[i].setText(String.valueOf(i + 1));
			this.dates[i].setGravity(Gravity.CENTER);
		} // Fin du for qui ajoute tous les jours de 1 à 31
		
		for(int i = 0; i < 7; i++) // Diminutif des jours
		{
			this.textViewJour[i].setText(dates[i].getDate().getDayDiminutif());
		}
		
		
		this.titre.setText(this.date.getMoisEtAnnee());

	}

}
