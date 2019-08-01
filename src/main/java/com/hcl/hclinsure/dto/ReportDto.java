package com.hcl.hclinsure.dto;

import lombok.Data;

@Data
public class ReportDto {

	private int policyId;
	private String policyName;
	private int policyCount;
	private double policyPercentage;
}
