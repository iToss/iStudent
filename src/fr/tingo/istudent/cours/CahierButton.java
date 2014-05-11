package fr.tingo.istudent.cours;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.LightingColorFilter;
import android.view.Gravity;
import android.widget.Button;
import fr.tingo.istudent.R;

public class CahierButton extends Button
{
	public String name;
	public int color;

	/** Constructeur par défaut */
	public CahierButton(Context c)
	{
		super(c);
	}
	
	
	@SuppressLint({"NewApi"})
	public CahierButton(Context c, String txt, int p_color)
	{
		super(c);
    	this.setGravity(Gravity.CENTER);
    	this.setBackgroundResource(R.drawable.my_cahier);
    	this.setText(txt);
    	this.name = txt.toString();
    	
    	this.color = p_color;
    	this.getBackground().setColorFilter(new LightingColorFilter(this.color, 0x00000000));
  	}


}