package fr.tingo.istudent.social;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.MainButton;
import fr.tingo.istudent.util.Sauvegarde;
import fr.tingo.istudent.util.Util;

public class DialogContact extends Dialog implements OnClickListener {

	public LinearLayout layout;

	public MainButton buttonAdd;
	public MainButton buttonRemove;
	public EditText editTextAdd;
	public Spinner spinnerContact;
	
	public LinearLayout.LayoutParams layoutParams;
	public Activity activity;
	
	
	public DialogContact(Context context) 
	{
		super(context);
	}

	
	@SuppressLint("ResourceAsColor")
	public DialogContact(Activity a) 
	{
		super(a);
		this.activity = a;
		
		this.setTitle(Html.fromHtml("<strong><u><font color=\"DeepSkyBlue\">  Contacts </font></strong></u>"));
		
		/** Initialisation des objets */
		this.layout = new LinearLayout (a);
		this.layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);

		/** configuration scrollview */
		this.layout.setLayoutParams(layoutParams);
		this.layout.setBackgroundColor(android.R.color.transparent);

		/** configuration du layout */
		this.layout.setOrientation(LinearLayout.VERTICAL);
		
		
		/** Ajout du titre */

		this.editTextAdd = new EditText(a);
		this.editTextAdd.setHint("Identifiant");
		this.editTextAdd.setOnClickListener(this);
		this.layout.addView(this.editTextAdd);
		
		// Ajout du bouton d'ajout de follow
		this.buttonAdd = new MainButton(a);
		this.buttonAdd.setText(Html.fromHtml("<u> Ajouter </u>"));
		this.buttonAdd.setTextSize(18.0f);
		this.buttonAdd.setOnClickListener(this);
		this.layout.addView(this.buttonAdd);
		

		// Space
		TextView space = new TextView(a);
		space.setText(Html.fromHtml("<br></br>"));
		this.layout.addView(space);
		
		
		// Ajout de la liste deroulante
		this.spinnerContact = new Spinner(a);
		this.setSpinerChoices(); // Ajout des choix à la liste déroulante

	    this.layout.addView(spinnerContact);

	    // Ajout du bouton supprimer
		this.buttonRemove = new MainButton(a);
		this.buttonRemove.setText(Html.fromHtml("<u> Supprimer </u>"));
		this.buttonRemove.setTextSize(18.0f);
		this.buttonRemove.setOnClickListener(this);
		this.layout.addView(this.buttonRemove);
		

		
		
		/** Ajout du Layout au scrollview */
		this.setContentView(layout);
		
		Util.resetFocus(activity);
		
	}
	
	
	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.buttonAdd)) //Lorsqu'on clique sur le bouton ajouter un contact
		{
			if(this.editTextAdd.length() == 0)
			{
				Toast.makeText(this.getContext(), "Veuilez saisir un identifiant", Toast.LENGTH_LONG).show();
			}
			else
			{
				Toast.makeText(this.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.editTextAdd.getText().toString()
						+ "</u> </strong> a été ajouté à votre liste de synchronisation."), Toast.LENGTH_LONG).show();
				Sauvegarde.addStringToList("contacts", this.editTextAdd.getText().toString(), this.activity);
				this.setSpinerChoices();
			}
		}
		if(v.equals(this.buttonRemove))
		{			
			Object choice = this.spinnerContact.getSelectedItem(); // On recupere l'objet selectionné
			
			if(choice != null) // si l'object existe, alors ...
			{
				Toast.makeText(this.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.editTextAdd.getText().toString() 
						+ " </u> </strong> a été supprimer de votre liste de contacts."), Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé
				Sauvegarde.removeStringFromList("contacts", choice.toString(), this.activity); // On supprime le contact de la liste
				this.setSpinerChoices(); // On redefinit les choix de la liste déroulante
			}
			else
			{
				Toast.makeText(this.getContext(), "Aucuns contacts disponibles.", Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé
			}
		}
	}

	
	/** Fonction redefinissant le contenu du spinner */
	private void setSpinerChoices() 
	{
		List<String> list = Sauvegarde.loadListString("contacts", this.activity);
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
	    this.spinnerContact.setAdapter(spinnerArrayAdapter);
	}
}
