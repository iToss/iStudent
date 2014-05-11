/** L'int�gralit� de ce code � �t� cr�e par:
 * 
 * @author Romain PEREIRA
 * 
 * En esperant que son contenu vous sera utile. Vous pouvez cr�e une date � part du jour, mois et ann�e. (ex: 1/1/2000) 
 * Vous pourrez ensuite recuperer tout un tas d'info sur cette date.
 */


package fr.tingo.istudent.util;

import java.util.Calendar;

import android.app.Activity;


public class Date {
	
	private int jour;
	private int mois;
	private int annee;
	
	private String id; // Id d'un date unique
	
	private String jourString;
	private String moisString;
	
	private int idJour;

	

	/** Constructeurs, on recupere sous la forme: "27/01/1996" */
	public Date(int pJour, int pMois, int pAnnee)
	{
		this.setDate(pJour, pMois, pAnnee);
	}

	
	
	
	/** M�thode appel�e lors de la cr�ation / modification de la date, on red�finit toutes les variables. */
	private void setDate(int pJour, int pMois, int pAnnee) 
	{
		this.jour = pJour;
		this.mois = pMois;
		annee = pAnnee; //Pas de this car la variable est static
		this.setMoisString(this.getMoisString(pMois));
		this.id = "" + this.annee + 10000 * this.mois + 1000000 * this.jour; // l'id est de la forme: 27011996 pour le 27 Janvier 1996
		this.jourString = Date.getDayNameAt(this.jour, this.mois, this.annee);
	}
	

	/** R�cuperer le nom d'un jour � partir de son num�ro dans la semaine */
	private String getDayString() 
	{
		return this.jourString;
	}


	/** Retourne true si l'ann�e est bissextile, false si non */
	public boolean isBissextile()
	{
		return ((int) this.annee / 4 == (float) annee / 4);
	}
	
	/** R�cuperer le nom du mois � partir de son ID */
	public String getMoisString(int pMois)
	{		
		String month = "";
		switch(pMois)
		{
			case 1: month = "Janvier";
			break;
				
			case 2: month = "Fevrier";
			break;
	
			case 3: month = "Mars";
			break;
	
			case 4: month = "Avril";
			break;
	
			case 5: month = "Mai";
			break;
	
			case 6: month = "Juin";
			break;
	
			case 7: month = "Juillet";
			break;
	
			case 8: month = "Aout";
			break;
	
			case 9: month = "Septembre";
			break;
	
			case 10: month = "Octobre";
			break;
	
			case 11: month = "Novembre";
			break;
	
			case 12: month = "Decembre";
			break;
		}
			
		return month;

	}
	
	/** Passez au jour suivant */
	public void nextDay()
	{	
		this.jour++;
		
		if(this.idJour == 6) // Id du jour de la semaine, on passe de DIMANCHE � LUNDI
		{
			this.idJour = 0;
		}
		else
		{
			this.idJour++;
		}

		if(this.mois == 12 && this.jour > 31) // Si on est le 31 d�cembre, on passe au 1er janvier de l'ann�e suivante
		{
			this.annee++;
			this.mois = 1;
			this.jour = 1;
		}
				
		if(this.jour > this.getDayInMonth(this.mois)) // Si le nombre de jour d�passe le nombre de jours du mois, on passe au mois suivant
		{
			this.jour = 1;
			this.mois++;
		}
		
		this.setDate(this.jour, this.mois, this.annee);	
	}
	
	/** Passez au jour pr�c�dent */
	public void previousDay()
	{	
		this.jour--;
		
		if(this.idJour == 0) // Id du jour de la semaine, on passe de LUNDI � DIMANCHE
		{
			this.idJour = 6;
		}
		else
		{
			this.idJour--;
		}

		if(this.mois == 1 && this.jour == 0) // Si on est le 1er janvier, on passe � l'ann�e pr�c�dentes au 31 d�cembre
		{
			this.annee--;
			this.mois = 12;
			this.jour = 31;
		}
				
		if(this.jour == 0) // On passe au mois pr�c�dent
		{
			this.mois--;
			this.jour = this.getDayInMonth(mois);
		}
		
		this.setDate(this.jour, this.mois, this.annee);	
	}
	
	
	/** Avancer de X jour */
	public void nextDays(int amount)
	{
		for(int i = 0; i < amount; i++)
		{
			this.nextDay();
		}
	}
	
	
	/** Reculer de X jour */
	public void previousDays(int amount)
	{
		for(int i = 0; i < amount; i++)
		{
			this.previousDay();
		}
	}
	
	
	/** Passer � la semaine suivante */
	public void nextWeek()
	{
		for(int i = 0; i < 7; i++)
		{
			this.nextDay();
		}
	}
	
	
	/** Passer � la semaine pr�c�dente */
	public void previousWeek()
	{
		for(int i = 0; i < 7; i++)
		{
			this.previousDay();
		}
	}

	

	/** R�cuperer le nombre de jour dans un mois
	 *  Args: ID du mois (ex: Janvier : 1)
	 *  */
	public int getDayInMonth(int month)
	{		
		if(month == 1 || // Si on est dans un mois � 31 jours
				month == 3 ||
					month == 5 ||
						month == 7 ||
							month == 8 ||
								month == 10 ||
									month == 12
									)
		{
			return 31;
		}
		
		else if(month == 4 || // Si on est dans un mois � 30 jours
					month == 6 ||
						month == 9 ||
							month == 11
								)
		{
			return 30;
		}
		else if(month == 2) // si on est en f�vrier
		{
			if(this.isBissextile()) // si c'est une ann�e bissextile
			{
				return 29;
			}
			else // si ce n'est pas bissextile
			{
				return 28;
			}
		}
		else // si ce n'est rien de tout ca, on retourne 31 (ex: si l'id est egale � -1, 13, 14 etc...)
		{
			return 31;
		}
	}
	

	/** R�cuperer l'id unique � la date */
	public String getId()
	{
		return this.id;
	}
	
	/** R�cuperer le nombre de jour dans un mois */
	public int getDay()
	{
		return this.jour;
	}

	/** R�cuperer l'id du mois */
	public int getMois()
	{
		return this.mois;
	}
	
	/** R�cuperer l'ann�e*/
	public int getAnnee()
	{
		return this.annee;
	}

	/** Retourne la date sous forme �crite */
	public String getDate() 
	{
		return this.getDayString() + " " + this.getDay() + " " + this.getMoisString(this.mois) + " " + this.annee;
	}
	
	/** Retourne la date sous forme �crite */
	public String getSpaceDate() 
	{
		return this.getDayString() + " " + this.getDay() + " \n" + this.getMoisString(this.mois) + " " + this.annee;
	}

	/** Recuperer le nom du jour de la semaine ("Lundi", "Mardi", "Mercredi" ...) */
	public String getDayToString() 
	{
		return jourString;
	}

	public int getDayOfTheWeek()
	{
		String day = this.getDayToString();
		
		if(day.equals("Lundi"))
		{
			return 1;
		}
		else if(day.equals("Mardi"))
		{
			return 2;
		}
		else if(day.equals("Mercredi"))
		{
			return 3;
		}
		else if(day.equals("Jeudi"))
		{
			return 4;
		}
		else if(day.equals("Vendredi"))
		{
			return 5;
		}
		else if(day.equals("Samedi"))
		{
			return 6;
		}
		else
		{
			return 7;
		}
	}

	
	/** Renvoies TRUE si la date correspond � un Lundi */
	public boolean isLundi() 
	{ 
		if(this.idJour == 0)
		{
			return true;
		}
		return false;
	}

	/** Renvoies TRUE si la date correspond � un Mardi */
	public boolean isMardi() 
	{ 
		if(this.idJour == 1)
		{
			return true;
		}
		return false;
	}
	
	/** Renvoies TRUE si la date correspond � un Mercredi */
	public boolean isMercredi() 
	{ 
		if(this.idJour == 2)
		{
			return true;
		}
		return false;
	}
	
	/** Renvoies TRUE si la date correspond � un Jeudi */
	public boolean isJeudi() 
	{ 
		if(this.idJour == 3)
		{
			return true;
		}
		return false;
	}
	
	/** Renvoies TRUE si la date correspond � un Vendredi */
	public boolean isVendredi() 
	{ 
		if(this.idJour == 4)
		{
			return true;
		}
		return false;
	}
	
	/** Renvoies TRUE si la date correspond � un Samedi */
	public boolean isSamedi() 
	{ 
		if(this.idJour == 5)
		{
			return true;
		}
		return false;
	}

	/** Renvoies TRUE si la date correspond � un Dimanche */
	public boolean isDimanche() 
	{ 
		if(this.idJour == 6)
		{
			return true;
		}
		return false;
	}
	
	/** M�thodes de Zeller arang� pour r�cuperer le nom du jour d'une date.
	 * EX: 01/01/2014
	 * @param day: 1
	 * @param month : 1
	 * @param Y = 2014;
	 * @return
	 * Algorythme arang� par PEREIRA Romain.
	 */
	public static String getDayNameAt(int day, int month, int Y)
	{
		String[] jours = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
		int monthZeller = (month + 10) % 12; //L'algorythme de Zeller utilise un Calendrier qui commence en Mars

		
		if(monthZeller == 11 || monthZeller == 12) // Si on est en Janvier ou Fevrier sous le mois de zeller, on a donc une ann�e de retard
		{
			Y--;
		}
		
		
		int C = Y / 100;
		int D = Y - C * 100;
		
		return jours[Date.zellerCongruence(day, monthZeller, C, D)];
	}
	
	/** Formule de Zeller */
	public static int zellerCongruence(int day, int month, int C, int D)
	{
		int idDay = (day + ((13 * month - 1) / 5) + D + (D/4) + (C/4) + 5 * C) % 7; // On n'additionne que des positifs, donc gr�ce au % 7, on retournera toujours un nombre < 7 et > 0
		return idDay;
	}

	/** Recuperes le nombre total de jour dans le mois de la date */
	public int getTotalDayInMonth()
	{
		return this.getDayInMonth(this.mois);
	}



	public void setMoisString(String pMois) 
	{
		this.moisString = pMois;
	}



	/** Retournes un diminutif du jour
	 * @return Lundi: Lun, Mardi: Mard */
	public CharSequence getDayDiminutif() 
	{
		return this.getDayToString().subSequence(0, 3);
	}



	/** Retournes le mois et l'ann�e sous forme d'une seul String */
	public CharSequence getMoisEtAnnee() 
	{
		return this.moisString + " " + this.annee;
	}



	/** Passer au mois suivant */
	public void nextMonth() 
	{
		if(this.mois != 12)
		{
			this.mois++;
		}
		else
		{
			this.mois = 1;
			this.annee++;
		}
		
		this.moisString = this.getMoisString(this.mois);
	}



	/** Passer au mois pr�c�dent */
	public void previousMonth() 
	{
		if(this.mois == 1) //Si on est en janvier
		{
			this.mois = 12;
			this.annee--;
		}
		else
		{
			this.mois--;
		}
		
		this.moisString = this.getMoisString(this.mois);		
	}
	
	/** Retournes les devoirs de cette date */
	public String getDevoir(Activity activity)
	{
		return Sauvegarde.loadString(this.getId(), Sauvegarde.DEFAULT_DEVOIRS, activity);
	}
	
	
	/** Retournes la date d'aujourd'hui. 
	 *  M�thode static:
	 *  @return Date date = Date.getTodayDate();*/
	public static Date getTodayDate()
	{
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH); // On recupere le jour du mois
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1; //On recupere le numero du mois (de 0 � 11, d'ou le + 1)
		int year = Calendar.getInstance().get(Calendar.YEAR); // On recupere l'ann�e
		
		return new Date(day, month, year);
	}

	
	
	/** Passes � l'ann�e suivante */
	public void nextYear() 
	{
		this.annee++;
	}
	
	/** Passes � l'ann�e pr�c�dente */
	public void previousYear() 
	{
		this.annee--;
	}
	
	
}	
