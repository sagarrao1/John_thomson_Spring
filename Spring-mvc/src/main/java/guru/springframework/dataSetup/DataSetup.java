package guru.springframework.dataSetup;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Address;
import guru.springframework.domain.Cart;
import guru.springframework.domain.CartDetail;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Order;
import guru.springframework.domain.OrderLine;
import guru.springframework.domain.Product;
import guru.springframework.domain.User;
import guru.springframework.enums.OrderStatus;
import guru.springframework.services.CustomerService;
import guru.springframework.services.OrderService;
import guru.springframework.services.ProductService;
import guru.springframework.services.UserService;

//commenting it as we are using data setup using data.sql in resources folder

@Component
public class DataSetup implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProductData();
		loadUserWithCustomer();
		loadCart();
		loadOrderHistory();
		
	}
	
	private void loadOrderHistory() {
		List<User> users = (List<User>) userService.listAll();		
		List<Product> products = productService.listAllProducts();
		
		for (User user : users) {
			Order order = new Order();
//			order.setCustomer(user.getCustomer());
			order.setOrderStatus(OrderStatus.SHIPPED);
			order.setDate_Shipped(new Date());
			order.setShipToAddress(user.getCustomer().getShippingAddress());
			
			
			for (Product product : products) {
				OrderLine orderLine= new OrderLine();
				orderLine.setOrder(order);
				orderLine.setProduct(products.get(0));
				orderLine.setQty(1);			
				order.addToOrderDetails(orderLine);
				
			}
			orderService.saveOrUpdate(order);
		}
	}

	private void loadCart() {
		List<User> users = (List<User>) userService.listAll();		
		List<Product> products = productService.listAllProducts();
		
		for (User user : users) {
			Cart cart = new Cart();
			user.setCart(cart);
			
			CartDetail cartDetail = new CartDetail();
			cartDetail.setProduct(products.get(0));
			cartDetail.setQty(2);
			user.getCart().addCartDetail(cartDetail);
			System.out.println(user);
			userService.saveOrUpdate(user);
		}
		
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
	
	private void loadUserWithCustomer() {
		
		User user1 = new User();		
		user1.setUserName("Sagar User 1");
		user1.setPassword("SagarPassword");
		
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setEmail("sagar@gmail.com");
		c1.setName("Sagar_A");
		c1.setPhone("998902727");
		c1.setDateCreated(new Date());
		c1.setBillingAddress(new Address());
		c1.getBillingAddress().setAddressLine1("Lan2 ");
		c1.getBillingAddress().setAddressLine2("opp: southindia shopping mall");
		c1.getBillingAddress().setCity("npr");
		c1.getBillingAddress().setState("TS");
		
		c1.setShippingAddress(new Address());
		c1.getShippingAddress().setAddressLine1("Lan2 ");
		c1.getShippingAddress().setAddressLine2("opp: southindia shopping mall");
		c1.getShippingAddress().setCity("npr");
		c1.getShippingAddress().setState("TS");
		
		
		user1.setCustomer(c1);
		
		/* Customer savedC1 = */ userService.saveOrUpdate(user1);
		
//		System.out.println("user1 plain password :"+savedC1.getUser().getPassword());
//		System.out.println("user1 plain encrypted password :"+savedC1.getUser().getEncryptedPassword());
		
		
		User user2 = new User();		
		user2.setUserName("Sagar User 2");
		user2.setPassword("SagarPassword");
		

		Customer c2 = new Customer();
//		c2.setId(2);
		c2.setEmail("sagar@gmail.com");
		c2.setName("Mahesh");
		c2.setPhone("9989033");
		c2.setBillingAddress(new Address());
		c2.getBillingAddress().setAddressLine1("bandari layout ");
		c2.getBillingAddress().setAddressLine2("opp: southindia shopping mall");
		c2.getBillingAddress().setCity("npr");
		c2.getBillingAddress().setState("KNR");
		
		c2.setShippingAddress(new Address());
		c2.getShippingAddress().setAddressLine1("Lan2 ");
		c2.getShippingAddress().setAddressLine2("opp: southindia shopping mall");
		c2.getShippingAddress().setCity("npr");
		c2.getShippingAddress().setState("TS");
		
		user2.setCustomer(c2);
		
		/* Customer savedC2 = */userService.saveOrUpdate(user2);
		
//		System.out.println("user1 plain password :"+savedC2.getUser().getPassword());
//		System.out.println("user1 plain encrypted password :"+savedC2.getUser().getEncryptedPassword());
		
		
	}


}
