package com.rob.movies;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class MovieDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Movie> getAllMovies() {
		Query query=em.createQuery("SELECT m FROM Movie m");
		return query.getResultList();
	}
	
	public Movie getMovie(int id) {
		return em.find(Movie.class, id);
	}
	
	public void save(Movie movie){
		em.persist(movie);
	}
	
	public void update(Movie movie){
		Movie m = em.find(Movie.class, movie.getId());
		m.setBudget(movie.getBudget());
		m.setCountry(movie.getCountry());
		m.setDescription(movie.getDescription());
		m.setOnLoan(movie.getOnLoan());
		m.setPicture(movie.getPicture());
		m.setRentalPrice(movie.getRentalPrice());
		m.setTitle(movie.getTitle());
		m.setYear(movie.getYear());
		em.persist(m);
	}
	
	public void remove(int id){
		Movie m = em.find(Movie.class, id);
		  em.remove(m);
	}
	
	public Movie getMovie(String title) {
		return em.find(Movie.class, title);
	}
}
