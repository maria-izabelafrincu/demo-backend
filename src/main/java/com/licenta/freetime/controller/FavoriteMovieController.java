package com.licenta.freetime.controller;

import com.licenta.freetime.data.domain.FavoriteMovie;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.licenta.freetime.data.repository.FavoriteMovieRepository;
import java.util.Date;
import java.util.List;

/**
 * Created by izabe on 4/1/2017.
 */

@CrossOrigin(allowedHeaders = "*")
@RestController("favorite-movies")
public class FavoriteMovieController {
    private final FavoriteMovieRepository favoriteMovieRepository;

    public FavoriteMovieController(FavoriteMovieRepository favoriteMovieRepository) {
        this.favoriteMovieRepository = favoriteMovieRepository;
    }

    @PostMapping(value = "favorite-movies/{email}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FavoriteMovie createFavoriteMovie(@RequestBody FavoriteMovie favoriteMovie, @PathVariable("email") String email) {
        favoriteMovie.setCreatedOn(new Date());
        favoriteMovie.setEmail(email);
        favoriteMovieRepository.saveFavoriteMovie(favoriteMovie);
        return favoriteMovie;
    }

    @GetMapping(value = "favorite-movies/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<FavoriteMovie> getAllFavoriteMovies(@PathVariable("email") String email) {
        return favoriteMovieRepository.getFavoriteMoviesOfAUser(email);
    }

    @GetMapping(value = "favorite-movies/{email}/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FavoriteMovie getFavoriteMovie(@PathVariable("email") String email, @PathVariable("title") String title) {
        return favoriteMovieRepository.getFavoriteMovie(email, title);
    }

    @DeleteMapping(value = "favorite-movies/{email}/{title}")
    public void deleteFavoriteMovie(@PathVariable("email") String email, @PathVariable("title") String title) {
        favoriteMovieRepository.deleteFavoriteMovie(email, title);
    }
}
