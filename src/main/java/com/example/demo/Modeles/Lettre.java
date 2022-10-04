package com.example.demo.Modeles;

public class Lettre {
	String lettre;	//A B C
	String code;// Code morse de la lettre associ�e

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
