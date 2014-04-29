package fr.tingo.istudent.eleve;

import java.util.List;

import android.content.Context;
import fr.tingo.istudent.util.Sauvegarde;

public class Matiere
{
  public float coef;
  public String id;
  public String matiere;
  public List<Float[]> notes;

  public Matiere(Context paramContext, String paramString, float paramFloat)
  {
    this.id = (paramString + "_id");
    this.coef = paramFloat;
    this.matiere = paramString;
    this.notes = Sauvegarde.loadListFloat(this.id, paramContext);
  }

  public void addNote(float paramFloat1, float paramFloat2)
  {
    Float[] arrayOfFloat = new Float[2];
    arrayOfFloat[0] = Float.valueOf(paramFloat1);
    arrayOfFloat[1] = Float.valueOf(paramFloat2);
    this.notes.add(arrayOfFloat);
  }

  public float getMoyenne()
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    for (int i = 0; ; i++)
    {
      if (i >= this.notes.size())
        return f1 / f2;
      f1 += ((Float[])this.notes.get(i))[0].floatValue() * ((Float[])this.notes.get(i))[1].floatValue();
      f2 += ((Float[])this.notes.get(i))[1].floatValue();
    }
  }

  public void removeNote(float paramFloat1, float paramFloat2)
  {
    Float[] arrayOfFloat = new Float[2];
    arrayOfFloat[0] = Float.valueOf(paramFloat1);
    arrayOfFloat[1] = Float.valueOf(paramFloat2);
    this.notes.remove(arrayOfFloat);
  }
}

/* Location:           C:\Users\Romain\Desktop\demofolder\classes_dex2jar.jar
 * Qualified Name:     fr.tingo.istudent.eleve.Matiere
 * JD-Core Version:    0.6.0
 */