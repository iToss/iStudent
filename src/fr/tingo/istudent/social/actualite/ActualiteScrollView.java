package fr.tingo.istudent.social.actualite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import fr.tingo.istudent.util.Sauvegarde;

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

public class ActualiteScrollView extends ScrollView {
	
	public List<TextViewActualite> textview;	
	public LinearLayout layout;
	
	public LinearLayout.LayoutParams scrollParams;
	public Activity activity;
	
	public ActualiteScrollView(Context context) {
		super(context);
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint({ "ResourceAsColor", "NewApi" })
	public ActualiteScrollView(Activity context) {
		super(context);
		
		this.textview  = new ArrayList<TextViewActualite>();
		this.activity = context;
		
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
		
		
		/** Configuration du titre */
		TextView title = new TextView(context);		
		SpannableString content = new SpannableString("\n" + "Actualités" + "\n");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		title.setText(content);
		title.setTextSize(24.0f);
		title.setGravity(Gravity.CENTER);
		this.layout.addView(title);
		
		
		/** On demarre le thread des recuperations d'actualités */
		List<String> pseudos = Sauvegarde.loadListString("contacts", getContext()); //On recupere les pseudos des gens que l'leve follow
		List<String> classes = Sauvegarde.loadListString("contacts_classe", getContext()); //On recupere la classe des gens que l'eleve follow

		String urlMessage = "http://grillecube.fr/iStudent/actualite/script_getMessages.php?";
		String actualite = new String(); //String contenant l'actualité
		
		for(int i = 0; i < pseudos.size(); i++)
		{
			urlMessage += "pseudo" + i + "=" + pseudos.get(i) + "&" + "classe" + i + "=" + classes.get(i) + "&";
		}
		
		urlMessage = urlMessage.substring(0, urlMessage.length() - 1); //On retire le & en trop

		try { //On essaye ...
			URL urlMsg = new URL(urlMessage); //On recupere l'URL des messages
			URLConnection urlConnectionMsg = urlMsg.openConnection(); //On ouvre la connection (on charge la page )
			BufferedReader readerMsg = new BufferedReader(new InputStreamReader(urlConnectionMsg.getInputStream())); //On prepare le reader del a page
			
			while((actualite = readerMsg.readLine()) != null) //Dans qu'il y a du contenu à lire sur la page
			{							
				while(!actualite.contains("&")) //Tant que la phrase ne contient pas le signe "&"
				{
					actualite += readerMsg.readLine(); // on ajoute le contenu à l'actualité
				}	
				actualite = actualite.substring(0, actualite.length() - 1); //On supprime le signe "&" de la phrase
				addActualite(new TextViewActualite(getContext(), actualite)); //Evenement: lorsqu'on ajoute la vue
			}				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		/** Ajout du Layout au scrollview */
		this.addView(layout);
		
	}

	
	/** Ajoute une vue d'actualité au layout */
	public void addActualite(TextViewActualite t)
	{
		this.layout.addView(t);
	}
   

}
