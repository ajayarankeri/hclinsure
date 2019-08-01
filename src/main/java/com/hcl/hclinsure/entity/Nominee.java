package com.hcl.hclinsure.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="nominee")
@Data
public class Nominee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nominee_id")
	private Long nomineeId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Customer_policy_id")
	private CustomerPolicy CustomerPolicyId;
	
	@Column(name="nominee_name")	
	private String nomineeName;
	
	@Column(name="nominee_age")	
	private int nomineeAge;
	
	@Column(name="nominee_gender")	
	private String nomineeGender;
	
	@Column(name="nominee_email")	
	private String nomineeEmail;
		
	@Column(name="nominee_address")	
	private String nomineeAddress;
	
	@Column(name="nominee_date_of_birth")	
	private LocalDate nomineeDateOfBirth;
	
	@Column(name="nominee_phone_number")	
	private Long nomineePhoneNumber;
	
	
	
	
	

}
