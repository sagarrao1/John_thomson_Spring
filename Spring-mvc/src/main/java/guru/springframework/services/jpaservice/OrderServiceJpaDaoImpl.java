package guru.springframework.services.jpaservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.Order;
import guru.springframework.services.OrderService;

@Repository
@Transactional
@Profile("jpa")
public class OrderServiceJpaDaoImpl implements OrderService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Order> listAll() {
		return entityManager.createQuery("from Order", Order.class).getResultList();
	}

	@Override
	public Order getById(Integer id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public Order saveOrUpdate(Order order) {
		return entityManager.merge(order);
	}

	@Override
	public void delete(Integer id) {
		entityManager.remove(entityManager.find(Order.class, id));

	}

//	public Order getByCustomerId(Integer id) {
//		return entityManager.createQuery(" from Order where customer_id="+id);
//	}
}
