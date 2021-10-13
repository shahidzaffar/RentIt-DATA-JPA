package com.rentit.restapi.service;

import java.util.List;

import com.rentit.restapi.entity.Feedback;

public interface FeedbackService {

	public List<Feedback> findAll();

	public Feedback findById(int id);

	public void save(Feedback theFeedback);

	public void deleteById(int id);

}
