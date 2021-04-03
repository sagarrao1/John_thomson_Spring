package guru.springframework.services.mapservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@Service
@Profile("map")
public class ProductServiceImpl implements ProductService {

	private Map<Integer, Product> products;	

	public ProductServiceImpl() {
		loadProducts();
	}

	private void loadProducts() {
		
		products= new HashMap<>();
		
		Product product1 = new Product();
		product1.setId(1);
		product1.setDescription("Product 1");
		product1.setPrice(new BigDecimal("12.99"));
		product1.setImageUrl("http://example.com/product1");

		products.put(1, product1);
		
		
		Product product2 = new Product();
		product2.setId(2);
		product2.setDescription("Product 2");
		product2.setPrice(new BigDecimal("6.99"));
		product2.setImageUrl("http://example.com/product2");

		products.put(2, product2);
		
		Product product3 = new Product();
		product3.setId(3);
		product3.setDescription("Product 3");
		product3.setPrice(new BigDecimal("32.99"));
		product3.setImageUrl("http://example.com/product3");

		products.put(3, product3);
		
		Product product4 = new Product();
		product4.setId(4);
		product4.setDescription("Product 4");
		product4.setPrice(new BigDecimal("42.99"));
		product4.setImageUrl("http://example.com/product4");

		products.put(4, product4);
	}
	
	@Override
	public List<Product> listAllProducts() {
		return new ArrayList<>(products.values());
	}

	@Override
	public Product getProductById(Integer id) {
		return products.get(id);
	}

	@Override
	public Product saveOrUpdate(Product product) {
		
//		System.out.println("saveOrUpdate in Impl");
//		System.out.println(product);
		
		if (product != null) {
			if(product.getId() == null) {
				product.setId(getNextKey());
			}

			products.put(product.getId(),product);
			
			return product;
			
		} else {
			
			throw new RuntimeException("Product can't be null");
		}
		
	}
	
	
	private Integer getNextKey() {		
		return Collections.max(products.keySet())+ 1;
	}

	@Override
	public void deleteProductById(Integer id) {
		products.remove(id);
		
	}
	
}
