package fr.tingo.istudent.util;

import java.util.ArrayList;
import java.util.List;


public class Matiere {
	
	public List<Float[]> notes = new ArrayList<Float[]>();
	public float coef;
	public String matiere;
	
	public Matiere(String n_matiere, float n_coef) 
	{
		this.coef = n_coef;
		this.matiere = n_matiere;
		
	}

	
	public void addNote(float pnote, float pcoef)
	{
		// On ajoute la note à la liste de notes
		Float[] note = {pnote,pcoef};
		this.notes.add(note);
		
			
	}
	
	public void removeNote(float pnote, float pcoef)
	{
		// On ajoute la note à la liste de notes
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
		
		return (ptTotal / diviseur);
	}
		
		
}
