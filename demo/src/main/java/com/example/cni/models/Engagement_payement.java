package com.example.cni.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Engagement_payement {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer code;
private BigDecimal montant_engage;
private BigDecimal montant_paye;
private LocalDate date ;

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public BigDecimal getMontant_engage() {
		return this.montant_engage;
	}

	public void setMontant_engage(BigDecimal montant_engage) {
		this.montant_engage = montant_engage;
	}

	public BigDecimal getMontant_paye() {
		return this.montant_paye;
	}

	public void setMontant_paye(BigDecimal montant_paye) {
		this.montant_paye = montant_paye;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Engagement_payement() {
	}

	public Engagement_payement( BigDecimal montant_engage, BigDecimal montant_paye, LocalDate date) {
		this.montant_engage = montant_engage;
		this.montant_paye = montant_paye;
		this.date = date;
	}

}
