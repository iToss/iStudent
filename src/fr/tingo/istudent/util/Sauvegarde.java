package fr.tingo.istudent.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import fr.tingo.istudent.eleve.Matiere;

<<<<<<< HEAD
public class Sauvegarde
{
  public static final String DEFAULT_DEVOIRS = "";
=======
public class Sauvegarde {
	
	public static final String DEFAULT_DEVOIRS = ""; // Le texte par defaut des devoirs

	
	
	
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
		
		Matiere matiere = new Matiere(p.getString(id, ""), p.getFloat(id, 0));
		matiere.notes = Sauvegarde.loadListFloat(id, context);
		
		return new Matiere(p.getString(id, ""), p.getFloat(id, 0));
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
	public static List<String> loadListString(String id, Context context)
	{
		List<String> list = new ArrayList<String>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("int_" + id, 0);

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
		editor.putInt("int_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			editor.putString(id + i, list.get(i));
		}
		
		editor.commit();
	}
	
	/** Ajoutes une string à la liste sauvegardé */
	public static void addStringToList(String id, String str, Activity activity)
	{
		List<String> list = Sauvegarde.loadListString(id, activity);
		list.add(str);
		Sauvegarde.saveListString(id, list, activity);
	}
	
	
	/** Supprime une string à la liste sauvegardé */
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
	
	
	
	
>>>>>>> 23d807182476563cc71813bc9b64abd23f8c40fb

  public static void addFloatsToList(String paramString, Float[] paramArrayOfFloat, Activity paramActivity)
  {
    List<Float[]> localList = loadListFloat(paramString, paramActivity);
    localList.add(paramArrayOfFloat);
    saveListFloat(paramString, localList, paramActivity);
  }

  public static void addIntegerToList(String paramString, Integer paramInteger, Activity paramActivity)
  {
    List<Integer> localList = loadListInt(paramString, paramActivity);
    localList.add(paramInteger);
    saveListInt(paramString, localList, paramActivity);
  }

  public static void addMatiereToList(String paramString, Matiere paramMatiere, Activity paramActivity)
  {
    List<Matiere> localList = loadListMatiere(paramString, paramActivity);
    localList.add(paramMatiere);
    saveListMatiere(paramString, localList, paramActivity);
  }

  public static void addStringToList(String paramString1, String paramString2, Context paramContext)
  {
    List<String> localList = loadListString(paramString1, paramContext);
    localList.add(paramString2);
    saveListString(paramString1, localList, paramContext);
  }

  public static float loadFloat(String paramString, float paramFloat, Activity paramActivity)
  {
    PreferenceManager.getDefaultSharedPreferences(paramActivity);
    return PreferenceManager.getDefaultSharedPreferences(paramActivity).getFloat(paramString, paramFloat);
  }

  public static int loadInt(String paramString, int paramInt, Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, paramInt);
  }

  public static List<Float[]> loadListFloat(String paramString, Context paramContext)
  {
    ArrayList<Float[]> localArrayList = new ArrayList<Float[]>();
    PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    Float[] arrayOfFloat = new Float[2];
    int i = localSharedPreferences.getInt("f1_" + paramString, 0);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localArrayList;
      arrayOfFloat[0] = Float.valueOf(localSharedPreferences.getFloat(paramString + j + "1", 0.0F));
      arrayOfFloat[0] = Float.valueOf(localSharedPreferences.getFloat(paramString + j + "2", 0.0F));
      localArrayList.add(arrayOfFloat);
    }
  }

  public static List<Integer> loadListInt(String paramString, Context paramContext)
  {
    ArrayList<Integer> localArrayList = new ArrayList<Integer>();
    PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    int i = localSharedPreferences.getInt("int_" + paramString, 0);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localArrayList;
      localArrayList.add(Integer.valueOf(localSharedPreferences.getInt(paramString + j, 0)));
    }
  }

  public static List<Matiere> loadListMatiere(String paramString, Context paramContext)
  {
    ArrayList<Matiere> localArrayList = new ArrayList<Matiere>();
    PreferenceManager.getDefaultSharedPreferences(paramContext);
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("size_" + paramString, 0);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localArrayList;
      localArrayList.add(loadMatiere(paramString, paramContext));
    }
  }

  public static List<String> loadListString(String paramString, Context paramContext)
  {
    ArrayList<String> localArrayList = new ArrayList<String>();
    PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    int i = localSharedPreferences.getInt("str_" + paramString, 0);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localArrayList;
      localArrayList.add(localSharedPreferences.getString(paramString + j, ""));
    }
  }

  public static Matiere loadMatiere(String paramString, Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    Matiere localMatiere = new Matiere(paramContext, localSharedPreferences.getString(paramString + "_mat", ""), localSharedPreferences.getFloat(paramString + "_coef", 0.0F));
    localMatiere.notes = loadListFloat(paramString + "_floats", paramContext);
    return localMatiere;
  }

  public static String loadString(String paramString1, String paramString2, Activity paramActivity)
  {
    PreferenceManager.getDefaultSharedPreferences(paramActivity);
    return PreferenceManager.getDefaultSharedPreferences(paramActivity).getString(paramString1, paramString2);
  }

  public static void removeFloatFromList(String paramString, Float[] paramArrayOfFloat, Activity paramActivity)
  {
    List<Float[]> localList = loadListFloat(paramString, paramActivity);
    localList.remove(paramArrayOfFloat);
    saveListFloat(paramString, localList, paramActivity);
  }

  public static void removeIntegerFromList(String paramString, Integer paramInteger, Activity paramActivity)
  {
    List<Integer> localList = loadListInt(paramString, paramActivity);
    localList.remove(paramInteger);
    saveListInt(paramString, localList, paramActivity);
  }

  public static void removeMatiereFromList(String paramString, Matiere paramMatiere, Activity paramActivity)
  {
    List<Matiere> localList = loadListMatiere(paramString, paramActivity);
    localList.remove(paramMatiere);
    saveListMatiere(paramString, localList, paramActivity);
  }

  public static void removeStringFromList(String paramString1, String paramString2, Context paramContext)
  {
    List<String> localList = loadListString(paramString1, paramContext);
    localList.remove(paramString2);
    saveListString(paramString1, localList, paramContext);
  }

  public static void removeStringFromListById(String paramString, int paramInt, Context paramContext)
  {
    List<String> localList = loadListString(paramString, paramContext);
    localList.remove(paramInt);
    saveListString(paramString, localList, paramContext);
  }

  public static void saveFloat(String paramString, float paramFloat, Activity paramActivity)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity).edit();
    localEditor.putFloat(paramString, paramFloat);
    localEditor.commit();
  }

  public static void saveInt(String paramString, int paramInt, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }

  public static void saveListFloat(String paramString, List<Float[]> paramList, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    int i = paramList.size();
    localEditor.putInt("f1_" + paramString, i);
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localEditor.commit();
        return;
      }
      localEditor.putFloat(paramString + j + "1", ((Float[])paramList.get(j))[0].floatValue());
      localEditor.putFloat(paramString + j + "2", ((Float[])paramList.get(j))[1].floatValue());
    }
  }

  public static void saveListInt(String paramString, List<Integer> paramList, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    int i = paramList.size();
    localEditor.putInt("int_" + paramString, i);
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localEditor.commit();
        return;
      }
      localEditor.putInt(paramString + j, ((Integer)paramList.get(j)).intValue());
    }
  }

  public static void saveListMatiere(String paramString, List<Matiere> paramList, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    int i = paramList.size();
    localEditor.putInt("size_" + paramString, i);
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localEditor.commit();
        return;
      }
      saveMatiere((Matiere)paramList.get(j), paramString + j, paramContext);
    }
  }

  public static void saveListString(String paramString, List<String> paramList, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    int i = paramList.size();
    localEditor.putInt("str_" + paramString, i);
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localEditor.commit();
        return;
      }
      localEditor.putString(paramString + j, (String)paramList.get(j));
    }
  }

  public static void saveMatiere(Matiere paramMatiere, String paramString, Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putFloat(paramString + "coef", paramMatiere.coef);
    localEditor.putString(paramString + "_mat", paramMatiere.matiere);
    saveListFloat(paramString + "_floats", paramMatiere.notes, paramContext);
    localEditor.commit();
  }

  public static void saveString(String paramString1, String paramString2, Activity paramActivity)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramActivity).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
}

/* Location:           C:\Users\Romain\Desktop\demofolder\classes_dex2jar.jar
 * Qualified Name:     fr.tingo.istudent.Sauvegarde
 * JD-Core Version:    0.6.0
 */
