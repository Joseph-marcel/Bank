package com.bank.web.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bank.web.models.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query(value="SELECT * FROM customer", nativeQuery = true)
	public Page<Customer> listOfCustomers(PageRequest pageRequest);
}
