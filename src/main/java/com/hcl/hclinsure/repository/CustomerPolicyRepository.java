package com.hcl.hclinsure.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.hclinsure.entity.Customer;
import com.hcl.hclinsure.dto.CustomerPolicyDto;
import com.hcl.hclinsure.entity.CustomerPolicy;
import com.hcl.hclinsure.entity.Policy;

@Repository
public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicy, Long>{
	
	@Query(value="select new com.hcl.hclinsure.dto.CustomerPolicyDto(c.customerId.customerId,c.policyId.policyId,c.policyStartDate,c.policyTotalAmount) from CustomerPolicy c where c.customerId.customerId=:id")
	public List<CustomerPolicyDto> findAllPolicies(@PathParam("id") long id);

	public CustomerPolicy findByCustomerIdAndPolicyId(Customer customer,Policy policy);
}
