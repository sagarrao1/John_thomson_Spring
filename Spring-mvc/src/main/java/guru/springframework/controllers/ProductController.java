package guru.springframework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@Controller
public class ProductController {

	ProductService  productService;	
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/products")
	public String listProducts(Model model) {		
		
		List<Product> allProducts = productService.listAllProducts();
		
		for (Product product : allProducts) {
			System.out.println(product);
		}
		model.addAttribute("products", productService.listAllProducts());		
		return "products";
	}


	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable("id") Integer id, Model model) {		
		model.addAttribute("product", productService.getProductById(id));		
		return "product";
	}

	
	@RequestMapping("/product/new")
	public String addProduct(Model model) {		
		model.addAttribute("product", new Product());		
		return "productForm";
	}

	
	@PostMapping("/product")
	public String saveOrUpdateProduct(Product product) {				
		Product savedProduct = productService.saveOrUpdate(product);	
		
		return "redirect:/product/" +savedProduct.getId();
	}

	@RequestMapping("/product/edit/{id}")
	public String updateProduct(@PathVariable Integer id,  Model model) {		
		model.addAttribute("product", productService.getProductById(id));		
		return "productForm";
	}
	
	@RequestMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable Integer id,  Model model) {		
		productService.deleteProductById(id);	
		
//		model.addAttribute("products", productService.listAllProducts());		
		return "redirect:/products";
	}
	
}
