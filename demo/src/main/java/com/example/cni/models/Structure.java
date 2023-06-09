package com.example.cni.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Structure {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code_str;
	private String des_str;
	private Integer code_str_mere;

	public Integer getCode_str() {
		return this.code_str;
	}

	public void setCode_str(Integer code_str) {
		this.code_str = code_str;
	}

	public String getDes_str() {
		return this.des_str;
	}

	public void setDes_str(String des_str) {
		this.des_str = des_str;
	}

	public Integer getCode_str_mere() {
		return this.code_str_mere;
	}

	public void setCode_str_mere(Integer code_str_mere) {
		this.code_str_mere = code_str_mere;
	}


	public Structure(Integer code_str, String des_str, Integer code_str_mere) {
		this.code_str = code_str;
		this.des_str = des_str;
		this.code_str_mere = code_str_mere;
	}

	public Structure() {
	}

}
