package fr.tingo.istudent.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Sauvegarde {
	
	public static final String DEFAULT_DEVOIRS = ""; // Le texte par defaut des devoirs

	
	
	/** Enregistres une String dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveListString(String id, List<String> list, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		int size = list.size();
		editor.putInt("int_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			editor.putString(id + i, list.get(i));
		}
		
		editor.commit();
	}
	
	
	/** Recuperes une String enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static List<String> loadListString(String id, Activity activity)
	{
		List<String> list = new ArrayList<String>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("int_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			list.add(preferences.getString(id + i, ""));
		}

		return list;
	}
	
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void addStringToList(String id, String str, Activity activity)
	{
		List<String> list = Sauvegarde.loadListString(id, activity);
		list.add(str);
		Sauvegarde.saveListString(id, list, activity);
	}
	
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void removeStringFromList(String id, String strRemoved, Activity activity)
	{
		List<String> list = Sauvegarde.loadListString(id, activity);
		list.remove(strRemoved);
		Sauvegarde.saveListString(id, list, activity);
	}
	
	

	
	/** Enregistres une String dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveString(String id, String stringSaved, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putString(id, stringSaved);
		editor.commit();	
	}
	
	
	/** Recuperes une String enregistré dans les SharedPreferences (mémoire morte du téléphone)
	 *  Args: ID de la String, String en cas d'erreur de chargement (not found), activity actuelle
	 **/
	public static String loadString(String id, String errorString, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		return preferences.getString(id, errorString);
	}

	/** Enregistres une Integer dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveInt(String id, int intSaved, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putInt(id, intSaved);
		editor.commit();	
	}
	
	
	/** Recuperes une Integer enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static int loadInt(String id, int errorInt, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		return preferences.getInt(id, errorInt);
	}
	
	
	/** Enregistres un Float dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveFloat(String id, float floatSaved, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putFloat(id, floatSaved);
		editor.commit();	
	}
	
	
	/** Recuperes un Float enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static float loadFloat(String id, float errorFloat, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		return preferences.getFloat(id, errorFloat);
	}
	

}
