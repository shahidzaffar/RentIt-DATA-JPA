package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Integer> {

}
