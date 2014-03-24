package fr.tingo.istudent.calendrier.blague;

import java.util.Random;

import android.app.Activity;
import fr.tingo.istudent.R;


/** Class utilisé pour les questions, renvoies la question et la réponse, c'est pratique */
public class Blague
{

	
	// Tableau contenant toutes les questions
	public static final Blague QUESTION[] = {
		
		new Blague(EnumBlague.Question, "Messieur et Madame CULASEC ont un fils, comment s'appelle t'il?", "Jean"),
		new Blague(EnumBlague.Question, "Quelle est la différence entre l'abominable homme des neiges et l'abominable femme des neiges ?", "Une abominable paire de couilles"),
		new Blague(EnumBlague.Question, "Monsieur et madame ERGEBELLE ont un fils comment s'appelle t'il ?", "Octave"),
		new Blague(EnumBlague.Question, "Quelle est la différence entre un roi et un taureau ?", "Le taureau rentre entierement dans l'arène."),
		new Blague(EnumBlague.Question, "Qu'est-ce qu'une soirée entre hiboux", "C'est ultra chouette!"),
		new Blague(EnumBlague.Question,"Quel est le point commun entre un professeur qui part à la retraite et un tampax ?", " Ils sortent tous les deux du corps enseignant ..."),
		new Blague(EnumBlague.Question,"Qu'est ce qui est bleu, blanc et rouge?", "Un schtroumpf qui saigne du nez !"),
		new Blague(EnumBlague.Question, "Pourquoi les schtroumpfs sont-ils bleus ?", "Car leur culotte est trop serrée !"),
		new Blague(EnumBlague.Question, "Qui est le frère de Albert Einstein ?", "Franck"),
		new Blague(EnumBlague.Question, "Vous connaissez la blague de la chaise?", "Dommage, elle est pliante!"),
		new Blague(EnumBlague.Question, "Deux fous marchent dans la rue. L'un des deux prends une crotte de chien dans ses mains et dis à l'autre: \n \n - Regarde un peu dans quoi j'allais marcher!", ""),
		new Blague(EnumBlague.Histoire, "Au pays des aveugles, les borgnes sont mals vus", ""),
		new Blague(EnumBlague.Question,"Comment appelle-t-on un chat tombé dans un pot de peinture le jour de Noël ?", "Un chat-peint de Noël"),
		new Blague(EnumBlague.Histoire,"Deux poules discutent: \n \n - Comment vas-tu ma cocotte? \n \n - Pas très bien. Je crois que je couve quelque chose ! ", ""),
		new Blague(EnumBlague.Histoire,"Melon et Melèche sont à la pèche. Melon pèche la truite et Melèche la raie.", ""),
		new Blague(EnumBlague.Question, "Tu connais l'histoire de la feuille de papier ?", " - Elle déchire !"),
		new Blague(EnumBlague.Question, "Pourquoi les Belges enlèvent-ils leurs lunettes lorsqu'ils sont soumis à un éthylotest ?", "Ca fait toujours deux verres en moins."),
		new Blague(EnumBlague.Question, "Pourquoi les Belges se promènent avec un sceau d'eau ?", "Pour payer en liquide."),
		new Blague(EnumBlague.Question, "Pourquoi les belges vont-ils aux toilettes avec du pain ?", " Pour nourrir le canard WC."),
		new Blague(EnumBlague.Question, "Pourquoi les belges nagent-ils toujours au milieu de la piscine ?", " Parce qu'ils sont un peu cons sur les bords."),
		new Blague(EnumBlague.Question, "Pourquoi les belges vont-ils aux toilettes avec un fusil ?", "Pour tirer la chasse."),
		new Blague(EnumBlague.Question, "Qu'est-ce qu'un homme intelligent en Belgique ?", "Un touriste."),
		new Blague(EnumBlague.Question, "Que fait un père belge qui vient d'avoir des jumeaux ?", " Il cherche le père de l'autre pour le féliciter..."),
		new Blague(EnumBlague.Contrepetrie, "Le doigt dans le trou du fût, la main entre les Caisses. \n\nLe doigt dans le trou du cul, la main entre les fesses.", ""),
		new Blague(EnumBlague.Contrepetrie, "Présente éléctions, \nPlaisantes éréctions", ""),
		new Blague(EnumBlague.Contrepetrie, "A la boutique des Milles Bottes, on solde des tennis de pro \n \nA la boutique des belles mottes, on solde des pénis de trop.", ""),
		new Blague(EnumBlague.Contrepetrie, "Adélaïde rue de La Paix. \n \nAdélaïde pue de la raie.", "")
		
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
