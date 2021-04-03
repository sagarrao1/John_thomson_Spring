package guru.springframework.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import guru.springframework.enums.OrderStatus;

@Entity
@Table(name = "ORDER_HEADER")
public class Order extends AbstractDomainClass{

//	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
//	private Customer customer;
	
	Date date_Shipped;	
		
	@OneToMany(mappedBy = "order",orphanRemoval = true)
	private List<OrderLine> orderLines = new ArrayList<>();
	
	private OrderStatus orderStatus;			
	@Embedded
	private Address shipToAddress;
	
	

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Date getDate_Shipped() {
		return date_Shipped;
	}

	public void setDate_Shipped(Date date_Shipped) {
		this.date_Shipped = date_Shipped;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Address getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(Address shipToAddress) {
		this.shipToAddress = shipToAddress;
	}
	
	public void addToOrderDetails(OrderLine orderline) {
		orderline.setOrder(this);
		orderLines.add(orderline);
	}
	
	public void removeOrderDetail(OrderLine orderLine) {
		orderLine.setOrder(null);
		orderLines.remove(orderLine);
		
	}

}
