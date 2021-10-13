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

import com.rentit.restapi.entity.Company;
import com.rentit.restapi.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyRestController {

	private CompanyService companyService;

	// inject company Service
	public CompanyRestController(CompanyService theCompanyService) {
		companyService = theCompanyService;
	}

	// expose '/companies' and return list of companies
	@GetMapping("/companies")
	public List<Company> findAll() {
		return companyService.findAll();
	}

	// mapping for admins/{admi_id}

	@GetMapping("/companies/{companyId}")
	public Company getCompanyById(@PathVariable int companyId) {
		Company theCompany = companyService.findById(companyId);

		if (theCompany == null)
			throw new RuntimeException("Company not found");
		return theCompany;
	}

	// mapping to save the new entry

	@PostMapping("/companies")
	public Company addCompany(@RequestBody Company theCompany) {
		// for saving a new Admin, we set the id to zero
		theCompany.setId(0);

		companyService.save(theCompany);

		return theCompany;
	}

	// mapping to update the new entry

	@PutMapping("/companies")
	public Company updateCompany(@RequestBody Company theCompany) {
		companyService.save(theCompany);
		return theCompany;
	}

	@DeleteMapping("/companies/{companyId}")
	public Company deleteCompany(@PathVariable int companyId) {
		Company theCompany = companyService.findById(companyId);

		if (theCompany == null)
			throw new RuntimeException("Company not found");
		companyService.deleteById(companyId);
		return theCompany;
	}
}
