package fr.tingo.istudent.emploi_du_temps;

import android.os.Bundle;
import fr.tingo.istudent.iStudentActivity;

public class TimetableActivity extends iStudentActivity {
	
	@Override
	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		
		this.setContentView(new TimetableLayout(this));
	}

}
