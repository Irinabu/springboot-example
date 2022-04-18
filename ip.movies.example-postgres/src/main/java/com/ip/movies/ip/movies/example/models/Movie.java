package com.ip.movies.ip.movies.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMovie;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_actors", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private List<Actor> actors;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    private boolean hasCaptions;
    private Date releaseDate;

    public UUID getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(UUID idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public boolean isHasCaptions() {
        return hasCaptions;
    }
}
