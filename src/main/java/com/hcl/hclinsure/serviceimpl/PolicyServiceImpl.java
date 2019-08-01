package com.hcl.hclinsure.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.hclinsure.entity.Policy;
import com.hcl.hclinsure.repository.PolicyRepository;
import com.hcl.hclinsure.service.PolicyService;

@Component
public class PolicyServiceImpl implements PolicyService{

	
	@Autowired
	PolicyRepository policyRepository;
	
	
	@Override
	 public List<Policy> policyList(){
	
		return policyRepository.findAll();
		
	}
}