package com.rentit.restapi.service;

import java.util.List;
import com.rentit.restapi.entity.Notification;

public interface NotificationService {
	public Notification findById(int id);

	public List<Notification> findAll();

	public void save(Notification theNotification);

	public void deleteById(int id);

}
