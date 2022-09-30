package com.example.Modeles;

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
		
		setL(l.RetourneAuDebut());
		//l.afficher_position();
			do
			{
					//Note : Faire remonter la piste de lecteur au tout debut � chaque nouvelle recherche dans la liste 
				//System.out.println("Recherche:"+mot+"/Trouve:"+Lettre_ref.getLettre());
				if(l.Prec == null)	//Si on commence au debut de la liste [ne marche pas, c'est B qui marche]
				{
					System.out.println("A");
					l.afficher_position();
					l.setLettre_ref(l.getSuivant().getLettre_ref());
					System.out.println("Recherche:"+mot+"/Trouve:"+l.Lettre_ref.getLettre()+" Statut "+l.Lettre_ref.getLettre().equals(mot));
					l.Suivant = l.Suivant.getSuivant();
					
				}
				else	//Si on commence � la fin de la liste
				{
					System.out.println("B");
					l.setLettre_ref(l.getPrec().getLettre_ref());
					System.out.println("Recherche:"+mot+"/Trouve:"+l.Lettre_ref.getLettre()+" Statut "+l.Lettre_ref.getLettre().equals(mot));
					l.Suivant = l.Prec;
					l.Prec = l.Prec.getPrec();
					
				}
				
			}while(!(l.Lettre_ref.getLettre().equals(mot)));
			System.out.println("SORTIE");
	
			return l.Lettre_ref.getCode();
		
		

			
		
		
	}
	
	public void recherchemot(String code)	//Retrouve le mot en fonction du code saisie
	{
		
	}
}
