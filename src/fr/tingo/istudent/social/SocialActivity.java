package fr.tingo.istudent.social;

import android.app.Activity;
import android.os.Bundle;

public class SocialActivity extends Activity
{
	public SocialLayout socialLayout;

	public void onCreate(Bundle paramBundle)
	{
		super.onCreate(paramBundle);
		
    	this.socialLayout = new SocialLayout(this);
    	setContentView(this.socialLayout);
	}
}
