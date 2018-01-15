package com.qa.cinema.business.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.*;

import com.qa.cinema.movie.Movie;
import com.qa.cinema.util.JSONUtil;

@Transactional(Transactional.TxType.SUPPORTS)
public class MovieService {
	@PersistenceContext (unitName = "primary")
	private EntityManager em;
	
	private JSONUtil jsonUtil = new JSONUtil();
	
	public Movie findMovie(Long id) {
		return em.find(Movie.class, id);
	}
	
	public List<Movie> findAllMovies() {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m order by m.title",Movie.class);
		return query.getResultList();
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
    public Movie create(Movie movie) {
        em.persist(movie);
        return movie;
    }
	
	@Transactional(Transactional.TxType.REQUIRED)
    public String delete(long id) {
        em.remove(findMovie(id));
        return "mooooovie deleted";
    }
	
	@Transactional(Transactional.TxType.REQUIRED)
    public String update(String movie) {
		Movie newMovie = jsonUtil.getObjectForJSON(movie, Movie.class);
        em.merge(newMovie);
        return "updated";
    }


}
