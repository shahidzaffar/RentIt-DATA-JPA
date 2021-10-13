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
import com.rentit.restapi.entity.ContactPerson;
import com.rentit.restapi.service.ContactPersonService;

@RestController
@RequestMapping("/api")
public class ContactPersonRestController {

	private ContactPersonService contactPersonService;

	// inject ContactPerson dao
	public ContactPersonRestController(ContactPersonService thecontactPersonService) {
		contactPersonService = thecontactPersonService;
	}

	// expose '/contactpersons' and return list of contactpersons

	@GetMapping("/contactpersons")
	public List<ContactPerson> findAll() {
		return contactPersonService.findAll();
	}

	// mapping for contactpersons/{contactPersonId}

	@GetMapping("/contactpersons/{contactPersonId}")
	public ContactPerson getContactPersonById(@PathVariable int contactPersonId) {
		ContactPerson theContactPerson = contactPersonService.findById(contactPersonId);

		if (theContactPerson == null)
			throw new RuntimeException("Contact Person not found");
		return theContactPerson;
	}

	// mapping to save the new entry

	@PostMapping("/contactpersons")
	public ContactPerson addContactPerson(@RequestBody ContactPerson theContactPerson) {
		// for saving a new Admin, we set the id to zero
		theContactPerson.setId(0);

		contactPersonService.save(theContactPerson);

		return theContactPerson;
	}

	// mapping to update the entry

	@PutMapping("/contactpersons")
	public ContactPerson updateContactPerson(@RequestBody ContactPerson theContactPerson) {
		contactPersonService.save(theContactPerson);
		return theContactPerson;
	}

	@DeleteMapping("/contactpersons/{contactPersonId}")
	public ContactPerson deleteContactPerson(@PathVariable int contactPersonId) {
		ContactPerson theContactPerson = contactPersonService.findById(contactPersonId);

		if (theContactPerson == null)
			throw new RuntimeException("ContactPerson not found");
		contactPersonService.deleteById(contactPersonId);
		return theContactPerson;
	}
}
