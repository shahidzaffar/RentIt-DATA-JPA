package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
