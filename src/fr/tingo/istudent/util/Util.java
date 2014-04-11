package fr.tingo.istudent.util;

import android.annotation.SuppressLint;
import android.util.Log;




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
	

	
}
