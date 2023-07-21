package com.example.maverikmovies.controller;

import com.example.maverikmovies.model.Movie;
import com.example.maverikmovies.service.LoadService;
import com.example.maverikmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	private final MovieService movieService;
	private final LoadService loadService;

	@Autowired
	public MovieController(MovieService movieService,
						   LoadService loadService) {
		this.movieService = movieService;
		this.loadService = loadService;
	}

	@PostMapping("/load")
	public ResponseEntity<Void> loadAllByTitle(@RequestBody List<String> names) {
		names.forEach(this.loadService::loadMoviesWithTitleSearch);
		return ResponseEntity.noContent().build();
	}

//	@GetMapping()
//	public ResponseEntity<Page<Movie>> search(
//			@RequestParam("imdbId") String imdbId,
//			@RequestParam("title") String title,
//			@RequestParam("actors") String actors,
//			@RequestParam("genre") String genre
//	) {
//
//		this.movieService.search(imdbId, title, actors, genre)
//
//	}




}
