package com.simple.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.demo.Service.CurdService;
import com.simple.demo.dto.RequestDto;
import com.simple.demo.dto.ResponseModel;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("curd")
public class CrudController {
	
	@Autowired 
	private CurdService curdService;
	
	
	@PostMapping("/add")
	public ResponseModel create(@RequestBody RequestDto dto) {
		return curdService.create(dto);

	}
	@GetMapping("/getall")
	public ResponseModel getAll() {
		return curdService.getAll();

	}
	
	@PutMapping("/update/{id}")
	public ResponseModel update(@PathVariable("id")int id,@RequestBody RequestDto dto) {
		return curdService.update(id,dto);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseModel delete(@PathVariable("id")int id) {
		return curdService.delete(id);

	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseModel getById(@PathVariable("id") int id) {
		return curdService.getById(id);

	}

}
