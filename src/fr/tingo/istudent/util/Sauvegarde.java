package fr.tingo.istudent.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import fr.tingo.istudent.eleve.Matiere;

public class Sauvegarde
{
  public static final String DEFAULT_DEVOIRS = "";

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