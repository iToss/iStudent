package fr.tingo.istudent.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.WindowManager;




@SuppressLint("DefaultLocale")
public class Util {
	

	/**Le mot insérer est retourné avec une majuscule en 1ere lettre */
	public static String convertStringMaj(String mot)
	{
		char maj = mot.charAt(0);
		String min = mot.substring(1, mot.length());
		return maj + min;
	}
	
	
	/** Log simplifier affichant des informations normals */
	@SuppressLint("DefaultLocale")
	public static void LogSafe(String info, String message)
	{
		Log.println(android.util.Log.INFO, "[" + info + "]", message);
	}
	
	/** Log simplifier affichant des informations de dangers */
	@SuppressLint("DefaultLocale")
	public static void LogDanger(String info, String message)
	{
		Log.println(android.util.Log.WARN, "[" + info.toUpperCase() + "]", message);
	}


	/** Supprimes tous les focus */
	public static void resetFocus(Activity activity) 
	{
		activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);		
	}
	

	
}
