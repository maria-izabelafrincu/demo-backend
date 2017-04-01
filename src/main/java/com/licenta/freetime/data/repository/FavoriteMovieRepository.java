package com.licenta.freetime.data.repository;

import com.datastax.driver.mapping.Mapper;
import com.licenta.freetime.data.CassandraPersistenceService;
import com.licenta.freetime.data.accessors.FavoriteMovieAccessor;
import com.licenta.freetime.data.domain.FavoriteMovie;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by izabe on 4/1/2017.
 */

@Repository
public class FavoriteMovieRepository {
    private final CassandraPersistenceService persistenceService;
    private final FavoriteMovieAccessor accessor;

    public FavoriteMovieRepository(CassandraPersistenceService persistenceService) {
        this.persistenceService = persistenceService;
        this.accessor = persistenceService.getMappingManager().createAccessor(FavoriteMovieAccessor.class);
    }

    public void saveFavoriteMovie(FavoriteMovie favoriteMovie) {
        Mapper<FavoriteMovie> mapper = persistenceService.getMappingManager().mapper(FavoriteMovie.class);
        mapper.save(favoriteMovie);
    }

    public void deleteFavoriteMovie(String email, String title) {
        accessor.deleteFavoriteMovie(email, title);
    }

    public FavoriteMovie getFavoriteMovie(String email, String title) {
        return accessor.getFavoriteMovie(email, title);
    }

    public List<FavoriteMovie> getFavoriteMoviesOfAUser(String email) {
        return accessor.getFavoriteMoviesOfAUser(email).all();
    }

}
