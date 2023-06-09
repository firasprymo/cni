package com.example.cni.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Projet {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code_prj;
	private String  des_prj;
	private LocalDate date_deb;
	private LocalDate date_fin;
	private BigDecimal cout_total;
	private BigDecimal flag_diff;
	private Integer code_str;
	private Integer code_sect;
	private Integer code_std;
	private String code_bailleur_fond;

	public Integer getCode_prj() {
		return this.code_prj;
	}

	public void setCode_prj(Integer code_prj) {
		this.code_prj = code_prj;
	}

	public LocalDate getDate_deb() {
		return this.date_deb;
	}

	public void setDate_deb(LocalDate date_deb) {
		this.date_deb = date_deb;
	}

	public LocalDate getDate_fin() {
		return this.date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public BigDecimal getCout_total() {
		return this.cout_total;
	}

	public void setCout_total(BigDecimal cout_total) {
		this.cout_total = cout_total;
	}

	public BigDecimal getFlag_diff() {
		return this.flag_diff;
	}

	public void setFlag_diff(BigDecimal flag_diff) {
		this.flag_diff = flag_diff;
	}

	public Integer getCode_str() {
		return this.code_str;
	}

	public void setCode_str(Integer code_str) {
		this.code_str = code_str;
	}

	public Integer getCode_sect() {
		return this.code_sect;
	}

	public void setCode_sect(Integer code_sect) {
		this.code_sect = code_sect;
	}

	public Integer getCode_std() {
		return this.code_std;
	}

	public void setCode_std(Integer code_std) {
		this.code_std = code_std;
	}

	public String getCode_bailleur_fond() {
		return this.code_bailleur_fond;
	}

	public void setCode_bailleur_fond(String code_bailleur_fond) {
		this.code_bailleur_fond = code_bailleur_fond;
	}


	public Projet(Integer code_prj, String des_prj, LocalDate date_deb, LocalDate date_fin, BigDecimal cout_total, BigDecimal flag_diff, Integer code_str, Integer code_sect, Integer code_std, String code_bailleur_fond) {
		this.code_prj = code_prj;
		this.des_prj = des_prj;
		this.date_deb = date_deb;
		this.date_fin = date_fin;
		this.cout_total = cout_total;
		this.flag_diff = flag_diff;
		this.code_str = code_str;
		this.code_sect = code_sect;
		this.code_std = code_std;
		this.code_bailleur_fond = code_bailleur_fond;
	}

	public Projet() {
	}


}
