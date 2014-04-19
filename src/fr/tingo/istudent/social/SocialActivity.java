package fr.tingo.istudent.social;

import android.app.Activity;
import android.os.Bundle;

public class SocialActivity extends Activity {
	
	public SocialLayout socialLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		this.socialLayout = new SocialLayout(this);
		this.setContentView(this.socialLayout);
	}

}
