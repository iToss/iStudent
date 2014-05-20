package fr.tingo.istudent.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import fr.tingo.istudent.MainLayout;

@SuppressLint("ViewConstructor")
public class EditTextStudent extends EditText implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener
{
	public Button[] bouton_tableau;
	public String id;
	public Spinner spinnerColor;
	
	  /** Objet qui hérite de l'EditText (champ pour entrer du texte) 
	   * @param paramActivity : Activité dans laquel l'edittext est contenu
	   * @param layout : layout dans lequel l'edittext (pour y ajouter les boutons d'options de mis en page
	   * @param y : hauteur à laquel se situe la barre de mis en page
	   */
	  @SuppressLint({"NewApi"})
	  public EditTextStudent(Activity paramActivity, RelativeLayout layout, int y)
	  {
	    super(paramActivity);
	   
	    this.bouton_tableau = new Button[4]; //Tableau contenant 4 boutons pour la barre d'outils
	    for(int i = 0; i < bouton_tableau.length; i++) //On fait une boucle de 0 à la longueu du tableau
	    {
	    	this.bouton_tableau[i] = new Button(paramActivity); //On instancie chaque bouton
	    	this.bouton_tableau[i].setId(i); //On définit l'ID unique de chaque bouton
	    	this.bouton_tableau[i].setX(MainLayout.width / 100 + MainLayout.width / 6 * i); //On place chaque bouton sur l'axe des abscices
	    	this.bouton_tableau[i].setOnClickListener(this); //On place les boutosn sur écouteur de clique
	    	this.bouton_tableau[i].setY(y); //Position Y de chauqe bouton (identique, dépends de l'argument utilisé pour l'objet
	    	layout.addView(this.bouton_tableau[i]); //On ajoute chaque bouton au layout de l'EditText
	    }
	    
	    //on definit le texte de chaque boutons: 
	    this.bouton_tableau[0].setText(Html.fromHtml("<strong>G</strong>")); //Bouton pour mettre en gras
	    this.bouton_tableau[1].setText(Html.fromHtml("<u>S</u>")); //Bouton pour souligner
	    this.bouton_tableau[2].setText(Html.fromHtml("<i>I</i>")); //Bouton pour mettre en italique
	    this.bouton_tableau[3].setText("•"); //Bouton pour modifier la couleur une fois choisit dans la liste déroulante
	    
	    this.setOnClickListener(this); //On place l'edittext sous ecouteur de clique
	    this.setOnFocusChangeListener(this); //On place la vue sur écouteur de changement de focalisation (lorque l'user utilise ou non l'objet)
	  
	    this.spinnerColor = new Spinner(paramActivity); //Instanciation du Spinner (liste déroulante) des couleurs

	    List<String> choices = new ArrayList<String>(); //Liste de string
	    choices.add("Noir"); //On ajoute les couleurs disponibles
	    choices.add("Rouge");
	    choices.add("Vert");
	    choices.add("Jaune");
	    choices.add("Bleu");
	    choices.add("Violet");
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, choices); //Un adapter de List de String pour la liste déroulante
	    this.spinnerColor.setAdapter(spinnerArrayAdapter); //On définit les choix possibles de la liste déroulante des couleurs
	    
	    this.spinnerColor.setX(MainLayout.width / 50 + 2 * MainLayout.width / 3); //On place la liste déroualnte sur l'axe des abscices
	    this.spinnerColor.setOnItemSelectedListener(this); //On place le spinner sous écouteur de clique
	    this.spinnerColor.setY(y); //Position Y du spinner
	    layout.addView(this.spinnerColor);
	    
	    for(int i = 0; i < bouton_tableau.length; i++) //On fait une boucle de 0 à la longueu du tableau
	    	this.bouton_tableau[i].setVisibility(INVISIBLE); //On rend tous les boutons invisibles
	    
	    this.spinnerColor.setVisibility(INVISIBLE);
	  }
	
	  /** Recuperes le code HTML de la couleur choisit */
	  private String getHtmlColorFrom(int id)
	  {
		  switch(id) //On switch l'id 
		  {
		  	case 0: //S'il est égal à 0...
		  		return "black";
		  		
		  	case 1:
		  		return "red";
		  		
		  	case 2:
		  		return "green";
		  		
		  	case 3:
		  		return "yellow";
		  		
		  	case 4:
		  		return "blue";
		  		
		  	case 5:
		  		return "purple";
		  		
		  	default: //sinon, on renvoit du noir
		  		return "black";
		  }
	  }
	
	  
	  /** Ajoutes une balise à l'edittext, pour que la mis en forme se fasse automatiquement (convertissant les balises insérées de l'HTML vers du texte en forme */
	  public void addBalises(String ... balises)
	  {
		  int start = this.getSelectionStart(); //On recupere la 1ere selection du curseur
		  int end = this.getSelectionEnd(); //La deuxieme selection du curseur
		  
		  if(start != end) //Si la selection n'est pas vide
		  {
			  String focus = this.getText().toString().substring(start, end); //On recupere le texte qui est sous le curseur
			  
			  String html = Html.toHtml(this.getText()); //On convertis ce texte en html (ce qui permis le multi-balisage, texte souligné, gras en couleur)
			  
			  Spanned text = Html.fromHtml(html.replace(focus, balises[0] + focus + balises[1])); //On crée une Spanned (qui est un String utilisé pour la mis en page, et on convertis le texte précèdent ajouté aux balises en html pour la mis en page)
			  this.setText(text); //On definit le texte de l'edit text
			  this.setSelection(this.getText().length()); //On place la selection du curseur à la fin du texte
		  }
	  }
	
	  
	  public void onClick(View v) //lorsuq'on clique sur une balise
	  {
		  if(v.getId() == 0) //Si son ID est égal à 1 ...
		  {
			  this.addBalises("<strong>", "</strong>");
		  }
		  else if(v.getId() == 1)
		  {
			  this.addBalises("<u>", "</u>");
		  }
		  else if(v.getId() == 2)
		  {
			  this.addBalises("<i>", "</i>");
		  }
		  else if(v.getId() == 3)
		  {
			  this.addBalises("<font color=\"" + getHtmlColorFrom(this.spinnerColor.getSelectedItemPosition()) + "\">", "</font>");
		  }
			  
	  }
	
	  /** Lorsque la focalisation de l'utilisateur sur l'objet change */
	  public void onFocusChange(View paramView, boolean hasFocus)
	  {
	    if(hasFocus) //Si la vue recupere le focus
	    {  
		    for(int i = 0; i < bouton_tableau.length; i++) //On fait une boucle de 0 à la longueu du tableau
		    	this.bouton_tableau[i].setVisibility(VISIBLE); //On rend tous les boutons visibles
		    
		    this.spinnerColor.setVisibility(VISIBLE);
	    }
	    else //Si la vue perd le focus
	    {
		    for(int i = 0; i < bouton_tableau.length; i++) //On fait une boucle de 0 à la longueu du tableau
		    	this.bouton_tableau[i].setVisibility(INVISIBLE); //On rend tous les boutons invisibles
		    
		    this.spinnerColor.setVisibility(INVISIBLE);
	    }
	  }
	
	  /** Lorsqu'on choisit un item du spinner (liste deroulante) ... */
	  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
	  {
		  this.bouton_tableau[3].setText(Html.fromHtml("<font color=\"" + this.getHtmlColorFrom(this.spinnerColor.getSelectedItemPosition()) + "\">•</font>")); //On modifie le texte du bouton pour changer la couleur
	  }
	
	  	
	  /** Lorsqu'on appuie sur une touche du clavier */
	  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
	  {
		  return super.onKeyDown(paramInt, paramKeyEvent);
	  }
	
	  /** Lorsqu'il n'y a aucuns objets selectionné dans la liste déroulante */
	  public void onNothingSelected(AdapterView<?> paramAdapterView){}
	  
}
