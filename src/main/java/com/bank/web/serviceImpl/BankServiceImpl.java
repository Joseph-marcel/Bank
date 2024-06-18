package com.bank.web.serviceImpl;



import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bank.web.customException.AccountNotFoundException;
import com.bank.web.customException.CustomerNotFoundException;
import com.bank.web.customException.InsuffisantBalanceException;
import com.bank.web.models.Account;
import com.bank.web.models.Checking;
import com.bank.web.models.Credit;
import com.bank.web.models.Customer;
import com.bank.web.models.Debit;
import com.bank.web.models.Operation;
import com.bank.web.repositories.AccountRepository;
import com.bank.web.repositories.CustomerRepository;
import com.bank.web.repositories.OperationRepository;
import com.bank.web.service.BankService;

@Service
@Transactional
public class BankServiceImpl implements BankService{
	
	@Autowired
	private CustomerRepository cstmRepo;
	
	@Autowired
	private AccountRepository actRepo;
	
	@Autowired
	private OperationRepository optRepo;
	
	

	@Override
	public Customer createCustomer(Customer cstm) {
		// TODO Auto-generated method stub
		
		
		return cstmRepo.save(cstm);
	}

	@Override
	public Customer searchCustomer(Long id) {
		// TODO Auto-generated method stub
		Customer cstm = cstmRepo.findById(id).orElse(null);
		if(cstm == null) throw new CustomerNotFoundException("The customer does not exist...!!!!");
		
		return cstm;
	}

	@Override
	public Customer modifyCustomer(Long id, Customer cstm) {
		// TODO Auto-generated method stub
		Customer existingCstm = searchCustomer(id);
		existingCstm.setEmail(cstm.getEmail());
		existingCstm.setFirstName(cstm.getFirstName());
		existingCstm.setLastName(cstm.getLastName());
		
		return cstmRepo.save(existingCstm);
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		Customer cstm = searchCustomer(id);
		cstmRepo.delete(cstm);
	}

	@Override
	public Account addAccount(Account act) {
		// TODO Auto-generated method stub
		
		return actRepo.save(act);
	}

	@Override
	public Account consultAccount(String code) {
		// TODO Auto-generated method stub
		Account account = actRepo.findById(code).orElse(null);
		if(account == null) throw new AccountNotFoundException("Account not found");
		 
		return account;
	}

	

	@Override
	public void newCredit(String code, double amount) {
		// TODO Auto-generated method stub
		Account act = consultAccount(code);
		Credit cdt = new Credit(new Date(), amount, act);
		optRepo.save(cdt);
		act.setBalance(act.getBalance() + amount);
		actRepo.save(act);
	}

	
	@Override
	public void newDebit(String code, double amount) {
		// TODO Auto-generated method stub
		Account act = consultAccount(code);
		double overall = 0;
		if(act instanceof Checking)
			overall = ((Checking) act).getOverDraft();
		if((act.getBalance() + overall) < amount) throw new InsuffisantBalanceException("Insuffisant balance");
		Debit dt = new Debit(new Date(), amount, act);
		optRepo.save(dt);
		act.setBalance(act.getBalance() - amount);
		actRepo.save(act);
	}

	@Override
	public void transfer(String code, String code2, double amount) {
		// TODO Auto-generated method stub
		
		if(code.equals(code2)) throw new RuntimeException("Impossible transfer from the same account...!!!");
			
		newDebit(code, amount);
		newCredit(code2, amount);
	}

	@Override
	public Page<Operation> listOperations(String code, int page, int size) {
		// TODO Auto-generated method stub
		return optRepo.listOperation(code, PageRequest.of(page, size));
	}


	@Override
	public Account modifyAccount(String code, Account act) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(String act) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer saveCustomer(Customer cstm) {
		// TODO Auto-generated method stub
		Customer savedCustomer;
		if(cstm.getId() == null) {
			savedCustomer = this.createCustomer(cstm);
		}else {
			savedCustomer = this.modifyCustomer(cstm.getId(), cstm);
		}
		
		return savedCustomer;
	}

	@Override
	public Page<Customer> listCustomers(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return cstmRepo.findAll();
	}

	@Override
	public Account saveAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> findAllAccount(int page, int size) {
		// TODO Auto-generated method stub
		return actRepo.findAll(PageRequest.of(page, size));
	}

}
