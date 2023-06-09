package com.example.cni.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Secteur {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code_sect;
	private String des_sect;

	public Integer getCode_sect() {
		return this.code_sect;
	}

	public void setCode_sect(Integer code_sect) {
		this.code_sect = code_sect;
	}

	public String getDes_sect() {
		return this.des_sect;
	}

	public void setDes_sect(String des_sect) {
		this.des_sect = des_sect;
	}


	public Secteur(Integer code_sect, String des_sect) {
		this.code_sect = code_sect;
		this.des_sect = des_sect;
	}

	public Secteur() {
	}

}
