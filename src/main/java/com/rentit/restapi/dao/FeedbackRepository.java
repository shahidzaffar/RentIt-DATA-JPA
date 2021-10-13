package com.rentit.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentit.restapi.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
