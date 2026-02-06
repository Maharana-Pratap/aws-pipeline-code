package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Emp;
import com.example.demo.emp.EmpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmpController {
	
	private final EmpService empService;
	
	@PostMapping
	public ResponseEntity<?> saveEmp(@RequestBody Emp emp) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(empService.addEmp(emp));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(empService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable Integer id) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(empService.deleteEmp(id));
	}

}
