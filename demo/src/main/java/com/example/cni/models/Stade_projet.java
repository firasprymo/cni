package com.example.cni.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Stade_projet {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code_std;
	private String des_std;

	public Integer getCode_std() {
		return this.code_std;
	}

	public void setCode_std(Integer code_std) {
		this.code_std = code_std;
	}

	public String getDes_std() {
		return this.des_std;
	}

	public void setDes_std(String des_std) {
		this.des_std = des_std;
	}


	public Stade_projet(Integer code_std, String des_std) {
		this.code_std = code_std;
		this.des_std = des_std;
	}

	public Stade_projet() {
	}

}
