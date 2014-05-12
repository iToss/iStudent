package fr.tingo.istudent.social;

import android.annotation.SuppressLint;
import android.os.Bundle;
import fr.tingo.istudent.iStudentActivity;

public class SocialActivity extends iStudentActivity
{
	public SocialLayout socialLayout;

	@SuppressLint("NewApi")
	public void onCreate(Bundle paramBundle)
	{
		super.onCreate(paramBundle);
		
    	this.socialLayout = new SocialLayout(this);
    	setContentView(this.socialLayout);
	}

}
