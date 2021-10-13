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
import com.rentit.restapi.entity.Terminal;
import com.rentit.restapi.service.TerminalService;

@RestController
@RequestMapping("/api")
public class TerminalRestController {

	private TerminalService terminalService;

	// inject Terminal dao
	public TerminalRestController(TerminalService theTerminalService) {
		terminalService = theTerminalService;
	}

	// expose '/terminals' and return list of Terminals
	@GetMapping("/terminals")
	public List<Terminal> findAll() {
		return terminalService.findAll();
	}

	// Get Terminal by id

	@GetMapping("/terminals/{terminalId}")
	public Terminal getTerminalById(@PathVariable int terminalId) {
		Terminal theTerminal = terminalService.findById(terminalId);

		if (theTerminal == null)
			throw new RuntimeException("Terminal not found");
		return theTerminal;
	}

	// mapping to save the new entry

	@PostMapping("/terminals")
	public Terminal addTerminal(@RequestBody Terminal theTerminal) {
		// for saving a new Terminal, we set the id to zero
		theTerminal.setId(0);

		terminalService.save(theTerminal);

		return theTerminal;
	}

	// mapping to update the entry

	@PutMapping("/terminals")
	public Terminal updateTerminal(@RequestBody Terminal theTerminal) {
		terminalService.save(theTerminal);
		return theTerminal;
	}

	// Delete a terminal

	@DeleteMapping("/terminals/{terminalId}")
	public Terminal deleteTerminal(@PathVariable int terminalId) {
		Terminal theTerminal = terminalService.findById(terminalId);

		if (theTerminal == null)
			throw new RuntimeException("Terminal not found");
		terminalService.deleteById(terminalId);
		return theTerminal;
	}

}
