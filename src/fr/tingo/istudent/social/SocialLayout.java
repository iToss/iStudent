package fr.tingo.istudent.social;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.FrameLayout.LayoutParams;
import fr.tingo.istudent.MainButton;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.bob.BobActivity;
import fr.tingo.istudent.social.actualite.ActualiteActivity;

public class SocialLayout extends RelativeLayout implements OnClickListener {

	public MainButton buttonActualite;
	public MainButton buttonBob;
	public MainButton buttonContact;
	
	public Activity context;

	
	@SuppressLint("NewApi")
	public SocialLayout(Activity c) 
	{
		super(c);
		
		this.context = c;
		
		this.buttonActualite = new MainButton(context);
		this.buttonBob = new MainButton(context);
		this.buttonContact = new MainButton(context);
		
		this.buttonActualite.setOnClickListener(this);
		this.buttonBob.setOnClickListener(this);
		this.buttonContact.setOnClickListener(this);
		
		int buttonWidth = MainLayout.width / 5 * 4;
		this.buttonActualite.setWidth(buttonWidth);
		this.buttonBob.setWidth(buttonWidth);
		this.buttonContact.setWidth(buttonWidth);

		int buttonHeight = MainLayout.height / 8;
		this.buttonActualite.setWidth(buttonHeight);
		this.buttonBob.setWidth(buttonHeight);
		this.buttonContact.setWidth(buttonHeight);
		
		this.buttonActualite.setX(buttonWidth / 8);
		this.buttonBob.setX(buttonWidth / 8);
		this.buttonContact.setX(buttonWidth / 8);
		
		int unit = buttonHeight / 4;
		this.buttonActualite.setY(buttonHeight / 2 + buttonHeight + unit);
		this.buttonBob.setY(buttonHeight / 2 + (buttonHeight + unit) * 2);
		this.buttonContact.setY(buttonHeight / 2 + (buttonHeight + unit) * 3);
		
		this.buttonActualite.setText("Actualité");
		this.buttonBob.setText("Bob");
		this.buttonContact.setText ("Mes contacts");
		
		
		this.addView(this.buttonActualite);
		this.addView(this.buttonBob);
		this.addView(this.buttonContact);

	}


	@Override
	public void onClick(View v) 
	{
		if(v.equals(this.buttonActualite))
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), ActualiteActivity.class);
			this.context.startActivity(intent);
		}
		else if(v.equals(this.buttonBob))
		{
			Intent intent = new Intent();
			intent.setClass(getContext(), BobActivity.class);
			this.context.startActivity(intent);
		}
		else if(v.equals(this.buttonContact))
		{
			DialogContact d = new DialogContact(this.context);
			d.show();
		}
	}
	
	

}
