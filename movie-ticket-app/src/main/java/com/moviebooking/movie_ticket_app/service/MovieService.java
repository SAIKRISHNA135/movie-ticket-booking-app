package com.moviebooking.movie_ticket_app.service;

import com.moviebooking.movie_ticket_app.model.Movie;
import com.moviebooking.movie_ticket_app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> searchMovies(String keyword) {

        return movieRepository
                .findByTitleContainingIgnoreCase(keyword);
    }
}