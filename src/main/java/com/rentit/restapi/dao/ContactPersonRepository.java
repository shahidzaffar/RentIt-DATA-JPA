package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.ContactPerson;

public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {

}
