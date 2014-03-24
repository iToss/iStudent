package fr.tingo.istudent.actualite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ActualiteLayout extends ScrollView {
	
	public List<TextViewActualite> textview;
	
	public LinearLayout layout;

	public int width;
	public int height;
	
	public LinearLayout.LayoutParams scrollParams;
	public Activity activity;
	
	public ActualiteLayout(Context context) {
		super(context);
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint({ "ResourceAsColor", "NewApi" })
	public ActualiteLayout(Activity context) {
		super(context);
		
		this.textview  = new ArrayList<TextViewActualite>();
		this.activity = context;

		this.width = context.getWindowManager().getDefaultDisplay().getWidth(); // On recupere la largeur de l'ecran
		this.height = context.getWindowManager().getDefaultDisplay().getHeight(); //On recupere la hauteutr de l'ecran
		
		
		/** Initialisation des objets */
		this.layout = new LinearLayout (context);
		this.scrollParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);

		/** configuration scrollview */
		this.setLayoutParams(scrollParams);
		this.setBackgroundColor(android.R.color.transparent);
		this.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        this.setFillViewport(true);
		this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		/** configuration du layout */
		this.layout.setOrientation(LinearLayout.VERTICAL);
		
		/** Ajout du titre */
		TextView title = new TextView(context);
		SpannableString content = new SpannableString("\n" + "Actualités" + "\n");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		title.setText(content);
		title.setTextSize(24.0f);
		title.setGravity(Gravity.CENTER);
		this.layout.addView(title);
		
		/**Ajout des vues au layout */
		this.getActualite();

		
		
		/** Ajout du Layout au scrollview */
		this.addView(layout);

	}

    /** Enregistres les actualités dans la list de TextViewActualite */
	public void getActualite()
	{
		try {
			int attempt = 0;
			URL urlMsg = new URL("http://grillecube.fr/iStudent/actualite/script_getMessages.php");
		    URLConnection urlConnectionMsg = urlMsg.openConnection();
			BufferedReader readerMsg = new BufferedReader(new InputStreamReader(urlConnectionMsg.getInputStream()));
			
			URL urlDate = new URL("http://grillecube.fr/iStudent/actualite/script_getDate.php");
		    URLConnection urlConnectionDate = urlDate.openConnection();
			BufferedReader readerDate = new BufferedReader(new InputStreamReader(urlConnectionDate.getInputStream()));
			
			String str[] = new String[2];
			str[0] = "";
			str[1] = "";
			
			while((str[0] = readerDate.readLine()) != null)
			{
				str[1] = "<br></br>" + readerMsg.readLine();
				
				while(!str[1].contains("&"))
				{
					str[1] += "<br></br>" + readerMsg.readLine();
				}

				str[1] = str[1].substring(0, str[1].length() - 1);
				this.layout.addView(new TextViewActualite(this.getContext(), str));
				attempt++;

				if(attempt > 10)
				{
					break;
				}
			}

			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
