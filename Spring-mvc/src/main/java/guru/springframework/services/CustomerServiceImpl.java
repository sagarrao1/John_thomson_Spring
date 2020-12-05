package guru.springframework.services;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Customer;
import guru.springframework.domain.DomainObject;

@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}

	@Override
	public Customer getById(Integer id) {
		return (Customer) super.getById(id);
	}

	@Override
	public Customer saveOrUpdate(Customer domainObject) {
		return (Customer) super.saveOrUpdate(domainObject);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	protected void loadDomainObjects() {
//		domainMap = new HashMap<>();

		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setName("Sagar");
		customer1.setEmail("sagarrao@gmail.com");
		customer1.setPhone("9989027590");
		customer1.setAddress1("H.no : 1-2-31");
		customer1.setCity("Hyderbad");
		customer1.setState("Telangana");

		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setName("Ravi");
		customer2.setEmail("ravarrao@gmail.com");
		customer2.setPhone("9989027590");
		customer2.setAddress1("H.no : 2-2-32");
		customer2.setCity("Hyderbad");
		customer2.setState("Telangana");

		Customer customer3 = new Customer();
		customer3.setId(3);
		customer3.setName("Sanju");
		customer3.setEmail("sanjurrao@gmail.com");
		customer3.setPhone("9989027590");
		customer3.setAddress1("H.no : 3-2-33");
		customer3.setCity("Hyderbad");
		customer3.setState("Telangana");

		Customer customer4 = new Customer();
		customer4.setId(4);
		customer4.setName("Naresh");
		customer4.setEmail("nareshrao@gmail.com");
		customer4.setPhone("9989027590");
		customer4.setAddress1("H.no : 4-2-34");
		customer4.setCity("Hyderbad");
		customer4.setState("Telangana");

		domainMap.put(1, customer1);
		domainMap.put(2, customer2);
		domainMap.put(3, customer3);
		domainMap.put(4, customer4);

	}

//	Map<Integer, Customer> customers;
//
//	private void loadCustomers() {
//		customers = new HashMap<>();
//
//		Customer customer1 = new Customer();
//
//		customer1.setId(1);
//		customer1.setName("Sagar");
//		customer1.setEmail("sagarrao@gmail.com");
//		customer1.setPhone("9989027590");
//		customer1.setAddress1("H.no : 1-2-31");
//		customer1.setCity("Hyderbad");
//		customer1.setState("Telangana");
//
//		customers.put(1, customer1);
//
//		Customer customer2 = new Customer();
//
//		customer2.setId(2);
//		customer2.setName("Ravi");
//		customer2.setEmail("ravarrao@gmail.com");
//		customer2.setPhone("9989027590");
//		customer2.setAddress1("H.no : 2-2-32");
//		customer2.setCity("Hyderbad");
//		customer2.setState("Telangana");
//
//		customers.put(2, customer2);
//
//		Customer customer3 = new Customer();
//
//		customer3.setId(3);
//		customer3.setName("Sanju");
//		customer3.setEmail("sanjurrao@gmail.com");
//		customer3.setPhone("9989027590");
//		customer3.setAddress1("H.no : 3-2-33");
//		customer3.setCity("Hyderbad");
//		customer3.setState("Telangana");
//
//		customers.put(3, customer3);
//
//		Customer customer4 = new Customer();
//
//		customer4.setId(4);
//		customer4.setName("Naresh");
//		customer4.setEmail("nareshrao@gmail.com");
//		customer4.setPhone("9989027590");
//		customer4.setAddress1("H.no : 4-2-34");
//		customer4.setCity("Hyderbad");
//		customer4.setState("Telangana");
//
//		customers.put(4, customer4);
//	}
//	
//	
//
//	public CustomerServiceImpl() {
//		loadCustomers();
//	}
//
//
//
//	@Override
//	public List<Customer> listAllCustomers() {
//		return new ArrayList<> (customers.values());
//	}
//
//	@Override
//	public Customer getCustomerById(Integer id) {
//		return customers.get(id);
//	}
//
//	@Override
//	public Customer saveOrUpdate(Customer customer) {
//		if (customer !=null) {
//			if(customer.getId() == null) {
//				customer.setId(getNextKey());
//			}
//			
//			customers.put(customer.getId(), customer);	
//			
//			return customer;
//			
//		} else {
//			throw new RuntimeException("Can't update Customer Object");
//		}
//	}
//
//	private Integer getNextKey() {
//		return Collections.max(customers.keySet())+1;
//	}
//
//
//
//	@Override
//	public void deleteCustomerById(Integer id) {
//		customers.remove(id);
//	}

}
