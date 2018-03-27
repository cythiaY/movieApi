package com.example.demo.controller;

import com.example.demo.domain.Movie;
import com.example.demo.service.MovieService;
import com.example.demo.utils.ResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Summer on 2018/3/22.
 */

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 查询电影信息
     */
    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    public ResponseDO getMovies(@RequestParam(value = "id", required = false) String id,
                                @RequestParam(value = "orderType", required = false) Integer orderType,
                                @RequestParam(value = "movieType", required = false) String movieType,
                                @RequestParam(value = "year", required = false) Integer year,
                                @RequestParam(value = "keyword", required = false) String keyword) {
        return new ResponseDO(movieService.getMovies(id, orderType, movieType, year, keyword));
    }

    /**
     * 更新电影信息
     */
    @RequestMapping(value = "/update/Movies", method = RequestMethod.POST)
    public ResponseDO updateMovies(@RequestBody Movie movie) {
        return new ResponseDO(movieService.updateMovie(movie));
    }

    /**
     * 删除电影信息
     */
    @RequestMapping(value = "/delete/Movies", method = RequestMethod.POST)
    public ResponseDO deleteMovies(@RequestParam(value = "id", required = false) String id) {
        return new ResponseDO(movieService.deleteMovie(id));
    }

    /**
     * 删除电影信息
     */
    @RequestMapping(value = "/add/Movies", method = RequestMethod.POST)
    public ResponseDO addMovies(@RequestBody Movie movie) {
        return new ResponseDO(movieService.addMovie(movie));
    }
}
