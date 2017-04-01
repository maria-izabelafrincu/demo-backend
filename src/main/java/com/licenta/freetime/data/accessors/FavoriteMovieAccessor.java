package com.licenta.freetime.data.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;
import com.licenta.freetime.data.domain.FavoriteMovie;

/**
 * Created by izabe on 4/1/2017.
 */
@Accessor
public interface FavoriteMovieAccessor {
//    @Query("insert into favorite_movies (email, movie_title, genre, overview, created_on, updated_on ) values (?,?,?,,?,?,?)")
//    FavoriteMovie saveFavoriteMovie(@Param("email") String email);

    @Query("select * FROM favorite_movies WHERE email=:email")
    Result<FavoriteMovie> getFavoriteMoviesOfAUser(@Param("email") String email);

    @Query("select * FROM favorite_movies WHERE email=:email AND movie_title=:title")
    FavoriteMovie getFavoriteMovie(@Param("email") String email, @Param("title") String title);

    @Query("delete FROM favorite_movies WHERE email=:email AND movie_title=:title")
    void deleteFavoriteMovie(@Param("email") String email, @Param("title") String title);
}
