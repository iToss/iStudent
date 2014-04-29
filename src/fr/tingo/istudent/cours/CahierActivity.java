package fr.tingo.istudent.cours;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import fr.tingo.istudent.EditTextStudent;
import fr.tingo.istudent.MainLayout;
import fr.tingo.istudent.util.Sauvegarde;

public class CahierActivity extends Activity implements View.OnClickListener, View.OnLongClickListener
{
	public Button[] button;
	public EditTextStudent editText;
	public RelativeLayout layout;
	public String matiere;
	public int n_page;
	public String pageID;
	public TextView title;


	@SuppressLint({"NewApi"})
	public void onCreate(Bundle paramBundle)
	{
	    super.onCreate(paramBundle);
	    
	    this.matiere = getIntent().getExtras().getString("matiere");
	    this.n_page = 0;
	    
	    this.layout = new RelativeLayout(this);
	    this.button = new Button[2];
	    
	    this.button[0] = new Button(this);
	    this.button[0].setText("<-");
	    this.button[0].setLayoutParams(new RelativeLayout.LayoutParams(MainLayout.width / 8, MainLayout.height / 16));
	    this.button[0].setX(MainLayout.width / 100);
	    this.button[0].setY(MainLayout.height / 32);
	    this.button[0].setOnClickListener(this);
	    this.button[0].setOnLongClickListener(this);
	    
	    this.button[1] = new Button(this);
	    this.button[1].setText("->");
	    this.button[1].setLayoutParams(new RelativeLayout.LayoutParams(MainLayout.width / 8, MainLayout.height / 16));
	    this.button[1].setX(MainLayout.width - MainLayout.width / 8 - MainLayout.width / 100);
	    this.button[1].setOnClickListener(this);
	    this.button[1].setOnLongClickListener(this);
	    this.button[1].setY(MainLayout.height / 32);
	    
	    this.editText = new EditTextStudent(this, this.layout, MainLayout.height / 8);
	    this.editText.setX(MainLayout.width / 100);
	    this.editText.setY(MainLayout.height / 5 + MainLayout.height / 100);
	    this.editText.setLayoutParams(new RelativeLayout.LayoutParams(98 * MainLayout.width / 100, 2 * MainLayout.height / 3));
	    this.editText.setGravity(48);
	    
	    this.title = new TextView(this);
	    this.title.setTextSize(20.0F);
	    this.title.setLayoutParams(new RelativeLayout.LayoutParams(MainLayout.width, MainLayout.height / 8));
	    this.title.setGravity(Gravity.CENTER);
	    
	    this.init();
	    
	    this.layout.addView(this.editText);
	    this.layout.addView(this.title);
	    this.layout.addView(this.button[0]);
	    this.layout.addView(this.button[1]);
	    this.setContentView(this.layout);
	    this.editText.setSelection(this.editText.getText().toString().length());
	}

	
	
	public void goToPage(int page)
	{
		this.n_page = page;
		this.init();
	}

	public void init()
	{
		this.pageID = (this.matiere + "_p_" + this.n_page);
		this.title.setText(Html.fromHtml("<u><strong>" + this.matiere + " - P" + this.n_page + "</u></strong>"));
		this.editText.setText(Html.fromHtml(Sauvegarde.loadString(this.pageID, "", this)));
	}

	public void onBackPressed()
	{
		Sauvegarde.saveString(this.pageID, Html.toHtml(this.editText.getText()), this);
		Toast.makeText(this, "Votre cours a été enregistré", Toast.LENGTH_LONG).show();
		super.onBackPressed();
	}

	
	public void onClick(View v)
	{
		if ((v.equals(this.button[0])) && (this.n_page > 0))
			goToPage(this.n_page - 1);
			
		else if (v.equals(this.button[1]))
			goToPage(1 + this.n_page);
	}
	
	
	
	public boolean onLongClick(View v)
	{
		if ((v.equals(this.button[0])) && (this.n_page > 10))
			goToPage(this.n_page - 10);
		else if (v.equals(this.button[1]))
			goToPage(10 + this.n_page);
		
		return false;
	}
}