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

import com.rentit.restapi.entity.Notification;
import com.rentit.restapi.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationRestController {

	private NotificationService notificationService;

	public NotificationRestController(NotificationService theNotificationService) {
		notificationService = theNotificationService;
	}


	
	
	@GetMapping("/notifications")
	public List<Notification> findAll() {
		return notificationService.findAll();
	}

	// mapping for admins/{admi_id}

	@GetMapping("/notifications/{id}")
	public Notification getById(@PathVariable int id) {
		Notification theNotify = notificationService.findById(id);

		if (theNotify == null)
			throw new RuntimeException("Notification not found");
		return theNotify;
	}

	// mapping to save the new entry

	@PostMapping("/notifications")
	public Notification add(@RequestBody Notification theNotify) {
		
		
		
		theNotify.setId(0);

		notificationService.save(theNotify);

		return theNotify;
	}

	// mapping to update the new entry

	@PutMapping("/notifications")
	public Notification update(@RequestBody Notification thenotify) {
		notificationService.save(thenotify);
		return thenotify;
	}

	@DeleteMapping("/notifications/{id}")
	public Notification delete(@PathVariable int id) {
		Notification thenotify = notificationService.findById(id);

		if (thenotify == null)
			throw new RuntimeException("Admin not found");
		notificationService.deleteById(id);
		return thenotify;
	}

}