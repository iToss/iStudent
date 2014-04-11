package fr.tingo.calendrier;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import fr.tingo.istudent.util.Date;

public class MensuelActivityContent extends ActivityContent
{

	private TextView titre; // Titre, mois + année
	private TextViewDate dates[]; // TextViewDate de tous les jours du mois
	private TextView textViewJour[]; // TextView des 7 premiers jour du mois (Lun, Mar, Mer...)
	

	public MensuelActivityContent(CalendarActivity pActivity, Date pDate)
	{
		super(pActivity, pDate);
	}
	
	/** Initialise toutes les vues lors de la création de l'objet */
	public void init() 
	{
		super.init();
		
		this.titre = new TextView(this.getActivity()); // Initialisation du titre
		
		this.textViewJour = new TextView[7]; // Initialisation des TextView des 7 premiers jour du mois (Lun, Mar, Mer...)
		for(int i = 0; i < textViewJour.length; i++)
		{
			this.textViewJour[i] = new TextView(this.getActivity());
		}
		
		this.dates = new TextViewDate[31]; // Initialisation des TextViewDate de tous les jours du mois (textview ayant une Date lié)
		Date today = Date.getTodayDate();
		
		for(int i = 0; i < dates.length; i++)
		{
			this.dates[i] = new TextViewDate(this.getActivity(), today);
		}
	}
	
	/** Configure les caractériques de toutes les vues (coordonées, textes, dates, écouteurs de cliques, Gravité, taille, couleur etc */
	@SuppressLint("NewApi")
	public void configure()
	{					
		super.configure();
		
		int hauteur = this.getActivity().getHeight() / 6;
		int decalage = hauteur * 2;
		
		
		// Definition du titre
		this.titre.setTypeface(null, Typeface.BOLD);	
		this.titre.setTextColor(Color.GRAY);
		this.titre.setTextSize(24.0F);
		this.titre.setText(getDate().getMoisEtAnnee());
		this.titre.setWidth(this.getActivity().getWidth());
		this.titre.setY(hauteur);
		this.titre.setGravity(Gravity.CENTER);
		this.getContentList().add(titre);

	
		

		// Dessin de tout les jours du mois
		for(int i = 0; i < this.getDate().getTotalDayInMonth(); i++) // Tous les jours du mois sont dessinées à la suite des autres
		{
			Date newDate = new Date(i + 1, this.getDate().getMois(), this.getDate().getAnnee());
			
			
			if(i % 7 == 0) // Si on est au rang 7, 14, 21 ou 28
			{
				decalage += 160;
			}
			
			this.dates[i].setDate(newDate); // On attribue une date au textView
			this.dates[i].setTextSize(16.0F);
			this.dates[i].setX(this.getActivity().getuWidth() * 2 + (this.getActivity().getWidth() - this.getActivity().getuWidth() * 4) / 7 * ((i) % 7));
			this.dates[i].setY(decalage);
			this.dates[i].setWidth(this.getActivity().getWidth() / 7);
			this.dates[i].setHeight(100);
			this.dates[i].setText(String.valueOf(i + 1));
			this.dates[i].setGravity(Gravity.CENTER);

			this.getContentList().add(this.dates[i]);
			
		} // Fin du for qui ajoute tous les jours de 1 à 31
		
		
		for(int i = 0; i < 7; i++) // Diminutif des jours
		{
			this.textViewJour[i].setX(this.getActivity().getuWidth() * 4 + (this.getActivity().getWidth() - this.getActivity().getuWidth() * 2) / 7 * ((i) % 7));
			this.textViewJour[i].setY(hauteur * 2);
			this.textViewJour[i].setTextSize(16.0F);
			this.textViewJour[i].setTextColor(Color.GRAY);
			this.textViewJour[i].setText(dates[i].getDate().getDayDiminutif());
			this.textViewJour[i].setGravity(Gravity.CENTER);
			this.textViewJour[i].setTypeface(null, Typeface.BOLD);	
			this.getContentList().add(this.textViewJour[i]);
		}
		

		
		this.getBoutonPrecedent().setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{	
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().previousMonth(); //On avance la date
				configure(); //On reinitnialise le contenu de cette classe
				//titre.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.verslagauche)); //On fait l'animation
			}
			
		});
		
		this.getBoutonPrecedent().setOnLongClickListener(new OnLongClickListener()
		{

			@Override
			public boolean onLongClick(View v)
			{	
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().previousYear(); //On avance la date	
				configure(); //On reinitnialise le contenu de cette classe
				//titre.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.verslagauche)); //On fait l'animation
				return false;
			}
			
		});
		

		this.getBoutonSuivant().setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().nextMonth(); //On avance la date
				configure(); //On reinitnialise le contenu de cette classe
				//titre.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.versladroite)); //On fait l'animation
			}
			
		});		
		
		this.getBoutonSuivant().setOnLongClickListener(new OnLongClickListener()
		{

			@Override
			public boolean onLongClick(View v) 
			{
				
				getActivity().init(); //On reinitialise l'activity principale (bouton Mois + Jour)
				getDate().nextYear(); //On avance la date
				configure(); //On reinitnialise le contenu de cette classe
				//titre.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.versladroite)); //On fait l'animation

				return false;
			}
			
		});	
		
		
		
		
		super.addContentToActivity();
		
	}

	


}

