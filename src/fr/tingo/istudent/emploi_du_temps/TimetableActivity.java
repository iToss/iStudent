package fr.tingo.istudent.emploi_du_temps;

import java.util.Calendar;

import android.os.Bundle;
import fr.tingo.istudent.iStudentActivity;

public class TimetableActivity extends iStudentActivity {
	
	@Override
	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		
		int jour =  (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 5) % 6; //Retournes l'id du jour (0 pour Dimanche, 1 pour Lundi, 2 pour Mardi etc...)
		this.setContentView(new TimetableLayout(this, jour));
	}

}
