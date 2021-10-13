package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.ContactPerson;

public interface ContactPersonService {
	public List<ContactPerson> findAll();

	public ContactPerson findById(int id);

	public void save(ContactPerson theContactPerson);

	public void deleteById(int id);

}
