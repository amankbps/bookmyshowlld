package org.aman.bms.controllers;


import org.aman.bms.models.Movie;
import org.aman.bms.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable long id) {

        Optional<Movie> movie=movieService.getMovieById(id);
        if(movie.isPresent()) {
            return movie.get();
        }
        else{
            throw new RuntimeException("Movie not found");
        }
    }
}
