package com.hcl.hclinsure.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerPolicyDto {

	
	
	private long policyId;
	
	
	private long customerId;

	private LocalDate policyStartDate;
	private Double policyTotalAmount;
	
}
