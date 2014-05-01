package fr.tingo.istudent.cours;

import android.os.Bundle;
import fr.tingo.istudent.ActivityStudent;

public class CoursActivity extends ActivityStudent
{
	public CoursLayout layout;

  	public void onCreate(Bundle paramBundle)
  	{
  		super.onCreate(paramBundle);
  		this.layout = new CoursLayout(this);
  		this.setContentView(this.layout);
  	}
}