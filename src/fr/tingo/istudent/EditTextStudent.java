package fr.tingo.istudent;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class EditTextStudent extends EditText implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener
{
	  public Button b_color;
	  public Button b_gras;
	  public Button b_italique;
	  public Button b_souligner;
	  public String id;
	  public Spinner spinnerColor;
	
	  @SuppressLint({"NewApi"})
	  public EditTextStudent(Activity paramActivity, RelativeLayout layout, int y)
	  {
	    super(paramActivity);
	   
	    this.setOnClickListener(this);
	    this.setOnFocusChangeListener(this);
	  
	    this.b_gras = new Button(paramActivity);
	    this.b_souligner = new Button(paramActivity);
	    this.b_italique = new Button(paramActivity);
	    this.b_color = new Button(paramActivity);
	    this.spinnerColor = new Spinner(paramActivity);
	   
	    this.b_gras.setText(Html.fromHtml("<strong>G</strong>"));
	    this.b_souligner.setText(Html.fromHtml("<u>S</u>"));
	    this.b_italique.setText(Html.fromHtml("<i>I</i>"));

	    List<String> choices = new ArrayList<String>();
	    choices.add("Rouge");
	    choices.add("Vert");
	    choices.add("Jaune");
	    choices.add("Bleu");
	    choices.add("Violet");
	    choices.add("Orange");  
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, choices);
	    this.spinnerColor.setAdapter(spinnerArrayAdapter);
	    
	    this.b_gras.setX(MainLayout.width / 100);
	    this.b_souligner.setX(MainLayout.width / 100 + MainLayout.width / 6);
	    this.b_italique.setX(MainLayout.width / 100 + 2 * (MainLayout.width / 6));
	    this.b_color.setX(MainLayout.width / 100 + 3 * (MainLayout.width / 6));
	    this.spinnerColor.setX(MainLayout.width / 50 + 4 * (MainLayout.width / 6));
	    
	    this.b_gras.setOnClickListener(this);
	    this.b_souligner.setOnClickListener(this);
	    this.b_italique.setOnClickListener(this);
	    this.b_color.setOnClickListener(this);
	    this.spinnerColor.setOnItemSelectedListener(this);
	    
	    this.b_gras.setId(1);
	    this.b_souligner.setId(2);
	    this.b_italique.setId(3);
	    this.b_color.setId(4);
	    
	    this.b_gras.setY(y);
	    this.b_souligner.setY(y);
	    this.b_italique.setY(y);
	    this.b_color.setY(y);
	    this.spinnerColor.setY(y);
	    
	    layout.addView(this.b_gras);
	    layout.addView(this.b_souligner);
	    layout.addView(this.b_italique);
	    layout.addView(this.b_color);
	    layout.addView(this.spinnerColor);
	    
	    this.b_gras.setVisibility(INVISIBLE);
	    this.b_souligner.setVisibility(INVISIBLE);
	    this.b_italique.setVisibility(INVISIBLE);
	    this.b_color.setVisibility(INVISIBLE);
	    this.spinnerColor.setVisibility(INVISIBLE);
	  }
	
	  public EditTextStudent(Context paramContext)
	  {
	    super(paramContext);
	  }
	
	  private String getEnglishColor(String str)
	  {
		  if(str.equals("Rouge"))
			  return "red";
		  else if(str.equals("Vert"))
			  return "green";
		  else if(str.equals("Jaune"))
			  return "yellow";
		  else if(str.equals("Bleu"))
			  return "blue";
		  else if(str.equals("Violet"))
			  return "purple";
		  else if(str.equals("Orange"))
			  return "orange";
		  else
			  return "black";
	  }
	
	  
	  public void addBalises(String ... balises)
	  {
		  int start = this.getSelectionStart();
		  int end = this.getSelectionEnd();
		  
		  if(start != end) //Si la selection n'est pas vide
		  {
			  String focus = this.getText().toString().substring(start, end);
			  
			  String html = Html.toHtml(this.getText());
			  
			  Spanned text = Html.fromHtml(html.replace(focus, balises[0] + focus + balises[1]));
			  this.setText(text);
			  this.setSelection(this.getText().length());
		  }
	  }
	
	  
	  public void onClick(View v) //lorsuq'on clique sur une balise
	  {
		  if(v.getId() == 1)
		  {
			  this.addBalises("<strong>", "</strong>");
		  }
		  else if(v.getId() == 2)
		  {
			  this.addBalises("<u>", "</u>");
		  }
		  else if(v.getId() == 3)
		  {
			  this.addBalises("<i>", "</i>");
		  }
		  else if(v.getId() == 4)
		  {
			  this.addBalises("<font color=\"" + getEnglishColor(this.spinnerColor.getSelectedItem().toString()) + "\">", "</font>");
		  }
			  
	  }
	
	  public void onFocusChange(View paramView, boolean hasFocus)
	  {
	    if(hasFocus)
	    {
	      this.b_gras.setVisibility(VISIBLE);
	      this.b_souligner.setVisibility(VISIBLE);
	      this.b_italique.setVisibility(VISIBLE);
	      this.b_color.setVisibility(VISIBLE);
	      this.spinnerColor.setVisibility(VISIBLE);
	    }
	    else
	    {
	      this.b_gras.setVisibility(INVISIBLE);
	      this.b_souligner.setVisibility(INVISIBLE);
	      this.b_italique.setVisibility(INVISIBLE);
	      this.b_color.setVisibility(INVISIBLE);
	      this.spinnerColor.setVisibility(INVISIBLE);
	    }
	  }
	
	  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
	  {
		  String text = this.spinnerColor.getSelectedItem().toString();
		  this.b_color.setText(Html.fromHtml("<font color=\"" + getEnglishColor(text) + "\">•</font>"));
	  }
	
	  
	  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
	  {
		  return super.onKeyDown(paramInt, paramKeyEvent);
	  }
	
	  public void onNothingSelected(AdapterView<?> paramAdapterView)
	  {
		  //Comment ceci peut se produire?
	  }
}
