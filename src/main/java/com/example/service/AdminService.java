package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AdminRepository;
import com.example.model.Admin;
@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repoObj;


	private static final String EMAIL_FORMAT = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
	private static final String PASSWORD_FORMAT = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
	private static final String USERNAME_FORMAT = "^(?=[a-zA-Z0-9._]{3,20}$)(?!.*[_.]{2})[^_.].*[^_.]$";
	
	public String addAdmin(Admin admin) {

		if (!admin.getEmail().matches(EMAIL_FORMAT)) {
			return "Invalid email format.";
		}

		if (!admin.getPassword().matches(PASSWORD_FORMAT)) {
			return "Invalid password format.";
		}


		if (!admin.getName().matches(USERNAME_FORMAT)) {
			return "Invalid adminname format.";
		}

		Admin anotherAdmin = repoObj.findByName(admin.getName());

		if (anotherAdmin != null) {
			return "Adminname already exists please try again";
		}

		String adminname = admin.getName();
		

		repoObj.save(admin);

		return "Admin Added Successfully!!\nYour Email:\t " + admin.getEmail()+"\n Password:\t "+admin.getPassword();

	}

}
