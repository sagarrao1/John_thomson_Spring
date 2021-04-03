package guru.springframework.services.jpaservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@Repository
@Profile("jpa")
@Transactional
public class ProductServiceJpaDaoImpl implements ProductService{
	
	@PersistenceContext
	EntityManager entityManager; 
	
	@Override
	public List<Product> listAllProducts() {		
		return entityManager.createQuery("from Product", Product.class).getResultList();
	}

	@Override
	public Product getProductById(Integer id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public Product saveOrUpdate(Product prd) {		
		Product savedProduct = entityManager.merge(prd);
		return savedProduct;
	}

	@Override
	public void deleteProductById(Integer id) {
		entityManager.remove(entityManager.find(Product.class, id));
		
	}

}
