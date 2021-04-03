package guru.springframework.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Product extends AbstractDomainClass{
	
	private String description;
	private BigDecimal price;
	private String imageUrl;
	
	public Product() {
		super();
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
		
	
	
	@Override
	public String toString() {
		return "Product [id=" + super.getId() + ", description=" + description + ", price=" + price + ", imageUrl=" + imageUrl
				+ "]";
	}
	
	

}

