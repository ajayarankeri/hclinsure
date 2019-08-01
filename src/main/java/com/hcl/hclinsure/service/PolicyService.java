package com.hcl.hclinsure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.hclinsure.entity.Policy;


@Service
public interface PolicyService  {
	
	
	 public List<Policy> policyList();

	 
}
