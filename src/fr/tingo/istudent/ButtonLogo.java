package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

/** Cette classe cocnerne les 6 boutons du menus d'accueil */
public class ButtonLogo extends Button {

	/**Constructeur par d�faut */
	public ButtonLogo(Context context)
	{
		super(context);
	}
	
	
	/** Prends comme parametre:
	 * 
	 * @param context : L'activity dans laquel se trouve le bouton
	 * @param resID : l'ID de la ressource du bouton (pour les 3 textures: Bouton Press�, Non press�, inactif
	 * @param largeur : la largeur du bouton ( et donc sa hauteur, bouton carr� )
	 * @param posX / posY : les coordonn�es du bouton (en pixel)
	 */
	@SuppressLint("NewApi") //Le tag "NewApi" signale au t�l�phone que si sa version d'android n'est pas assez r�cente, alors l'application  ne pourra pas �tre utilis�
	public ButtonLogo(Context context, int resID, int largeur, int posX, int posY) 
	{
		super(context);

	    this.setBackgroundResource(resID);
	    this.setX(posX);
	    this.setY(posY);
	    this.setLayoutParams(new LayoutParams(largeur, largeur));
	}

}
