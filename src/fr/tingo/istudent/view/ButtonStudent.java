package fr.tingo.istudent.view;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;
import fr.tingo.istudent.R;

public class ButtonStudent extends Button {
	
	public String text;
	public int width;
	public int height;
	public int color[];
	
	/** Class de bouton personnalis� */
	public ButtonStudent(Context context) {
		super(context);
		this.setGravity(Gravity.CENTER);
		this.setBackgroundResource(R.drawable.my_button);
	}
	
	
	
}
