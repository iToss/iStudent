package fr.tingo.istudent.emploi_du_temps;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import fr.tingo.istudent.util.Color;
import fr.tingo.istudent.view.ButtonStudent;

public class DialogAddCreneau extends Dialog implements OnClickListener {

	public TimetableLayout timetable_layout;
	
	public LinearLayout layout;
	public LinearLayout.LayoutParams layoutParams;
	
	public EditText[] editTextCours;
	public Spinner spinnerColor;
	public ButtonStudent bouton_valider;
	
	
	public DialogAddCreneau(TimetableLayout p_timetable_layout) 
	{
		super(p_timetable_layout.getContext());
		
		this.timetable_layout = p_timetable_layout; //On recupere le Layout du fond (emploi du temps)
		
		this.setTitle("Ajouter un créneau"); //on definit le titre du dialog
		
		this.layout = new LinearLayout(timetable_layout.getContext());
	    this.layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
	    this.layout.setBackgroundColor(Color.TRANSPARENT);
	    this.layout.setOrientation(LinearLayout.VERTICAL);
	    
		this.editTextCours = new EditText[3]; //Tableau à 3 EditText (nom du cours, horaires de début et horaires de fin
		this.editTextCours[0] = new EditText(timetable_layout.getContext());
		this.editTextCours[0].setHint("Nom du cours...");
		
		this.editTextCours[1] = new EditText(timetable_layout.getContext());
		this.editTextCours[1].setHint("Début du créneau...");
	
		this.editTextCours[2] = new EditText(timetable_layout.getContext());
		this.editTextCours[2].setHint("Fin du créneau...");
		
		this.spinnerColor = new Spinner(timetable_layout.getContext());
	    List<String> choices = new ArrayList<String>(); //Liste de string
	    choices.add("Blanc"); //On ajoute les couleurs disponibles
	    choices.add("Rouge");
	    choices.add("Vert");
	    choices.add("Jaune");
	    choices.add("Bleu");
	    choices.add("Violet");
	    choices.add("Orange");
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(timetable_layout.getContext(), android.R.layout.simple_spinner_dropdown_item, choices); //Un adapter de List de String pour la liste déroulante
	    this.spinnerColor.setAdapter(spinnerArrayAdapter); //On définit les choix possibles de la liste déroulante des couleurs
	    
		this.bouton_valider = new ButtonStudent(timetable_layout.getContext());
		this.bouton_valider.setText("Ajouter");
		this.bouton_valider.setOnClickListener(this);
		
		for(EditText e : this.editTextCours) //Pour tous les edittext e du tableau...
			this.layout.addView(e); // on les ajoute au layout
		
		this.layout.addView(this.spinnerColor); //on ajoute le spinner des couleurs
		
		this.layout.addView(this.bouton_valider);


		this.addContentView(this.layout, this.layoutParams); //On ajoute le layout au dialog
	}
	
	
	
	  /** Recuperes le code HTML de la couleur choisit */
	  private int getHtmlColorFrom(int id)
	  {
		  switch(id) //On switch l'id 
		  {
		  	case 0: //S'il est égal à 0...
		  		return Color.BLACK;
		  		
		  	case 1:
		  		return Color.RED;
		  		
		  	case 2:
		  		return Color.GREEN;
		  		
		  	case 3:
		  		return Color.YELLOW;
		  		
		  	case 4:
		  		return Color.CYAN;
		  		
		  	case 5:
		  		return Color.MAGENTA;
		  		
		  	case 6:
		  		return Color.ORANGE;
		  		
		  	default: //sinon, on renvoit du noir
		  		return Color.BLACK;
		  }
	  }


	@Override
	public void onClick(View v) 
	{
		
		String text = "<center>" 
							+  "<font color=\"" + getHtmlColorFrom(this.spinnerColor.getSelectedItemPosition()) + "\"> <big><big> <strong>" + this.editTextCours[0].getText().toString() + "</strong> </big></big> </font>"
							+ "<br></br><br></br>" 
							+ "de " + "<strong>" + this.editTextCours[1].getText().toString() + "</strong>"
							+ " à " + "<strong>" + this.editTextCours[2].getText().toString() + "</strong>"
						+ "</center>";
		
		TextViewTimetable t = new TextViewTimetable(this.timetable_layout.getContext(),
												text);
		  
		this.timetable_layout.addCours(t);
		this.onBackPressed(); //on ferme le dialog
	}

}
