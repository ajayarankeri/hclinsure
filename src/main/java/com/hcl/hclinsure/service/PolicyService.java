package com.hcl.hclinsure.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hcl.hclinsure.dto.ReportDto;
import com.hcl.hclinsure.dto.ResponseDto;
import com.hcl.hclinsure.exception.ResourceNotFoundException;


@Component
public interface PolicyService  {
	
	public List<ReportDto> analysisReport(String type) throws ResourceNotFoundException;
	
	ResponseDto  policyList() throws ResourceNotFoundException;

	ResponseDto getPolicyDetails(Long policyId) throws ResourceNotFoundException;

}
