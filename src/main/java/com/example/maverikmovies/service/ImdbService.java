package com.example.maverikmovies.service;

import com.example.maverikmovies.exception.ImdbException;
import com.example.maverikmovies.model.ImdbRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ImdbService {
	@Value("${maverik.imdb.host}")
	private String imdbHost;

	private final RestTemplate restTemplate;

	@Autowired
	public ImdbService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<ImdbRecord> findAllByTitle(String titleQuery) {
		try {
			String moviesUrl = this.imdbHost + "/movie/api/movie/title/" + titleQuery + "?source=web";
			ImdbRecord[] records = this.restTemplate.getForObject(moviesUrl, ImdbRecord[].class);
			return Arrays.asList(records);
		} catch (Exception e) {
			throw new ImdbException(e);
		}
	}

	public ImdbRecord findOneByImdbId(String imdbId) {
		try {
			String moviesUrl = this.imdbHost + "/movie/api/movie/"+ imdbId +"?source=web";
			return this.restTemplate.getForObject(moviesUrl, ImdbRecord.class);
		} catch (Exception e) {
			throw new ImdbException(e);
		}
	}
}
