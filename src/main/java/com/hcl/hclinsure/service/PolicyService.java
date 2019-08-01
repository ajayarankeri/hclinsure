package com.hcl.hclinsure.service;

import org.springframework.stereotype.Service;

import com.hcl.hclinsure.dto.PoliciesOptDto;
import com.hcl.hclinsure.exception.NotCorrectInformationException;
import com.hcl.hclinsure.exception.ResourceNotFoundException;

@Service
public interface PolicyService {

	public String savePolicies(PoliciesOptDto policiesOptDto) throws ResourceNotFoundException,NotCorrectInformationException ;
}
