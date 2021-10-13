package com.rentit.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentit.restapi.dao.FeedbackRepository;
import com.rentit.restapi.entity.Feedback;

@Service
public class FeedbackServiceImplimentation implements FeedbackService {

	private FeedbackRepository feedbackRepository;

	// @PersistenceContext
	// private EntityManager entityManager;
	//

	@Autowired
	public FeedbackServiceImplimentation(FeedbackRepository theFeedbackRepository) {

		feedbackRepository = theFeedbackRepository;
	}

	@Override

	public List<Feedback> findAll() {

		return feedbackRepository.findAll();
	}

	@Override

	public Feedback findById(int id) {
		// return feedbackRepository.findById(id);
		Optional<Feedback> result = feedbackRepository.findById(id);

		Feedback theFeedback = null;
		if (result.isPresent()) {
			theFeedback = result.get();
		} else
			throw new RuntimeException("Feedback not found");

		return theFeedback;

	}

	@Override

	public void save(Feedback theFeedback) {
		

		feedbackRepository.save(theFeedback);

	}

	@Override

	public void deleteById(int id) {

		feedbackRepository.deleteById(id);

	}
}