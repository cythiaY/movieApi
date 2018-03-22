package com.example.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Movie;
import com.example.demo.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
public class MovieService extends ServiceImpl<MovieMapper, Movie>{
    @Autowired
    private MovieMapper movieMapper;

    public List<Movie> getMovies(){
        return movieMapper.getMovies();
    }
}
