package fr.tingo.istudent;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;

public class MainButton extends Button {
	
	public String text;
	public int width;
	public int height;
	public int color[];
	
	public MainButton(Context context) {
		super(context);
		this.setGravity(Gravity.CENTER);
		this.setBackgroundResource(R.drawable.my_button);
	}
	
	
	
}
