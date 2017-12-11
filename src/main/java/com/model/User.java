package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	@Id
	@NotNull(message="Email Id cannot be blank")
	@Pattern(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$",message="Email ID is not in proper format")
	private String email;
	
	@NotNull(message="Name cannot be blank")
	//@Size(min=8,max=15)
	private String name;
	
	@NotNull(message="Password cannot be blank")
	//@Size(min=8,max=15)
	private String password;
	private boolean enabled;
	private String role;

	@NotNull(message="City cannot be blank")
	private String city;
	
	@NotNull(message="Mobile Number cannot be cannot be blank")
	//@Size(min=10,max=10)
	//@Pattern(regexp="[789]\\d{9}",message="Mobile Number is not in proper format")
	private String phone;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
