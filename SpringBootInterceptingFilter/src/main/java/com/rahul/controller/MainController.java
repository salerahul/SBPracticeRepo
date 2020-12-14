package com.rahul.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.Employee;

@RestController
public class MainController {

	static Map<String, Employee> map = new HashMap<>(); 
	
	static {
		Employee emp1 = new Employee("101", "Rahul");
		
		map.put(emp1.getId(), emp1);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<String> update(@PathVariable String id){
		
		if(!map.containsKey(id)) {
			throw new IllegalArgumentException("id not found");
		}
		
		
		return new ResponseEntity<String>("Updated suucessfully", HttpStatus.OK);
	}
}
