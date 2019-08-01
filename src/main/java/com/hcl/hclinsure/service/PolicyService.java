package com.hcl.hclinsure.service;

import org.springframework.stereotype.Service;

import com.hcl.hclinsure.dto.ResponseDto;
import com.hcl.hclinsure.exception.ResourceNotFoundException;

@Service
public interface PolicyService {

	ResponseDto getPolicyDetails(Long policyId) throws ResourceNotFoundException;

}
