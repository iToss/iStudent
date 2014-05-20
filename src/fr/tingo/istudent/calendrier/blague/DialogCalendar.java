package fr.tingo.istudent.calendrier.blague;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import fr.tingo.istudent.R;

public class DialogCalendar extends Dialog implements OnClickListener
{
	private LayoutParams paramsText = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT); 
	private TextView textView;
	private Blague blague;
	private Savoir savoir;
	private Citation citation;
	

	/** Boite pop up de dialogue personnalisé. */
	public DialogCalendar(Context pContext, Blague pQuestion) 
	{
		super(pContext);
		this.textView = new TextView(pContext);
		this.setTitle(pContext.getText(R.string.blague)); // On recupere la string crée en XML
		this.blague = pQuestion;
		this.setContent(this.blague.getTextWithoutReponse());
		this.textView.setOnClickListener(this);
	}
	
					
	public DialogCalendar(Context pContext, Savoir pSavoir) 
	{
		super(pContext);
		this.textView = new TextView(pContext);
		this.setTitle(pContext.getText(R.string.savoir)); // On recupere la string crée en XML
		this.savoir = pSavoir;
		this.setContent(this.savoir.getSavoir());
	}
	
	public DialogCalendar(Context pContext, Citation pCitation) 
	{
		super(pContext);
		this.textView = new TextView(pContext);
		this.setTitle(pContext.getText(R.string.citation)); // On recupere la string crée en XML
		this.citation = pCitation;
		this.setContent(this.citation.getFullCitation());
	}

	public void setContent(String pText)
	{
		
		ColorDrawable drawable = new ColorDrawable(Color.TRANSPARENT); // Création du background drawable avec des teintes grandiantes
		drawable.setBounds(40, 40, 40, 40);
		this.getWindow().setBackgroundDrawable(drawable); // Modification du background de la boite de dialog
		
		this.textView.setText(pText); // On lie le text au textview, on ajoute des sauts de lignes pour espacer le tout
		this.textView.setTextColor(Color.WHITE); // La couleur du texte est blanche
		this.textView.setPadding(40, 60, 40, 60); // Le padding est le decalage, dans l'ordre: GAUCHE, HAUT, DROITE, BAS
		this.textView.setTextSize(16.0F); // Modification de la taille de la police
		
		this.setContentView(this.textView, this.paramsText); // On ajoute le textView à la boite.
	}



	@Override
	public void onClick(View v) 
	{
		this.textView.setText(this.blague.getTextWithReponse());
	}
	

	/** Affiche un Dialog aléatoire entre Savoir, Citation et Blague */
	public static void showRandomDialog(Activity activity)
	{
		Random rand = new Random();
		int alea = rand.nextInt(3);
		DialogCalendar dialog = null;
		
		switch(alea)
		{
			case 0: 
				Blague question = new Blague(activity, rand);
				dialog = new DialogCalendar(activity, question); // On crée une nouvelle boite de dialogue
				dialog.show(); // On l'affiche
				break;
				
			case 1: 
				Savoir savoir = new Savoir(rand);
				dialog = new DialogCalendar(activity, savoir); // On crée une nouvelle boite de dialogue
				dialog.show(); // On l'affiche
				break;
				
			case 2: 
				Citation citation = new Citation(rand);
				dialog = new DialogCalendar(activity, citation); // On crée une nouvelle boite de dialogue
				dialog.show(); // On l'affiche
				break;	
		}	
	}


}

