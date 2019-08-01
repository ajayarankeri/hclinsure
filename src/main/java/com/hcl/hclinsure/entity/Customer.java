package com.hcl.hclinsure.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;	
	
	@Column(name="full_name")	
	private String fullName;
	
	@Column(name="customer_age")	
	private int customerAge;
	
	@Column(name="customer_gender")	
	private String customerGender;
	
	@Column(name="customer_email")	
	private String customerEmail;
	
	@Column(name="customer_address")	
	private String customerAddress;
	
	@Column(name="customer_date_of_birth")	
	private LocalDate customerDateOfBirth;
	
	@Column(name="customer_phone_number")	
	private Long customerPhoneNumber;
	
	
}
