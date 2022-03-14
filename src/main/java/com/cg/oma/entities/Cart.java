package com.cg.oma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int quantity;
	private int cost;
	
	
	public Cart(int cartId, int quantity, int cost) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.cost = cost;
	}
	public Cart() {
		super();
	}
}
