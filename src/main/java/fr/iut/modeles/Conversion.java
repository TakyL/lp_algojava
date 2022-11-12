package fr.iut.modeles;

/**
 * Classe Conversion qui permet la conversion :
 * Code Morse -> Texte
 * Texte -> Code Morse
 */
@SuppressWarnings("StringConcatenationInLoop")
public class Conversion {
	Liste l;

	public Liste getL() {
		return l;
	}

	public void setL(Liste l) {
		this.l = l;
	}


	/**
	 * Construit un dictonnaire à partir d'une liste
	 * @param l : La liste (içi en provenance du fichier ref.txt)
	 */
	public Conversion(Liste l) {
		super();
		this.l = l;
	}


	/**
	 * Recherche le code morse d'une lettre
	 * @param lettre : caractère ("a","b"...etc)
	 * @return String: code morse de la lettre
	 */
	private String RechercheMorse(String lettre)	//Recherche le code morse d'une lettre
	{
		Fichier f1 = new  Fichier("src/main/resources/morse.codelist/ref.txt");

		setL(f1.FichierToListe());	//Crée le dictionnaire en fonction du fichier ref.txt

		while(!(l.Lettre_ref.getLettre().equals(lettre))) {	//Parcours de la liste(dictionnaire)
			l.setLettre_ref(l.getPrec().getLettre_ref());
			l.setPrec(l.getPrec().getPrec());
		}
		return l.Lettre_ref.getCode();
	}

	/**
	 * Recherche la lettre à partir d'un code morse
	 * @param code : String correspond au code morse ex: "...-"
	 * @return String correspond à la lettre trouvée
	 */
	private String RecherchetLettre(String code)	//Retrouve la lettre en fonction du code saisie
	{
		Fichier f1 = new  Fichier("src/main/resources/morse.codelist/ref.txt");

		setL(f1.FichierToListe());	//Crée le dictionnaire en fonction du fichier ref.txt


		while(!(l.Lettre_ref.getCode().equals(code))){	//Parcours de la liste(dictionnaire)
			//	System.out.println("Je recherche le mot"+l.Lettre_ref.getCode()+"/"+code);
			l.setLettre_ref(l.getPrec().getLettre_ref());
			l.setPrec(l.getPrec().getPrec());
		}
		//System.out.println("SORTIE : "+ l.Lettre_ref.getLettre() +l.Lettre_ref.getCode());

		return l.Lettre_ref.getLettre();
	}

	/**
	 *Permet de convertir un mot en code morse (Ne fonctionne pas avec des phrases)
	 * @param Mot String : Mot à convertir ex:"abc"
	 * @return String : Le code morse du mot saisie en paramètre ex: .- -... -.-. / chaque code morse est séparé d'un espace pour pouvoir retrouver leur équivalent en lettre
	 */
	public String ConversionMotsVersMorse(String Mot)	//Recherche le morse à partir d'un mot/phrase
	{
		String MotEnMorse = "";	//Texte à afficher
		String [] tab = {" "};	//Tableau contenant les différents mots à traduire

		if(Mot.contains(" "))	//Si la phrase contient plusieurs mots
		{
			tab = Mot.split(" ");	//Stocke tous les mots de la phrase à traduire dans le tableau

		}else tab[0] = Mot;//Sinon ne contient qu'un seul mot

		for(int j = 0; j<= tab.length-1;j++) {//Boucle pour chaque mot présent dans le tableau de mots
			//System.out.println("MOT SELECTIONNE : "+tab[j]);
			for (int i = 0; i <= tab[j].length() - 1; i++) {	//Boucle pour chaque mot
				MotEnMorse = MotEnMorse + RechercheMorse(String.valueOf(tab[j].toLowerCase().charAt(i))) + " ";	//Concat le code morse
				//System.out.println("Morse : " + MotEnMorse);
			}
		}
		System.out.println("Morse : " + MotEnMorse);

		return MotEnMorse;
	}

	/**
	 * Permet de convertir un code morse en mot
	 * @param Code String : Code morse ex: .- -... -.-.
	 * @return String : Mot code morse ex:"abc"
	 */
	/*Note chaque lettre en code morse est séparé d'un espace*/
	public String ConversionMorseVersMots(String Code)	//Recherche le mot à partir d'un code morse
	{
		String MorseEnMot = "";	//Texte a afficher
		String [] tab ={" "};	//Tableau contenant les différents code morse à traduire

		if(Code.contains(" "))	//Recherche si un espace est detecté car un espace = deux lettres mini
		{
			tab = Code.split(" ");
		}else tab[0]=Code;


		for (int i = 0; i <= tab.length - 1; i++) {
			//System.out.println(tab[i]);
			MorseEnMot = MorseEnMot + RecherchetLettre(tab[i]);	//Concat
		}
		MorseEnMot = MorseEnMot + " ";

		System.out.println("Mot ou phrase : " + MorseEnMot );

		return MorseEnMot;
	}
}
