package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.ContactPersonRepository;
import com.rentit.restapi.entity.ContactPerson;

@Service
public class ContactPersonServiceImplimentation implements ContactPersonService {

	private ContactPersonRepository cpRepository;

	@Autowired
	public ContactPersonServiceImplimentation(ContactPersonRepository contactPersonRepository) {

		cpRepository = contactPersonRepository;
	}

	@Override

	public List<ContactPerson> findAll() {

		return cpRepository.findAll();
	}

	@Override

	public ContactPerson findById(int id) {

		// return cpRepository.findById(id);
		Optional<ContactPerson> result = cpRepository.findById(id);

		ContactPerson theContactPerson = null;
		if (result.isPresent()) {
			theContactPerson = result.get();
		} else
			throw new RuntimeException("ContactPerson not found");

		return theContactPerson;

	}

	@Override

	public void save(ContactPerson theContactPerson)

	{

		cpRepository.save(theContactPerson);

	}

	@Override

	public void deleteById(int id) {

		cpRepository.deleteById(id);

	}

}
