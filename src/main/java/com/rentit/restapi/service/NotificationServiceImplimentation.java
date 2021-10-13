package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.NotificationRepository;
import com.rentit.restapi.entity.Notification;

@Service
public class NotificationServiceImplimentation implements NotificationService {

	
	
	
	
	
	
	
	private NotificationRepository notifyRepository;

	@Autowired
	public NotificationServiceImplimentation(NotificationRepository theNotifyRepository) {
		notifyRepository = theNotifyRepository;
	}

	
	
	
	
	
	
	
	@Override
	public List<Notification> findAll() {
		return notifyRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public Notification findById(int id) {
		Optional<Notification> result = notifyRepository.findById(id);

		Notification theAdmin = null;
		if (result.isPresent()) {
			theAdmin = result.get();
		} else
			throw new RuntimeException("Notification not found");

		return theAdmin;
	}

	@Override

	public void save(Notification theNotify) {

		notifyRepository.save(theNotify);

	}

	@Override
	public void deleteById(int id) {

		notifyRepository.deleteById(id);

	}

}
