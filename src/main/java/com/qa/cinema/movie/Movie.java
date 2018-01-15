package com.qa.cinema.movie;

import javax.persistence.*;


@Entity
public class Movie {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(length = 100)
	private String title;
	@Column(length = 50)
	private String genre;
	@Column(length = 4)
	private String ageRating;
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAgeRating() {
		return ageRating;
	}
	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}
	public Movie(Long id, String title, String genre, String ageRating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.ageRating = ageRating;
	}
	
}
