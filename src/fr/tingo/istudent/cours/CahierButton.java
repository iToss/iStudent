package fr.tingo.istudent.cours;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.LightingColorFilter;
import android.text.Spanned;
import android.view.Gravity;
import android.widget.Button;
import fr.tingo.istudent.R;
import fr.tingo.istudent.util.Sauvegarde;

public class CahierButton extends Button
{
	public String name;
	public int color;

	@SuppressLint({"NewApi"})
	public CahierButton(Context c, String txt)
	{
		super(c);
    	this.setGravity(Gravity.CENTER);
    	this.setBackgroundResource(R.drawable.my_cahier);
    	this.setText(txt);
    	this.name = txt.toString();
    	
    	this.color = Sauvegarde.loadInt(this.name + "_color", 0, c);
    	
    	if(this.color == 0)
    	{
    		this.color = this.getRandomColor();
    		Sauvegarde.saveInt(this.name + "_color", this.color, c);
    	}
    		
    	this.getBackground().setColorFilter(new LightingColorFilter(this.color, 0x00000000));
  	}

	private int getRandomColor() 
	{
		Random r = new Random();
		
		switch(r.nextInt(11))
		{
			case 0 : 
				return 0xE67E30; // abricot
				
			case 1 :
				return 0x74D0F1; // Azurclair
				
			case 2 :
				return 0x00000000; // Transparent
				
			case 3 :
				return 0xC8AD7F; //Beige
				
			case 4 :
				return 0xFFCB60; //Aurore (jaune)
				
			case 5 :
				return 0xFBF2B7; //champagne
				
			case 6 :
				return 0xD2CAEC; // Gris de lain
				
			case 7 :
				return  0x54F98D; //Menthe à l'eau
				
			case 8 :
				return 0xFAF0C5; //Platine
				
			case 9 :
				return 0xBEF574; //Pistache
				
			case 10 :
				return 0xE32636; // Rouge
				
			case 11 :
				return 0xE97451; // Terre brulé
				
			case 12 :
				return 0xFAEA73; //Topaze
				
			case 13 :
				return 0xE9C9B1; // Biche
				
			case 14 :
				return 0xCFA0E9; //Parme
				
			case 15 :
				return 0xFD6C9E;  //Rose
				
		}
		
		return 0;
	}
}