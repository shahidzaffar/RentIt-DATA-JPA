package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
