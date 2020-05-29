package com.lambda.web.mappers;

import com.lambda.web.movie.MovieDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {

    public int count();


    public MovieDTO selectMovie(String searchWord);
    public MovieDTO insert(MovieDTO params);
    public MovieDTO updateMovie();
    public MovieDTO deleteMovie();
}
