package fr.tingo.istudent.social;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import fr.tingo.istudent.ButtonStudent;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.R;
import fr.tingo.istudent.social.actualite.ActualiteActivity;

@SuppressLint("ViewConstructor")
public class SocialLayout extends RelativeLayout implements View.OnClickListener
{
	  public ButtonStudent buttonActualite;
	  public ButtonStudent buttonContact;
	  public Activity context;
	
	  @SuppressLint({"NewApi"})
	  public SocialLayout(Activity paramActivity)
	  {
		  super(paramActivity);
		  this.context = paramActivity;
		  
		  int i = 4 * (MainLayout.width / 5);
		  int j = MainLayout.height / 8;
		  
		  ImageView image = new ImageView(paramActivity);
		  image.setLayoutParams(new RelativeLayout.LayoutParams(MainLayout.width, (int)(0.9F * MainLayout.width)));
		  image.setImageResource(R.drawable.student_2);
		  
		  this.buttonActualite = new ButtonStudent(this.context);
		  this.buttonContact = new ButtonStudent(this.context);
		  this.buttonActualite.setOnClickListener(this);
		  this.buttonContact.setOnClickListener(this);
		  
		  this.buttonActualite.setWidth(i);
		  this.buttonContact.setWidth(i);
		  
		  this.buttonActualite.setHeight(j);
		  this.buttonContact.setHeight(j);
		  
		  this.buttonActualite.setX(i / 8);
		  this.buttonContact.setX(i / 8);
		  
		  this.buttonActualite.setY(MainLayout.height / 2);
		  this.buttonContact.setY(MainLayout.height / 2 + 1.5F * j);
		  
		  this.buttonActualite.setText("Actualités");
		  this.buttonContact.setText("Mes contacts");
		  
		  this.addView(image);
		  this.addView(this.buttonActualite);
		  this.addView(this.buttonContact);
	  }
	
	  public void onClick(View v)
	  {
		    if (v.equals(this.buttonActualite))
		    {
		      Intent localIntent = new Intent();
		      localIntent.setClass(getContext(), ActualiteActivity.class);
		      this.context.startActivity(localIntent);
		    }
		    else if (v.equals(this.buttonContact))
		    {
		        new DialogContact(this.context).show();
		    }
	  }
}
