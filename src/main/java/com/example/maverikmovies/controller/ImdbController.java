package com.example.maverikmovies.controller;

import com.example.maverikmovies.model.ImdbRecord;
import com.example.maverikmovies.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller is just to test the functionality of the ImdbService
 */
@RestController
@RequestMapping("/api/imdb")
public class ImdbController {

	private final ImdbService imdbService;

	@Autowired
	public ImdbController(ImdbService imdbService) {
		this.imdbService = imdbService;
	}

	@GetMapping("/search")
	public ResponseEntity<List<ImdbRecord>> findAll(@RequestParam("title-query") String titleQuery) {
		List<ImdbRecord> records = this.imdbService.findAllByTitle(titleQuery);
		return ResponseEntity.ok(records);
	}

	@GetMapping("/{imdbId}")
	public ResponseEntity<ImdbRecord> findOne(@PathVariable("imdbId") String imdbId) {
		ImdbRecord imdbRecord = this.imdbService.findOneByImdbId(imdbId);
		return ResponseEntity.ok(imdbRecord);

	}
}
