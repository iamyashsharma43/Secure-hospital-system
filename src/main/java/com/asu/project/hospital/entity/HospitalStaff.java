package com.asu.project.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hospital_staff")
public class HospitalStaff {
	
	@Id
    @Column(name = "hospitalStaffID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long hospitalStaffID;
	
	@OneToOne
	@JoinColumn(name="userId", nullable=false)
	private User user;
	
	@Column(name="phoneNumber")
	private Long phoneNumber;
	
	@Column(name="address")
	private String address;

	public HospitalStaff(User user, Long phoneNumber, String address) {
		super();
		this.user = user;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public HospitalStaff() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
