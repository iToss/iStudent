package fr.tingo.istudent.calendrier.blague;

import java.util.Random;


public class Citation {
	

	//Tableau de String contenant pleins d'informations
	public static final Citation CITATION[] = 
	{
		new Citation("Le miracle est, avec la vigne, l'une des principales cultures de la France", "Pierre Daninos"),
		new Citation("Cela semble toujours impossible, jusqu'� ce qu'on le fasse.", "Nelson Mandela"),
		new Citation("J'ai appris que le courage n'est pas l'absence de peur, mais la capacit� de la vaincre.", "Nelson Mandela"),
		new Citation("La politique peut �tre renforc�e par la musique, mais la musique a une puissance qui d�fie la politique.", "Nelson Mandela"),
		new Citation("Les hommes qui prennent de grands risques doivent s'attendre � en supporter souvent les lourdes cons�quences.", "Nelson Mandela"),
		new Citation("Une nation arc-en-ciel, en paix avec elle-m�me et avec le monde.", "Nelson Mandela"),
		new Citation("L'�ducation est votre arme la plus puissante pour changer le monde. ", "Nelson Mandela"),
		new Citation("Un c�ur bon et un bon esprit forment toujours une formidable combinaison. ", "Nelson Mandela"),
		new Citation("L'argent ne cr�era pas le succ�s, c'est la libert� d'en gagner qui le fera.", "Nelson Mandela"),
		new Citation("Des gens courageux ne craignent pas le pardon, au nom de la paix.", "Nelson Mandela"),
		new Citation("Tout homme ou toute institution qui essaieront de me voler ma dignit� perdront.", "Nelson Mandela"),
		new Citation("Il ne peut y avoir plus vive r�v�lation de l'�me d'une soci�t� que la mani�re dont elle traite ses enfants.", "Nelson Mandela"),
		new Citation("Je ne suis pas contre toutes les guerres ; je suis seulement contre les guerres idiotes.", "Barack Obama"),
		new Citation("J'esp�re que Giulia (fille de Nicolas SARKOZY avec Carla BRUNI) a h�rit� du physique de sa m�re plut�t que celui de son p�re. ", "Barack Obama"),
		new Citation("Nous sommes une nation de chr�tiens et de musulmans, de juifs et d'hindous - et d'ath�es.", "Barack Obama"),
		new Citation("S�me un acte, tu r�colteras une habitude ; s�me une habitude, tu r�colteras un caract�re ; s�me un caract�re, tu r�colteras une destin�e.", "Barack Obama"),
		new Citation("L�apaisement r�side en chacun de nous.", "Barack Obama"),
		new Citation("Il n'y a personne qui soit n� sous une mauvaise �toile, il n'y a que des gens qui ne savent pas lire le ciel.", "Barack Obama"),
		new Citation("Si nous devenions violents, nous n'aurions plus rien � d�fendre.", "Dala� Lama"),
		new Citation("On ne peut �tre aimant et compatissant sans contenir ses d�sirs et ses int�r�ts imm�diats.", "Dala� Lama"),
		new Citation("Il n�importe pas qu�un �tre soit croyant ou non : il est plus important qu�il soit bon. ", "Dala� Lama"),
		new Citation("Certains regardent la vase au fond de l'�tang, d'autres contemplent la fleur de lotus � la surface de l'eau, il s'agit d'un choix. ", "Dala� Lama"),
		new Citation("Plus nous aurons donn� de sens � notre vie, moins nous �prouverons de regrets � l'instant de la mort.", "Dala� Lama"),
		new Citation("Le vrai bonheur ne d�pend d'aucun �tre, d'aucun objet ext�rieur. Il ne d�pend que de nous.", "Dala� Lama"),
		new Citation("Nul besoin de temples, nul besoin de philosophies compliqu�es. Notre cerveau et notre coeur sont nos temples.", "Dala� Lama"),
		new Citation("Lorsque nos intentions sont �go�stes, le fait que nos actes puissent para�tre bons ne garantit pas qu'ils soient positifs ou �thiques.", "Dala� Lama"),
		new Citation("Le d�sarmement ext�rieur passe par le d�sarmement int�rieur. Le seul vrai garant de la paix est en soi.", "Dala� Lama"),
		new Citation("Faites constamment aux autres le bien que vous voulez en recevoir.", "Dala� Lama"),
		new Citation("Folie toute l'intelligence sans la conscience profonde de la mort et de l'impertinence.", "Dala� Lama"),
		new Citation("On s'int�resse � ses membres comme parties de son corps, pourquoi pas aux hommes comme parties de l'humanit� ?", "Dala� Lama"),
		new Citation("Les livres sont la lumi�re qui guide la civilisation.", "F.D Roosevelt"),
		new Citation("Faites quelque chose et, si �a ne r�ussit pas, essayez autre chose.", "Dala� Lama"),
		new Citation(" Les caresses n'ont jamais transform� un tigre en chaton.", "F.D Roosevelt"),
		new Citation("Un r�actionnaire est un somnambule qui marche � reculons.", "F.D Roosevelt"),
		new Citation("Soyez sinc�re, soyez bref, restez assis.", "F.D Roosevelt"),
		new Citation("Ne sous-estimez jamais un homme qui se surestime.", "F.D Roosevelt"),
		new Citation("Il est dur d'�chouer ; mais il est pire de n'avoir jamais tent� de r�ussir.", "F.D Roosevelt"),
		new Citation("La seule chose que nous ayons � craindre est la crainte elle-m�me.", "F.D Roosevelt"),
		new Citation("La seule limite � nos r�alisations de demain sera nos doutes d'aujourd'hui.", "F.D Roosevelt"),
		new Citation("No�l n�est pas un jour ni une saison, c�est un �tat d�esprit.", "Calvin Coolidge"),
		new Citation("Les femmes sont extr�mes ; elles sont meilleures ou pires que les hommes. ", "Jean de La Bruy�re"),
		new Citation("Il est plus difficile de bien faire l�amour que de bien faire la guerre.", "Ninon de Lenclos"),
		new Citation("On ne na�t pas femme : on le devient.", "Simone de Beauvoir"),
		new Citation("Le devoir des grands Etats est de servir et non de dominer le monde.", "Harry Truman"),
		new Citation("Gouverner, c'est maintenir les balances de la justice �gales pour tous. ", "F.D Roosevelt"),
		new Citation("Le politicien qui r�ussit le mieux est celui qui dit le plus souvent et de la voix la plus forte ce que tout le monde pense.", "Theodore Roosevelt"),
		new Citation("Si vous ne dites rien, on ne vous demandera pas de le r�p�ter.", "Calvin Coolidge"),
		new Citation("La libert� est une plante qui cro�t vite, une fois qu'elle a pris racine.", "George Washington"),
		new Citation("A chaque g�n�ration, les Am�ricains doivent d�finir ce que veut dire '�tre am�ricain'", "Bill Clinton"),
		new Citation("L'humanit� devra mettre un terme � la guerre, ou la guerre mettra un terme � l'humanit�.", "John Fitzgerald Kennedy"),
		new Citation("Mon point fort, si j�en ai un, c�est la performance. J�en fais toujours plus que ce que je dis. Je produis toujours plus que ce que je promets. ", "Richard Nixon"),
		new Citation("Si deux hommes sont d�accord sur tout, c�est qu�un seul des deux pense.", "Lyndon Johnson"),
		new Citation("Lorsque vous faites usage de la force, il est une chose � ne jamais faire : perdre.", "Dwight Eisenhower"),
		new Citation("Les mots sans actions assassinent l�id�alisme. ", "Herbert Hoover"),
		new Citation("Les faits sont rebelles ; et quels que soient nos souhaits, nos d�sirs ou nos passions, ils ne pourront pas alt�rer un �tat de fait.", "John Adams"),
		new Citation("Le prix de la libert� c�est la vigilance �ternelle.", "Thomas Jefferson"),
		new Citation("Un gouvernement c�est comme un b�b�. Un tube digestif avec un gros app�tit � un bout et aucun sens des responsabilit�s de l�autre.", "Ronald Reagan"),
		new Citation("La culture est ce qui subsiste quand on a oubli� tout ce qu'on avait appris.", "Selma Lagerlof"),
		new Citation("La culture, c'est avant tout une unit� de style qui se manifeste dans toutes les activit�s d'une nation.", "Friedrich Nietzsche"),
		new Citation("On a trouv�, en bonne politique, le secret de faire mourir de faim ceux qui, en cultivant la terre, font vivre les autres. ", "Voltaire"),
		new Citation("La dictature c'est 'Ferme ta gueule !', la d�mocratie c'est 'Cause toujours !'.", "Coluche"),
		new Citation("Comme le despotisme est l'abus de la royaut�, l'anarchie est l'abus de la d�mocratie. ", "Voltaire"),
		new Citation("Il existe un moyen infaillible pour dire quand un politicien ment � il remue les l�vres.", "Felicity Kendall"),
		new Citation("Comme un politicien ne croit jamais � ce qu'il dit, il est toujours �tonn� que d'autres le fassent.", "General de Gaulle"),
		new Citation("Tout pouvoir sans contr�le rend fou.", ""),
		new Citation("La Politique a pour fin, non pas la connaissance, mais l'action.", "Aristote"),
		new Citation("La d�cadence d'une soci�t� commence lorsque l'home se demande 'Que va-t-il arriver?' au lieu de 'Que puis-je faire?'.", ""),
		new Citation("Les politiciens sont des gens qui souvent se prom�nent les fesses serr�es de peur de laisser �chapper un peu de v�rit�.", ""),
		new Citation("De m�me que je refuse d'�tre un esclave, je refuse d'�tre un ma�tre. Telle est mon id�e de la d�mocratie.", "Abraham Lincoln"),
		new Citation("Un bulletin de vote est plus fort qu'une balle de fusil.", "Abraham Lincoln"),
		new Citation("Tout est faux et vrai � la fois: Tel est le vrai caract�re de la Loi.", "Bouddha"),
		new Citation("Presque tous les hommes peuvent faire face � l'adversit� ; mais si vous voulez tester la capacit� de quelqu'un, donnez-lui le pouvoir", "Abraham Lincoln"),
		new Citation("Le pouvoir est aveugle, les d�tresses les plus accablantes sont muettes... Comment faire se rejoindre ceux qui savent et ceux qui peuvent ?", "Abb� Pierre"),
		new Citation("Les hommes politiques ne connaissent la mis�re que par les statistiques. On ne pleure pas devant les chiffres.", "Abb� Pierre"),
		new Citation("Il n'y a qu'une seule fa�on de tuer le capitalisme : des imp�ts, des imp�ts et toujours plus d'imp�ts.", "Abb� Pierre"),
		new Citation("L'histoire de toute soci�t� jusqu'� nos jours n'a �t� que l'histoire de luttes de classes.", "Karl Marx"),
		new Citation("Toute classe qui aspire � la domination doit conqu�rir d'abord le pouvoir politique pour repr�senter � son tour son int�r�t propre comme �tant l'int�r�t g�n�ral.", "Karl Marx"),
		new Citation("Le meilleur r�gime politique est la monarchie absolue temp�r�e par l'assassinat.", "Stendhal"),
		new Citation("On peut conna�tre tout, except� soi-m�me. ", "Stendhal"),
		new Citation("Pour un amant, il n�est plus d�ami.", "Stendhal"),
		new Citation("J�appelle caract�re d�un homme sa mani�re habituelle d�aller � la chasse au bonheur.", "Stendhal"),
		new Citation("L�admission des femmes � l��galit� parfaite serait la marque la plus s�re de la civilisation, et elle doublerait les forces intellectuelles du genre humain. ", "Stendhal"),
		new Citation("Qui s�excuse s�accuse.", "Stendhal"),
		new Citation("On ne se console pas des chagrins, on s�en distrait.", "Stendhal"),
		new Citation("J�aime la force, et de la force que j�aime, une fourmi peut en montrer autant qu�un �l�phant.", "Stendhal"),
		new Citation("Un roman est comme un archet, la caisse du violon qui rend les sons, c�est l��me du lecteur.", "Stendhal"),
		new Citation("Pourquoi parler ? Pourquoi se mettre en communication avec cet �teignoir de tout enthousiasme et de toute sensibilit� : les autres ?", "Stendhal"),
		new Citation("Pour un amant, il n�est plus d�ami.", "Stendhal"),
		new Citation("Deux choses instruisent l'homme de toute sa nature: l'instinct et l'exp�rience.", "Blaise Pascal")
		
		
	};


	private String citation;
	private String auteur;
	
	
	/** Genere une citation al�atoire */
	public Citation(Random rand) 
	{
		int alea = rand.nextInt(Citation.CITATION.length);
		this.citation = Citation.CITATION[alea].getCitation();
		this.auteur = Citation.CITATION[alea].getAuteur();
	}
	
	/** Constructeur d'une citation, Arg: Citation, Auteur */
	public Citation(String pCitation, String pAuteur) 
	{
		this.citation = pCitation;
		
		if(pAuteur.equals("")) // Si le champ auteur est vide, on met un auteur inconnu
		{
			this.auteur = "Inconnu";
		}
		else // Sinon on recupere l'auteur
		{
			this.auteur = pAuteur;
		}
	}
	
	public String getCitation()
	{
		return this.citation;
	}
	
	public String getAuteur()
	{
		return this.auteur;
	}
	
	public String getFullCitation()
	{
		return this.citation + "\n \n" + "� de " + this.auteur;
	}

}
