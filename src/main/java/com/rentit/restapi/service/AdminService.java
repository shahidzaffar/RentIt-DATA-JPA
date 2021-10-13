package com.rentit.restapi.service;

import java.util.List;
import com.rentit.restapi.entity.Admin;

public interface AdminService {
	public Admin findById(int id);

	public List<Admin> findAll();

	public void save(Admin theAdmin);

	public void deleteById(int id);

}
