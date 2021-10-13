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

import com.rentit.restapi.entity.Feedback;
import com.rentit.restapi.service.FeedbackService;

@RestController
@RequestMapping("/api")
public class FeedbackRestController {

	private FeedbackService feedbackService;

	// inject Feedback dao
	public FeedbackRestController(FeedbackService theFeedbackService) {
		feedbackService = theFeedbackService;
	}

	// expose '/feedbacks' and return list of feedbacks
	@GetMapping("/feedbacks")
	public List<Feedback> findAll() {
		return feedbackService.findAll();
	}

	@GetMapping("/feedbacks/{feedbackId}")
	public Feedback getFeedbackById(@PathVariable int feedbackId) {

		Feedback theFeedback = feedbackService.findById(feedbackId);

		if (theFeedback == null)
			throw new RuntimeException("Feedback not found");
		return theFeedback;
	}

	// mapping to save the new entry

	@PostMapping("/feedbacks")
	public Feedback addFeedback(@RequestBody Feedback theFeedback) {
		// for saving a new Feedback, we set the id to zero
		theFeedback.setId(0);

		feedbackService.save(theFeedback);

		return theFeedback;
	}

	// mapping to update the entry

	@PutMapping("/feedbacks")
	public Feedback updateFeedback(@RequestBody Feedback theFeedback) {
		feedbackService.save(theFeedback);
		return theFeedback;
	}

	// Delete Mapping
	@DeleteMapping("/feedbacks/{feedbackId}")
	public Feedback deleteFeedback(@PathVariable int feedbackId) {
		Feedback theFeedback = feedbackService.findById(feedbackId);

		if (theFeedback == null)
			throw new RuntimeException("Feedback not found");
		feedbackService.deleteById(feedbackId);
		return theFeedback;
	}

}
