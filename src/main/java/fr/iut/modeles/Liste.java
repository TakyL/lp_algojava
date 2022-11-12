package fr.iut.modeles;

/**
 * Classe représentant la Liste permettant la traduction
 */
public class Liste {

	Lettre Lettre_ref;//Lettre actuel
	Liste Suivant;	//Pointeur suivant
	Liste Prec;		//Pointeur precedeur




// --Commented out by Inspection START (09/11/2022 21:14):
//	public Liste(Lettre lettre_ref, Liste l) {
//		super();
//		Lettre_ref = lettre_ref;
//		Suivant = l;
//	}
// --Commented out by Inspection STOP (09/11/2022 21:14)

	/**
	 * Construit une liste doublement fillé
	 */
	public Liste()
	{
		Suivant=null;
		Prec=null;
	}



	//Getters et setters
	public Lettre getLettre_ref() {
		return Lettre_ref;
	}

	public void setLettre_ref(Lettre lettre_ref) {
		Lettre_ref = lettre_ref;
	}

	/**
	 * Récupère l'élément suivant de la liste
	 * @return Liste : élément suivant de la liste
	 */
	public Liste getSuivant() {
		return Suivant;
	}


	public void setSuivant(Liste suivant) {
		Suivant = suivant;
	}


	/**
	 * Récupère l'élément précédent de la liste
	 * @return Liste : élément précedent de la liste
	 */
	public Liste getPrec() {
		return Prec;
	}

	public void setPrec(Liste prec) {
		Prec = prec;
	}


	/**
	 * Ajoute une lettre à la liste
	 * @param l String : la lettre à ajouter
	 */
	public void inserer(Lettre l)	//Ajoute une lettre à la liste (Utilise la class Lettre)
	{
		if(Suivant==null)	//Si il n'y a pas de prochain élément
		{
			Liste l0 = new Liste();
			l0.setLettre_ref(l);
			l0.setPrec(null);
			l0.setSuivant(Suivant);

			Suivant = l0;	//Ajoute la lettre à la liste
		}
		else	//Sinon
		{
			while(Suivant.getSuivant() != null)//Parcours la liste pour retrouver le dernier élément
			{
				Suivant = Suivant.getSuivant();
			}
			Liste l0 = new Liste();
			l0.setLettre_ref(l);
			l0.setSuivant(null);
			l0.setPrec(Suivant);

			Prec=Suivant;//Conserve la valeur précedente
			Suivant=l0;//Ajoute la lettre à la suite


		}

	}

// --Commented out by Inspection START (09/11/2022 21:13):
//	//Fonctions d'affichage
//	public void affichage()
//	{
//		if(getPrec()==null)
//		{
//			AffichageDebut();
//		}
//		else AffichageFin();
//	}
// --Commented out by Inspection STOP (09/11/2022 21:13)

	/***
	 * Affiche les éléments de la liste à partir du début
	 */
	public void AffichageDebut()	//Affiche tous les �l�ments de la liste
	{
		System.out.println("Affichage Descendant");
		System.out.println(getLettre_ref());	//Affiche l'�l�ment actuel [cf AffichageFin]
		while(getSuivant()!=null)
		{

			System.out.println(""+getSuivant().getLettre_ref());
			Suivant = Suivant.getSuivant();

		}
	}

	/**
	 * Affiche les éléments de la liste à partir de la fin
	 */
	public void AffichageFin()	//Affiche tous les �l�ments de la liste
	{
		System.out.println("Affichage Ascendant");
		setLettre_ref(getSuivant().getLettre_ref());	//Null sinon 
		System.out.println(getLettre_ref());	//Affiche l'�l�ment actuel
		while(getPrec()!=null)
		{
			System.out.println(""+getPrec().getLettre_ref());
			Prec = Prec.getPrec();
		}
	}

	/**
	 * Permet de connaitre le contenu de suivant et précedent
	 */
	public void afficher_position()	//Permet de connaitre l'emplacement des lettres (debug)
	{
		if(getSuivant() == null)System.out.println("PREC"+getPrec().getLettre_ref());
		else if(getPrec() == null) System.out.println("NEXT"+getSuivant().getLettre_ref());
		else System.out.println("ALL"+Suivant.getLettre_ref()+Prec.getLettre_ref());
	}
	//TODO l'insertion d'un code, la suppression d'un code, la recherche d'un code dans une liste,....etc.

}
