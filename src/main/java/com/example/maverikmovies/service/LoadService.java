package com.example.maverikmovies.service;

import com.example.maverikmovies.model.ImdbRecord;
import com.example.maverikmovies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LoadService {

	private final MovieService movieService;
	private final ImdbService imdbService;

	@Autowired
	public LoadService(MovieService movieService, ImdbService imdbService) {
		this.movieService = movieService;
		this.imdbService = imdbService;
	}

	public void loadMoviesWithTitleSearch(String title) {
		List<ImdbRecord> records = this.imdbService.findAllByTitle(title);
		List<Movie> movies = records.stream()
				.map(basicRecord -> {
					ImdbRecord details = this.imdbService.findOneByImdbId(basicRecord.getImdbID());
					return this.convertImdbRecord(details);
				})
				.toList();

		// TODO check for duplicates by imdbId before saving
		this.movieService.saveMovies(movies);
	}

	private Movie convertImdbRecord(ImdbRecord imdbR) {
		Movie movie = new Movie();
		movie.setImdbId(imdbR.getImdbID());
		movie.setImdbRating(imdbR.getImdbRating());
		movie.setRated(imdbR.getRated());
		movie.setActors(imdbR.getActors());
		movie.setGenre(imdbR.getGenre());
		movie.setReleased(imdbR.getReleased());
		movie.setYear(imdbR.getYear());
		movie.setTitle(imdbR.getTitle());
		return movie;
	}
}
