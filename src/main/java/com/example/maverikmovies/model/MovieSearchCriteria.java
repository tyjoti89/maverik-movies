package com.example.maverikmovies.model;

import java.io.Serializable;

public class MovieSearchCriteria implements Serializable {

	String field;
	String value;

	public MovieSearchCriteria(String field, String value) {
		this.field = field;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
