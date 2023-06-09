package com.example.cni.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Bwailleur_fond {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String code_bailleur_fond;
	private String des_bailleur_fond;
public Bwailleur_fond() {
	}
	public Bwailleur_fond(String des_bailleur_fond){
		this.des_bailleur_fond = des_bailleur_fond;
	}

	public String getCode_bailleur_fond() {
		return this.code_bailleur_fond;
	}

	public void setCode_bailleur_fond(String code_bailleur_fond) {
		this.code_bailleur_fond = code_bailleur_fond;
	}

	public String getDes_bailleur_fond() {
		return this.des_bailleur_fond;
	}

	public void setDes_bailleur_fond(String des_bailleur_fond) {
		this.des_bailleur_fond = des_bailleur_fond;
	}

	
}
