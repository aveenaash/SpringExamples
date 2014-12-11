package com.packt.webstore.persistence.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity(name = "PRODUCT")
public class ProductOld {


		@Id
		private int id;
		
		@Column(name = "PRODUCTID")
		private String productId;
		

		private String name;
		
		@Column(name = "PRICEPERUNIT")
		private BigDecimal unitPrice;
		private String description;
		private String manufacturer;
		private String category;
		private long unitsInStock;
		private long unitsInOrder;
		private boolean discontinued;
		private String condition;

		@Transient
		private MultipartFile  productImage;

		public ProductOld() {
			super();
	}

		public ProductOld(String productId, String name, BigDecimal unitPrice) {
			this.productId = productId;
			this.name = name;
			this.unitPrice = unitPrice;
		}

		public int getId() {
			return  id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
		}

		public String getDescription() {
			return description;
		}

 
		public MultipartFile getProductImage() {
			return productImage;
		}

		public void setProductImage(MultipartFile productImage) {
			this.productImage = productImage;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public long getUnitsInStock() {
			return unitsInStock;
		}

		public void setUnitsInStock(long unitsInStock) {
			this.unitsInStock = unitsInStock;
		}

		public long getUnitsInOrder() {
			return unitsInOrder;
		}

		public void setUnitsInOrder(long unitsInOrder) {
			this.unitsInOrder = unitsInOrder;
		}

		public boolean isDiscontinued() {
			return discontinued;
		}

		public void setDiscontinued(boolean discontinued) {
			this.discontinued = discontinued;
		}
		
		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProductOld other = (ProductOld) obj;
			if (productId == null) {
				if (other.productId != null)
					return false;
			} else if (!productId.equals(other.productId))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((productId == null) ? 0 : productId.hashCode());
			return result;
		}

		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + name + "]";
		}


}
