package guru.springframework.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.Customer;

@Repository
@Profile("jpa")
@Transactional
public class CustomerServiceJpaDaoImpl implements CustomerService{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Customer> listAll() {
		return entityManager.createQuery("from Customer", Customer.class).getResultList();
	}

	@Override
	public Customer getById(Integer id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public Customer saveOrUpdate(Customer domainObject) {
		return entityManager.merge(domainObject);
	}

	@Override
	public void delete(Integer id) {
		entityManager.remove(entityManager.find(Customer.class, id));
	}

}
