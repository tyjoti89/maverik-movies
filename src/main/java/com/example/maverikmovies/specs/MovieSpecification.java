package com.example.maverikmovies.specs;

import com.example.maverikmovies.model.Movie;
import org.springframework.data.jpa.domain.Specification;

public interface MovieSpecification {

	static Specification<Movie> imdbIdLike(String imdbId) {
		return (movie, cq, cb) -> cb.like(cb.lower(movie.get("imdbId")), "%" + imdbId.toLowerCase() + "%");
	}

	static Specification<Movie> actorsLike(String actors) {
		return (movie, cq, cb) -> cb.like(cb.lower(movie.get("actors")), "%" + actors.toLowerCase() + "%");
	}

	static Specification<Movie> genreLike(String genre) {
		return (movie, cq, cb) -> cb.like(cb.lower(movie.get("genre")), "%" + genre.toLowerCase() + "%");
	}

	static Specification<Movie> titleLike(String title) {
		return (movie, cq, cb) -> cb.like(cb.lower(movie.get("title")), "%" + title.toLowerCase() + "%");
	}


}
