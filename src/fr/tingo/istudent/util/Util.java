package fr.tingo.istudent.util;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

@SuppressLint({"DefaultLocale"})
public class Util
{
	
	/** Affiches des Logs dans la console de l'ordinateur (indiquant une Erreur de programmation )*/
	  @SuppressLint({"DefaultLocale"}) //cette indication signale que ceci ne fonctionne qu'en local (lorsque le telephone est branché au PC)
	  public static void LogDanger(String paramString1, String paramString2)
	  {
		  Log.println(5, "[" + paramString1.toUpperCase() + "]", paramString2);
	  }
	
	  /** Affiches un message dans la console de l'ordinateur (Message d'information) */
	  @SuppressLint({"DefaultLocale"}) //cette indication signale que ceci ne fonctionne qu'en local (lorsque le telephone est branché au PC)
	  public static void LogSafe(String paramString1, String paramString2)
	  {
		  Log.println(4, "[" + paramString1 + "]", paramString2);
	  }

	  
	  
	  /** Convertis une String sous la forme:
	   * 
	   * @param paramString : BonJoUr, aurevoir, SALUt
	   * @return : Bonjour , Aurevoir, Salut
	   */
	  public static String convertStringMaj(String paramString)
	  {
		  char c = paramString.charAt(0);
		  String str = paramString.substring(1, paramString.length());
		  return c + str;
	  }


	/** Supprimes tous les focus de la vue */
	public static void resetFocus(Activity activity) 
	{
		activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);		
	}
	
	
	/** Renvoies une couleur de police aléatoire en html */
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

			   case 4: str = "purple";
			   break;
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

	  
	    
	    /** Generes un message d'aurevoir aléatoire */
		public static CharSequence getRandomMessage() 
		{
			CharSequence msg = "";
			Random rand = new Random();
			int alea = rand.nextInt(2);
			
			if(alea == 0) // Alors on affiche un message neutre
			{
				switch(rand.nextInt(3))
				{
					case 0: msg = "Merci d'avoir utilisé l'application, à bientot.";
						break;
				
					case 1: msg = "N'oublies pas de faire tes devoirs!";
						break;
					
					case 2: msg = "0100000101110101011100100110010101110110011011110110100101110010 (Aurevoir)";
						break;
					
					case 3: msg = "Tu retournes sur un de tes jeux idiots c'est ça? :(";
						break;
				}
			}
			else // On affiche un message en fonction du mois.
			{
				Date today = Date.getTodayDate();
				if(today.getMois() == 1 || today.getMois() == 12 || today.getMois() == 11) // Si on est en janvier ou en decembre ou en novembre
				{
					alea = rand.nextInt(6);

					switch(alea)
					{
						case 0 : msg = "Je deteste le mois de Janvier! Retournes travailler!";
							break;
						
						case 1 : msg = "Tu ferai mieux de travailler, il fait froid dehors!";
							break;
						
						case 2 : msg = "Je deteste le mois de Janvier! Retournes travailler!";
							break;
							
						case 3 : msg = "L'hiver... la période la plus longue de l'année.";
							break;
						
						case 4 : msg = "Et si tu m'achetais une nouvelle coque pour l'hiver?";
							break;
							
						case 5 : msg = "Vas - t'il neiger cette année? Avec un peu de chance tu louperas des cours... :p";
							break;
					}
				}
				else if(today.getMois() == 6 || today.getMois() == 5) // Si on est en juin ou en mai
				{
					alea = rand.nextInt(6);

					switch(alea)
					{
						case 0 : msg = "Il fait chaud, c'est la fin de l'année... Aller, fais une pause!";
							break;
						
						case 1 : msg = "Tu as raison, avec ce soleil tu ferais mieux de t'amuser dehors!";
							break;
						
						case 2 : msg = "La fin des cours arrive bientot! Encore moins d'un mois!";
							break;
							
						case 3 : msg = "C'est la derniere ligne droite avant la fin de l'année!";
							break;
						
						case 4 : msg = "Il serait peut être temps d'arrêter de jouer et de commencer à réviser...";
							break;
						
						case 5 : msg = "Les beaux jours ne veulent pas dire repos! Penses à tes examens si tu en as cette année.";
							break;
					}
				}
				else if(today.getMois() == 9 || today.getMois() == 10) // Si on est en septembre ou octobre (début année)
				{
					alea = rand.nextInt(5);

					switch(alea)
					{
						case 0 : msg = "C'est reparti pour une année! Je serai ton compagnon de classe :)";
							break;
						
						case 1 : msg = "J'espere t'aider au cours de cette nouvelle année!";
							break;
						
						case 2 : msg = "Ca se passe bien la rentré? Pense à te faire de nouveaux amis!";
							break;
							
						case 3 : msg = "Aller, encore au moins 8 mois de travail :p";
							break;
							
						case 4 : msg = "L'année ne fait que commencer! Pense à travailler regulierement";
							break;
					}
				}
				else if(today.getMois() == 8 || today.getMois() == 7) // Si on est en Juillet ou Aout
				{
					alea = rand.nextInt(2);

					switch(alea)
					{
						case 0 : msg = "C'est les vacaaaaaaances! Quittes l'applicaiton et va te baigner!";
							break;
						
						case 1 : msg = "Arrêtes de travailler et vas bronzer!";
							break;
					}
				}
				else
				{
					alea = rand.nextInt(3);

					switch(alea)
					{
						case 0 : msg = "Pense à respecter tes camarades, tu te feras de nouveaux amis!";
							break;
						
						case 1 : msg = "L'entraide au sein d'une classe est la base du progrès!";
							break;
							
						case 2 : msg = "Cette application a été fait dans le cadre d'un projet de BAC!";
							break;
					}
				}
			}
			
			
			return msg;
		}
		
		/** Renvoies une couleur aléatoire en héxadécimal */
		public static int getRandomColor() 
		{
			Random r = new Random();
			
			switch(r.nextInt(16))
			{
				case 0 : 
					return 0xE67E30; // abricot
					
				case 1 :
					return 0x74D0F1; // Azurclair
					
				case 2 :
					return 0x00000000; // Transparent
					
				case 3 :
					return 0xC8AD7F; //Beige
					
				case 4 :
					return 0xFFCB60; //Aurore (jaune)
					
				case 5 :
					return 0xFBF2B7; //champagne
					
				case 6 :
					return 0xD2CAEC; // Gris de lain
					
				case 7 :
					return  0x54F98D; //Menthe à l'eau
					
				case 8 :
					return 0xFAF0C5; //Platine
					
				case 9 :
					return 0xBEF574; //Pistache
					
				case 10 :
					return 0xE32636; // Rouge
					
				case 11 :
					return 0xE97451; // Terre brulé
					
				case 12 :
					return 0xFAEA73; //Topaze
					
				case 13 :
					return 0xE9C9B1; // Biche
					
				case 14 :
					return 0xCFA0E9; //Parme
					
				case 15 :
					return 0xFD6C9E;  //Rose
					
			}
			
			return 0;
		}
}
