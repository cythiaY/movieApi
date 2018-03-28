package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Movie;
import com.example.demo.dto.PageDTO;
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


    public PageDTO<Movie> getMovies(Integer id, Integer orderType, String movieType, Integer year, String keyword, Integer pageNo, Integer pageSize) {
        Page<Movie> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        List<Movie> movies = movieMapper.getMovies(page, id, orderType, movieType, year, keyword);
        PageDTO<Movie> pageDTO = new PageDTO<>();
        pageDTO.setCurrent(pageNo);
        pageDTO.setSize(pageSize);
        pageDTO.setTotal(page.getTotal());
        pageDTO.setRecords(movies);
        return pageDTO;
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
