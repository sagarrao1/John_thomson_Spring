package guru.springframework.services.jpaservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.Customer;
import guru.springframework.domain.Order;
import guru.springframework.domain.OrderLine;
import guru.springframework.services.CustomerService;
import guru.springframework.services.OrderService;
import guru.springframework.services.security.EncryptionService;

@Repository
@Profile("jpa")
@Transactional
public class CustomerServiceJpaDaoImpl implements CustomerService{
	
	@Autowired
	EncryptionService encryptionService;

	@Autowired
	OrderService orderService;
	
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
	public Customer saveOrUpdate(Customer customer) {
		
		if(customer.getUser() != null && customer.getUser().getPassword() != null) {
			customer.getUser().setEncryptedPassword(encryptionService.encrpytString(customer.getUser().getPassword()));
			
//			System.out.println("** in saveOrUpdate menthod");
			
//			System.out.println("customer plain password :"+customer.getUser().getPassword());
//			System.out.println("customer  encrypted password :"+customer.getUser().getEncryptedPassword());

		}

		
		Customer savedCustomer = entityManager.merge(customer);
		return savedCustomer;
	}

	@Override
	public void delete(Integer id) {
//		List<Order> orders = (List<Order>) orderService.listAll();
//		
//		Order gotOrder=null;
//		
//		for (Order order : orders) {
//			if (order.getCustomer().getId() == id) {
//				gotOrder=order;
//				System.out.println("gotOrder id: "+gotOrder.getId());
//			}
//		}
//		
//		if (gotOrder!=null) {
//			
//			List<OrderLine> orderLines = gotOrder.getOrderLines();
//			for (OrderLine orderLine : orderLines) {
//				gotOrder.removeOrderDetail(orderLine);
//			}
//			
//		}
//		
		
		entityManager.remove(entityManager.find(Customer.class, id));
	}

}
