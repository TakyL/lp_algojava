package com.example.demo.Modeles;

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

	//NOTE: Toujours v�rifier la position car pour l'instant, getsuivant() a tendance a �tre la lettre actuelle et que du coup la lettre actuelle ait de fortes chances d'�tre null
	public String recherchecode(String mot)	//Recherche le code binaire d'un caract�re associ�
	{
		Fichier f1 = new  Fichier("src/main/java/com/example/demo/Texte/ref.txt");
		setL(f1.FichierToListe());

		//l.setLettre_ref(l.getSuivant().getLettre_ref());	//Pour récup le z Note: déplacer dans fichier

	while(!(l.Lettre_ref.getLettre().equals(mot))){
		l.setLettre_ref(l.getPrec().getLettre_ref());
		l.setPrec(l.getPrec().getPrec());
	}
		System.out.println("SORTIE"+ l.Lettre_ref.getLettre() +l.Lettre_ref.getCode());

		return l.Lettre_ref.getCode();
	}

	public String recherchemot(String code)	//Retrouve le mot en fonction du code saisie
	{
		Fichier f1 = new  Fichier("src/main/java/com/example/demo/Texte/ref.txt");
		setL(f1.FichierToListe());

		//l.setLettre_ref(l.getSuivant().getLettre_ref());	//Pour récup le z Note: déplacer dans fichier

		while(!(l.Lettre_ref.getCode().equals(code))){
			//	System.out.println("Je recherche le mot"+l.Lettre_ref.getCode()+"/"+code);
			l.setLettre_ref(l.getPrec().getLettre_ref());
			l.setPrec(l.getPrec().getPrec());
		}
		System.out.println("SORTIE : "+ l.Lettre_ref.getLettre() +" "+l.Lettre_ref.getCode());

		return l.Lettre_ref.getLettre();
	}

	public String recherchecode2(String Mot)
	{
		String MotEnMorse = "";
		for(int i =0; i <=Mot.length()-1;i++)
		{
			MotEnMorse = MotEnMorse + recherchecode(String.valueOf(Mot.charAt(i)).toLowerCase()+ " ");
			System.out.println(""+MotEnMorse);
		}

		return MotEnMorse;
	}
	/*Note chaque lettre morse est séparé d'un espace*/
	public String recherchemot2(String Code)
	{
		String MorseEnMot = "";

		{
			if(Code.contains(" "))	//Recherche si un espace est detecté car un espace = deux lettres mini
			/*{
				System.out.println("DETECTE ESPACE");
				MorseEnMot = MorseEnMot + " "; /*Suppresion de l'espace
				Code = Code.substring(0,Code.indexOf(" "));
				System.out.println(""+Code);
			}*/
			{
				String [] tab = Code.split(" ");
			}

			//System.out.println("CODE DU MOT RECHERCHE/" + MorseEnMot );
			MorseEnMot = MorseEnMot + recherchemot(Code);


		}

		return MorseEnMot;
	}
}