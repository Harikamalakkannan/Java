package com.productsDB.productsDB.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "category_type")
public class CategoryType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categorytype_id")
	private UUID categoryTypeId;

	@Column(name = "categorytype_name")
	private String categoryTypeName;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "created_by")
	private String cretaedBy;

	@Column(name = "updated_on")
	private Date updateOn;

	@Column(name = "updated_by")
	private String updatedBy;

	public UUID getCategoryTypeId() {
		return categoryTypeId;
	}

	public void setCategoryTypeId(UUID categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	public String getCategoryTypeName() {
		return categoryTypeName;
	}

	public void setCategoryTypeName(String categoryTypeName) {
		this.categoryTypeName = categoryTypeName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCretaedBy() {
		return cretaedBy;
	}

	public void setCretaedBy(String cretaedBy) {
		this.cretaedBy = cretaedBy;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public ProductType getProducttype() {
		return producttype;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
}

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "producttype_id", referencedColumnName = " producttype_id", nullable = false)
	private ProductType producttype;
	
}
