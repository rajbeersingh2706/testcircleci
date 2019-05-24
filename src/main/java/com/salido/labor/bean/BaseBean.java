package com.salido.labor.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class BaseBean {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	public Date getCreatedDate() {
		return getMutableDate(createdDate);
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = getMutableDate(createdDate);
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return getMutableDate(updatedDate);
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = getMutableDate(updatedDate);
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public BaseBean(Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.createdDate = new Date(createdDate.getTime());
		this.createdBy = createdBy;
		this.updatedDate = new Date(updatedDate.getTime());
		this.updatedBy = updatedBy;
	}

	public BaseBean() {

	}

	public Date getMutableDate(Date date) {
		return date != null ? (Date) date.clone() : null;
	}

}
