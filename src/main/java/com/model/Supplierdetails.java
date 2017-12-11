package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.springframework.stereotype.Component;

@Entity
@Component

public class Supplierdetails {
	@Id
private int sid;
	private String sname;
	@OneToMany(targetEntity=Productdetails.class, fetch=FetchType.EAGER,mappedBy="supplierdetails")
	private Set<Productdetails>productdetails=new HashSet<Productdetails>(0);
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname= sname;
	}
	
}
