package com.qa.cinema.business.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.*;

import com.qa.cinema.movie.Movie;

@Transactional(Transactional.TxType.SUPPORTS)
public class MovieService {
	@PersistenceContext (unitName = "primary")
	private EntityManager em;
	
	public Movie findMovie(Long id) {
		return em.find(Movie.class, id);
	}
	
	public List<Movie> findAllMovies() {
		TypedQuery<Movie> query = em.createQuery("SELECT * FROM Movie",Movie.class);
		return query.getResultList();
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
    public Movie create(Movie movie) {
        em.persist(movie);
        return movie;
    }
	
	@Transactional(Transactional.TxType.REQUIRED)
    public Movie delete(Movie movie) {
        em.remove(movie);
        return movie;
    }
	
	@Transactional(Transactional.TxType.REQUIRED)
    public Movie update(Movie movie) {
        em.merge(movie);
        return movie;
    }


}
