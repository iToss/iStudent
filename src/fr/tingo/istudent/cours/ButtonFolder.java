package fr.tingo.istudent.cours;

import fr.tingo.istudent.R;
import android.content.Context;
import android.view.Gravity;
import android.widget.Button;

public class ButtonFolder extends Button
{
	  public int[] color;
	  public int height;
	  public String text;
	  public int width;

	  public ButtonFolder(Context paramContext)
	  {
		  super(paramContext);
		  setGravity(Gravity.CENTER);
		  this.setBackgroundResource(R.drawable.my_button_folder);
	  }
}