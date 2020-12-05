package guru.springframework.services;

import java.util.List;
import guru.springframework.domain.Product;

public interface ProductService {
	
	public List<Product> listAllProducts();

	public Product getProductById(Integer id);
	
	public Product saveOrUpdate(Product prd);

	public void deleteProductById(Integer id); 

}
