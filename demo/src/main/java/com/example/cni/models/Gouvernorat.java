package com.example.cni.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Gouvernorat {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer code_gvrt;
 private String des_gvrt;
 private Long latitude;
 private Long longitude;

	public Gouvernorat(Integer code_gvrt, String des_gvrt, Long latitude, Long longitude) {
		this.code_gvrt = code_gvrt;
		this.des_gvrt = des_gvrt;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Gouvernorat() {
	}

	public Integer getCode_gvrt() {
		return this.code_gvrt;
	}

	public void setCode_gvrt(Integer code_gvrt) {
		this.code_gvrt = code_gvrt;
	}

	public String getDes_gvrt() {
		return this.des_gvrt;
	}

	public void setDes_gvrt(String des_gvrt) {
		this.des_gvrt = des_gvrt;
	}

	public Long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

}
