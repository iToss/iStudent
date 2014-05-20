package fr.tingo.istudent.calendrier;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.R;
import fr.tingo.istudent.iStudentActivity;
import fr.tingo.istudent.util.Date;

public class CalendarActivity extends iStudentActivity implements OnClickListener 
{

	public RelativeLayout layout;
		
	public Button buttonMensuelle;
	public Button buttonJournalier;
	

	/** Dans ce genre d'Activité, les différents composants prennent l'ordre suivant:
	 * 
	 * ScrollView parent du Layout
	 * Layout parent de toutes les vues
	 * les vues filles du Layout
	 * 
	 * BaseActivity est l'activity de Base, qui affiche les options "Année, Mois, Jour" en haut de la fenetre
	 * 
	 */
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		this.layout = new RelativeLayout(this); //Instanciation d'un nouveau RelativeLayout vierge
		
		/** Bouton pour afficher sous forme mensuel */
		this.buttonMensuelle = new Button(this); //Initialisation puis confoguration du bouton "Mois"
		this.buttonMensuelle.setText("Mois");
		this.buttonMensuelle.setX(0);
		this.buttonMensuelle.setY(0);
		this.buttonMensuelle.setWidth(MainLayout.width / 2);
		this.buttonMensuelle.setOnClickListener(this);
		
		/** Bouton pour afficher sous forme journaliere */
		this.buttonJournalier = new Button(this); // initialisation puis configuration du bouton "Jour"
		this.buttonJournalier.setText("Jour");
		this.buttonJournalier.setX(MainLayout.width / 2);
		this.buttonJournalier.setY(0);
		this.buttonJournalier.setWidth(MainLayout.width / 2);
		this.buttonJournalier.setOnClickListener(this);
		
		this.setLayout(this.layout);
	}
	
	

	/** Il s'agit ici de la création du menu de la touche tactile "menu" du portable */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	/**Lorsqu'on clique sur un composant sous écouteur de clique... */
	@Override
	public void onClick(View v) // Lorsqu'on clique sur un composant
	{
		if(v.equals(this.buttonJournalier))
		{
			this.setLayout(new JournalierLayout(this, Date.getTodayDate()));
		}
		
		else if(v.equals(this.buttonMensuelle))
		{
			this.setLayout(new MensuelLayout(this, Date.getTodayDate()));
		}
	}


	
	/**Definit le contneu de l'Activité */
	public void setLayout(RelativeLayout p_layout)
	{
		this.layout.removeAllViews(); //On supprime toutes les vues du Layout pour que les boutons n'ait plus de parents
		this.layout = p_layout;
		this.layout.addView(this.buttonJournalier);
		this.layout.addView(this.buttonMensuelle);
		super.setContentView(this.layout);
	}
	



}

