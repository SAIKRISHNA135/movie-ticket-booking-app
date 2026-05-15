package com.moviebooking.movie_ticket_app.controller;

import com.moviebooking.movie_ticket_app.model.Movie;
import com.moviebooking.movie_ticket_app.service.MovieService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String home() {
        return "redirect:/movies-page";
    }

    @GetMapping("/add-movie")
    public String addMoviePage(Model model) {

        model.addAttribute("movie", new Movie());

        return "add-movie";
    }

    @PostMapping("/save-movie")
    public String saveMovie(@Valid @ModelAttribute Movie movie, BindingResult result) {

        if(result.hasErrors()){
            return "add-movie";
        }

        movieService.addMovie(movie);

        return "redirect:/movies-page";
    }

    @GetMapping("/movies-page")
    public String moviesPage(Model model) {

        model.addAttribute(
                "movies",
                movieService.getAllMovies()
        );

        return "movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return "redirect:/movies-page";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id,
                            Model model) {

        Movie movie =
                movieService.getMovieById(id);

        model.addAttribute("movie", movie);

        return "edit-movie";
    }

    @PostMapping("/update-movie")
    public String updateMovie(
            @Valid @ModelAttribute Movie movie,
            BindingResult result) {

        if (result.hasErrors()) {
            return "edit-movie";
        }

        movieService.addMovie(movie);

        return "redirect:/movies-page";
    }

    @GetMapping("/search")
    public String searchMovies(
            @RequestParam String keyword,
            Model model) {

        model.addAttribute(
                "movies",
                movieService.searchMovies(keyword)
        );

        return "movies";
    }
}