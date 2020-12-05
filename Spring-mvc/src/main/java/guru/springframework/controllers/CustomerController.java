package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.domain.Customer;
import guru.springframework.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customers")
	public String listCustomers(Model model) {		
		model.addAttribute("customers", customerService.listAll());		
		
		return "cust/customers";
	}
	

	@RequestMapping("/customer/{id}")
	public String getCustomer(@PathVariable Integer id, Model model) {		
		model.addAttribute("customer", customerService.getById(id));
		
		return "cust/customer";
	}
	
	
	@RequestMapping("/customer/new")
	public String addCustomer(Model model) {		
		model.addAttribute("customer", new Customer());
		
		return "cust/customerForm";
	}

	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String addCustomer(Customer customer) {				
		Customer savedCustomer = customerService.saveOrUpdate(customer);		
		
		return "redirect:/customer/" + savedCustomer.getId();
	}
	

	@RequestMapping("/customer/edit/{id}")
	public String editCustomer(@PathVariable Integer id, Model model) {		
		model.addAttribute("customer", customerService.getById(id));
		
		return "cust/customerForm";
	}
	
	
	@RequestMapping("/customer/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id, Model model) {		
		customerService.delete(id);
		
		return "redirect:/customers";
	}

}
