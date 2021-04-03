package guru.springframework.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class ProductServiceJpaDaoImplTest {

	@Autowired
	private ProductService service;
	
	@Test
	public void testListMethod() {
		List<Product> allProducts = service.listAllProducts();
		
		assertEquals(2, allProducts.size());
//		assert allProducts.size()==2;
		
	}
	
	
	
}
