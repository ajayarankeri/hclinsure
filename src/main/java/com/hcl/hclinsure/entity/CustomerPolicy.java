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
@Table(name="Customer_policy")
@Data
public class CustomerPolicy {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Customer_policy_id")
	private Long CustomerPolicyId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="policy_id")
	private Policy policyId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private Customer customerId;
		
	@Column(name="policy_start_date")
	private LocalDate policyStartDate;
	
	@Column(name="policy_end_date")
	private LocalDate policyEndDate;
	
	@Column(name="policy_frequency")
	private String policyFrequency;
	
	@Column(name="policy_total_amount")
	private Double policyTotalAmount;
	
	@Column(name="policy_premium_amount")
	private Double policyPremiumAmount;
	
	@Column(name="policy_maturity_amount")
	private Double policyMaturityAmount;
	
	@Column(name="terms_and_condition_status")
	private int termsAndConditionStatus;
		
}
