package com.hcl.hclinsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hclinsure.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
