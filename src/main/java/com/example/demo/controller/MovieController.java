package com.example.demo.controller;

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
     *
     * 查询电影信息
     *
     */
    @RequestMapping(value = "/getMovies",method = RequestMethod.GET)
    public ResponseDO getMovies(@RequestParam(value = "id",required = false) String id){
        return new ResponseDO(movieService.getMovies(id));
    }
}
