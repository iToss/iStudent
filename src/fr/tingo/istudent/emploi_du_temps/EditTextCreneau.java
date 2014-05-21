package fr.tingo.istudent.emploi_du_temps;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditTextCreneau extends EditText implements TextWatcher{
	
	public int heure; //L'heure sous forme numérique (comparaison horaire pour placer les creneaux dans un ordre temporelle): "845" pour "08h45"
	public String heure_str; //l'heure sous forme de String : "08h45"
	private String previous_text;

	public EditTextCreneau(Context context) 
	{
		super(context);
		this.setInputType(InputType.TYPE_CLASS_NUMBER); //On utilise le clavier contenant uniquement des chiffres
		this.addTextChangedListener(this);
	}

	/** Lorsque le texte change */
	@Override //On appelle une méthode d'un classe parente qu'on modifie
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {}
	
	
	/** Avant que le texte ne soit changé */
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) 
	{
		this.previous_text = s.toString();
	}
	
	/** Apres que le texte ait été changé */
	@Override
	public void afterTextChanged(Editable s) 
	{
		String text = this.getText().toString();
		
		if(!text.contains("h"))
		{
			this.setText(text.toString() + "h");
			this.setSelection(this.getText().toString().length()); //On place le curseur à la fin
		}
		
		if(text.length() > 5)
		{
			this.setText(this.previous_text);
			this.setSelection(5); //On place le curseur à la fin
		}
		
		String horaire = "0";
		for(int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			if(c != 'h')
				horaire += c;
		}
		
		this.heure = Integer.valueOf(horaire);
		this.heure_str = this.getText().toString();
	}
	
	
}
