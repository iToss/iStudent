package fr.tingo.istudent.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spanned;
import fr.tingo.istudent.cours.CahierButton;
import fr.tingo.istudent.cours.CoursActivity;
import fr.tingo.istudent.eleve.Matiere;

public class Sauvegarde {
	
	public static final String DEFAULT_DEVOIRS = ""; // Le texte par defaut des devoirs

	
	
	/**Sauvegarde une SpannedString */
	public static void saveSpannedString(String id, Spanned spn, Context context)
	{
		Sauvegarde.saveString(id, Html.toHtml(spn), context);
	}
	
	/**Charge une SpannedString */
	public static Spanned loadSpanned(String id, Context context)
	{
		return Html.fromHtml(Sauvegarde.loadString(id, "", context));
	}
	
	
	
	
	
	/** Charges une liste de cahier */
	public static List<CahierButton> loadListCahier(String id, CoursActivity ac) 
	{
		List<CahierButton> list = new ArrayList<CahierButton>();
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ac); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(ac); // On recupere les SharedPreferences
		
		for(int i = 0; i < preferences.getInt("length_" + id, 0); i++)
		{
			list.add(new CahierButton(ac, preferences.getString("cahier_" + id + i, "none"), preferences.getInt("cahier_color_" + id + i, 0)));
		}
				
		return list;
	}
	
	/** Enregistres une liste de cahier */
	public static void saveListCahier(List<CahierButton> list, String id, Context ac) 
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ac); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences

		editor.putInt("length_" + id, list.size());
		
		for(int i = 0; i < list.size(); i++)
		{
			editor.putString("cahier_" + id + i, list.get(i).name);
			editor.putInt("cahier_color_" + id + i, list.get(i).color);
		}

		editor.commit();
	}
	

	
	
	
	
	
	/** Charge la liste des matieres de l'élève */
	public static List<Matiere> loadListMatiere(String id, Context context)
	{
		List<Matiere> list = new ArrayList<Matiere>();
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("size_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			list.add(Sauvegarde.loadMatiere(id, context));
		}

		return list;
	}
	
	/** Enregistres une String dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveListMatiere(String id, List<Matiere> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		int size = list.size();
		editor.putInt("size_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			Sauvegarde.saveMatiere(list.get(i), id + i, c);
		}
		
		editor.commit();
	}
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void addMatiereToList(String id, Matiere mat, Activity activity)
	{
		List<Matiere> list = Sauvegarde.loadListMatiere(id, activity);
		list.add(mat);
		Sauvegarde.saveListMatiere(id, list, activity);
	}
	
	
	/** Supprimes une Matiere de la liste */
	public static void removeMatiereFromList(String id, Matiere matiereRemoved, Activity activity)
	{
		List<Matiere> list = Sauvegarde.loadListMatiere(id, activity);
		list.remove(matiereRemoved);
		Sauvegarde.saveListMatiere(id, list, activity);
	}
	
	
	
	
	
	
	
	
	
	
	/** Recupere une matiere */
	public static Matiere loadMatiere(String id, Context context)
	{
		SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		p = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences		
		
		Matiere matiere = new Matiere(context, p.getString(id, ""), p.getFloat(id, 0));
		matiere.notes = Sauvegarde.loadListFloat(id, context);
		
		return new Matiere(context, p.getString(id, ""), p.getFloat(id, 0));
	}
	
	
	/** Sauvegarde une matiere */
	public static void saveMatiere(Matiere matiere, String id, Context context)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		editor.putFloat(id, matiere.coef);
		editor.putString(id, matiere.matiere);
		
		Sauvegarde.saveListFloat(id, matiere.notes, context);
		
		editor.commit();
	}
	
	
	
	
	

	
	/** Recuperes une List de tableau de Float enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static List<Float[]> loadListFloat(String id, Context context)
	{
		List<Float[]> list = new ArrayList<Float[]>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		Float[] floate = new Float[2];
		int maxStr = preferences.getInt("f1_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			floate[0] = preferences.getFloat(id + i + "1", 0);
			floate[0] = preferences.getFloat(id + i + "2", 0);
			list.add(floate);
		}

		return list;
	}
	
	
	/** Enregistres une List de tableau de Float dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveListFloat(String id, List<Float[]> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		

		int size = list.size();
		editor.putInt("f1_" + id, size);
	
		for(int i = 0; i < size; i++)
		{
			editor.putFloat(id + i + "1", list.get(i)[0]);
			editor.putFloat(id + i + "2", list.get(i)[1]);
		}
		
		editor.commit();
	}
	
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void addFloatsToList(String id, Float[] floate, Activity activity)
	{
		List<Float[]> list = Sauvegarde.loadListFloat(id, activity);
		list.add(floate);
		Sauvegarde.saveListFloat(id, list, activity);
	}
	
	
	/** Ajoutes un Float à la liste sauvegardé */
	public static void removeFloatFromList(String id, Float[] floatRemoved, Activity activity)
	{
		List<Float[]> list = Sauvegarde.loadListFloat(id, activity);
		list.remove(floatRemoved);
		Sauvegarde.saveListFloat(id, list, activity);
	}

	
	
	
	
	/** Recuperes une String enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static List<Integer> loadListInt(String id, Context context)
	{
		List<Integer> list = new ArrayList<Integer>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("int_" + id, Color.WHITE);

		for(int i = 0; i < maxStr; i++)
		{
			list.add(preferences.getInt(id + i, 0));
		}

		return list;
	}
	
	/** Enregistres une liste d'Integer dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveListInt(String id, List<Integer> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		int size = list.size();
		editor.putInt("int_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			editor.putInt(id + i, list.get(i));
		}
		
		editor.commit();
	}
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void addIntegerToList(String id, Integer integer, Context c)
	{		
		List<Integer> list = Sauvegarde.loadListInt(id, c);
		list.add(integer);
		Sauvegarde.saveListInt(id, list, c);
	}
	
	
	/** Supprime un Integer à la liste sauvegardé */
	public static void removeIntegerFromList(String id, int intremoved, Context context)
	{
		List<Integer> list = Sauvegarde.loadListInt(id, context);
		list.remove(intremoved);
		Sauvegarde.saveListInt(id, list, context);
	}

	
	
	
	
	
	
	
	
	/** Recuperes une String enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static List<String> loadListString(String id, Context context)
	{
		List<String> list = new ArrayList<String>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("str_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			list.add(preferences.getString(id + i, ""));
		}

		return list;
	}
	
	/** Enregistres une String dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveListString(String id, List<String> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		int size = list.size();
		editor.putInt("str_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			editor.putString(id + i, list.get(i));
		}
		
		editor.commit();
	}
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void addStringToList(String id, String str, Context c)
	{		
		List<String> list = Sauvegarde.loadListString(id, c);
		list.add(str);
		Sauvegarde.saveListString(id, list, c);
	}
	
	
	/** Supprime une string à la liste sauvegardé */
	public static void removeStringFromList(String id, String strRemoved, Context context)
	{
		List<String> list = Sauvegarde.loadListString(id, context);
		list.remove(strRemoved);
		Sauvegarde.saveListString(id, list, context);
	}
	
	/** Supprimes la string du rang ID de la liste */
	public static void removeStringFromListById(String string, int id, Context context) 
	{
		List<String> list = Sauvegarde.loadListString(string, context);
		list.remove(id);
		Sauvegarde.saveListString(string, list, context);
	}
	
	

	
	
	/** Enregistres une String dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveString(String id, String stringSaved, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putString(id, stringSaved);
		editor.commit();	
	}
	
	
	/** Recuperes une String enregistré dans les SharedPreferences (mémoire morte du téléphone)
	 *  Args: ID de la String, String en cas d'erreur de chargement (not found), activity actuelle
	 **/
	public static String loadString(String id, String errorString, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		return preferences.getString(id, errorString);
	}

	
	
	
	
	/** Enregistres une Integer dans les SharedPreferences (mémoire morte du téléphone) */
	public static void saveInt(String id, int intSaved, Context context)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putInt(id, intSaved);
		editor.commit();	
	}
	
	
	/** Recuperes une Integer enregistré dans les SharedPreferences (mémoire morte du téléphone) */
	public static int loadInt(String id, int errorInt, Context context)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
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
