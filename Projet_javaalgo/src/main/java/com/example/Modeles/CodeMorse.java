package com.example.Modeles;

public class CodeMorse {	//Correspond � un code morse
	String code;
	
	public CodeMorse(String code) {
		super();
		this.code = code;
	}
	
	
	public void  ConversionCodeToLettre()		/*switch case ou bien d�composer chaque caract�re du code (proc�dure comme l'arbre) et faire un appel recursif � une fonction*/
	{
		if(code.equals(".-")) System.out.println("a");
		else if(code.equals("---.")) System.out.println("b"); 
		//else System.out.println("Pas trouve");
	}


	
	public void Afficher()
	{
	 System.out.println(code);
	}

}
