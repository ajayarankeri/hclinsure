package com.hcl.hclinsure.dto;

import lombok.Data;

@Data
public class PoliciesOptDto {
	private long policyId;
	private long userId;
	private String termAndConditions;
	private long sumAssured;
}
