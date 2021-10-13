package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
