package fr.tingo.istudent.calendrier.blague;

import java.util.Random;


public class Citation {
	

	//Tableau de String contenant pleins d'informations
	public static final Citation CITATION[] = 
	{
		new Citation("Le miracle est, avec la vigne, l'une des principales cultures de la France", "Pierre Daninos"),
		new Citation("Cela semble toujours impossible, jusqu'à ce qu'on le fasse.", "Nelson Mandela"),
		new Citation("J'ai appris que le courage n'est pas l'absence de peur, mais la capacité de la vaincre.", "Nelson Mandela"),
		new Citation("La politique peut être renforcée par la musique, mais la musique a une puissance qui défie la politique.", "Nelson Mandela"),
		new Citation("Les hommes qui prennent de grands risques doivent s'attendre à en supporter souvent les lourdes conséquences.", "Nelson Mandela"),
		new Citation("Une nation arc-en-ciel, en paix avec elle-même et avec le monde.", "Nelson Mandela"),
		new Citation("L'éducation est votre arme la plus puissante pour changer le monde. ", "Nelson Mandela"),
		new Citation("Un cœur bon et un bon esprit forment toujours une formidable combinaison. ", "Nelson Mandela"),
		new Citation("L'argent ne créera pas le succès, c'est la liberté d'en gagner qui le fera.", "Nelson Mandela"),
		new Citation("Des gens courageux ne craignent pas le pardon, au nom de la paix.", "Nelson Mandela"),
		new Citation("Tout homme ou toute institution qui essaieront de me voler ma dignité perdront.", "Nelson Mandela"),
		new Citation("Il ne peut y avoir plus vive révélation de l'âme d'une société que la manière dont elle traite ses enfants.", "Nelson Mandela"),
		new Citation("Je ne suis pas contre toutes les guerres ; je suis seulement contre les guerres idiotes.", "Barack Obama"),
		new Citation("J'espère que Giulia (fille de Nicolas SARKOZY avec Carla BRUNI) a hérité du physique de sa mère plutôt que celui de son père. ", "Barack Obama"),
		new Citation("Nous sommes une nation de chrétiens et de musulmans, de juifs et d'hindous - et d'athées.", "Barack Obama"),
		new Citation("Sème un acte, tu récolteras une habitude ; sème une habitude, tu récolteras un caractère ; sème un caractère, tu récolteras une destinée.", "Barack Obama"),
		new Citation("L’apaisement réside en chacun de nous.", "Barack Obama"),
		new Citation("Il n'y a personne qui soit né sous une mauvaise étoile, il n'y a que des gens qui ne savent pas lire le ciel.", "Barack Obama"),
		new Citation("Si nous devenions violents, nous n'aurions plus rien à défendre.", "Dalaï Lama"),
		new Citation("On ne peut être aimant et compatissant sans contenir ses désirs et ses intérêts immédiats.", "Dalaï Lama"),
		new Citation("Il n’importe pas qu’un être soit croyant ou non : il est plus important qu’il soit bon. ", "Dalaï Lama"),
		new Citation("Certains regardent la vase au fond de l'étang, d'autres contemplent la fleur de lotus à la surface de l'eau, il s'agit d'un choix. ", "Dalaï Lama"),
		new Citation("Plus nous aurons donné de sens à notre vie, moins nous éprouverons de regrets à l'instant de la mort.", "Dalaï Lama"),
		new Citation("Le vrai bonheur ne dépend d'aucun être, d'aucun objet extérieur. Il ne dépend que de nous.", "Dalaï Lama"),
		new Citation("Nul besoin de temples, nul besoin de philosophies compliquées. Notre cerveau et notre coeur sont nos temples.", "Dalaï Lama"),
		new Citation("Lorsque nos intentions sont égoïstes, le fait que nos actes puissent paraître bons ne garantit pas qu'ils soient positifs ou éthiques.", "Dalaï Lama"),
		new Citation("Le désarmement extérieur passe par le désarmement intérieur. Le seul vrai garant de la paix est en soi.", "Dalaï Lama"),
		new Citation("Faites constamment aux autres le bien que vous voulez en recevoir.", "Dalaï Lama"),
		new Citation("Folie toute l'intelligence sans la conscience profonde de la mort et de l'impertinence.", "Dalaï Lama"),
		new Citation("On s'intéresse à ses membres comme parties de son corps, pourquoi pas aux hommes comme parties de l'humanité ?", "Dalaï Lama"),
		new Citation("Les livres sont la lumière qui guide la civilisation.", "F.D Roosevelt"),
		new Citation("Faites quelque chose et, si ça ne réussit pas, essayez autre chose.", "Dalaï Lama"),
		new Citation(" Les caresses n'ont jamais transformé un tigre en chaton.", "F.D Roosevelt"),
		new Citation("Un réactionnaire est un somnambule qui marche à reculons.", "F.D Roosevelt"),
		new Citation("Soyez sincère, soyez bref, restez assis.", "F.D Roosevelt"),
		new Citation("Ne sous-estimez jamais un homme qui se surestime.", "F.D Roosevelt"),
		new Citation("Il est dur d'échouer ; mais il est pire de n'avoir jamais tenté de réussir.", "F.D Roosevelt"),
		new Citation("La seule chose que nous ayons à craindre est la crainte elle-même.", "F.D Roosevelt"),
		new Citation("La seule limite à nos réalisations de demain sera nos doutes d'aujourd'hui.", "F.D Roosevelt"),
		new Citation("Noël n’est pas un jour ni une saison, c’est un état d’esprit.", "Calvin Coolidge"),
		new Citation("Les femmes sont extrêmes ; elles sont meilleures ou pires que les hommes. ", "Jean de La Bruyère"),
		new Citation("Il est plus difficile de bien faire l’amour que de bien faire la guerre.", "Ninon de Lenclos"),
		new Citation("On ne naît pas femme : on le devient.", "Simone de Beauvoir"),
		new Citation("Le devoir des grands Etats est de servir et non de dominer le monde.", "Harry Truman"),
		new Citation("Gouverner, c'est maintenir les balances de la justice égales pour tous. ", "F.D Roosevelt"),
		new Citation("Le politicien qui réussit le mieux est celui qui dit le plus souvent et de la voix la plus forte ce que tout le monde pense.", "Theodore Roosevelt"),
		new Citation("Si vous ne dites rien, on ne vous demandera pas de le répéter.", "Calvin Coolidge"),
		new Citation("La liberté est une plante qui croît vite, une fois qu'elle a pris racine.", "George Washington"),
		new Citation("A chaque génération, les Américains doivent définir ce que veut dire 'être américain'", "Bill Clinton"),
		new Citation("L'humanité devra mettre un terme à la guerre, ou la guerre mettra un terme à l'humanité.", "John Fitzgerald Kennedy"),
		new Citation("Mon point fort, si j’en ai un, c’est la performance. J’en fais toujours plus que ce que je dis. Je produis toujours plus que ce que je promets. ", "Richard Nixon"),
		new Citation("Si deux hommes sont d’accord sur tout, c’est qu’un seul des deux pense.", "Lyndon Johnson"),
		new Citation("Lorsque vous faites usage de la force, il est une chose à ne jamais faire : perdre.", "Dwight Eisenhower"),
		new Citation("Les mots sans actions assassinent l’idéalisme. ", "Herbert Hoover"),
		new Citation("Les faits sont rebelles ; et quels que soient nos souhaits, nos désirs ou nos passions, ils ne pourront pas altérer un état de fait.", "John Adams"),
		new Citation("Le prix de la liberté c’est la vigilance éternelle.", "Thomas Jefferson"),
		new Citation("Un gouvernement c’est comme un bébé. Un tube digestif avec un gros appétit à un bout et aucun sens des responsabilités de l’autre.", "Ronald Reagan"),
		new Citation("La culture est ce qui subsiste quand on a oublié tout ce qu'on avait appris.", "Selma Lagerlof"),
		new Citation("La culture, c'est avant tout une unité de style qui se manifeste dans toutes les activités d'une nation.", "Friedrich Nietzsche"),
		new Citation("On a trouvé, en bonne politique, le secret de faire mourir de faim ceux qui, en cultivant la terre, font vivre les autres. ", "Voltaire"),
		new Citation("La dictature c'est 'Ferme ta gueule !', la démocratie c'est 'Cause toujours !'.", "Coluche"),
		new Citation("Comme le despotisme est l'abus de la royauté, l'anarchie est l'abus de la démocratie. ", "Voltaire"),
		new Citation("Il existe un moyen infaillible pour dire quand un politicien ment — il remue les lèvres.", "Felicity Kendall"),
		new Citation("Comme un politicien ne croit jamais à ce qu'il dit, il est toujours étonné que d'autres le fassent.", "General de Gaulle"),
		new Citation("Tout pouvoir sans contrôle rend fou.", ""),
		new Citation("La Politique a pour fin, non pas la connaissance, mais l'action.", "Aristote"),
		new Citation("La décadence d'une société commence lorsque l'home se demande 'Que va-t-il arriver?' au lieu de 'Que puis-je faire?'.", ""),
		new Citation("Les politiciens sont des gens qui souvent se promènent les fesses serrées de peur de laisser échapper un peu de vérité.", ""),
		new Citation("De même que je refuse d'être un esclave, je refuse d'être un maître. Telle est mon idée de la démocratie.", "Abraham Lincoln"),
		new Citation("Un bulletin de vote est plus fort qu'une balle de fusil.", "Abraham Lincoln"),
		new Citation("Tout est faux et vrai à la fois: Tel est le vrai caractère de la Loi.", "Bouddha"),
		new Citation("Presque tous les hommes peuvent faire face à l'adversité ; mais si vous voulez tester la capacité de quelqu'un, donnez-lui le pouvoir", "Abraham Lincoln"),
		new Citation("Le pouvoir est aveugle, les détresses les plus accablantes sont muettes... Comment faire se rejoindre ceux qui savent et ceux qui peuvent ?", "Abbé Pierre"),
		new Citation("Les hommes politiques ne connaissent la misère que par les statistiques. On ne pleure pas devant les chiffres.", "Abbé Pierre"),
		new Citation("Il n'y a qu'une seule façon de tuer le capitalisme : des impôts, des impôts et toujours plus d'impôts.", "Abbé Pierre"),
		new Citation("L'histoire de toute société jusqu'à nos jours n'a été que l'histoire de luttes de classes.", "Karl Marx"),
		new Citation("Toute classe qui aspire à la domination doit conquérir d'abord le pouvoir politique pour représenter à son tour son intérêt propre comme étant l'intérêt général.", "Karl Marx"),
		new Citation("Le meilleur régime politique est la monarchie absolue tempérée par l'assassinat.", "Stendhal"),
		new Citation("On peut connaître tout, excepté soi-même. ", "Stendhal"),
		new Citation("Pour un amant, il n’est plus d’ami.", "Stendhal"),
		new Citation("J’appelle caractère d’un homme sa manière habituelle d’aller à la chasse au bonheur.", "Stendhal"),
		new Citation("L’admission des femmes à l’égalité parfaite serait la marque la plus sûre de la civilisation, et elle doublerait les forces intellectuelles du genre humain. ", "Stendhal"),
		new Citation("Qui s’excuse s’accuse.", "Stendhal"),
		new Citation("On ne se console pas des chagrins, on s’en distrait.", "Stendhal"),
		new Citation("J’aime la force, et de la force que j’aime, une fourmi peut en montrer autant qu’un éléphant.", "Stendhal"),
		new Citation("Un roman est comme un archet, la caisse du violon qui rend les sons, c’est l’âme du lecteur.", "Stendhal"),
		new Citation("Pourquoi parler ? Pourquoi se mettre en communication avec cet éteignoir de tout enthousiasme et de toute sensibilité : les autres ?", "Stendhal"),
		new Citation("Pour un amant, il n’est plus d’ami.", "Stendhal"),
		new Citation("Deux choses instruisent l'homme de toute sa nature: l'instinct et l'expérience.", "Blaise Pascal")
		
		
	};


	private String citation;
	private String auteur;
	
	
	/** Genere une citation aléatoire */
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
		return this.citation + "\n \n" + "• de " + this.auteur;
	}

}
