package guru.springframework.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart extends AbstractDomainClass{

	@OneToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart",orphanRemoval = true)
	private List<CartDetail> cartDetails = new ArrayList<>();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
	public void addCartDetail(CartDetail cartDetail){
        cartDetails.add(cartDetail);
        cartDetail.setCart(this);
    }

    public void removeCartDetail(CartDetail cartDetail){
        cartDetail.setCart(null);
        this.cartDetails.remove(cartDetail);
    }

//	@Override
//	public String toString() {
//		return "Cart [id=" + id + ", user=" + user + ", version=" + version + ", cartDetails=" + cartDetails
//				+ ", date_created=" + date_created + ", date_updated=" + date_updated + "]";
//	}

    
}
