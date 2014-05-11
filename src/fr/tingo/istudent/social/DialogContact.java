package fr.tingo.istudent.social;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
import fr.tingo.istudent.util.Sauvegarde;
import fr.tingo.istudent.util.Util;
import fr.tingo.istudent.view.ButtonStudent;

public class DialogContact extends Dialog implements OnClickListener {

	public LinearLayout layout;

	public ButtonStudent buttonAdd;
	public ButtonStudent buttonRemove;
	public EditText editTextAdd;
	public Spinner spinnerContact;
	public List<String> list_contacts;
	
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
		
		this.list_contacts = Sauvegarde.loadListString("contacts", a); //On charge la liste de contact
		
		this.setTitle(Html.fromHtml("<strong><u><font color=\"DeepSkyBlue\">  Contacts </font></strong></u>")); //On definit le titre du Dialogue
		
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
					URLConnection url = new URL("http://grillecube.fr/iStudent/script_add_contact.php?pseudo=" + this.editTextAdd.getText().toString()).openConnection();
					BufferedReader readerMsg = new BufferedReader(new InputStreamReader(url.getInputStream()));				
					result = readerMsg.readLine();
					
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				
				if(result == null) //Le professeur n'a pas encore ajouté de classe
				{
					Toast.makeText(this.getContext(), "L'utilisateur que vous avez rentré n'a pas encore créer de classes.", Toast.LENGTH_LONG).show();
				}
				else if(result.equals("0")) //L'user n'existe pas
				{
					Toast.makeText(this.getContext(), "L'utilisateur que vous avez rentré ne semble pas exister.", Toast.LENGTH_LONG).show();
				}
				else //Le professeur existe et a au moins une classe
				{
					List<String> list_classe = new ArrayList<String>(); //On crée une liste de String, (qui contiendra l'ensemble des classes du professeur ajouté )
					DialogContactClasse dialog = new DialogContactClasse(); //On prépare un nouveau DialogContactClass (Dialogue dans lequel l'utilisateur choisit la classe qui le concerne)
					String string_builder = new String(); //String qui servira d'instance pour récuperer chaque classe avant de les stocker dans la liste
					
					for(int i = 0; i < result.length(); i++) //Pour i allant de 0 jusqu'à la longueur de la réponse
					{
						char c = result.charAt(i); //On recupere le caractère de rang i
						
						if(c != '&') //Lorsque le caractère est différent de '&' ...
						{
							string_builder += c; // on l'ajoute à la String contenant une classe
						}
						else //Sinon, c'est qu'il s'agit d'une autre classe
						{
							list_classe.add(string_builder); // on ajoute la classe à la liste
							string_builder = new String(); //On reinitialise la String d'instance
						}
					}

					dialog.init(this, list_classe); //On initialise le dialogue 
				}
			}
		}
		if(v.equals(this.buttonRemove)) //Si on clique sur le bouton pour supprimer un contact
		{			
			Object choice = this.spinnerContact.getSelectedItem(); // On recupere l'objet selectionné
			
			if(choice != null) // si l'objet existe, alors ...
			{
				String str = choice.toString(); //On recupere son contenu sous forme de String : EX: 'rpereira | ts4'
				
				this.list_contacts.remove(str); //On supprime le contact de la liste
				
				Sauvegarde.saveListString("contacts", this.list_contacts, this.activity); // On enregistre la liste de String avec le contact qui a été supprimé
				
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
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, this.list_contacts);
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
		this.dialog = d; //On enregistre le Dialog dans une variable
		this.dialog.layout.removeAllViews(); //Supprime toutes les vues du layout

		this.user = this.dialog.editTextAdd.getText().toString(); //On reucpere le professeur entré
		this.spinner_classe = new Spinner(d.getContext()); // Initialisation du Spinner (liste déroulante contenant les classes du professeur ajouté)
		this.dialog.layout.addView(this.spinner_classe); //On ajoute la vue au Layout du DialogContact

		TextView t = new TextView(d.getContext());
		t.setText(Html.fromHtml("<br></br>Veuillez choisir la classe qui vous concerne. <br></br>"));
		t.setGravity(Gravity.CENTER);
		this.dialog.layout.addView(t);	
		
		this.button_selectionner = new Button(d.getContext());
		this.button_selectionner.setText("Séléctionner");
		this.button_selectionner.setOnClickListener(this);
		this.dialog.layout.addView(this.button_selectionner);	
		
		this.button_retour = new Button(d.getContext());
		this.button_retour.setText("Retour");
		this.button_retour.setOnClickListener(this);
		this.dialog.layout.addView(this.button_retour);	

	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.dialog.getContext(),
	    																	android.R.layout.simple_spinner_dropdown_item, 
	    																	list_classe);
	    this.spinner_classe.setAdapter(spinnerArrayAdapter);
	}
	

	
	
	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.button_selectionner))		//Si on clique sur le bouton selectionner...
		{
			this.dialog.list_contacts.add(this.user + " | " + this.spinner_classe.getSelectedItem().toString()); // On ajoute le contact à la liste des contacts, sous la forme "rpereira | ts4"
			Sauvegarde.saveListString("contacts", this.dialog.list_contacts, this.dialog.activity); //On enregistre la liste modifié
			
			Toast.makeText(this.dialog.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.user 
					+ " </u> </strong> a été ajouté de votre liste de contacts."), Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé

		}
		
		this.dialog.onBackPressed(); //On simule l'appuie sur la touche retour du téléphone: On ferme le dialogue
	}
	
}
