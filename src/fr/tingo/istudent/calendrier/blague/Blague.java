package fr.tingo.istudent.calendrier.blague;

import java.util.Random;

import android.app.Activity;
import fr.tingo.istudent.R;


/** Class utilis� pour les questions, renvoies la question et la r�ponse, c'est pratique */
public class Blague
{

	
	// Tableau contenant toutes les questions
	public static final Blague QUESTION[] = {
		
		new Blague(EnumBlague.Question, "Messieur et Madame CULASEC ont un fils, comment s'appelle t'il?", "Jean"),
		new Blague(EnumBlague.Question, "Quelle est la diff�rence entre l'abominable homme des neiges et l'abominable femme des neiges ?", "Une abominable paire de couilles"),
		new Blague(EnumBlague.Question, "Monsieur et madame ERGEBELLE ont un fils comment s'appelle t'il ?", "Octave"),
		new Blague(EnumBlague.Question, "Quelle est la diff�rence entre un roi et un taureau ?", "Le taureau rentre entierement dans l'ar�ne."),
		new Blague(EnumBlague.Question, "Qu'est-ce qu'une soir�e entre hiboux", "C'est ultra chouette!"),
		new Blague(EnumBlague.Question,"Quel est le point commun entre un professeur qui part � la retraite et un tampax ?", " Ils sortent tous les deux du corps enseignant ..."),
		new Blague(EnumBlague.Question,"Qu'est ce qui est bleu, blanc et rouge?", "Un schtroumpf qui saigne du nez !"),
		new Blague(EnumBlague.Question, "Pourquoi les schtroumpfs sont-ils bleus ?", "Car leur culotte est trop serr�e !"),
		new Blague(EnumBlague.Question, "Qui est le fr�re de Albert Einstein ?", "Franck"),
		new Blague(EnumBlague.Question, "Vous connaissez la blague de la chaise?", "Dommage, elle est pliante!"),
		new Blague(EnumBlague.Question, "Deux fous marchent dans la rue. L'un des deux prends une crotte de chien dans ses mains et dis � l'autre: \n \n - Regarde un peu dans quoi j'allais marcher!", ""),
		new Blague(EnumBlague.Histoire, "Au pays des aveugles, les borgnes sont mals vus", ""),
		new Blague(EnumBlague.Question,"Comment appelle-t-on un chat tomb� dans un pot de peinture le jour de No�l ?", "Un chat-peint de No�l"),
		new Blague(EnumBlague.Histoire,"Deux poules discutent: \n \n - Comment vas-tu ma cocotte? \n \n - Pas tr�s bien. Je crois que je couve quelque chose ! ", ""),
		new Blague(EnumBlague.Histoire,"Melon et Mel�che sont � la p�che. Melon p�che la truite et Mel�che la raie.", ""),
		new Blague(EnumBlague.Question, "Tu connais l'histoire de la feuille de papier ?", " - Elle d�chire !"),
		new Blague(EnumBlague.Question, "Pourquoi les Belges enl�vent-ils leurs lunettes lorsqu'ils sont soumis � un �thylotest ?", "Ca fait toujours deux verres en moins."),
		new Blague(EnumBlague.Question, "Pourquoi les Belges se prom�nent avec un sceau d'eau ?", "Pour payer en liquide."),
		new Blague(EnumBlague.Question, "Pourquoi les belges vont-ils aux toilettes avec du pain ?", " Pour nourrir le canard WC."),
		new Blague(EnumBlague.Question, "Pourquoi les belges nagent-ils toujours au milieu de la piscine ?", " Parce qu'ils sont un peu cons sur les bords."),
		new Blague(EnumBlague.Question, "Pourquoi les belges vont-ils aux toilettes avec un fusil ?", "Pour tirer la chasse."),
		new Blague(EnumBlague.Question, "Qu'est-ce qu'un homme intelligent en Belgique ?", "Un touriste."),
		new Blague(EnumBlague.Question, "Que fait un p�re belge qui vient d'avoir des jumeaux ?", " Il cherche le p�re de l'autre pour le f�liciter..."),
		new Blague(EnumBlague.Contrepetrie, "Le doigt dans le trou du f�t, la main entre les Caisses. \n\nLe doigt dans le trou du cul, la main entre les fesses.", ""),
		new Blague(EnumBlague.Contrepetrie, "Pr�sente �l�ctions, \nPlaisantes �r�ctions", ""),
		new Blague(EnumBlague.Contrepetrie, "A la boutique des Milles Bottes, on solde des tennis de pro \n \nA la boutique des belles mottes, on solde des p�nis de trop.", ""),
		new Blague(EnumBlague.Contrepetrie, "Ad�la�de rue de La Paix. \n \nAd�la�de pue de la raie.", "")
		
	};
	
	
	
	
	private Activity activity;
	private String question;
	private String reponse;
	private EnumBlague categorie;
	
	public Blague(Activity pActivity, Random rand)
	{
		this.activity = pActivity;
		int alea = rand.nextInt(Blague.QUESTION.length);
		this.question = QUESTION[alea].getQuestion();
		this.reponse = QUESTION[alea].getReponse();
		this.categorie = QUESTION[alea].getCategorie();
	}
	


	public Blague(EnumBlague pCategorie, String pQuestion, String pReponse)
	{
		this.question = pQuestion;
		this.categorie = pCategorie;
		this.reponse = pReponse;
	}
	
	public String getQuestion()
	{
		return this.question;
	}
	
	public String getReponse()
	{
		return this.reponse;
	}
	
	public String alaligne()
	{
		return "\n \n";
	}
	
	private EnumBlague getCategorie() {

		return this.categorie;
	}
	
	public String getTextWithReponse()
	{
		if(this.isQuestion()) // S'il s'agit d'une question
		{
			return this.activity.getText(R.string.question) + this.alaligne() + this.question +
					alaligne() + this.activity.getText(R.string.reponse) + this.reponse;
		}
		else if(this.isHistoire())// S'il s'agit d'une histoire
		{
			return this.activity.getText(R.string.histoire) + this.alaligne() + this.question;
		}
		else if(this.isContrepetrie()) // S'il s'agit d'une contrepetrie
		{
			return this.activity.getText(R.string.contrepetrie) + this.alaligne() + this.question;
		}
		
		return "Arf... Une erreur est survenu";
	}
	
	public String getTextWithoutReponse()
	{
		if(this.isQuestion()) // S'il s'agit d'une question
		{
			return this.activity.getText(R.string.question) + this.alaligne() + this.question +
					alaligne() + this.activity.getText(R.string.reponse) + "...";
		}
		else
		{
			return this.getTextWithReponse();
		}
	}
	
	public boolean isQuestion()
	{
		return this.categorie == EnumBlague.Question;
	}
	
	public boolean isContrepetrie()
	{
		return this.categorie == EnumBlague.Contrepetrie;
	}
	
	public boolean isHistoire()
	{
		return this.categorie == EnumBlague.Histoire;
	}
}
