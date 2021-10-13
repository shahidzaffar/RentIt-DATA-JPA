package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.AdminRepository;
import com.rentit.restapi.entity.Admin;

@Service
public class AdminServiceImplimentation implements AdminService {

	
	
	
	
	
	
	
	private AdminRepository adminRepository;

	@Autowired
	public AdminServiceImplimentation(AdminRepository theAdminRepository) {
		adminRepository = theAdminRepository;
	}

	
	
	
	
	
	
	
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public Admin findById(int id) {
		Optional<Admin> result = adminRepository.findById(id);

		Admin theAdmin = null;
		if (result.isPresent()) {
			theAdmin = result.get();
		} else
			throw new RuntimeException("Admin not found");

		return theAdmin;
	}

	@Override

	public void save(Admin theAdmin) {

		adminRepository.save(theAdmin);

	}

	@Override
	public void deleteById(int id) {

		adminRepository.deleteById(id);

	}

}
