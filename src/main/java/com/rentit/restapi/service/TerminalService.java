package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Terminal;

public interface TerminalService {
	public List<Terminal> findAll();

	public Terminal findById(int id);

	public void save(Terminal theTerminal);

	public void deleteById(int id);

}
