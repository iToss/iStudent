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
import android.widget.Toast;
import fr.tingo.istudent.util.Color;
import fr.tingo.istudent.view.ButtonStudent;

public class DialogAddCreneau extends Dialog implements OnClickListener {

	public TimetableScrollView timetable_layout;
	
	public LinearLayout layout;
	public LinearLayout.LayoutParams layoutParams;
	
	public EditText editTextCours;
	public EditTextCreneau[] editTextCreneau;
	public Spinner spinnerColor;
	public ButtonStudent bouton_valider;
	
	
	public DialogAddCreneau(TimetableScrollView p_timetable_layout) 
	{
		super(p_timetable_layout.getContext());
		
		this.timetable_layout = p_timetable_layout; //On recupere le Layout du fond (emploi du temps)
		
		this.setTitle("Ajouter un cr�neau"); //on definit le titre du dialog
		
		this.layout = new LinearLayout(timetable_layout.getContext());
	    this.layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
	    this.layout.setBackgroundColor(Color.TRANSPARENT);
	    this.layout.setOrientation(LinearLayout.VERTICAL);
	    		
		this.editTextCours = new EditText(timetable_layout.getContext());
		this.editTextCours.setHint("Nom du cours...");
		
		this.editTextCreneau = new EditTextCreneau[2]; //Tableau � 2 EditText (pour les 2 horaires du cr�neaux)

		this.editTextCreneau[0] = new EditTextCreneau(timetable_layout.getContext());
		this.editTextCreneau[0].setHint("D�but du cr�neau...");
		
		this.editTextCreneau[1] = new EditTextCreneau(timetable_layout.getContext());
		this.editTextCreneau[1].setHint("Fin du cr�neau...");
		
		this.spinnerColor = new Spinner(timetable_layout.getContext());
	    List<String> choices = new ArrayList<String>(); //Liste de string
	    choices.add("Noir"); //On ajoute les couleurs disponibles
	    choices.add("Rouge");
	    choices.add("Vert");
	    choices.add("Jaune");
	    choices.add("Bleu");
	    choices.add("Violet");
	    choices.add("Orange");
	    choices.add("Gris");
	    choices.add("Marron");
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(timetable_layout.getContext(), android.R.layout.simple_spinner_dropdown_item, choices); //Un adapter de List de String pour la liste d�roulante
	    this.spinnerColor.setAdapter(spinnerArrayAdapter); //On d�finit les choix possibles de la liste d�roulante des couleurs
	    
		this.bouton_valider = new ButtonStudent(timetable_layout.getContext());
		this.bouton_valider.setText("Ajouter");
		this.bouton_valider.setOnClickListener(this);
		
		this.layout.addView(this.editTextCours); // on ajoute le champ du nom du cours
		this.layout.addView(this.editTextCreneau[0]); // on les ajoute au layout
		this.layout.addView(this.editTextCreneau[1]); // on les ajoute au layout
		this.layout.addView(this.spinnerColor); //on ajoute le spinner des couleurs
		this.layout.addView(this.bouton_valider); //On ajoute le bouton valider


		this.addContentView(this.layout, this.layoutParams); //On ajoute le layout au dialog pour afficher son contenu
	}
	
	
	
	  /** Recuperes le code HTML de la couleur choisit */
	  private int getHtmlColorFrom(int id)
	  {
		  switch(id) //On switch l'id 
		  {
		  	case 0: //S'il est �gal � 0...
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
		  		
		  	case 7:
		  		return Color.GRAY_CLAIR;
		  		
		  	case 8:
		  		return Color.BROWN_CLAIR;
		  		
		  	default: //sinon, on renvoit du noir
		  		return Color.BLACK;
		  }
	  }


	@Override
	public void onClick(View v)  //Lorsqu'on clique sur un �lement sous �couteur de clique (ici uniquement le bouton valider)
	{
		if(this.editTextCours.getText() != null && this.editTextCreneau[0].getText() != null && this.editTextCreneau[1].getText() != null)
		{
			String text = "<center>" 
								+  "<font color=\"" + getHtmlColorFrom(this.spinnerColor.getSelectedItemPosition()) + "\"> "
									+ "<big><big><big><big> <strong>" + this.editTextCours.getText().toString() + "</strong> </big></big></big></big>"
								+ "</font>"
								+ "<br></br><br></br>" 
								+ "de " + "<strong>" + this.editTextCreneau[0].heure_str + "</strong>"
								+ " � " + "<strong>" + this.editTextCreneau[1].heure_str + "</strong>"
							+ "</center>";
			
			TextViewTimetable t = new TextViewTimetable(this.timetable_layout.getContext(),
													text); //On cr�e un nouveau TextViewTimetable (affichage d'un cr�neau de cours)
			  
			this.timetable_layout.addCours(t, this.editTextCreneau[0].heure); //On l'ajoute � la vue, et on l'enregistre
			this.onBackPressed(); //on ferme le dialog
		}
		else
		{
			Toast.makeText(getContext(), "Veuillez compl�ter tous les champs", Toast.LENGTH_LONG).show();
		}
	}

}
