package com.hcl.hclinsure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.hclinsure.dto.PoliciesOptDto;
import com.hcl.hclinsure.dto.ReportDto;
import com.hcl.hclinsure.dto.ResponseDto;
import com.hcl.hclinsure.exception.NotCorrectInformationException;
import com.hcl.hclinsure.exception.ResourceNotFoundException;

@Service
public interface PolicyService {

	public List<ReportDto> analysisReport(String type) throws ResourceNotFoundException;
	
	ResponseDto  policyList() throws ResourceNotFoundException;

	ResponseDto getPolicyDetails(Long policyId) throws ResourceNotFoundException;

	public String savePolicies(PoliciesOptDto policiesOptDto) throws ResourceNotFoundException,NotCorrectInformationException ;
}
