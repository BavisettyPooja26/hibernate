package com.nri;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
//	one to one restricts one customer class has one order
	@OneToMany(mappedBy="customers", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Orders> order;
	
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
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	public List<Orders> getOrder() {
		return order;
	}	
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	@Column(name="customercity")
	private String custcity;
	

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custcity=" + custcity + "]";
	}
	public Customer() {
		super();
	}

	
}
