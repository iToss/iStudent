package fr.tingo.istudent.calendrier.blague;

import java.util.Random;

public class Savoir {
	

	//Tableau de String contenant pleins d'informations
	public static final String SAVOIR[] = {
		
		"Cette application a �t� codd� en Java, pour un projet de la specialit� ISN de Terminale S, au lyc�e Francois Couperin. \n \n Elle a �t� entierement con�u par PEREIRA Romain et BOISGARD Mathias.",
		"Caligula �tait un Empereur Romain entre l'an 37 et 41. Il a nomm� Inciatus, son cheval favori, Consul de l'Empire... Soit l'�quivalent du 1er ministre Francais.",
		"Kurt Cobain, Jimi Hendrix, Amy Whinehouse, Janis Joplin, Robert Johnson; tout ces grandes personnalit�s du Rock et du Blues sont d�c�d�s � l'�ge de 27 ans.",
		"Un escargot peut dormir jusqu'� 3 ans!",
		"Les Pandas ont un 6eme doigt, qui n'est en r�alit� qu'une hypertrophie d'un os de la paume. Il leur est tr�s utile pour eplucher les bambous.",
		"L'oeil de l'autruche est plus gros que son cerveau.",
		"Si vous criez 8 ans, 7 mois et 6 jours, vous cr�erez suffisament d'�nergie pour chauffer une tasse de caf�.",
		"Une fourmi peut soulever 50 fois son poids.",
		"Si nous avions le meme rapport poids/force que les fourmis, nous pourrions soulever 2 � 3 Peugeot 206. (3000 tonnes)",
		"La chaise �l�ctrique a �t� invent� par un dentiste.",
		"La dur�e moyenne de sommeil pour un francais est de 7h.",
		"Nous dormons en moyenne 30 minutes de moins qu'il y a 100 ans.",
		"Les australiens sont les plus gros dormeurs, avec une moyenne de 8h de sommeil par nuit.",
		"En 1998, James Cameron, le r�alisateur de Titanic, Avatar ou encore Terminator recoit l'Oscar du meilleur r�alisateur.",
		"Il y a une ville nomm� Rome sur chaque continent",
		"Les dessins anim�s de Donald Duck ont �t� interdit en Finlande car il ne portait pas de pantalon.",
		"En Italie, la loi interdit aux hommes de porter des jupes.",
		"Le sperme poss�de des propri�t�s d'antid�presseur.",
		"25% du nombre des os humains se trouvent dans ses pieds.",
		"C'est durant la phase embryonnaire qu'un Homme fabriquera toutes ses neuronnes (entre 86 et 100 milliars de cellules). Ce nombre de neurones agira durant toute la vie d'un individu sur ses facult�s intelectuelles."		,
		"Si vous ne savez pas expliquer quelque chose � un enfant de 6 ans, c'est que vous ne l'avez vous m�me pas bien compris.",
		"Le reccord du monde de pompes est de 10 507.",
		"La vitesse du son, et plus g�n�ralement des ondes, grandit proportionellement � la densit� du milieu. Les s�ismes vont plus vite dans de la roche que dans l'eau.",
		"Le vrai nom de Jimi Hendrix �tait Johnny Allen Hendrix",
		"Le soleil est a peu pr�s 110 fois plus gros que la Terre",
		"Le nom le plus port� au monde est Chang",
		"Les acides produits par l'estomac sont assez puissants pour dissoudre du Zinc.",
		"Le pH des acides de votre estomac avoisine 2. Soit un pH extrement acide!",
		"Un cafard peut vivre 1 semaine si on lui coupe la t�te, apres quoi il mourra de faim.",
		"Bic a vendu 100 milliars de stylos entre 1950 et 2005. Ce qui repr�sente suffisament d'encre pour tracer une ligne jusqu'� Pluton, et revenir, et cela environ 20 fois.",
		"Les Grecs avec 164 rapports sexuels annuels par personne, en moyenne arrivent tr�s loin devant les Japonais, avec 48 rapports sexuels annuels.",
		"50% des richesses mondiales sont poss�d�s par 2 % de l'humanit�.",
		"La fourchette a �t� invent� en Roumanie",
		"Un crayon moyen peut �crire environ 45 000 mots",
		"La derniere attaque contre le Canada fut en 1812, par les Etats-Unis.",
		"Si la Terre n'avait pas d'atmosphere, sa temperature moyenne serait de -18�C. Elle est de 14�C actuellement.",
		"86% des gens se font des sc�nations qui ne se produiront jamais avant de s'endormir.",
		"Les rayons du Soleil mettent 8 minutes sur Terre.",
		"Environ une personne sur 4 est fumeurs.",
		"Il n'y a pas de muscles dans le poignet, uniquement des tendons.",
		"La Russie s'�tends sur 9 fuseaux horraires. Cela signifie que le pays prends 9 heures � passer � l'ann�e suivante!",
		"On a plus de chances de se faire frapper par la foudre que de gagner au loto!",
		"Nous mettons en moyenne 7 minutes � nous endormir",
		"On ne voit pas avec nos yeux, mais avec notre cerveau. Les yeux fournissent les impulsions nerveuses � notre cerveau qui les transcrit en image.",
		"Au cours de votre vie, vous marcherez l'�quivalent de 3 fois le tour du monde.",
		"Dans le Maryland, une loi interdit de maltraiter les huitres.",
		"Il y a plus de poulets que d'humains sur Terre.",
		"Une girafe peut nettoyer ses oreilles avec sa langue",
		"De nombreux arbres sont plant�s par les ecureils. Ils enterrent leur graines, et oublient ou il les ont mises.",
		"Il est impossible d'�ternuer les yeux ouverts",
		"Le 'couac' du canard ne produit pas d'�cho, la cause en reste un myst�re.",
		"Le briquet a �t� invent� avant l'allumette",
		"Les rats se mutliplient si rapidement, qu'en 18 mois, un couple peut avoir plus d'un million de descendants.",
		"Pendant la dur�e moyenne d'une vie, une personne qui dort avalera 70 insectes",
		"Les �l�phants sont les seuls animaux qui ne peuvent pas sauter.",
		"Les femmes clignent des yeux 2 fois plus que les hommes.",
		"Les yeux humains restent les m�me de sa naissance jusqu'� sa mort, il ne grossissent pas.",
		"Le 14 Juillet, f�te nationale francaise, marque l'anniversaire de la prise de la Bastille par les r�volutionnaires en 1789",
		"L'hymne espagnol intitul� La Marche Royal ne dispose d'aucunes paroles, et cela suite � la chute du dictateur Franco qui les avait instaur�es",
		"'Etre un mouton de Panurge' d�signe une personne suivant un mouvement sans r�fl�chir. Cet expression est issue du livre Pantagruel, o� des moutons se jettent tous � l'eau, se suivant les uns les autres.",
		"L'arbre le plus grand du monde est un s�quoia g�ant situ� en Californie, faisant 84 m�tres de haut, avec un diam�tre de 11 m�tres � sa base.",
		"Seuls les vrais jumeaux peuvent avoir le m�me g�notype. (ensemble des g�nes)",
		"Les jeux olympiques en Grece antique se faisait nu.",
		"Si vous ing�rez une quantit� importante de betteraves, vous urinerez mauve. Le colorant pr�sent dans la betterave est mal dig�r� par l'Homme.",
		"Le blobfish est un poisson vivant tr�s en profondeur pr�s des cotes australiennes. Sa chair est g�latineuse ce qui lui permet de survivre � de tr�s grandes pressions.",
		"La femelle du furet doit se reproduire pour sa survie, sinon elle mourra d'hyperoestrog�nisme. (s�cr�tion trop importante d'hormones sexuelles.",
		"Google est l'une des plus imposantes entreprises du march� d'Internet et fait partie, avec Apple, Facebook et Amazon.com, des Big Four",
		"La marque de sport Asics est l'acronyme de l'expression latine 'Anima Sana In Corpore Sano', soit en fran�ais 'un esprit sain dans un corps sain'",
		"L'acteur John Travolta poss�de un avion Falcon et un Boeing 707. Il dispose d'un a�roport priv� chez lui, dont la tour de contr�le est situ�e juste au-dessus de son salon.",
		"La soie d'araign�e est un des mat�riaux naturels les plus r�sistants. En effet, � �paisseur �gale, la toile d'araign�e est 10 fois plus dure que l'acier, et 7 fois plus souple que le latex.",
		"La NASA travaille actuellement sur un 'distordeur d'espace' qui permettrait de voyager jusqu'� Proxima du Centaure (4,2 ann�es-lumi�re) en deux semaines.",
		"Si vous allez en Arctique, vous y trouverez des ours polaires : 'Arctique' vient du grec ancien '�rktos' et se traduit par ours.",
		"En France, il se vend chaque jour 8 fois plus de sandwichs jambon-beurre que de hamburgers, et 3 fois plus que de kebabs. Ce sont plus de 2,2 millions de jambon-beurre qui sont consomm�s par les fran�ais chaque jour.",
		"Faites attention aux quiproquo si vous allez en Albanie : contrairement � la plupart des autres pays, les albanais hochent la t�te de haut en bas pour dire 'Non' et de gauche � droite pour dire 'Oui'.",
		"Le Tchad et la Roumanie ont quasiment le m�me drapeau : il est bleu jaune et rouge, et la diff�rence est tr�s subtile, le drapeau roumain ayant un bleu un peu plus clair. Les drapeaux se diff�renciaient avant 1989 par un symbole communiste au centre du drapeau roumain.",
		"Le weta est un tr�s gros insecte vivant en altitude en Nouvelle-Z�lande. Lorsqu'il fait froid, il peut geler puis d�geler chaque matin afin de vaquer � ses occupations comme si de rien n'�tait.",
		"Dans les jeux vid�o Mario, Luigi est vert. Cela est d� aux limitations techniques des consoles lors des premiers �pisodes de la c�l�bre s�rie. La m�moire limit�e imposait que le second personnage soit identique au premier, et seule la couleur restait modifiable",
		"Vous connaissez s�rement les quatre saveurs fondamentales que sont le sucr�, le sal�, l'acide et l'amer. Il existe une cinqui�me saveur fondamentale moins connue : l'umami, que l'on trouve notamment dans la cuisine asiatique.",
		"Il arrive souvent que les hommes morts par pendaison aient une �rection dite post mortem ou terminale. Ce ph�nom�ne serait d� � la fois � une compression du cervelet et de la moelle �pini�re par la corde, et � l'afflux de sang dans les parties inf�rieures du corps."
	
	};

	private String savoir;
	
	public Savoir(Random rand) 
	{
		int alea = rand.nextInt(Savoir.SAVOIR.length);
		this.savoir = Savoir.SAVOIR[alea];
	}
	
	public String getSavoir()
	{
		return this.savoir;
	}

}
