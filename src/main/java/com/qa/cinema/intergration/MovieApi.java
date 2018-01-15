package com.qa.cinema.intergration;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.qa.cinema.business.repository.MovieService;
import com.qa.cinema.movie.Movie;
import com.qa.cinema.util.JSONUtil;

@Path("/cinema")
public class MovieApi {
	@Inject
	MovieService movieService;
	
	@Inject
	JSONUtil jsonUtil;
	
	@Path("/json")
	@GET
	public String getAllFilms() {
		List<Movie> movies = movieService.findAllMovies();
		return jsonUtil.getJSONForObject(movies);
	}
	
	@Path("/json/{id}")
	@GET
	public String getFilm(@PathParam("id") long id) {
		Movie movie = movieService.findMovie(id);
		return jsonUtil.getJSONForObject(movie);
	}
	
	@Path("/json/{id}")
	@DELETE
	public String deleteFilm(@PathParam("id") long id) {
		return movieService.delete(id);
	}
	
	@Path("/json")
	@POST
	public String addFilm(String movie) {
		Movie movieToAdd = jsonUtil.getObjectForJSON(movie, Movie.class);
		 movieService.create(movieToAdd);
		 return movie;
	}
	
	@Path("/json")
	@PUT
	public String updateFilm(String movie) {
		return movieService.update(movie);
		
	}
}
