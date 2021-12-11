/**
 * 
 */
package com.jsfspring.curddemo.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class EmployeeUITO implements Serializable {

	private static final long serialVersionUID = 4840260415183676656L;
	private Long shoeId;
	private String brand;
	private String model;
	private int price;
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


	@Override
	public String toString() {
		return "EmployeeUITO [shoeId=" + shoeId + ", brand=" + brand + ", model=" + model + ", price="
				+ String.valueOf(price) + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeUITO other = (EmployeeUITO) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		return true;
	}

}
