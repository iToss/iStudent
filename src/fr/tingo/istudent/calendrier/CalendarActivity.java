package fr.tingo.istudent.calendrier;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import fr.tingo.istudent.R;
import fr.tingo.istudent.util.Date;

public class CalendarActivity extends Activity implements OnClickListener {

	public Random rand = new Random();
	
	private int width; //Largeur de l'écran
	private int height; // Hauteur de l'écran
	private int uWidth; // Unité de la largeur de l'écran (largeur total / 100)
	private int uHeight; // Unité de la hauteur de l'écran (hauteur total / 100)

	public Button buttonMensuelle;
	public Button buttonJournalier;
	public ScrollView scrollView;
	public RelativeLayout layout;
	public ActivityContent content;
		
	
	
	/** Dans ce genre d'Activité, les différents composants prennent l'ordre suivant:
	 * 
	 * ScrollView parent du Layout
	 * Layout parent de toutes les vues
	 * les vues filles du Layout
	 * 
	 * BaseActivity est l'activity de Base, qui affiche les options "Année, Mois, Jour" en haut de la fenetre
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		/** Background */
		this.setWidth(this.getWindowManager().getDefaultDisplay().getWidth()); //On recupere la largeur de l'ecran
		this.setHeight(this.getWindowManager().getDefaultDisplay().getHeight()); //On recupere la hauteutr de l'ecran
		this.setuWidth(getWidth() / 100); // On crée des unités de mesures
		this.setuHeight(this.getHeight() / 100); 
		this.init(); // On execute la méthode "init";
		
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint({ "NewApi", "ResourceAsColor" })
	public void init() // On definit toute la vue de base, (fond, vue deroulante, bouton "mois" et "jour"
	{		
		
		/** Configuration du layout */
		this.layout = new RelativeLayout(this);
		this.layout.setBackgroundColor(Color.WHITE);

		/** configuration scrollview */
		this.scrollView = new ScrollView(this);
		this.scrollView.setBackgroundColor(android.R.color.transparent);
		this.scrollView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        this.scrollView.setFillViewport(true);
		this.scrollView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		/** Bouton pour afficher sous forme mensuel */
		this.buttonMensuelle = new Button(this); //Initialisation puis confoguration du bouton "Mois"
		this.buttonMensuelle.setText("Mois");
		this.buttonMensuelle.setX(0);
		this.buttonMensuelle.setY(0);
		this.buttonMensuelle.setWidth(this.getWidth() / 2);
		this.buttonMensuelle.setOnClickListener(this);
		this.getLayout().addView(buttonMensuelle, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)); // Ajout du bouton "Mois"
		
		/** Bouton pour afficher sous forme journaliere */
		this.buttonJournalier = new Button(this); // initialisation puis configuration du bouton "Jour"
		this.buttonJournalier.setText("Jour");
		this.buttonJournalier.setX(this.getWidth() / 2);
		this.buttonJournalier.setY(0);
		this.buttonJournalier.setWidth(this.getWidth() / 2);
		this.buttonJournalier.setOnClickListener(this);
		this.getLayout().addView(buttonJournalier, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)); // Ajout du bouton jour
	
		this.scrollView.addView(this.layout);
		this.setContentView(this.scrollView);
	}


	/** Il s'agit ici de la création du menu de la touche tactile "menu" du portable */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}




	@Override
	public void onClick(View v) // Lorsqu'on clique sur un composant
	{
		if(v.equals(this.buttonJournalier))
		{
			this.init(); //On redessine le layout par défaut (bouton Mois et Jour)
			this.content = new JournalierActivityContent(this, Date.getTodayDate());
		}
		
		else if(v.equals(this.buttonMensuelle))
		{
			this.init(); //On redessine le layout par défaut (bouton Mois et Jour)
			this.content = new MensuelActivityContent(this, Date.getTodayDate());
		}

	}


	/** retournes le layout de la vue principal */
	public RelativeLayout getLayout() {
		return layout;
	}


	/** retournes le layout de la vue principal */
	public void setLayout(RelativeLayout layout) {
		this.layout = layout;
	}


	/** Retournes une unité de largeur de l'ecran */
	public int getuWidth() {
		return uWidth;
	}



	public void setuWidth(int uWidth) {
		this.uWidth = uWidth;
	}



	public int getuHeight() {
		return uHeight;
	}


	/** Retournes une unité de hauteur de l'ecran */
	public void setuHeight(int uHeight) {
		this.uHeight = uHeight;
	}


/** Retournes la largeur de l'ecran */
	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}


	/** Retournes la hauteur de l'ecran */
	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}
	
	/** Ajoutes du contenu au layout */
	public void addContent(View view)
	{		
		if(view != null)
		{
			if( ((ViewGroup) view.getParent()) != null) // Si le contenu a deja un parent, on lui supprime pour lui redefinir son parent comme le layout.
			{
				((ViewGroup) view.getParent()).removeView(view);
			}
			this.layout.addView(view);
		}
	}


	public ActivityContent getActivityContent() {

		return this.content;
	}


}

