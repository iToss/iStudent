package fr.tingo.istudent.bob;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class BobActivity extends Activity implements OnClickListener {
	
	public LinearLayout layout;
	
	@Override
	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		
		this.layout = new LinearLayout(this);
		this.setContentView(new LinearLayout(this), new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	    this.layout.setOnClickListener(this);
	}
	

	@Override
	public void onClick(View v) 
	{
		
	}

}
