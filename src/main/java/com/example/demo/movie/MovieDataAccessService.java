package com.example.demo.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> selectMovies() {
        var sql = """
                SELECT id, name, release_date
                FROM movie
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());

    }

    @Override
    public int insertMovie(Movie movie) {
        var sql = """
                INSERT INTO movie(name, release_date)
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, movie.name(), movie.releaseDate());

    }

    @Override
    public int deleteMovie(int id) {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        throw new UnsupportedOperationException("not implemented");
    }
}
