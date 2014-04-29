package fr.tingo.istudent.util;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.WindowManager;

@SuppressLint({"DefaultLocale"})
public class Util
{
	  @SuppressLint({"DefaultLocale"})
	  public static void LogDanger(String paramString1, String paramString2)
	  {
		  Log.println(5, "[" + paramString1.toUpperCase() + "]", paramString2);
	  }
	
	  @SuppressLint({"DefaultLocale"})
	  public static void LogSafe(String paramString1, String paramString2)
	  {
		  Log.println(4, "[" + paramString1 + "]", paramString2);
	  }

	  public static String convertStringMaj(String paramString)
	  {
		  char c = paramString.charAt(0);
		  String str = paramString.substring(1, paramString.length());
		  return c + str;
	  }

	  public static String getRandomFont()
	  {
		  String str = "red";
		  switch (new Random().nextInt(21))
		  {
			   case 1: str = "brown";
			   break;
			    
			   case 2: str = "cyan";
			   break;

			   case 3: str = "orange";
			   break;

<<<<<<< HEAD
			   case 4: str = "purple";
			   break;
=======
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
	
>>>>>>> 23d807182476563cc71813bc9b64abd23f8c40fb

			   case 5: str = "chartreuse";
			   break;

			   case 6: str = "darkgoldenrod";
			   break;

			   case 7: str = "darkorchid";
			   break;

			   case 8: str = "darksalmon";
			   break;

			   case 9: str = "forestgreen";
			   break;

			   case 10: str = "indianred";
			   break;

			   case 11: str = "tan";
			   break;

			   case 12: str = "steelblue";
			   break;

			   case 13: str = "tomato";
			   break;

			   case 14: str = "violet";
			   break;

			   case 15: str = "turquoise";
			   break;

			   case 16: str = "royalblue";
			   break;

			   case 17: str = "rosybrown";
			   break;

			   case 18: str = "peru";
			   break;

			   case 19: str = "olive";
			   break;

			   case 20: str = "mediumvioletred";
			   break;
		   }
		  
		  return "<font color=\"" + str + "\">";    
	  }


	public static void resetFocus(Activity ac)
	{
		ac.getWindow().setSoftInputMode(3);
  	}
}
