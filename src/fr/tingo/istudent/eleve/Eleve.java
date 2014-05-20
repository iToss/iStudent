package fr.tingo.istudent.eleve;

import java.util.List;

import android.app.Activity;
import fr.tingo.istudent.util.Sauvegarde;

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
