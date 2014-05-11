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
	
	public List<CahierButton> cahier;

	
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
	    this.button.setText(Html.fromHtml("<strong> G�rer mes cahiers </strong>"));
	    this.button.setGravity(Gravity.RIGHT);
	    this.button.setWidth(MainLayout.width - MainLayout.width / 50);
	    this.button.setX(MainLayout.width / 100);
	    this.button.setY(MainLayout.height / 100);
	    this.button.setOnClickListener(this);
	    
	    this.addView(this.button);

	    this.cahier = Sauvegarde.loadListCahier("cahiers", ac);
	    
	    this.drawCahier();
  	}

	/** Retires tous les cahiers de la vue */
	private void removeEveryCahier()
	{
		removeAllViews();
		addView(this.button);
  	}

	/** Ajoutes un cahier � la vue */
	public void addCahier(CahierButton p_cahier)
  	{
		this.cahier.add(p_cahier);
		Sauvegarde.saveListCahier(this.cahier, "cahiers", getContext());
	    drawCahier();
  	}

	
	/** Dessines tous les cahiers */
	@SuppressLint({"NewApi"})
  	public void drawCahier()
  	{
		this.removeEveryCahier();
		
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(MainLayout.width / 5, MainLayout.height / 6);
		int x = MainLayout.width / 25;
		int y = 0;
		
		for (int i = 0; i < this.cahier.size(); i++)
		{
			if (i % 4 == 0)
			{
				x = MainLayout.width / 25;
	        	y += MainLayout.height / 6 + MainLayout.height / 100;
			}
			
			this.cahier.get(i).setId(i);
			this.cahier.get(i).setX(x);
			this.cahier.get(i).setY(y);
			this.cahier.get(i).setLayoutParams(layoutParams);
			
			x += MainLayout.width / 25 + MainLayout.width / 5;
			this.cahier.get(i).setOnClickListener(this);
			
			addView(this.cahier.get(i));
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
		this.cahier.remove(i);
		Sauvegarde.saveListCahier(cahier, "cahiers", getContext());
	    this.drawCahier();
	}
	
	
}