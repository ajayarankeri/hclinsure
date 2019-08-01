package com.hcl.hclinsure.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.hclinsure.dto.ResponseDto;
import com.hcl.hclinsure.entity.Policy;
import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.repository.PolicyRepository;
import com.hcl.hclinsure.service.PolicyService;

@Component
public class PolicyServiceImpl implements PolicyService{

	
	@Autowired
	PolicyRepository policyRepository;
	
	
	@Override
	public ResponseDto getPolicyDetails(Long policyId) throws ResourceNotFoundException {
		Policy policyDetails=policyRepository.findById(policyId).orElseThrow(()->new ResourceNotFoundException("Policy Not Available"));
		return new ResponseDto("sucess", 200, policyDetails);
	}


	@Override
	public ResponseDto policyList() throws ResourceNotFoundException {
	 List<Policy> policyList =policyRepository.findAll(); 
	 if(policyList.isEmpty()) {
	    	throw new ResourceNotFoundException("No policy list result found");
	    }
		
		return  new ResponseDto("sucess", 200 , policyList);
	}
	
	
}