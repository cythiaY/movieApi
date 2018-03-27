package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
public interface MovieMapper extends BaseMapper<Movie> {

    List<Movie> getMovies(@Param("id") String id, @Param("orderType") Integer orderType, @Param("movieType") String movieType, @Param("year") Integer year, @Param("keyword") String keyword);

}
