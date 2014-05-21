package fr.tingo.istudent.emploi_du_temps;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.R;
import fr.tingo.istudent.util.Date;
import fr.tingo.istudent.util.Sauvegarde;

@SuppressLint({ "ViewConstructor", "NewApi" })
public class TimetableScrollView extends ScrollView implements OnClickListener, OnLongClickListener {
	
	public TimetableActivity activity;
	public LinearLayout layout;
	public LinearLayout.LayoutParams scrollParams;
	
	public TextView textview_jour;
	public int jour;
	

	@SuppressLint({ "NewApi", "ResourceAsColor" }) //On utilise des méthodes utilisé par des versions android récentes + des couleurs sous forme de resources externes
	public TimetableScrollView(TimetableActivity p_activity, int p_jour) 
	{
		super(p_activity);
		
		this.activity = p_activity;
		this.jour = p_jour;
				
		/** configuration du layout */
		this.layout = new LinearLayout(activity);
		this.layout.setOrientation(LinearLayout.VERTICAL); //Vertical pour que les actualtiés déroules verticalement
		this.scrollParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);

		
		/** configuration scrollview */
		this.setBackgroundColor(android.R.color.transparent); //Couleur de fond du scrollview (transparente, les boutons sont contenus dans le Layout
		this.setLayoutParams(new LayoutParams(this.scrollParams)); //La scrollview rempli toute l'activity
        this.setFillViewport(true); //La scrollview rempli toute l'activity
		this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //On redessine la barre deroulante (pour ne pas voir le tracer du curseur
		
		this.textview_jour = new TextView(activity); //On instancie un nouveau textview pour l'affichage du jour
		this.textview_jour.setWidth(MainLayout.width);
		this.textview_jour.setHeight(MainLayout.height / 8);
	    this.textview_jour.setGravity(Gravity.CENTER);
	    this.textview_jour.setOnClickListener(this);
		this.textview_jour.setTextSize(MainLayout.width / 20);
		this.textview_jour.setText(Html.fromHtml("<strong>" + Date.jours[this.jour] + "</strong>")); //On recupere le nom du jour sous forme de String à partir de l'ID du jour de la semaine donné en paramètre		
		this.layout.addView(this.textview_jour);
		

		Animation anim = AnimationUtils.loadAnimation(this.activity, R.anim.gros_to_petit); // On charge une animation

	    List<TextViewTimetable> list = this.loadTimetable();
	    for(int i = 0; i < list.size(); i++) //Pour tous les TextViewTimetable t dans la liste textview_timetable
	    {
	    	list.get(i).setAnimation(anim);
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
	    	t.setLayoutParams(new LayoutParams(MainLayout.width, MainLayout.height / 6));
	    	t.setOnClickListener(this.activity);
	    	t.setOnTouchListener(this.activity);
	    	t.setOnLongClickListener(this);
	    	t.setId(i);

	    	list.add(t); //On crée la liste des textview
		}
		
		return list;
	}
	
	 
	/** Ajoutes un créneau à ce jour ci */
	@SuppressLint("NewApi")
	public void addCours(TextViewTimetable t, int horaire)
	{
		List<String> cours = Sauvegarde.loadListString("timetable_cours_" + this.jour, this.getContext());
		List<Integer> creneaux = Sauvegarde.loadListInt("timetable_creneau_" + this.jour, this.getContext());
		
		int i = 0;
		
		while(i < creneaux.size() && creneaux.get(i) < horaire)
			i++;
		
		cours.add(i, t.cours);
		creneaux.add(i, horaire);
		
		Sauvegarde.saveListString("timetable_cours_" + this.jour, cours, this.getContext());
		Sauvegarde.saveListInt("timetable_creneau_" + this.jour, creneaux, this.getContext());
		
		this.layout.removeAllViews();
		this.layout.addView(this.textview_jour);
		
		Animation anim = AnimationUtils.loadAnimation(this.activity, R.anim.gros_to_petit); // On charge une animation
		List<TextViewTimetable> timetables = this.loadTimetable();
		for(int j = 0; j < timetables.size(); j++)
		{
			if(i == j) //Si jamais il s'agit du creneau que l'on vient d'ajouter
				timetables.get(j).setAnimation(anim);
			this.layout.addView(timetables.get(j), j + 1);
		}
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
			Sauvegarde.removeStringFromListById("timetable_cours_" + this.jour, v.getId(), this.activity); //On supprime le créneau des sauvegardes
			Sauvegarde.removeIntFromListById("timetable_creneau_" + this.jour, v.getId(), this.activity); //On supprime le créneau des sauvegardes
			Toast.makeText(this.getContext(), "Vous avez bien supprimé ce créneau.", Toast.LENGTH_LONG).show();
			Bundle b = new Bundle();
			b.putInt("jour", this.jour);
			this.activity.onCreate(b); //On rappelle la méthode de création de l'activité pour synchroniser tout l'emploi du temps
		}
		
		return false;
	}


	
	
}
