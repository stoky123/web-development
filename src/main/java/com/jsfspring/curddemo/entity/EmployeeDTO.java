/**
 * 
 */
package com.jsfspring.curddemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

/**
 * @author s727953
 *
 */

@Entity
@Table(name = "SHOE_INFO")
@NamedQuery(name = "EmployeeDTO.findAll", query = "SELECT a FROM EmployeeDTO a")
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long shoeId;
	@Column(name = "BRAND", nullable = false)
	private String brand;
	@Column(name = "MODEL", nullable = false)
	private String model;
	@Column(name = "PRICE", nullable = false)
	private int price;
	@Column(name = "DESCRIPTION")
	private String description;

	public Long getShoeId() {
		return shoeId;
	}

	public void setShoeId(Long shoeId) {
		this.shoeId = shoeId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
