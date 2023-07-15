package com.bank.web.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.web.models.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query(value="SELECT * FROM operation WHERE account_code = :code ORDER BY date_operation DESC", nativeQuery = true)
	public Page<Operation> listOperation(@Param("code") String code,PageRequest pageRequest);
}
