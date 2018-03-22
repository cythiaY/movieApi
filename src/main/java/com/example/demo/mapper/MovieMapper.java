package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.Movie;

import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
public interface MovieMapper extends BaseMapper<Movie>{

    List<Movie> getMovies();

}
