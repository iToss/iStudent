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
import android.graphics.Color;
import android.os.StrictMode;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.ButtonStudent;
import fr.tingo.istudent.util.Sauvegarde;
import fr.tingo.istudent.util.Util;

public class DialogContact extends Dialog implements View.OnClickListener
{
	  public Activity activity;
	  public ButtonStudent buttonAdd;
	  public ButtonStudent buttonRemove;
	  public EditText editTextAdd;
	  public LinearLayout layout;
	  public LinearLayout.LayoutParams layoutParams;
	  public Spinner spinnerContact;
	
	  @SuppressLint({"ResourceAsColor", "NewApi"})
	  public DialogContact(Activity paramActivity)
	  {
	    super(paramActivity);
	    
	    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
	    
	    this.activity = paramActivity;
	    setTitle(Html.fromHtml("<strong><u><font color=\"DeepSkyBlue\">  Contacts </font></strong></u>"));
	    
	    this.layout = new LinearLayout(paramActivity);
	    this.layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT); 
	    this.layout.setLayoutParams(this.layoutParams);
	    this.layout.setBackgroundColor(Color.TRANSPARENT);
	    this.layout.setOrientation(LinearLayout.VERTICAL);
	    
	    this.editTextAdd = new EditText(paramActivity);
	    this.editTextAdd.setHint("Identifiant");
	    this.editTextAdd.setOnClickListener(this);
	    this.layout.addView(this.editTextAdd);
	    
	    this.buttonAdd = new ButtonStudent(paramActivity);
	    this.buttonAdd.setText(Html.fromHtml("<u> Ajouter </u>"));
	    this.buttonAdd.setTextSize(18.0F);
	    this.buttonAdd.setOnClickListener(this);
	    this.layout.addView(this.buttonAdd);
	    
	    TextView localTextView = new TextView(paramActivity);
	    localTextView.setText(Html.fromHtml("<br></br>"));
	    this.layout.addView(localTextView);
	    
	    this.spinnerContact = new Spinner(paramActivity);
	    this.setSpinerChoices();
	    this.layout.addView(this.spinnerContact);
	    
	    this.buttonRemove = new ButtonStudent(paramActivity);
	    this.buttonRemove.setText(Html.fromHtml("<u>Supprimer</u>"));
	    this.buttonRemove.setTextSize(18.0F);
	    this.buttonRemove.setOnClickListener(this);
	    this.layout.addView(this.buttonRemove);
	    
	    this.setContentView(this.layout);
	    Util.resetFocus(this.activity);
	  }
	
	  public DialogContact(Context paramContext)
	  {
	    super(paramContext);
	  }
	
		/** Fonction redefinissant le contenu du spinner */
		public void setSpinerChoices() 
		{
			List<String> list_contact = Sauvegarde.loadListString("contacts", this.activity);
			List<String> list_classe = Sauvegarde.loadListString("contacts_classe", this.activity);
			List<String> spinnerList = new ArrayList<String>();
			
			for(int i = 0; i < list_contact.size(); i++)
			{
				spinnerList.add(list_contact.get(i) + " | " + list_classe.get(i));
			}

		    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerList);
		    this.spinnerContact.setAdapter(spinnerArrayAdapter);
		}
		
		
		public void onClick(View v)
		{
			if (v.equals(this.buttonAdd))
			{
		        String user = this.editTextAdd.getText().toString();

				if (user.length() == 0)
				{
					Toast.makeText(getContext(), "Veuilez saisir un identifiant", Toast.LENGTH_LONG).show();
				}
				else
				{
			        String url = "http://grillecube.fr/iStudent/script_add_contact.php?pseudo=" + user;
			        String result = "";
			        
			        try 
			        { //On essaye ...
						URL urlMsg = new URL(url); //On recupere l'URL des messages
						URLConnection urlConnectionMsg = urlMsg.openConnection(); //On ouvre la connection (on charge la page )
						BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnectionMsg.getInputStream())); //On prepare le reader del a page
						
						result = reader.readLine();
						
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
					}
			        
			        if(result == null) //Si l'user n'a pas de classe
			        {
			        	Toast.makeText(this.getContext(), "L'utilisateur ne semble pas encore avoir créer de classe.", Toast.LENGTH_LONG).show();
			        }
			        else if(result.equals("0") || result.equals(""))//Le pseudo n'existe pas
			        {
			        	Toast.makeText(this.getContext(), "L'utilisateur ne semble pas exister, veuillez verifier.", Toast.LENGTH_LONG).show();
			        }
			        else
			        {
			        	new DialogSelectClass().init(this, user, result);
			        }
				}
			}
			else if(v.equals(this.buttonRemove))
			{			
				Object choice = this.spinnerContact.getSelectedItem(); // On recupere l'objet selectionné
				
				if(choice != null) // si l'object existe, alors ...
				{
					String str = choice.toString();
					String user = "";
					String classe = "";
					char c;
					
					for(int i = 0; i < str.length(); i++)
					{
						c = str.charAt(i);
						
						if(c == '|')
						{
							user = user.substring(0, i - 1);
							classe = str.substring(i + 2, str.length());
							break;
						}
						
						user += c;
					}
					
					Toast.makeText(this.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.editTextAdd.getText().toString() 
							+ " </u> </strong> a été supprimer de votre liste de contacts."), Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé
					Sauvegarde.removeStringFromList("contacts", user, this.activity); // On supprime le contact de la liste
					Sauvegarde.removeStringFromList("contacts_classe", classe, this.activity); // On supprime le contact de la liste
					this.setSpinerChoices(); // On redefinit les choix de la liste déroulante
				}
			}
	        
		}
}


class DialogSelectClass implements OnClickListener  //Le contenu du dialog qui affiche la selection de la classe 
{
	public Spinner spinner_classe;
	public String user;
	public DialogContact dialog;
	public Button button_oui;
	public Button button_non;
	
	
	/** Remplaces le contenu du DialogContact par celui ci de la selection de la classe lors de l'ajout du contact */
	public void init(DialogContact d, String p_user, String result)
	{
		d.layout.removeAllViews();
		
		this.dialog = d;
		
		this.user = p_user;
		
		TextView t = new TextView(d.getContext());
		t.setText(Html.fromHtml("<br></br> Veuillez selectionner la classe qui vous concerne.</u><br></br>"));
		t.setGravity(Gravity.CENTER);
		d.layout.addView(t);	
		
		this.spinner_classe = new Spinner(d.getContext());
		List<String> list_classe = new ArrayList<String>();
		String builder = new String();
		
		for(int i = 0; i < result.length(); i++)
		{			
			if(result.charAt(i) == '&')
			{
				list_classe.add(builder);
				builder = new String();
				i++;
			}
			
			if(i < result.length())
				builder += result.charAt(i);
		}
		
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.dialog.getContext(), android.R.layout.simple_spinner_dropdown_item, list_classe);
	    this.spinner_classe.setAdapter(spinnerArrayAdapter);
		d.layout.addView(this.spinner_classe);	

		
		this.button_oui = new Button(d.getContext());
		this.button_oui.setText("Selectionner");
		this.button_oui.setOnClickListener(this);
		d.layout.addView(this.button_oui);	
		
		this.button_non = new Button(d.getContext());
		this.button_non.setText("Retour");
		this.button_non.setOnClickListener(this);
		d.layout.addView(this.button_non);	

	}
	
	
	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.button_oui) && this.spinner_classe.getSelectedItem() != null)		
		{
			Toast.makeText(this.dialog.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + user + "</u> </strong> a été ajouté à votre liste de synchronisation."), Toast.LENGTH_LONG).show();
		    Sauvegarde.addStringToList("contacts", this.dialog.editTextAdd.getText().toString(), this.dialog.activity); //On enregistre le contact ajouté
		    Sauvegarde.addStringToList("contacts_classe", this.spinner_classe.getSelectedItem().toString(), this.dialog.activity); //On enregistre la classe selectionné
		}
		
		this.dialog.onBackPressed(); //On ferme le Dialog
	}
	
	
}
	