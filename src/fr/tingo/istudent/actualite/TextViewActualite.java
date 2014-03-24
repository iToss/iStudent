package fr.tingo.istudent.actualite;

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

	
	@SuppressLint("NewApi")
	public TextViewActualite(Context context, String[] actualites) {
		super(context);
		this.setGravity(Gravity.CENTER);
		this.setTextSize(16.0f);
		
		String str =  actualites[1] + "<br></br><br></br>" + "<u>" + actualites[0] + "</u>" + "<br></br>";
		this.setText(Html.fromHtml(str));
	}

	
	/** Appelez lorsque le textView est dessiné, on dessine le texte, le cadre...*/
	@Override
    public void draw(Canvas canvas) 
    {
		Paint paint = new Paint();
		
		paint.setColor(fr.tingo.istudent.util.Color.NOIR);
		canvas.drawRect(new Rect(0, 0, this.getWidth(), this.getHeight()), paint);
		
		paint.setColor(fr.tingo.istudent.util.Color.LIGHTEN);
		canvas.drawRect(new Rect(4, 4, this.getWidth() - 4, this.getHeight() - 4), paint);
		
		super.draw(canvas);
		
    }
}
