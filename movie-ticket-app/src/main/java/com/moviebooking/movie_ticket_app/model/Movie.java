package com.moviebooking.movie_ticket_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Min(value = 1,
            message = "Duration must be greater than 0")
    private Integer duration;

    @NotBlank(message = "Language is required")
     private String language;
    private String posterUrl;

}
