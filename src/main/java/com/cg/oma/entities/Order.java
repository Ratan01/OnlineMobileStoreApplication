package com.cg.oma.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//private List<OrderedMobile> orderedMobile;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate orderDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dispatchDate;

	@Min(value = 1, message = "Minimum cart value can't be zero or negative")
	private int quantity;

	@Min(value = 1)
	private int totalCost;

//	private Customer customer;

	@NotNull(message = "Status can't be Not Null")
	private String status;

	public Order() {
		super();
	}

	public Order(int orderId, LocalDate orderDate, LocalDate dispatchDate, int quantity, int totalCost,
			String status) {
		super();
		this.orderId = orderId;
		//this.orderedMobile = orderedMobile;
		this.orderDate = orderDate;
		this.dispatchDate = dispatchDate;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.status = status;
	}

}
