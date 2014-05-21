package fr.tingo.istudent.emploi_du_temps;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.iStudentActivity;
import fr.tingo.istudent.util.Date;
import fr.tingo.istudent.util.Sauvegarde;

@SuppressLint("NewApi")
public class TimetableActivity extends iStudentActivity implements OnTouchListener, OnClickListener {
	
	public int jour;
	public Point point_down;
	public Point point_up;
	public long lastChanged;
	
	@Override
	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		this.jour =  (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 5) % 6; //Retournes l'id du jour (0 pour Dimanche, 1 pour Lundi, 2 pour Mardi etc...)
		this.point_down = null; //Point lorsqu'on touche l'écran
		this.point_up = new Point(0, 0); //Point lorsqu'on releve le doight de l'écran
		this.setDay();
	}
	
	
	@Override //On recupere une méthode parente que l'on modifie
    protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		
		if(Sauvegarde.loadInt("message_info_timetable", 0, this) == 0)
		{
				Toast.makeText(this, Html.fromHtml("Cliquez sur <strong>" + Date.jours[this.jour] + "</strong> pour ajouter un créneau. <br></br><br></br>"
											+ "Bougez votre doigt sur l'écran pour passer à un autre jour. <br></br><br></br>"
											+"Restez appuyé sur un créneau pour le supprimer."), Toast.LENGTH_LONG).show();
				Sauvegarde.saveInt("message_info_timetable", 1, this);
		}
    }

	/** Definit le contenu de l'activité (l'emploi du temps à tel jour) */
	private void setDay()
	{
		TimetableScrollView t = new TimetableScrollView(this, this.jour);
		t.layout.setOnTouchListener(this);
		t.layout.setOnClickListener(this);
		this.setContentView(t);
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{			
		if(this.point_down == null) //Si la position est null... (permet de recuperer la position lors du toucher
		{
			this.point_down = new Point(event.getX(), event.getY());
		}
			
		this.point_up.x = event.getX();
		this.point_up.y = event.getY();
		
		return false;
	}


	@Override
	public void onClick(View v) //necesaire pour repeter le OnTouch lorsqu'ont ouche l'écran
	{
		Vecteur vec = new Vecteur(this.point_down, this.point_up); //Vecteur mouvement du doigt (fait à partir du point de doigt lors du touché et du levé du doigt
		
		if(System.currentTimeMillis() - this.lastChanged > 200) //Si on a pas changé de jour depuis plus de 200 millisecondes
		{
			if(vec.x < -MainLayout.width / 8) //Il faut que le vecteur mouvement soit d'au moins 1/8 de la largeur de l'ecran pour que la condition soit réalisé
			{
				this.jour = (this.jour + 6) % 7;
				this.setDay();
			}
			else if(vec.x > MainLayout.width / 8) //Il faut que le vecteur mouvement soit d'au moins 1/8 de la largeur de l'ecran pour que la condition soit réalisé
			{
				this.jour = (this.jour + 8) % 7;
				this.setDay();
			}
			
			this.lastChanged = System.currentTimeMillis();
		}
		
		
		this.point_down = null;
		this.point_up = new Point(0, 0);
	}

}
