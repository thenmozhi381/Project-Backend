package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.springframework.stereotype.Component;

@Entity
@Component

public class Categorydetails implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	@OneToMany(targetEntity=Productdetails.class, fetch=FetchType.EAGER,mappedBy="categorydetails")
	private Set<Productdetails>productdetails=new HashSet<Productdetails>(0);

	
	
	
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
}


