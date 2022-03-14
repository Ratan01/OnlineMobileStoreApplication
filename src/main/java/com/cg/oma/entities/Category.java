package com.cg.oma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString

public class Category {
	@Id
	private int categoryId;
	private String categoryName;


	public Category() {
		super();

	}

	public Category(int categoryId, String categoryName ) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;

	}




}
