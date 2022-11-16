package com.nri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//->gets converted into a table in dbms 
@Entity
//gets a table named tblcustomer
@Table(name="tblcustomer")
public class Customer {
	@Id
	@Column(name="customerid")
	private int custid;
	
	@Column(name="customername")
	private String custname; 
	
	private Orders order;
	
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	@Column(name="customercity")
	private String custcity;
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustcity() {
		return custcity;
	}
	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custcity=" + custcity + "]";
	}
	public Customer() {
		super();
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
}
