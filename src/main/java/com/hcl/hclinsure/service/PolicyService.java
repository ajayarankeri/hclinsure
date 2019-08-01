package com.hcl.hclinsure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.hclinsure.entity.Policy;

import com.hcl.hclinsure.dto.ResponseDto;
import com.hcl.hclinsure.exception.ResourceNotFoundException;


@Service
public interface PolicyService  {
	
	
	 public List<Policy> policyList();

	ResponseDto getPolicyDetails(Long policyId) throws ResourceNotFoundException;

}
