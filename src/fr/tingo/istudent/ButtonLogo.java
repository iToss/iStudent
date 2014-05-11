package fr.tingo.istudent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

/** Cette classe cocnerne les 6 boutons du menus d'accueil */
public class ButtonLogo extends Button {

	/**Constructeur par défaut */
	public ButtonLogo(Context context)
	{
		super(context);
	}
	
	
	/** Prends comme parametre:
	 * 
	 * @param context : L'activity dans laquel se trouve le bouton
	 * @param resID : l'ID de la ressource du bouton (pour les 3 textures: Bouton Pressé, Non pressé, inactif
	 * @param largeur : la largeur du bouton ( et donc sa hauteur, bouton carré )
	 * @param posX / posY : les coordonnées du bouton (en pixel)
	 */
	@SuppressLint("NewApi") //Le tag "NewApi" signale au téléphone que si sa version d'android n'est pas assez récente, alors l'application  ne pourra pas être utilisé
	public ButtonLogo(Context context, int resID, int largeur, int posX, int posY) 
	{
		super(context);

	    this.setBackgroundResource(resID);
	    this.setX(posX);
	    this.setY(posY);
	    this.setLayoutParams(new LayoutParams(largeur, largeur));
	}

}
