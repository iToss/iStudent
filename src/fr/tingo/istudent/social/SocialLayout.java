package fr.tingo.istudent.social;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.R;
import fr.tingo.istudent.social.actualite.ActualiteActivity;
import fr.tingo.istudent.view.ButtonStudent;

@SuppressLint("ViewConstructor")
public class SocialLayout extends RelativeLayout implements OnClickListener {

	public ButtonStudent buttonActualite;
	public ButtonStudent buttonContact;
	
	public Activity context;

	
	@SuppressLint("NewApi")
	public SocialLayout(Activity c) 
	{
		super(c);
		
		this.context = c;
		
		ImageView img = new ImageView(c);
		img.setMinimumWidth(MainLayout.width);
		img.setMinimumHeight(MainLayout.height / 2);
		img.setBackgroundResource(R.drawable.student_2);
		this.addView(img);
		
		this.buttonActualite = new ButtonStudent(context);
		this.buttonContact = new ButtonStudent(context);
		
		this.buttonActualite.setOnClickListener(this);
		this.buttonContact.setOnClickListener(this);
		
		this.buttonActualite.setWidth(MainLayout.width - MainLayout.width / 5);
		this.buttonContact.setWidth(MainLayout.width - MainLayout.width / 5);

		this.buttonActualite.setHeight(MainLayout.height / 8);
		this.buttonContact.setHeight(MainLayout.height / 8);
		
		this.buttonActualite.setX( MainLayout.width / 10);
		this.buttonContact.setX( MainLayout.width / 10);
		
		this.buttonActualite.setY(MainLayout.height / 2 + MainLayout.height / 32);
		this.buttonContact.setY(MainLayout.height / 2 + MainLayout.height / 8 + MainLayout.height / 16);
		
		this.buttonActualite.setText("Actualités");
		this.buttonContact.setText ("Mes contacts");
		
		
		this.addView(this.buttonActualite);
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
		else if(v.equals(this.buttonContact))
		{
			DialogContact d = new DialogContact(this.context);
			d.show();
		}
	}

}
