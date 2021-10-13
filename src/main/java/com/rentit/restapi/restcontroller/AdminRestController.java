package com.rentit.restapi.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentit.restapi.entity.Admin;
import com.rentit.restapi.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminRestController {

	private AdminService adminService;

	// inject admin dao
	public AdminRestController(AdminService theAdminService) {
		adminService = theAdminService;
	}

	// expose '/admins' and return list of admins
	@GetMapping("/admins")
	public List<Admin> findAll() {
		return adminService.findAll();
	}

	// mapping for admins/{admi_id}

	@GetMapping("/admins/{adminId}")
	public Admin getById(@PathVariable int adminId) {
		Admin theAdmin = adminService.findById(adminId);

		if (theAdmin == null)
			throw new RuntimeException("Admin not found");
		return theAdmin;
	}

	// mapping to save the new entry

	@PostMapping("/admins")
	public Admin add(@RequestBody Admin theAdmin) {
		// for saving a new Admin, we set the id to zero
		theAdmin.setId(0);

		adminService.save(theAdmin);

		return theAdmin;
	}

	// mapping to update the new entry

	@PutMapping("/admins")
	public Admin update(@RequestBody Admin theAdmin) {
		adminService.save(theAdmin);
		return theAdmin;
	}

	@DeleteMapping("/admins/{adminId}")
	public Admin delete(@PathVariable int adminId) {
		Admin theAdmin = adminService.findById(adminId);

		if (theAdmin == null)
			throw new RuntimeException("Admin not found");
		adminService.deleteById(adminId);
		return theAdmin;
	}

}