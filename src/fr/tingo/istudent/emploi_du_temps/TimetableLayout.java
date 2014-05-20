package fr.tingo.istudent.emploi_du_temps;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.util.Date;
import fr.tingo.istudent.util.Sauvegarde;

@SuppressLint("ViewConstructor")
public class TimetableLayout extends ScrollView implements OnClickListener, OnLongClickListener {
	
	public LinearLayout layout;
	public LinearLayout.LayoutParams scrollParams;
	
	public TextView textview_jour;
	public int jour;
	

	@SuppressLint({ "NewApi", "ResourceAsColor" }) //On utilise des méthodes utilisé par des versions android récentes + des couleurs sous forme de resources externes
	public TimetableLayout(TimetableActivity activity, int p_jour) 
	{
		super(activity);
		
		this.jour = p_jour;
		
		/** Initialisation des objets */
		this.layout = new LinearLayout(activity);
		this.scrollParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		
		/** configuration scrollview */
		this.setBackgroundColor(android.R.color.transparent); //Couleur de fond du scrollview (transparente, les boutons sont contenus dans le Layout
		this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)); //La scrollview rempli toute l'activity
        this.setFillViewport(true); //La scrollview rempli toute l'activity
		this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //On redessine la barre deroulante (pour ne pas voir le tracer du curseur

		/** configuration du layout */
		this.layout.setOrientation(LinearLayout.VERTICAL); //Vertical pour que les actualtiés déroules verticalement
		
		
		this.textview_jour = new TextView(activity); //On instancie un nouveau textview pour l'affichage du jour
		this.textview_jour.setText(Html.fromHtml("<strong>" + Date.jours[p_jour] + "</strong>")); //On recupere le nom du jour sous forme de String à partir de l'ID du jour de la semaine donné en paramètre
		this.textview_jour.setWidth(MainLayout.width);
		this.textview_jour.setHeight(MainLayout.height / 8);
		
		this.textview_jour.setTextSize(MainLayout.width / (this.textview_jour.getText().length() * 4));
	    this.textview_jour.setGravity(Gravity.CENTER);
	    this.textview_jour.setOnClickListener(this);
	    
	    this.layout.addView(this.textview_jour);
	    	    
	    List<TextViewTimetable> list = this.loadTimetable();
	    for(int i = 0; i < list.size(); i++) //Pour tous les TextViewTimetable t dans la liste textview_timetable
	    {
	    	list.get(i).setId(i);
	    	list.get(i).setOnLongClickListener(this);
	    	this.layout.addView(list.get(i)); //On les ajoute à la vue
	    }
	    
	    this.addView(this.layout);
	}

	
	
	/** Charges tous les TextViewTimetable de ce jour */
	@SuppressLint("NewApi")
	public List<TextViewTimetable> loadTimetable() 
	{
		List<TextViewTimetable> list = new ArrayList<TextViewTimetable>();
		
		List<String> cours = Sauvegarde.loadListString("timetable_cours_" + this.jour, this.getContext()); //Renvoies une liste qui contient tous les cours d'une journée sous forme de String avec leurs horaires

		for(int i = 0; i < cours.size(); i++)
		{
			TextViewTimetable t = new TextViewTimetable(this.getContext(), cours.get(i));
	    	t.setWidth(MainLayout.width);
	    	t.setHeight(MainLayout.height / 8);
	    	
	    	list.add(t); //On crée la liste des textview
		}
		
		return list;
	}
	
	
	/** Ajoutes un créneau à ce jour ci */
	@SuppressLint("NewApi")
	public void addCours(TextViewTimetable t)
	{
    	t.setWidth(MainLayout.width);
    	t.setHeight(MainLayout.height / 8);
    	
		this.layout.addView(t);
		Sauvegarde.addStringToList("timetable_cours_" + this.jour, t.cours, this.getContext());  //On sauvegarde le créneau en formmat HTML
	}



	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.textview_jour))
		{
			DialogAddCreneau d = new DialogAddCreneau(this);
			d.show();
		}
	}



	@Override
	public boolean onLongClick(View v) 
	{
		if(v instanceof TextViewTimetable)
		{
			Sauvegarde.removeStringFromListById("timetable_cours_" + this.jour, v.getId(), this.getContext());
			this.layout.removeViewAt(v.getId());
		}
		
		return false;
	}
	
	
}
