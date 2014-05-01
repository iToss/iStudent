package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import fr.tingo.istudent.calendrier.CalendarActivity;
import fr.tingo.istudent.cours.CoursActivity;
import fr.tingo.istudent.social.SocialActivity;

@SuppressLint({"ViewConstructor"})
public class MainLayout extends ScrollView implements View.OnClickListener
{
	  public static int height;
	  public static int width;
	  public Activity activity;
	  public ButtonStudent buttonAgenda;
	  public ButtonStudent buttonEmploiDuTemps;
	  public ButtonStudent buttonMesCours;
	  public ButtonStudent buttonQuitter;
	  public ButtonStudent buttonSocial;
	  public RelativeLayout layout;
	  public LinearLayout.LayoutParams scrollParams;
	
	  @SuppressLint({"ResourceAsColor", "NewApi"})
	  public MainLayout(Activity paramActivity)
	  {
		    super(paramActivity);
		    
		    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
		    Point localPoint = new Point();
		    localDisplay.getSize(localPoint);
		    
		    width = localPoint.x;
		    height = localPoint.y;
		    
		    this.activity = paramActivity;
		    this.buttonSocial = new ButtonStudent(paramActivity);
		    this.buttonAgenda = new ButtonStudent(paramActivity);
		    this.buttonMesCours = new ButtonStudent(paramActivity);
		    this.buttonEmploiDuTemps = new ButtonStudent(paramActivity);
		    this.buttonQuitter = new ButtonStudent(paramActivity);
		    
		    this.layout = new RelativeLayout(paramActivity);
		    this.scrollParams = new LinearLayout.LayoutParams(-2, -1);
		    this.setLayoutParams(this.scrollParams);
		    this.setBackgroundColor(17170445);
		    this.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
		    this.setFillViewport(true);
		    this.setScrollBarStyle(0);
		    
		    this.buttonSocial.setText("Social");
		    this.buttonAgenda.setText("Agenda");
		    this.buttonMesCours.setText("Mes cours");
		    this.buttonEmploiDuTemps.setText("Emploi du temps");
		    this.buttonQuitter.setText("Quitter");
		    
		    int i = height / 8;
		    this.buttonSocial.setHeight(i);
		    this.buttonAgenda.setHeight(i);
		    this.buttonMesCours.setHeight(i);
		    this.buttonEmploiDuTemps.setHeight(i);
		    this.buttonQuitter.setHeight(i);
		    
		    int j = 4 * (width / 5);
		    this.buttonSocial.setWidth(j);
		    this.buttonAgenda.setWidth(j);
		    this.buttonMesCours.setWidth(j);
		    this.buttonEmploiDuTemps.setWidth(j);
		    this.buttonQuitter.setWidth(j);
		    
		    this.buttonSocial.setX(j / 8);
		    this.buttonAgenda.setX(j / 8);
		    this.buttonMesCours.setX(j / 8);
		    this.buttonEmploiDuTemps.setX(j / 8);
		    this.buttonQuitter.setX(j / 8);
		    
		    int k = i / 4;
		    this.buttonSocial.setY(i / 2);
		    this.buttonAgenda.setY(k + (i + i / 2));
		    this.buttonMesCours.setY(i / 2 + 2 * (i + k));
		    this.buttonEmploiDuTemps.setY(i / 2 + 3 * (i + k));
		    this.buttonQuitter.setY(height - 2.5F * i);
		    
		    this.layout.addView(this.buttonSocial);
		    this.layout.addView(this.buttonAgenda);
		    this.layout.addView(this.buttonMesCours);
		    this.layout.addView(this.buttonEmploiDuTemps);
		    this.layout.addView(this.buttonQuitter);
		    this.addView(this.layout);
		    
		    this.buttonSocial.setOnClickListener(this);
		    this.buttonMesCours.setOnClickListener(this);
		    this.buttonQuitter.setOnClickListener(this);
		    this.buttonAgenda.setOnClickListener(this);
		    this.buttonEmploiDuTemps.setOnClickListener(this);
	  }
	
	  public void onClick(View v)
	  {
		    if (v.equals(this.buttonQuitter))
		    {
		      this.activity.onBackPressed();
		    }
		    else if(v.equals(this.buttonSocial))
		    {
		        Intent intent = new Intent();
		        intent.setClass(getContext(), SocialActivity.class);
		        this.activity.startActivity(intent);
		    }
		    
		    else if(v.equals(this.buttonAgenda))
		    {
		        Intent intent = new Intent();
		        intent.setClass(getContext(), CalendarActivity.class);
		        this.activity.startActivity(intent);
		    }
		    
		    else if(v.equals(this.buttonEmploiDuTemps))
		    {
		    	//TODO emploi du temps
		    }
		    
		    else if(v.equals(this.buttonMesCours))
		    {
			      Intent intent = new Intent();
			      intent.setClass(getContext(), CoursActivity.class);
			      this.activity.startActivity(intent);
		    }
	  }
}