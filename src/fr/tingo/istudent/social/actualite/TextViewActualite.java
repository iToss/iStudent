package fr.tingo.istudent.social.actualite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Html;
import android.view.Gravity;
import android.widget.TextView;

public class TextViewActualite extends TextView {

		
	public TextViewActualite(Context context) {
		super(context);
	}

	/** Objet d'affichage de texte pour les Actualités */
	@SuppressLint("NewApi")
	public TextViewActualite(Context context, String actualite) {
		super(context);
		this.setGravity(Gravity.CENTER); // Centres le texte sur la vue
		this.setTextSize(16.0f); //Taille de la police
		this.setText(Html.fromHtml(actualite)); //On transcrit le texte de l'html pour une mis en page
	}

	
	/** Appelez lorsque le textView est dessiné, on dessine le texte, le cadre gris...*/
	@Override
    public void draw(Canvas canvas) 
    {
		Paint paint = new Paint();
		
		paint.setColor(fr.tingo.istudent.util.Color.NOIR);
		canvas.drawRect(new Rect(0, 0, this.getWidth(), this.getHeight()), paint);
		
		paint.setColor(fr.tingo.istudent.util.Color.GRIS_CLAIR);
		canvas.drawRect(new Rect(4, 4, this.getWidth() - 4, this.getHeight() - 4), paint);
		
		super.draw(canvas);
		
    }
}
