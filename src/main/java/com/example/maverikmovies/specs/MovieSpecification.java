package com.example.maverikmovies.specs;

import com.example.maverikmovies.model.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class MovieSpecification  {


	public static Predicate withField(CriteriaBuilder cb, Root<Movie> root, String field, String value) {
		return cb.equal(root.get(field), value);
	}



}
