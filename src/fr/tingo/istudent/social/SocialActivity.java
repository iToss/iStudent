package fr.tingo.istudent.social;

import android.annotation.SuppressLint;
import android.os.Bundle;
import fr.tingo.istudent.ActivityStudent;

public class SocialActivity extends ActivityStudent
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
