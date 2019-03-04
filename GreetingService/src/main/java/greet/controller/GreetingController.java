package greet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greet.models.Greeting;

@RestController
public class GreetingController {
	
	@RequestMapping("/greeting/{message}")
	public ResponseEntity<?> getGreeting(@PathVariable("message") String message) {
		Greeting greeting = new Greeting();
		greeting.setContent("Hello world "+message);
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
		
	}

}
