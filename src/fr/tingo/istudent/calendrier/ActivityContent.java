package fr.tingo.istudent.calendrier;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import fr.tingo.istudent.util.Date;

public class ActivityContent {
	
	public CalendarActivity activity;
	private List<View> contentList;
	private Date date;
	private Button boutonPrecedent;
	private Button boutonSuivant;
	public Button buttonMensuelle;
	public Button buttonJournalier;
	
	
	/** Constructeurs, permettant de recuperer l'Activity principal et la date correspondant à celle souhaité */
	public ActivityContent(CalendarActivity pActivity, Date pDate)
	{
		this.contentList = new ArrayList<View>();
		this.setActivity(pActivity);
		this.date = pDate;
		this.init();
		this.configure();
	}
	
	
	/** Initialisation de tous les objets dont on aura besoin */
	public void init() 
	{
		this.boutonPrecedent = new Button(this.getActivity()); //Initialsiation du bouton precedent
		this.boutonSuivant = new Button(this.getActivity()); //Initialsiation du bouton suivant
	}
	
	/** Configuration des objets crées par l'init */
	@SuppressLint("NewApi")
	public void configure() 
	{

		this.getBoutonPrecedent().setText("<-");
		this.getBoutonPrecedent().setWidth(this.getActivity().getuWidth() * 20);
		this.getBoutonPrecedent().setX(this.getActivity().getuWidth());
		this.getBoutonPrecedent().setGravity(Gravity.CENTER);
		this.getBoutonPrecedent().setY(this.getActivity().getHeight() / 6 - this.getActivity().getuHeight());
		this.getContentList().add(getBoutonPrecedent());
		
		this.getBoutonSuivant().setText("->");
		this.getBoutonSuivant().setWidth(this.getActivity().getuWidth() * 20);
		this.getBoutonSuivant().setX(this.getActivity().getWidth() - this.getActivity().getuWidth() * 21);
		this.getBoutonSuivant().setGravity(Gravity.CENTER);
		this.getBoutonSuivant().setY(this.getActivity().getHeight() / 6 - this.getActivity().getuHeight());
		this.getContentList().add(getBoutonSuivant());
	}
	
	
	/** Recuperes l'activity du layout */
	public CalendarActivity getActivity() {
		return activity;
	}

	/** Definit l'activity du layout */
	public void setActivity(CalendarActivity activity) {
		this.activity = activity;
	}

	/** Recupere la liste de contenu du layout */
	public List<View> getContentList() {
		return contentList;
	}

	/** Définit la liste de contenu du layout */
	public void setContentList(List<View> contentList) {
		this.contentList = contentList;
	}
	
	/** Recuperer la date */
	public Date getDate()
	{
		return this.date;
	}
	
	/** Definir la date */
	public void setDate(Date pDate)
	{
		this.date = pDate;
	}


	/** Ajoutes tout le contenu à l'activity */
	public void addContentToActivity() 
	{
		//on ajoute tout le contenu à l'activity
		for(int i = 0; i < this.getContentList().size(); i++) //On l'ajoute à l'activity
		{
			this.getActivity().addContent(getContentList().get(i));
		}		
	}

	/** Retournes le bouton precedent */
	public Button getBoutonPrecedent() {
		return boutonPrecedent;
	}

	/** Retournes le bouton precedent */
	public void setBoutonPrecedent(Button boutonPrecedent) {
		this.boutonPrecedent = boutonPrecedent;
	}

	/** Retournes le bouton suivant */
	public Button getBoutonSuivant() {
		return boutonSuivant;
	}

	/** Definit le bouton suivant */
	public void setBoutonSuivant(Button boutonSuivant) {
		this.boutonSuivant = boutonSuivant;
	}


	/** Animes toute la page avec l'animation souhaité */
	public void animerLaPage(Animation animation) 
	{
		for(int i = 0; i < this.contentList.size(); i++)
		{
			if(this.contentList.get(i) != null)
			{
				this.contentList.get(i).startAnimation(animation);
			}
		}
	}
	

}
