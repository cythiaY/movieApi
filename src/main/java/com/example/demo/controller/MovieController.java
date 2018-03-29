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
     *
     * @orderType 1：最新 2：最热
     */
    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    public ResponseDO getMovies(@RequestParam(value = "id", required = false) Integer id,
                                @RequestParam(value = "orderType", required = false) Integer orderType,
                                @RequestParam(value = "movieType", required = false) String movieType,
                                @RequestParam(value = "year", required = false) Integer year,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "page_no", required = false, defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "page_size", required = false, defaultValue = "10") Integer pageSize) {
        return new ResponseDO(movieService.getMovies(id, orderType, movieType, year, keyword, pageNo, pageSize));

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
    @RequestMapping(value = "/delete/Movies")
    public ResponseDO deleteMovies(@RequestParam(value = "id") Integer id) {
        return new ResponseDO(movieService.deleteMovie(id));
    }

    /**
     * 新增电影
     */
    @RequestMapping(value = "/add/Movies", method = RequestMethod.POST)
    public ResponseDO addMovies(@RequestBody Movie movie) {
        return new ResponseDO(movieService.addMovie(movie));
    }

}
