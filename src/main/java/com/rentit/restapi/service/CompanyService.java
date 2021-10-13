package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Company;

public interface CompanyService {
	public List<Company> findAll();

	public Company findById(int id);

	public void save(Company theCompany);

	public void deleteById(int id);

}
