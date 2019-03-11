package greet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greet.models.Book;
import greet.models.CustomError;
import greet.models.CustomSuccess;
import greet.models.product.Order;
import greet.models.product.OrderLine;
import greet.models.product.Product;
import greet.models.product.ShoppingCart;
import greet.models.product.Stock;
import greet.service.IBookService;
import greet.service.IProductCatalogService;
import greet.serviceImp.OrderService;
import greet.serviceImp.ShoppingService;

@RestController
public class CartController {

	@Autowired
	ShoppingService service;
	@Autowired
	OrderService serviceOrder;
	
	
	@PostMapping("/cart/addproduct/{cartID}")
	public ResponseEntity<?> addProd(@RequestBody OrderLine oLine, @PathVariable("cartID") String cartID) {
//		if(cartID.equals("0"))
		service.addToCart(cartID, oLine.getProductNumber(), oLine.getQuantity());
		return new ResponseEntity<CustomSuccess>(new CustomSuccess("Product added", cartID),HttpStatus.OK);
	}
	
	@GetMapping("/cart/{cartID}")
	public ResponseEntity<?> getProduct(@PathVariable("cartID") String cartID) {
		ShoppingCart cart = service.getCart(cartID);
		if(cart != null)
		return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
		else return new ResponseEntity<CustomError>(new CustomError("Cart has not been found with  "+cartID), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/cart/checkout/{cartID}")
	public ResponseEntity<?> checkoutCart(@PathVariable("cartID") String cartID) {
		ShoppingCart cart = service.getCart(cartID);
	
		if(cart != null)
		 {
			
			serviceOrder.createOrder(cartID, cart);
			return new ResponseEntity<CustomSuccess>(new CustomSuccess("Order created with orderNumber "+cartID),HttpStatus.OK);
		}
		else return new ResponseEntity<CustomError>(new CustomError("Cart has not been found with  "+cartID), HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
}
