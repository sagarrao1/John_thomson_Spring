package guru.springframework.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Cart;
import guru.springframework.domain.CartDetail;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Product;
import guru.springframework.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class UserServiceJpaDaoImplTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Test
	public void testSaveOfUser() {
		
		User user= new User();
		
		user.setUserName("Sagar");
		user.setPassword("myPassword");		
		User savedUser = userService.saveOrUpdate(user);
		
		assertNotNull(savedUser.getId());
		assertNotNull(savedUser.getEncryptedPassword());
		
		System.out.println("user id :"+savedUser.getId());
		System.out.println("encrypted passsword :"+savedUser.getEncryptedPassword());
		
	}
	
	
	@Test
	public void testSaveOfUserWithCustomer() {
		
		User user= new User();
		
		user.setUserName("Mike");
		user.setPassword("myPassword");		
		
		Customer customer =  new Customer();
		customer.setName("Mike customer storing with User");
		
		user.setCustomer(customer);
				
		User savedUser = userService.saveOrUpdate(user);
		
		assertNotNull(savedUser.getId());
		assertNotNull(savedUser.getEncryptedPassword());
		
		assertNotNull(savedUser.getCustomer().getId());
		assertNotNull(savedUser.getCustomer().getName());
				
		System.out.println("user id :"+savedUser.getId());
		System.out.println("encrypted passsword :"+savedUser.getEncryptedPassword());
		
		System.out.println("customer id: "+savedUser.getCustomer().getId());
		System.out.println("customer name : "+savedUser.getCustomer().getName());
		
	}
	
	
	@Test
	public void testAddCarttoUser() {
		
		User user= new User();
		
		user.setUserName("Ram");
		user.setPassword("myPassword");		
		
		user.setCart(new Cart());
		 
		User savedUser = userService.saveOrUpdate(user);
		
		assertNotNull(savedUser.getId());
		assertNotNull(savedUser.getEncryptedPassword());
		
		assertNotNull(savedUser.getCart());
		
			
	}
	
	@Test
	public void testAddCartToUserWithCartDetails() {
		
		User user= new User();
		
		user.setUserName("Suresh");
		user.setPassword("myPassword");		
		
		user.setCart(new Cart());
		
		List<Product> storedProducts  = productService.listAllProducts();
		
		CartDetail detail1= new CartDetail();		
		detail1.setProduct(storedProducts.get(0));
		user.getCart().addCartDetail(detail1);
		 
		CartDetail detail2= new CartDetail();
		detail2.setProduct(storedProducts.get(1));
		user.getCart().addCartDetail(detail2);		
		
		User savedUser = userService.saveOrUpdate(user);
		
		assertEquals(2, savedUser.getCart().getCartDetails().size());
		
		savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));
		
		assertEquals(1, savedUser.getCart().getCartDetails().size());
		
			
	}

	
}
