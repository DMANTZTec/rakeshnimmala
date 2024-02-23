package com.dmantz.SpringJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.SpringJDBC.model.Alian;
import com.dmantz.SpringJDBC.repository.AlianRepo;

@RestController
@RequestMapping("/api")
public class AlianController {
	
	@Autowired
	AlianRepo alianrepo;
    
	@PostMapping("/add")
	public String add(@RequestBody Alian alian) {
		alianrepo.save(alian);
		return "Alian inserted Successfully";

	}
	@GetMapping("/getall")
	public List<Alian> findAll(){
		return alianrepo.findAll();
		
	}
	@GetMapping("/getByID/{id}")
	public Alian getById( @PathVariable int id) {
		return alianrepo.getById(id);
		
	}
	@PutMapping("/putById/{id}")
	public String UpdateById(@PathVariable int  id) {
		return alianrepo.updateById(id);
		
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int  id) {
		return alianrepo.deleteById(id);
		
	}

}
