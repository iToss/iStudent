package fr.tingo.istudent.cours;

import android.app.Activity;
import android.os.Bundle;

public class CoursActivity extends Activity
{
	public CoursLayout layout;

  	public void onCreate(Bundle paramBundle)
  	{
  		super.onCreate(paramBundle);
  		this.layout = new CoursLayout(this);
  		this.setContentView(this.layout);
  	}
}