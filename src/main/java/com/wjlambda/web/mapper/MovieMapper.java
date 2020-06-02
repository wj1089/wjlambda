package com.wjlambda.web.mapper;

import com.wjlambda.web.movie.MovieDTO;
import com.wjlambda.web.proxy.Pager;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieMapper {
    public void insertMovie(MovieDTO movie);
    public void updateMovie(MovieDTO movie);
    public void deleteMovie(MovieDTO movie);
    public MovieDTO selectMovie(String movieNo);
    public int count();
    public List<MovieDTO> selectMovies(Pager pager);

}
