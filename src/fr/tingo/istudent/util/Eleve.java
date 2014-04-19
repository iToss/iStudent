package fr.tingo.istudent.util;

import java.util.List;

import android.app.Activity;

public class Eleve {
	
	public String name;
	public int age;
	public List<Matiere> matieres;
	
	public Eleve(Activity activity)
	{
		this.name = Sauvegarde.loadString("username", "Romain", activity);
		this.matieres = Sauvegarde.loadListMatiere(this.name + "_matieres", activity);
	}
	

}
