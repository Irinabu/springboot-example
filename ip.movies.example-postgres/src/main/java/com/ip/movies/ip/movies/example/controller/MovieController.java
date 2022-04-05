package com.ip.movies.ip.movies.example.controller;

import com.ip.movies.ip.movies.example.model.Movie;
import com.ip.movies.ip.movies.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovieList(){
        List<Movie> movies = service.getMovies();
        return new ResponseEntity<List<Movie>>(movies, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") UUID id){
        Movie foundMovie = service.findByGivenId(id);
        return new ResponseEntity<Movie>(foundMovie, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie newMovie = service.createMovie(movie);
        return new ResponseEntity<Movie>(newMovie, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        service.deleteMovies();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }





}
