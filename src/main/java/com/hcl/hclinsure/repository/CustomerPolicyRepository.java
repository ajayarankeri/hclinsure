package com.hcl.hclinsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hclinsure.entity.CustomerPolicy;

@Repository
public interface CustomerPolicyRepository extends JpaRepository<CustomerPolicy, Long>{

}
