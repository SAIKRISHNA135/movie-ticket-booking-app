package com.moviebooking.movie_ticket_app.repository;

import com.moviebooking.movie_ticket_app.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContainingIgnoreCase(String title);

}