package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.TerminalRepository;
import com.rentit.restapi.entity.Terminal;

@Service
public class TerminalServiceImplimentation implements TerminalService {

	private TerminalRepository terminalRepository;

	@Autowired
	public TerminalServiceImplimentation(TerminalRepository theTerminalRepository) {
		terminalRepository = theTerminalRepository;
	}

	@Override

	public List<Terminal> findAll() {

		return terminalRepository.findAll();
	}

	@Override

	public Terminal findById(int id) {

		// return terminalRepository.findById(id);
		Optional<Terminal> result = terminalRepository.findById(id);

		Terminal theTerminal = null;
		if (result.isPresent()) {
			theTerminal = result.get();
		} else
			throw new RuntimeException("Terminal not found");

		return theTerminal;

	}

	@Override

	public void save(Terminal theTerminal) {
		terminalRepository.save(theTerminal);

	}

	@Override
	public void deleteById(int id) {
		terminalRepository.deleteById(id);

	}

}
