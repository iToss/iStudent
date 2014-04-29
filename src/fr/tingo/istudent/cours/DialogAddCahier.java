package fr.tingo.istudent.cours;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.ButtonStudent;
import fr.tingo.istudent.util.Sauvegarde;
import fr.tingo.istudent.util.Util;

public class DialogAddCahier extends Dialog implements View.OnClickListener
{
	public CoursActivity activity;
	public ButtonStudent buttonAdd;
	public ButtonStudent buttonRemove;
	public EditText editTextAdd;
	public LinearLayout layout;
	public LinearLayout.LayoutParams layoutParams;
	public Spinner spinnerCahier;

	public DialogAddCahier(Context paramContext)
	{
		super(paramContext);
	}	

	@SuppressLint({"ResourceAsColor"})
  	public DialogAddCahier(CoursActivity ac)
	{
	    super(ac);
	    
	    this.activity = ac;
	    
	    setTitle(Html.fromHtml("<strong><u><font color=\"DeepSkyBlue\">  Mes cahiers </font></strong></u>"));
	    this.layout = new LinearLayout(this.activity);
	    this.layoutParams = new LinearLayout.LayoutParams(-2, -1);
	    this.layout.setLayoutParams(this.layoutParams);
	    this.layout.setBackgroundColor(Color.TRANSPARENT);
	    this.layout.setOrientation(LinearLayout.VERTICAL);
	    
	    this.editTextAdd = new EditText(this.activity);
	    this.editTextAdd.setHint("Nom du cahier");
	    this.editTextAdd.setOnClickListener(this);
	    this.layout.addView(this.editTextAdd);
	    
	    this.buttonAdd = new ButtonStudent(this.activity);
	    this.buttonAdd.setText(Html.fromHtml("<u> Ajouter </u>"));
	    this.buttonAdd.setTextSize(18.0F);
	    this.buttonAdd.setOnClickListener(this);
	    this.layout.addView(this.buttonAdd);
	    
	    TextView localTextView = new TextView(this.activity);
	    localTextView.setText(Html.fromHtml("<br></br>"));
	    this.layout.addView(localTextView);
	    this.spinnerCahier = new Spinner(this.activity);
	    this.setSpinerChoices();
	    this.layout.addView(this.spinnerCahier);
	    
	    this.buttonRemove = new ButtonStudent(this.activity);
	    this.buttonRemove.setText(Html.fromHtml("<u> Supprimer </u>"));
	    this.buttonRemove.setTextSize(18.0F);
	    this.buttonRemove.setOnClickListener(this);
	    this.layout.addView(this.buttonRemove);
	    
	    this.setContentView(this.layout);
	    Util.resetFocus(ac);
	}

	/** Redefinis le choix de la liste deroulante des cahiers */
	private void setSpinerChoices()
	{
		List<String> list = Sauvegarde.loadListString("cahiers", this.activity);
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
		this.spinnerCahier.setAdapter(spinnerArrayAdapter);
	}

	/** Lorsuqo'n clique... */
	public void onClick(View paramView)
	{
		if (paramView.equals(this.buttonAdd)) //Sur le bouton ajouter
		{
			String cahier_name = this.editTextAdd.getText().toString(); //On recupere le contenu de l'edittext
			if (cahier_name.length() == 0) //S'il est vide
			{
				Toast.makeText(getContext(), "Entrez un nom pour votre cahier", Toast.LENGTH_LONG).show();
			}
			else //Sinon, on ajout ele cahier
			{
			      Toast.makeText(getContext(), Html.fromHtml("Vous avez ajouté un nouveau cahier: <strong> <u>" + cahier_name + "</u> </strong>"), Toast.LENGTH_LONG).show();
			      this.activity.layout.addCahier(this.editTextAdd.getText().toString());
			      this.onBackPressed();
			}
		}
		else if (paramView.equals(this.buttonRemove)) //Si on supprime un cahier
		{
			DialogRemoveCahier d = new DialogRemoveCahier();
			d.init(this);
		}
    }

}



class DialogRemoveCahier implements OnClickListener 
{
	
	public DialogAddCahier dialog;
	public Button button_oui;
	public Button button_non;

	public Object choice;
	
	public void init(DialogAddCahier d)
	{
		this.dialog = d;
		this.choice = this.dialog.spinnerCahier.getSelectedItem(); //On recupere le choix de la liste deroulante

		d.layout.removeAllViews();
		
		d.setTitle("Supprimer un cahier");

		
		TextView t = new TextView(d.getContext());
		t.setText(Html.fromHtml("<br></br> Etes - vous bien sur de vouloir supprimer votre de cahier de : <u>" + this.choice.toString() + "</u> ?<br></br>"));
		t.setGravity(Gravity.CENTER);
		d.layout.addView(t);	
		
		this.button_oui = new Button(d.getContext());
		this.button_oui.setText("Oui");
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
		if(v.equals(this.button_oui))		
		{
			Toast.makeText(this.dialog.getContext(), Html.fromHtml("Vous avez supprimer votre cahier de <strong> <u>" + choice.toString() + " </u> </strong>"), Toast.LENGTH_LONG).show();
			this.dialog.activity.layout.removeCahier(this.dialog.spinnerCahier.getSelectedItemPosition());
			this.dialog.onBackPressed();
		}
		else
		{
			this.dialog.onBackPressed();
		}
	}
	
}