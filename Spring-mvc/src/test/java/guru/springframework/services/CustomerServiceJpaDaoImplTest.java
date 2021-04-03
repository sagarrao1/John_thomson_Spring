package guru.springframework.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Customer;
import guru.springframework.domain.User;
import guru.springframework.services.security.EncryptionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class CustomerServiceJpaDaoImplTest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EncryptionService encryptService;
	
	@Test
	public void testListMethod() {
		List<Customer> customers = (List<Customer>) customerService.listAll();
		
		assertEquals(2, customers.size());
		
	}
	
	@Test
	public void testsaveWithuser() {
		
		Customer customer = new Customer();
		User user= new User();
		user.setUserName("customer user");
		user.setPassword("awesome password");
		
		customer.setUser(user);
		
		Customer savedCustomer = customerService.saveOrUpdate(customer);
		
		System.out.println("saved customer user id: "+savedCustomer.getUser());
		
		System.out.println("customer obj: "+savedCustomer);
		assertNotNull(savedCustomer.getUser().getId());
		
		
		assertTrue("password is not same", encryptService.checkPassword("awesome password", savedCustomer.getUser().getEncryptedPassword()));
	}
	
	
}
