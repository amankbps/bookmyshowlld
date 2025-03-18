package org.aman.bms.services;

import org.aman.bms.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public List<Movie> getAllMovies();
    public Optional<Movie> getMovieById(Long id);
}
