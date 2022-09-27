package Modeles;

public class CodeMorse {	//Correspond à un code morse
	String code;
	
	public CodeMorse(String code) {
		super();
		this.code = code;
	}
	
	
	public void  ConversionCodeToLettre()		/*switch case ou bien décomposer chaque caractère du code (procédure comme l'arbre) et faire un appel recursif à une fonction*/
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
