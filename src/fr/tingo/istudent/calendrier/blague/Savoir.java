package fr.tingo.istudent.calendrier.blague;

import java.util.Random;

public class Savoir {
	

	//Tableau de String contenant pleins d'informations
	public static final String SAVOIR[] = {
		
		"Cette application a été coddé en Java, pour un projet de la specialité ISN de Terminale S, au lycée Francois Couperin. \n \n Elle a été entierement conçu par PEREIRA Romain et BOISGARD Mathias.",
		"Caligula était un Empereur Romain entre l'an 37 et 41. Il a nommé Inciatus, son cheval favori, Consul de l'Empire... Soit l'équivalent du 1er ministre Francais.",
		"Kurt Cobain, Jimi Hendrix, Amy Whinehouse, Janis Joplin, Robert Johnson; tout ces grandes personnalités du Rock et du Blues sont décèdés à l'âge de 27 ans.",
		"Un escargot peut dormir jusqu'à 3 ans!",
		"Les Pandas ont un 6eme doigt, qui n'est en réalité qu'une hypertrophie d'un os de la paume. Il leur est très utile pour eplucher les bambous.",
		"L'oeil de l'autruche est plus gros que son cerveau.",
		"Si vous criez 8 ans, 7 mois et 6 jours, vous créerez suffisament d'énergie pour chauffer une tasse de café.",
		"Une fourmi peut soulever 50 fois son poids.",
		"Si nous avions le meme rapport poids/force que les fourmis, nous pourrions soulever 2 à 3 Peugeot 206. (3000 tonnes)",
		"La chaise éléctrique a été inventé par un dentiste.",
		"La durée moyenne de sommeil pour un francais est de 7h.",
		"Nous dormons en moyenne 30 minutes de moins qu'il y a 100 ans.",
		"Les australiens sont les plus gros dormeurs, avec une moyenne de 8h de sommeil par nuit.",
		"En 1998, James Cameron, le réalisateur de Titanic, Avatar ou encore Terminator recoit l'Oscar du meilleur réalisateur.",
		"Il y a une ville nommé Rome sur chaque continent",
		"Les dessins animés de Donald Duck ont été interdit en Finlande car il ne portait pas de pantalon.",
		"En Italie, la loi interdit aux hommes de porter des jupes.",
		"Le sperme possède des propriétés d'antidépresseur.",
		"25% du nombre des os humains se trouvent dans ses pieds.",
		"C'est durant la phase embryonnaire qu'un Homme fabriquera toutes ses neuronnes (entre 86 et 100 milliars de cellules). Ce nombre de neurones agira durant toute la vie d'un individu sur ses facultés intelectuelles."		,
		"Si vous ne savez pas expliquer quelque chose à un enfant de 6 ans, c'est que vous ne l'avez vous même pas bien compris.",
		"Le reccord du monde de pompes est de 10 507.",
		"La vitesse du son, et plus généralement des ondes, grandit proportionellement à la densité du milieu. Les séismes vont plus vite dans de la roche que dans l'eau.",
		"Le vrai nom de Jimi Hendrix était Johnny Allen Hendrix",
		"Le soleil est a peu près 110 fois plus gros que la Terre",
		"Le nom le plus porté au monde est Chang",
		"Les acides produits par l'estomac sont assez puissants pour dissoudre du Zinc.",
		"Le pH des acides de votre estomac avoisine 2. Soit un pH extrement acide!",
		"Un cafard peut vivre 1 semaine si on lui coupe la tête, apres quoi il mourra de faim.",
		"Bic a vendu 100 milliars de stylos entre 1950 et 2005. Ce qui représente suffisament d'encre pour tracer une ligne jusqu'à Pluton, et revenir, et cela environ 20 fois.",
		"Les Grecs avec 164 rapports sexuels annuels par personne, en moyenne arrivent très loin devant les Japonais, avec 48 rapports sexuels annuels.",
		"50% des richesses mondiales sont possèdés par 2 % de l'humanité.",
		"La fourchette a été inventé en Roumanie",
		"Un crayon moyen peut écrire environ 45 000 mots",
		"La derniere attaque contre le Canada fut en 1812, par les Etats-Unis.",
		"Si la Terre n'avait pas d'atmosphere, sa temperature moyenne serait de -18°C. Elle est de 14°C actuellement.",
		"86% des gens se font des scénations qui ne se produiront jamais avant de s'endormir.",
		"Les rayons du Soleil mettent 8 minutes sur Terre.",
		"Environ une personne sur 4 est fumeurs.",
		"Il n'y a pas de muscles dans le poignet, uniquement des tendons.",
		"La Russie s'étends sur 9 fuseaux horraires. Cela signifie que le pays prends 9 heures à passer à l'année suivante!",
		"On a plus de chances de se faire frapper par la foudre que de gagner au loto!",
		"Nous mettons en moyenne 7 minutes à nous endormir",
		"On ne voit pas avec nos yeux, mais avec notre cerveau. Les yeux fournissent les impulsions nerveuses à notre cerveau qui les transcrit en image.",
		"Au cours de votre vie, vous marcherez l'équivalent de 3 fois le tour du monde.",
		"Dans le Maryland, une loi interdit de maltraiter les huitres.",
		"Il y a plus de poulets que d'humains sur Terre.",
		"Une girafe peut nettoyer ses oreilles avec sa langue",
		"De nombreux arbres sont plantés par les ecureils. Ils enterrent leur graines, et oublient ou il les ont mises.",
		"Il est impossible d'éternuer les yeux ouverts",
		"Le 'couac' du canard ne produit pas d'écho, la cause en reste un mystère.",
		"Le briquet a été inventé avant l'allumette",
		"Les rats se mutliplient si rapidement, qu'en 18 mois, un couple peut avoir plus d'un million de descendants.",
		"Pendant la durée moyenne d'une vie, une personne qui dort avalera 70 insectes",
		"Les éléphants sont les seuls animaux qui ne peuvent pas sauter.",
		"Les femmes clignent des yeux 2 fois plus que les hommes.",
		"Les yeux humains restent les même de sa naissance jusqu'à sa mort, il ne grossissent pas.",
		"Le 14 Juillet, fête nationale francaise, marque l'anniversaire de la prise de la Bastille par les révolutionnaires en 1789",
		"L'hymne espagnol intitulé La Marche Royal ne dispose d'aucunes paroles, et cela suite à la chute du dictateur Franco qui les avait instaurées",
		"'Etre un mouton de Panurge' désigne une personne suivant un mouvement sans réfléchir. Cet expression est issue du livre Pantagruel, où des moutons se jettent tous à l'eau, se suivant les uns les autres.",
		"L'arbre le plus grand du monde est un séquoia géant situé en Californie, faisant 84 mètres de haut, avec un diamètre de 11 mètres à sa base.",
		"Seuls les vrais jumeaux peuvent avoir le même génotype. (ensemble des gènes)",
		"Les jeux olympiques en Grece antique se faisait nu.",
		"Si vous ingérez une quantité importante de betteraves, vous urinerez mauve. Le colorant présent dans la betterave est mal digéré par l'Homme.",
		"Le blobfish est un poisson vivant très en profondeur près des cotes australiennes. Sa chair est gélatineuse ce qui lui permet de survivre à de très grandes pressions.",
		"La femelle du furet doit se reproduire pour sa survie, sinon elle mourra d'hyperoestrogénisme. (sécrétion trop importante d'hormones sexuelles.",
		"Google est l'une des plus imposantes entreprises du marché d'Internet et fait partie, avec Apple, Facebook et Amazon.com, des Big Four",
		"La marque de sport Asics est l'acronyme de l'expression latine 'Anima Sana In Corpore Sano', soit en français 'un esprit sain dans un corps sain'",
		"L'acteur John Travolta possède un avion Falcon et un Boeing 707. Il dispose d'un aéroport privé chez lui, dont la tour de contrôle est située juste au-dessus de son salon.",
		"La soie d'araignée est un des matériaux naturels les plus résistants. En effet, à épaisseur égale, la toile d'araignée est 10 fois plus dure que l'acier, et 7 fois plus souple que le latex.",
		"La NASA travaille actuellement sur un 'distordeur d'espace' qui permettrait de voyager jusqu'à Proxima du Centaure (4,2 années-lumière) en deux semaines.",
		"Si vous allez en Arctique, vous y trouverez des ours polaires : 'Arctique' vient du grec ancien 'árktos' et se traduit par ours.",
		"En France, il se vend chaque jour 8 fois plus de sandwichs jambon-beurre que de hamburgers, et 3 fois plus que de kebabs. Ce sont plus de 2,2 millions de jambon-beurre qui sont consommés par les français chaque jour.",
		"Faites attention aux quiproquo si vous allez en Albanie : contrairement à la plupart des autres pays, les albanais hochent la tête de haut en bas pour dire 'Non' et de gauche à droite pour dire 'Oui'.",
		"Le Tchad et la Roumanie ont quasiment le même drapeau : il est bleu jaune et rouge, et la différence est très subtile, le drapeau roumain ayant un bleu un peu plus clair. Les drapeaux se différenciaient avant 1989 par un symbole communiste au centre du drapeau roumain.",
		"Le weta est un très gros insecte vivant en altitude en Nouvelle-Zélande. Lorsqu'il fait froid, il peut geler puis dégeler chaque matin afin de vaquer à ses occupations comme si de rien n'était.",
		"Dans les jeux vidéo Mario, Luigi est vert. Cela est dû aux limitations techniques des consoles lors des premiers épisodes de la célèbre série. La mémoire limitée imposait que le second personnage soit identique au premier, et seule la couleur restait modifiable",
		"Vous connaissez sûrement les quatre saveurs fondamentales que sont le sucré, le salé, l'acide et l'amer. Il existe une cinquième saveur fondamentale moins connue : l'umami, que l'on trouve notamment dans la cuisine asiatique.",
		"Il arrive souvent que les hommes morts par pendaison aient une érection dite post mortem ou terminale. Ce phénomène serait dû à la fois à une compression du cervelet et de la moelle épinière par la corde, et à l'afflux de sang dans les parties inférieures du corps."
	
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
