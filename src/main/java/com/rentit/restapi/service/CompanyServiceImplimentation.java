package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.CompanyRepository;
import com.rentit.restapi.entity.Company;

@Service
public class CompanyServiceImplimentation implements CompanyService {

	private CompanyRepository companyRepository;

	@Autowired
	public CompanyServiceImplimentation(CompanyRepository theCompanyRepository) {
		companyRepository = theCompanyRepository;
	}

	@Override

	public List<Company> findAll() {

		return companyRepository.findAll();
	}

	@Override

	public Company findById(int id) {

		// return companyRepository.findById(id);

		Optional<Company> result = companyRepository.findById(id);

		Company theCompany = null;
		if (result.isPresent()) {
			theCompany = result.get();
		} else
			throw new RuntimeException("Admin not found");

		return theCompany;
	}

	@Override

	public void save(Company theCompany) {
		companyRepository.save(theCompany);

	}

	@Override

	public void deleteById(int id) {
		companyRepository.deleteById(id);

	}

}
