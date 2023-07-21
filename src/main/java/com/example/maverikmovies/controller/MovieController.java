package com.example.maverikmovies.controller;

import com.example.maverikmovies.model.Movie;
import com.example.maverikmovies.service.LoadService;
import com.example.maverikmovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
		return ResponseEntity.noContent()
				.build();
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

	@GetMapping("/{id}")
	public ResponseEntity<Movie> findOne(@PathVariable("id") Integer movieId) {
		Movie movie = this.movieService.findOneById(movieId);
		return ResponseEntity.ok(movie);
	}

	@PostMapping()
	public ResponseEntity<Movie> createOne(@RequestBody Movie movie) {
		return ResponseEntity.ok(this.movieService.saveMovie(movie));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateOne(
			@PathVariable("id") Integer movieId,
			@RequestBody Movie movie) {
		Movie saved = this.movieService.updateMovie(movieId, movie);
		return ResponseEntity.ok(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable("id") Integer movieId) {
		this.movieService.deleteMovie(movieId);
		return ResponseEntity.noContent()
				.build();
	}


}
