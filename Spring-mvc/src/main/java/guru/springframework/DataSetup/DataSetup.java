package guru.springframework.DataSetup;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Customer;
import guru.springframework.domain.Product;
import guru.springframework.services.CustomerService;
import guru.springframework.services.ProductService;

//commenting it as we are using data setup using data.sql in resources folder

//@Component
public class DataSetup implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProductData();
		loadCustomertData();
		
	}
	
	private void loadProductData() {
		
		Product p1 = new Product();
		p1.setDescription("Product 1");
		p1.setId(1);
		p1.setImageUrl("http:Lister.com/Product 1");
		p1.setPrice(new BigDecimal(45.23));
		
		productService.saveOrUpdate(p1);
		

		Product p2 = new Product();
		p2.setDescription("Product 2");
		p2.setId(2);
		p2.setImageUrl("http:Lister.com/Product 2");
		p2.setPrice(new BigDecimal(22.78));
		
		productService.saveOrUpdate(p2);		
	}
	
	private void loadCustomertData() {
		
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setAddress1("Npr");
		c1.setCity("KNR");
		c1.setEmail("sagar@gmail.com");
		c1.setName("Sagar_A");
		c1.setPhone("998902727");
		c1.setState("TS");
		
		customerService.saveOrUpdate(c1);
		

		Customer c2 = new Customer();
		c2.setId(2);
		c2.setAddress1("Npr");
		c2.setCity("KNR");
		c2.setEmail("sagar@gmail.com");
		c2.setName("Mahesh");
		c2.setPhone("9989033");
		c2.setState("TS");
		
		customerService.saveOrUpdate(c2);
		

		
	}


}
