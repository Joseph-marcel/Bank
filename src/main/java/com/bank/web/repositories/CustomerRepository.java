package com.bank.web.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.web.models.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
}
