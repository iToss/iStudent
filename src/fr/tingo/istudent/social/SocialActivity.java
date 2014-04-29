package fr.tingo.istudent.social;

import android.app.Activity;
import android.os.Bundle;

<<<<<<< HEAD
public class SocialActivity extends Activity
{
	public SocialLayout socialLayout;

	public void onCreate(Bundle paramBundle)
	{
		super.onCreate(paramBundle);
		
    	this.socialLayout = new SocialLayout(this);
    	setContentView(this.socialLayout);
	}
=======
public class SocialActivity extends Activity {
	
	public SocialLayout socialLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		this.socialLayout = new SocialLayout(this);
		this.setContentView(this.socialLayout);
	}

>>>>>>> 23d807182476563cc71813bc9b64abd23f8c40fb
}
