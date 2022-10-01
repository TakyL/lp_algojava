package com.example.demo.Modeles;

public class Liste {	//Tableau de liste A/.- => B/-...  en gros on associe chaque lettre � son code
	Lettre Lettre_ref;//Lettre r�f�rence
	Liste Suivant;	//Pointeur suivant
	Liste Prec;
	

	

	public Liste(Lettre lettre_ref, Liste l) {
		super();
		Lettre_ref = lettre_ref;
		Suivant = l;
	}
	
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

	public Liste getSuivant() {
		return Suivant;
	}

	public void setSuivant(Liste suivant) {
		Suivant = suivant;
	}

	
	public Liste getPrec() {
		return Prec;
	}

	public void setPrec(Liste prec) {
		Prec = prec;
	}


	
	public Liste RetourneAuDebut()//Permet de parcourir la liste jusqu'a la lettre a
	{
		while(Prec.getPrec() != null)
		{
			//Prec.setSuivant(Suivant);
			Prec.afficher_position();
			Prec.setSuivant(Prec);
			Prec = Prec.getPrec();

		}

		System.out.println("Je suis bien remonté au début"+getPrec().getLettre_ref());
		return Prec;
	}
	
	
	
	public void inserer(Lettre l)	//Ajoute une lettre � la liste (Utilise la class Lettre)
	{
		if(Suivant==null)
		{
			Liste l0 = new Liste();
			l0.setLettre_ref(l);
			l0.setPrec(null);
			l0.setSuivant(Suivant);
			
			Suivant = l0;
		}
		else
		{
			while(Suivant.getSuivant() != null)
			{
				Suivant = Suivant.getSuivant();
			}
			Liste l0 = new Liste();
			l0.setLettre_ref(l);
			l0.setSuivant(null);
			l0.setPrec(Suivant);
			
			Prec=Suivant;
			Suivant=l0;
			
			
		}	
		
	}
		//Fonctions d'affichage
	public void affichage()
	{
		if(getPrec()==null)
		{
			AffichageDebut();
		}
		else AffichageFin();
	}
	
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
	
	public void AffichageFin()	//Affiche tous les �l�ments de la liste
	{
		System.out.println("Affichage AScendant");
		setLettre_ref(getSuivant().getLettre_ref());	//Null sinon 
		System.out.println(getLettre_ref());	//Affiche l'�l�ment actuel
		while(getPrec()!=null)
		{	
			System.out.println(""+getPrec().getLettre_ref());
			Prec = Prec.getPrec();	
		}
	}
	
	

	public void afficher_position()	//Permet de connaitre l'emplacement des lettrers (debug)
	{
		if(getSuivant() == null)System.out.println(Lettre_ref);
			// System.out.println("PREC"+getPrec().getLettre_ref());
		else if(getPrec() == null) System.out.println("NEXT"+getSuivant().getLettre_ref());
		else System.out.println("ALL"+getSuivant().getLettre_ref()+getPrec().getLettre_ref());
	}
	

}
