package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.AdminRepository;
import com.example.model.Admin;
import com.example.service.AdminService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")

public class AdminController {
	
	@Autowired
	private AdminService AdminService;
	
	@Autowired
	private AdminRepository u;
	
	@PostMapping("/add")
	public String addAdmin(@RequestBody Admin Admin) {
		return AdminService.addAdmin(Admin);
	}
	
	@ResponseBody
	@PostMapping("/login")
	public Integer loginAdmin(@Valid @RequestBody Admin Admin) {
		List<Admin> Admins = u.findAll();
		for (Admin other : Admins) {
			if (other.equals(Admin)) {
				Admin.setLoggedIn(true);
				System.out.println("Successful login");
//				u.save(Admin);
				return(other.getId());
			}
		}

		return 0;
	}

}
