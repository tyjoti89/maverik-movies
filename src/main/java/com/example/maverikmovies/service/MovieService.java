package com.example.maverikmovies.service;

import com.example.maverikmovies.exception.ResourceNotFoundException;
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

	public Movie findOneById(Integer id) {
		Optional<Movie> opt = this.movieRepository.findById(id);
		return opt.orElseThrow(ResourceNotFoundException::new);
	}

	public Movie saveMovie(Movie movie) {
		return this.movieRepository.save(movie);
	}

	public void saveMovies(List<Movie> movies) {
		this.movieRepository.saveAll(movies);
	}

	public void deleteMovie(Integer id) {
		this.movieRepository.deleteById(id);
	}

	public Movie updateMovie(Integer id, Movie source) {
		Movie target = this.movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie with id does not exist"));
		target.setTitle(source.getTitle());
		target.setActors(source.getActors());
		target.setGenre(source.getGenre());
		target.setYear(source.getYear());
		target.setRated(source.getRated());
		target.setReleased(source.getReleased());
		target.setImdbRating(source.getImdbRating());
		return this.movieRepository.save(target);
	}

}
