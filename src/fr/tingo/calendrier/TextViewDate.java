package fr.tingo.calendrier;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import fr.tingo.istudent.util.Color;
import fr.tingo.istudent.util.Date;
import fr.tingo.istudent.util.Sauvegarde;

@SuppressLint("ViewConstructor")
public class TextViewDate extends TextView implements OnClickListener {

	private Date date;
	private CalendarActivity activity;


	/** Constructeurs, prends l'activity principal et une date */
	public TextViewDate(CalendarActivity act, Date pDate) {
		super(act);
		this.date = pDate;
		this.activity = act;
		this.setOnClickListener(this);
	}
	
	
	/** Defini la date lié au textview */
	public void setDate(Date pDate)
	{
		this.date = pDate;
	}


	/** Appelez lorsque le textView est dessiné, on dessine le texte, le cadre...*/
	@Override
    public void draw(Canvas canvas) 
    {
		
		this.setTextColor(Color.GRAY); // couleur du text

		Paint paint = new Paint();
		
		paint.setColor(Color.BLACK); // Couleur du contour des cases
		canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint); //Contour des cases
			
		paint.setColor(Color.LIGHTEN); // couleurs des cases
		canvas.drawRect(4, 4, this.getWidth() - 4, this.getHeight() - 4, paint); // Fond des cases blanches
		
		
		int color = 0;
		if(this.date.getDevoir(this.activity) != Sauvegarde.DEFAULT_DEVOIRS) //Si la date contient des devoirs, on l'affiche en CYAN
		{
			color = Color.BLEU;
		}
			
		if(this.date.getDate().equals(Date.getTodayDate().getDate())) //Si la date est la meme que celle d'aujourd'hui, on l'affiche en YELLOW
		{
			color = Color.CYAN;
		}
		
		
		
		paint.setColor(color);
		canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, this.getHeight() / 5 * 2, paint);
			
		paint.setColor(Color.LIGHTEN); // Couleur du cercle de fond
		canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, this.getHeight() / 5 * 2 - 8, paint); // Circle beige en fond

		
		super.draw(canvas);
    }

	
	/** Retournes la date du textview */
	public Date getDate()
	{
		int jour = Integer.valueOf((String) this.getText()); // Cast compliqué pour récuperer le jour sous forme d'Integer pour initialiser une date au jour cliqué
		int mois = this.date.getMois();
		int annee = this.date.getAnnee();
		
		return new Date(jour, mois, annee);
	}


	/** Lorsqu'on clique sur ce textview */
	@Override
	public void onClick(View v) 
	{
		this.activity.init(); //On redessine le layout par défaut (bouton Mois et Jour)
		int jour = Integer.valueOf((String) ((TextView) v).getText()); // Cast compliqué pour récuperer le jour sous forme d'Integer pour initialiser une date au jour cliqué
		int mois = getDate().getMois();
		int annee = getDate().getAnnee();
		JournalierActivityContent activityJour = new JournalierActivityContent(this.activity, new Date(jour, mois, annee)); // Création du contenu de la vue "Journaliere" (agenda)
		activityJour.configure();			
	}

	
}
