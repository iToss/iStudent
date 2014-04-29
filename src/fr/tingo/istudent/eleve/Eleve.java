package fr.tingo.istudent.eleve;

import java.util.List;

import android.app.Activity;
import fr.tingo.istudent.util.Sauvegarde;

public class Eleve
{
  public int age;
  public List<Matiere> matieres;
  public String name;

  public Eleve(Activity paramActivity)
  {
    this.name = Sauvegarde.loadString("username", "Romain", paramActivity);
    this.matieres = Sauvegarde.loadListMatiere("student_matieres", paramActivity);
  }
}