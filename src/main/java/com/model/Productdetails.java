package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
@Entity

public class Productdetails implements Serializable
 {
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//pid-automatic generate
	private String pname;
	private String description;
	private Float price;
	private int stock;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private Categorydetails  categorydetails;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sid")
	private Supplierdetails supplierdetails;
	
	
	
	
	@Transient
	MultipartFile pimage;
	public String imgname;
	
	public int getId()
	{return id;}
	
	
	public void setId(int id)
	{this.id=id;}
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public Categorydetails getCategorydetails() {
		return categorydetails;
	}

	public void setCategorydetails(Categorydetails categorydetails) {
		this.categorydetails = categorydetails;
	}

	public Supplierdetails getSupplierdetails() {
		return supplierdetails;
	}

	public void setSupplierdetails(Supplierdetails supplierdetails) {
		this.supplierdetails = supplierdetails;
	}

/*	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
*/

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
}
