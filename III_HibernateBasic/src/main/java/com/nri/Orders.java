package com.nri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//
@Entity
//if name not specified it creates a table with class name
@Table(name="tblborder")
public class Orders {
	
	@Id
	@Column(name="orderid")
	//if name not specified it creates a column with variable name
	private int ordid;
	@Column(name="ordername")
	private String ordname;
	@Column(name="orderprice")
	private double ordprice;
	
	
	@ManyToOne
	private Customer customers;
	
	public Customer getCustomer() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers=customers;
	}
	
	public int getOrdid() {
		return ordid;
	}
	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	public String getOrdname() {
		return ordname;
	}
	public void setOrdname(String ordname) {
		this.ordname = ordname;
	}
	public double getOrdprice() {
		return ordprice;
	}
	public void setOrdprice(double ordprice) {
		this.ordprice = ordprice;
	}
	@Override
	public String toString() {
		return "Orders [ordid=" + ordid + ", ordname=" + ordname + ", ordprice=" + ordprice + "]";
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

