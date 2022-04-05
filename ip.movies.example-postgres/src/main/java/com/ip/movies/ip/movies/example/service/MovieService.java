package com.ip.movies.ip.movies.example.service;

import com.ip.movies.ip.movies.example.model.Movie;
import com.ip.movies.ip.movies.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getMovies() {
        List<Movie> movieList = repository.findAll();
        if (movieList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return movieList;
        }
    }

    public Movie createMovie(Movie movie){
        movie.setIdMovie(UUID.randomUUID());
        movie.setReleaseDate(new Date());
        movie = repository.save(movie);
        return movie;
    }

    public Movie findByGivenId(UUID id){

        List<Movie> movieList = repository.findAll();
        if (!movieList.isEmpty()) {
            for(Movie movie : movieList){
                if(movie.getIdMovie().equals(id)){
                    return movie;
                }
            }
        }
        return new Movie();
    }

    public void deleteMovies(){
        repository.deleteAll();
    }

}
