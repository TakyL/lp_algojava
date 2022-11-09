package fr.iut.modeles;

@SuppressWarnings("StringConcatenationInLoop")
public class Conversion {
	Liste l;

	public Liste getL() {
		return l;
	}

	public void setL(Liste l) {
		this.l = l;
	}


	public Conversion(Liste l) {
		super();
		this.l = l;
	}


	public String RechercheMorse(String lettre)	//Recherche le code morse d'une lettre
	{
		Fichier f1 = new  Fichier("src/main/resources/morse.codelist/ref.txt");

		setL(f1.FichierToListe());	//Crée le dictionnaire en fonction du fichier ref.txt

		while(!(l.Lettre_ref.getLettre().equals(lettre))) {	//Parcours de la liste(dictionnaire)
			l.setLettre_ref(l.getPrec().getLettre_ref());
			l.setPrec(l.getPrec().getPrec());
		}
		return l.Lettre_ref.getCode();
	}

	public String RecherchetLettre(String code)	//Retrouve la lettre en fonction du code saisie
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
