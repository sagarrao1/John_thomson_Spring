package guru.springframework.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class User extends AbstractDomainClass{
	
	private String userName;	

	@Transient
	private String password;	
	private String encryptedPassword;	
	private boolean enabled=true;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	Cart cart;
	
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		customer.setUser(this);
	}	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "User [id=" + super.getId() + ", userName=" + userName + ", password=" + password + ", encryptedPassword="
				+ encryptedPassword + ", enabled=" + enabled + ", customer=" + customer + ", cart=" + cart
				+ ", date_created=" + super.getDateCreated() + ", date_updated=" + super.getDateUpdated() + "]";
	}	

	
	
}
