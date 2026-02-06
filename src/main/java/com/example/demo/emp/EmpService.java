package com.example.demo.emp;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Emp;

@Service
public class EmpService {
	
	List<Emp> empList = new LinkedList<>();
	
	public List<Emp> addEmp(Emp emp) {
		empList.add(emp);
		return empList;
	}
	
	public Emp findById(Integer id) {
		return empList.stream()
				.filter(emp-> emp.getId().equals(id))
				.findFirst()
				.orElseThrow();
	}
	
	public List<Emp> deleteEmp(Integer id) {
		Emp emp = empList.stream()
				.filter(data-> data.getId().equals(id))
				.findFirst()
				.orElseThrow();
		empList.remove(emp);
		return empList;
	}

}
