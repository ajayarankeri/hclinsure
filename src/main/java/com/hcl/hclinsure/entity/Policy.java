package com.hcl.hclinsure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="policy")
@Data
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="policy_id")
	private Long policyId;	
	
	@Column(name="policy_name")	
	private String policyName;
	
	@Column(name="policy_period")	
	private int policyPeriod;
	
	@Column(name="policy_from_age")	
	private int policyFromAge;
	
	@Column(name="policy_to_age")	
	private int policyToAge;
	
	@Column(name="policy_base_amount")	
	private Double policyBaseAmount;
	
	@Column(name="policy_offer")	
	private String policyOffer;
	
	@Column(name="terms_and_condition")	
	private String termsAndCondition;
}
