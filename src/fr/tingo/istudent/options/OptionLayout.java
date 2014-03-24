package fr.tingo.istudent.options;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.MainButton;
import fr.tingo.istudent.actualite.TextViewActualite;
import fr.tingo.istudent.util.Sauvegarde;

public class OptionLayout extends ScrollView implements OnClickListener {
		
	public LinearLayout layout;

	public MainButton buttonAdd;
	public MainButton buttonRemove;
	public EditText editTextAdd;
	public Spinner spinner;


	public LinearLayout.LayoutParams scrollParams;
	public Activity activity;

	
	public OptionLayout(Context context) {
		super(context);
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint({ "ResourceAsColor", "NewApi" })
	public OptionLayout(Activity context) {
		super(context);
		
		this.activity = context;

		
		/** Initialisation des objets */
		this.layout = new LinearLayout (context);
		this.scrollParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);

		/** configuration scrollview */
		this.setLayoutParams(scrollParams);
		this.setBackgroundColor(android.R.color.transparent);
		this.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        this.setFillViewport(true);
		this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		/** configuration du layout */
		this.layout.setOrientation(LinearLayout.VERTICAL);
		
		/** Ajout du titre */
		TextView title = new TextView(context);
		SpannableString content = new SpannableString("\n" + "Options" + "\n");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		title.setText(content);
		title.setTextSize(24.0f);
		title.setGravity(Gravity.CENTER);
		this.layout.addView(title);
		

		TextViewActualite info = new TextViewActualite(context);
		info.setPadding(100, 0, 100, 0);
		info.setGravity(Gravity.CENTER);
		info.setText("\n Ajouter ou supprimer des contacts à votre liste pour vous synchroniser ou non avec eux. \n");
		this.layout.addView(info);

		this.editTextAdd = new EditText(context);
		this.editTextAdd.setHint("Identifiant");
		this.layout.addView(this.editTextAdd);
		
		// Ajout du bouton d'ajout de follow
		this.buttonAdd = new MainButton(context);
		this.buttonAdd.setText("Ajouter");
		this.buttonAdd.setOnClickListener(this);
		this.layout.addView(this.buttonAdd);
		

		// Ajout de la liste deroulante
		this.spinner = new Spinner(context);
		this.setSpinerChoices(); // Ajout des choix à la liste déroulante

	    this.layout.addView(spinner);

	    // Ajout du bouton supprimer
		this.buttonRemove = new MainButton(context);
		this.buttonRemove.setText("Supprimer");
		this.buttonRemove.setOnClickListener(this);
		layout.addView(this.buttonRemove);
		
		
		/** Ajout du Layout au scrollview */
		this.addView(layout);
		
		this.editTextAdd.setFocusable(true);
		this.editTextAdd.setFocusableInTouchMode(true);
	}

	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.buttonAdd))
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
		else if(v.equals(this.buttonRemove))
		{			
			Object choice = this.spinner.getSelectedItem(); // On recupere l'objet selectionné
			
			if(choice != null) // si l'object existe, alors ...
			{
				Toast.makeText(this.getContext(), Html.fromHtml("L'utilisateur <strong> <u>" + this.editTextAdd.getText().toString() 
						+ " </u> </strong> a été supprimer de votre liste de contacts."), Toast.LENGTH_LONG).show(); // On affiche que le contact a bien été supprimé
				Sauvegarde.removeStringFromList("contacts", choice.toString(), this.activity); // On supprime le contact de la liste
				this.setSpinerChoices(); // On redefinit les choix de la liste déroulante
			}
		}
	}

	
	/** Fonction redefinissant le contenu du spinner */
	private void setSpinerChoices() 
	{
		List<String> list = Sauvegarde.loadListString("contacts", this.activity);
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
	    this.spinner.setAdapter(spinnerArrayAdapter);
	}

   

}
