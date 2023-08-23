package com.plugsity.com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.style.ToStringCreator;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class AbstractBaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created_Datetime")
	@CreationTimestamp
	private Date createdTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Updated_Datetime")
	@CreationTimestamp
	private Date updatedTime;
	
	@Column(name = "Created_By")
	private String createdBy;
	
	@Column(name = "Updated_By")
	private String updatedBy;
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}



	public Date getUpdatedTime() {
		return updatedTime;
	}



	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	@Override
	public String toString() {
		return new ToStringCreator(this).append(createdBy).append(createdTime).append(updatedBy).append(updatedTime).toString();
		
	}
}
