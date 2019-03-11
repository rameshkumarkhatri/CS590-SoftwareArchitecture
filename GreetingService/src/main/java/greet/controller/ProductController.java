package greet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greet.models.Book;
import greet.models.CustomError;
import greet.models.CustomSuccess;
import greet.models.product.OrderLine;
import greet.models.product.Product;
import greet.models.product.ShoppingCart;
import greet.models.product.Stock;
import greet.repository.IShoppingCartRepository;
import greet.service.IBookService;
import greet.service.IProductCatalogService;
import greet.serviceImp.ShoppingService;

@RestController
public class ProductController {

	@Autowired
	IProductCatalogService prodService;
	

	
	@PostMapping("/product")
	public ResponseEntity<?> addProd(@RequestBody Product prod) {
		prodService.addProduct(prod.getProductNumber(), prod.getDescription(), prod.getPrice());
		return new ResponseEntity<CustomSuccess>(new CustomSuccess("Product added"),HttpStatus.OK);
	}
	@PatchMapping("/product/stock/{productNumber}")
	public ResponseEntity<?> updateProduct(@PathVariable("productNumber") long productNumber, @RequestBody Stock stock) {
		prodService.setStock(productNumber, stock.getQuantity(), stock.getLocationcode());
		return new ResponseEntity<CustomSuccess>(new CustomSuccess("Product data updated"),HttpStatus.OK);
	}
	
	@GetMapping("/product/{productNumber}")
	public ResponseEntity<?> getProduct(@PathVariable("productNumber") long productNumber) {
		Product prod = prodService.getProduct(productNumber);
		if(prod != null)
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
		else return new ResponseEntity<CustomError>(new CustomError("Product has not been found with  "+productNumber), HttpStatus.NOT_FOUND);
	}
	
	
}
