package com.example.maverikmovies.service;

import com.example.maverikmovies.model.Movie;
import com.example.maverikmovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

	private final MovieRepository movieRepository;

	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Page<Movie> findAll(Pageable pageable) {
		return this.movieRepository.findAll(pageable);
	}

	public Optional<Movie> findOneById(Integer id) {
		return this.movieRepository.findById(id);
	}

	public void saveMovie(Movie movie) {
		this.movieRepository.save(movie);
	}

	public void saveMovies(List<Movie> movies) {
		this.movieRepository.saveAll(movies);
	}

	public void deleteMovie(Integer id) {
		this.movieRepository.deleteById(id);
	}

}
