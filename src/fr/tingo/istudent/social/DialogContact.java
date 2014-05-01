package fr.tingo.istudent.social;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.StrictMode;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.ButtonStudent;
import fr.tingo.istudent.util.Sauvegarde;
import fr.tingo.istudent.util.Util;

public class DialogContact extends Dialog implements OnClickListener {

	public LinearLayout layout;

	public ButtonStudent buttonAdd;
	public ButtonStudent buttonRemove;
	public EditText editTextAdd;
	public Spinner spinnerContact;
	
	public LinearLayout.LayoutParams layoutParams;
	public Activity activity;
	
	
	public DialogContact(Context context) 
	{
		super(context);
	}

	
	@SuppressLint({ "ResourceAsColor", "NewApi" })
	public DialogContact(Activity a) 
	{
		super(a);
		this.activity = a;
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //Autorise la connection internet
		StrictMode.setThreadPolicy(policy);
		
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
		this.buttonAdd = new ButtonStudent(a);
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
		this.buttonRemove = new ButtonStudent(a);
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
				String result = "";
				
				try { //On essaye ...
					BufferedReader readerMsg = new BufferedReader(new InputStreamReader(new URL("http://grillecube.fr/iStudent/script_add_contact.php?pseudo=" + this.editTextAdd.getText().toString()).openConnection().getInputStream()));				
					result = readerMsg.readLine();
					
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				
				if(result == null) //L'user n'a pas encore ajouté de classe
				{
					Toast.makeText(this.getContext(), "L'utilisateur que vous avez rentré n'a pas encore créer de classes.", Toast.LENGTH_LONG).show();
				}
				else if(result.equals("0")) //L'user n'existe pas
				{
					Toast.makeText(this.getContext(), "L'utilisateur que vous avez rentré ne semble pas exister.", Toast.LENGTH_LONG).show();
				}
				else //L'user existe et a au moins une classe
				{
					List<String> list_classe = new ArrayList<String>();
					DialogContactClasse dialog = new DialogContactClasse();
					String str = new String();
					
					for(int i = 0; i < result.length(); i++)
					{
						char c = result.charAt(i);
						
						if(c != '&')
						{
							str += c;
						}
						else
						{
							list_classe.add(str);
							str = new String();
						}
					}

					dialog.init(this, list_classe); //On initialise le dialog (on l'affiche)
				}
			}
		}
		if(v.equals(this.buttonRemove))
		{			
			Object choice = this.spinnerContact.getSelectedItem(); // On recupere l'objet selectionné
			
			if(choice != null) // si l'object existe, alors ...
			{
				String str = choice.toString();
				int i;
				
				for(i = 0; i < str.length(); i++)
				{
					if(str.charAt(i) == '|')
						break;
				}
				
				Sauvegarde.removeStringFromList("contacts", str.substring(0, i - 1), this.activity); // On supprime le contact de la liste
				Sauvegarde.removeStringFromList("classes", str.substring(i + 1, str.length()), this.activity); // On supprime le contact de la liste

				
				Toast.makeText(this.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.editTextAdd.getText().toString() 
						+ " </u> </strong> a été supprimer de votre liste de contacts."), Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé
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
		List<String> list_contact = Sauvegarde.loadListString("contacts", this.activity);
		List<String> list_classe = Sauvegarde.loadListString("classes", this.activity);
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < list_contact.size(); i++)
		{
			list.add(list_contact.get(i) + " | " + list_classe.get(i));
		}
		
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
	    this.spinnerContact.setAdapter(spinnerArrayAdapter);
	}
}



class DialogContactClasse implements OnClickListener 
{
	
	public DialogContact dialog;
	public Spinner spinner_classe;
	public Button button_selectionner;
	public Button button_retour;
	public String user;
	
	public void init(DialogContact d, List<String> list_classe)
	{
		this.dialog = d;
		d.layout.removeAllViews(); //Supprime toutes les vues du layout

		this.user = this.dialog.editTextAdd.getText().toString(); //On reucpere l'user rentré
		this.spinner_classe = new Spinner(d.getContext()); // Initialisation du Spinner (liste déroulante )
		d.layout.addView(this.spinner_classe);

		TextView t = new TextView(d.getContext());
		t.setText(Html.fromHtml("<br></br>Veuillez choisir la classe qui vous concerne. <br></br>"));
		t.setGravity(Gravity.CENTER);
		d.layout.addView(t);	
		
		this.button_selectionner = new Button(d.getContext());
		this.button_selectionner.setText("Séléctionner");
		this.button_selectionner.setOnClickListener(this);
		d.layout.addView(this.button_selectionner);	
		
		this.button_retour = new Button(d.getContext());
		this.button_retour.setText("Retour");
		this.button_retour.setOnClickListener(this);
		d.layout.addView(this.button_retour);	


		
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.dialog.getContext(),
	    																	android.R.layout.simple_spinner_dropdown_item, 
	    																	list_classe);
	    this.spinner_classe.setAdapter(spinnerArrayAdapter);
	}
	

	
	
	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.button_selectionner))		
		{
			Sauvegarde.addStringToList("contacts", this.user, this.dialog.activity); //On ajoute le contact à la liste
			Sauvegarde.addStringToList("classes", this.spinner_classe.getSelectedItem().toString(), this.dialog.activity); //on ajoute la classe à la liste (qui sera de meme rang que le contact)

			
			Toast.makeText(this.dialog.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.user 
					+ " </u> </strong> a été ajouté de votre liste de contacts."), Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé

		}
		
		this.dialog.onBackPressed();
	}
	
}
