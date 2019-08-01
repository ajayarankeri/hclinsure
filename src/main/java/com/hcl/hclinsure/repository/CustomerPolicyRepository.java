package com.hcl.hclinsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hclinsure.entity.Customer;
import com.hcl.hclinsure.entity.CustomerPolicy;
import com.hcl.hclinsure.entity.Policy;

@Repository
public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicy, Long>{

	public CustomerPolicy findByCustomerIdAndPolicyId(Customer customer,Policy policy);
}
