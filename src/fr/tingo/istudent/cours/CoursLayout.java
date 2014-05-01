package fr.tingo.istudent.cours;

import java.util.List;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.util.Sauvegarde;

public class CoursLayout extends RelativeLayout implements View.OnClickListener
{
	public CoursActivity activity;
	public ButtonFolder button;
	public CahierButton[] cahier;
	public int nb_cahier;
	public List<String> nom_cahier;
	
	@SuppressLint({"NewApi"})
  	public CoursLayout(Context c)
  	{
		super(c);
  	}
	
	@SuppressLint({"NewApi"})
  	public CoursLayout(CoursActivity ac)
  	{
	    super(ac);
	    
	    new Random(); 
	    this.activity = ac;
	    
	    this.button = new ButtonFolder(ac);
	    this.button.setText(Html.fromHtml("<strong> Gérer mes cahiers </strong>"));
	    this.button.setGravity(Gravity.RIGHT);
	    this.button.setWidth(MainLayout.width - MainLayout.width / 50);
	    this.button.setX(MainLayout.width / 100);
	    this.button.setY(MainLayout.height / 100);
	    this.button.setOnClickListener(this);
	    
	    this.addView(this.button);
	    this.nom_cahier = Sauvegarde.loadListString("cahiers", ac);
	    this.nb_cahier = Sauvegarde.loadInt("nb_cahiers", 0, getContext());
	    
	    this.drawCahier();
  	}

	/** Retires tous les cahiers de la vue */
	private void removeEveryCahier()
	{
		removeAllViews();
		addView(this.button);
  	}

	/** Ajoutes un cahier à la vue */
	public void addCahier(String cahier_name)
  	{
	    Sauvegarde.saveInt("nb_cahiers", 1 + this.activity.layout.nb_cahier, getContext());
	    Sauvegarde.addStringToList("cahiers", cahier_name, this.activity);
	    this.nom_cahier.add(cahier_name);
	    this.nb_cahier = (1 + this.nb_cahier);
	    drawCahier();
  	}

	
	/** Dessines tous les cahiers */
	@SuppressLint({"NewApi"})
  	public void drawCahier()
  	{
		this.removeEveryCahier();
		this.cahier = new CahierButton[this.nb_cahier];
		
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(MainLayout.width / 5, MainLayout.height / 6);
		int x = MainLayout.width / 25;
		int y = 0;
		
		for (int i = 0; i < this.nb_cahier; i++)
		{
			if (i % 4 == 0)
			{
				x = MainLayout.width / 25;
	        	y += MainLayout.height / 6 + MainLayout.height / 100;
			}
			
			this.cahier[i] = new CahierButton(getContext(), this.nom_cahier.get(i));
			this.cahier[i].setId(i);
			this.cahier[i].setX(x);
			this.cahier[i].setY(y);
			this.cahier[i].setLayoutParams(layoutParams);
			
			x += MainLayout.width / 25 + MainLayout.width / 5;
			this.cahier[i].setOnClickListener(this);
			
			addView(this.cahier[i]);
	    }
  }

	
	/** Lorsqu'on clique ... */
	public void onClick(View v)
	{
		if(v.equals(this.button)) //Sur le bouton pour ajouter un cahier
		{
			new DialogAddCahier(this.activity).show();
		}
		else if(v instanceof CahierButton) //Sur un cahier
		{
			Intent intent = new Intent();
			intent.putExtra("matiere", ((CahierButton)v).name);
			intent.setClass(getContext(), CahierActivity.class);
			getContext().startActivity(intent);
		}
	}

	/** Supprimes le cahier au rang i*/
	public void removeCahier(int i)
	{		
		Sauvegarde.saveInt(this.nom_cahier.get(i) + "_color", 0, this.getContext()); //Reset de la couleur du cahier

	    Sauvegarde.saveInt("nb_cahiers", this.nb_cahier - 1, getContext());
	    Sauvegarde.removeStringFromListById("cahiers", i, this.activity);
	    this.nom_cahier.remove(this.nom_cahier.get(i));
	    this.nb_cahier--;
	    this.drawCahier();
	}
	
	
}