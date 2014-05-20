package fr.tingo.istudent.eleve;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import fr.tingo.istudent.util.Sauvegarde;


public class Matiere {
	
	public List<Float[]> notes = new ArrayList<Float[]>(); //Liste de tableau de décimals contenant une note et son coef
	public float coef; //Coefficient de la matière dans la moyenne générale
	public String matiere; //Nom de la matière
	public String id;


	public Matiere(Context c, String n_matiere, float n_coef)
	{
		this.coef = n_coef;
		this.matiere = n_matiere;
		this.id = (n_matiere + "_id");
		this.notes = Sauvegarde.loadListFloat(this.id, c);
	}


	public void addNote(float pnote, float pcoef)
	{
		// On ajoute la note � la liste de notes
		Float[] note = {pnote,pcoef};
		this.notes.add(note);
	}

	public void removeNote(float pnote, float pcoef)
	{
		// On supprime la note � la liste de notes
		Float[] note = {pnote, pcoef};
		this.notes.remove(note);
	}

	public float getMoyenne()
	{
		float ptTotal = 0;
		float diviseur = 0;
		
		for (int i = 0; i < notes.size(); i++) // On recupere le total des points et le total des coefficients
		{
			ptTotal += notes.get(i)[0] * notes.get(i)[1];
			diviseur += notes.get(i)[1];	
		}
		
		return (ptTotal / diviseur); //On calcul la moyenne avec les points totaux divisés par les coefficeints
	}


}
