package com.bank.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bank.web.customException.CustomerNotFoundException;
import com.bank.web.models.Account;
import com.bank.web.models.Checking;
import com.bank.web.models.Customer;
import com.bank.web.models.Operation;
import com.bank.web.service.BankService;
import jakarta.validation.Valid;



@Controller
//@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService iBank;
	

	
	
	@GetMapping("/index")
	public String index(Model model) {
		Account account = new Checking();
		account = null;
		model.addAttribute("account", account);
		
		return "home";
	}
	
	@GetMapping("/consultAccount")
	public String consult(Model model, String code,
			String sms,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="5")int size) {
		
		model.addAttribute("sms", sms);
		model.addAttribute("code", code);
		try {
			Account account = iBank.consultAccount(code);
			Page<Operation> pageOperations = iBank.listOperations(code, page, size);
			model.addAttribute("account",account);
			model.addAttribute("listOperations", pageOperations.getContent());
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("currentPage", page - 1);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("exception",e);
			
		}
		
		
		return "home";
	}
	
	
	@PostMapping("/saveOperation")
	public String create(Model model,
			             String operationType,
			             String code,
			             double amount,
			             String code2,
			             String sms) {
		
		try {
				if(operationType.equals("Credit")) {
					iBank.newCredit(code, amount);
				}else {
					if(operationType.equals("Debit")) {
						iBank.newDebit(code, amount);
					
					}else {
						
						if(operationType.equals("Transfer")) {
							
							iBank.transfer(code, code2, amount);
						}
					}
				}
		} catch (Exception e) {
			   
			    sms = e.getMessage();
			    
				return "redirect:/consultAccount?code="+code+"&sms="+sms;
		}
		
		
		return "redirect:/consultAccount?code="+code;
	}
	
	@GetMapping("/searchCustomer")
	public String search(Model model, Long id) {
		
		Customer cstm = iBank.searchCustomer(id);
		System.out.println(cstm.getEmail() + " " + cstm.getFirstName() +" " + cstm.getLastName());
		if(cstm != null) {
			model.addAttribute("customer",cstm);
		}

		
		return "home";
	}
	
	
	@GetMapping("/formCustomer")
	public String createCustomer(Model model) {
		Customer cstm = new Customer();
		model.addAttribute("customer", cstm);
		
		return "formCustomer";
	}
	
	
	@GetMapping("/formAccount")
	public String createAccount(Model model,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="5")int size) {
		Account account = new Checking();
		model.addAttribute("account", account);
		Page<Customer> customers = iBank.findAllCustomers(page,size);
		model.addAttribute("customers", customers);
		
		
		return "formAccount";
	}
	
	@GetMapping("/indexCustomers")
	public String indexCustomers(Model model,
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="8") int size,
			String message){
		    
		         model.addAttribute("message", message);
		try {
			Page<Customer> customers = iBank.findAllCustomers(page, size);
			model.addAttribute("customers", customers.getContent());
			int[] pages = new int[customers.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("currentPage", page);
		
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("exception",e);
		}
		
		
		return "indexCustomers";
	}
	
	
	@PostMapping("/saveCustomer")
	public String save(Model model,@Valid Customer customer, BindingResult bindingResult,
			String message) {
		if(bindingResult.hasErrors()) return "formCustomer";

		iBank.saveCustomer(customer);
	    message = "Successfull......!!!!";
		
		
		return "redirect:/indexCustomers?message="+message;
	}
	
	
	@GetMapping("/updateCustomer")
	public String update(Model model,Long id,
			@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue=" ")String keyword){
		    
		try {
			Customer cstm = iBank.searchCustomer(id);
			model.addAttribute("customer", cstm);
			model.addAttribute("page", page);
			model.addAttribute("keyword", keyword);
		} catch (CustomerNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("exception",e);
			
		}
		
		
		return "formUpdateCustomer";
	}
	
	
	@PostMapping("/saveAccount")
	public String create(Model model,@Valid Account account) {
		 
		System.out.println(account.getDateCreation());
		
		return "redirect:/indexAccount";
	}
	
	
	@GetMapping("/indexAccounts")
	public String indexAccounts(Model model,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="5")int size) {
		
		Page<Account> accounts = iBank.findAllAccount(page, size);
		model.addAttribute("accounts", accounts.getContent());
		int[] pages = new int[accounts.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("currentPage", page);
		
		
		return "indexAccounts";
	}
	
	
//	@GetMapping("/formUser")
//	public String createAppUser(Model model) {
//		AppUser appUser = new AppUser();
//		model.addAttribute("user", appUser);
//		
//		return "formUser";
//	}
//	
//	@PostMapping("/saveUser")
//	public String save(Model model,@Valid AppUser appUser,BindingResult bindingResult,
//			@RequestParam(defaultValue="0")int page,
//			@RequestParam(defaultValue="")String keyword) {
//		if(bindingResult.hasErrors()) return "formUser";
//		
//		customUser.addNewUser(appUser.getUsername(), appUser.getPassword(), appUser.getEmail(), appUser.getConfirmPassword());
//		model.addAttribute("page", page);
//		model.addAttribute("keyword", keyword);
//		
//		return "redirect:/bank/indexUsers?page="+page+"&keyword="+keyword;
//	}
	
}
