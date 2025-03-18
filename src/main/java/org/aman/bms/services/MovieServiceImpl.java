package org.aman.bms.services;

import org.aman.bms.models.Movie;
import org.aman.bms.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
     public MovieServiceImpl(MovieRepository movieRepository) {
         this.movieRepository = movieRepository;
     }
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
}
