package fr.iut.modeles;

public class Lettre {
	String lettre;	//A B C
	String code;// Code morse de la lettre associée

		//Getters et Setters
	public String getLettre() {
		return lettre;
	}
	public void setLettre(String lettre) {
		this.lettre = lettre;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Construit un objet Lettre
	 * @param lettre String  : lettre ex:"a","b"
	 * @param code String : équivalent de la lettre en code morse
	 */
	public Lettre(String lettre, String code) {
		super();
		this.lettre = lettre;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Lettre [lettre=" + lettre + ", code=" + code + "]";
	}
	
	
}
