package com.cg.oma.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter
@ToString
@Table(name = "mobile")
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mobileId;

	@NotNull(message="Mobile Name should not be empty")
	private String mobileName;

	@Min(value=100, message="Mobile cost should not be less than 100")
	private float mobileCost;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate mfd;

	@NotNull(message="model no should not be empty")
	private String modelNumber;

	@NotNull(message="copany should not be empty")
	private String companyName;
	@JsonIgnoreProperties("mobileList")
	@ManyToOne
	private Category category;


	public Mobile() {
		super();

	}

	public Mobile(String mobileName,
			@Min(value = 100, message = "Mobile cost should not be less than 100") float mobileCost, LocalDate mfd,
			@NotNull(message = "model no should not be empty") String modelNumber,
			@NotNull(message = "copany should not be empty") String companyName, Category category
			) {
		super();

		this.mobileName = mobileName;
		this.mobileCost = mobileCost;
		this.mfd = mfd;
		this.modelNumber = modelNumber;
		this.companyName = companyName;
		this.category = category;

	}











}


