package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Movie;
import com.example.demo.mapper.MovieMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
@Service
public class MovieService extends ServiceImpl<MovieMapper, Movie> {
    @Autowired
    private MovieMapper movieMapper;



    public List<Movie> getMovies(String id, Integer orderType, String movieType, Integer year, String keyword,Integer pageNo, Integer pageSize) {
            Page<Movie> page = new Page<>();
            page.setCurrent(pageNo);
            page.setSize(pageSize);

        return movieMapper.getMovies(page,id, orderType, movieType, year, keyword);

    }

    public boolean updateMovie(Movie movie) {
        return updateById(movie);
    }

    public boolean deleteMovie(String id) {
        return deleteById(id);
    }

    public boolean addMovie(Movie movie) {
        return insert(movie);
    }
}
