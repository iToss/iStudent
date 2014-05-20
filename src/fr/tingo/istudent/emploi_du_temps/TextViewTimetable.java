package fr.tingo.istudent.emploi_du_temps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.widget.TextView;
import fr.tingo.istudent.R;

@SuppressLint("ViewConstructor")//Le constructeur par défaut n'est pas utilisé
public class TextViewTimetable extends TextView {

	public String cours;

	public TextViewTimetable(Context context, String p_cours) 
	{
		super(context);		

		this.cours = p_cours;
		this.setBackgroundResource(R.drawable.fond_blanc);

    	this.setGravity(Gravity.CENTER);
    	this.setText(Html.fromHtml(p_cours));
	}




}
