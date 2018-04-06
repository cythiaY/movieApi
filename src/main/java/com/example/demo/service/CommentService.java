package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Movie;
import com.example.demo.dto.PageDTO;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.utils.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

/**
 * Created by Summer on 2018/3/22.
 */
@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private MovieService movieService;

    /**
     * 根据电影id获取评论列表
     *
     * @return
     */
    public PageDTO<Comment> getComment(Integer movieId, String keyword, Integer pageNo, Integer pageSize) {
        Page<Comment> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(pageSize);
        List<Comment> comments = commentMapper.getComment(page, movieId, keyword);
        PageDTO<Comment> pageDTO = new PageDTO<>();
        pageDTO.setCurrent(pageNo);
        pageDTO.setSize(pageSize);
        pageDTO.setTotal(page.getTotal());
        pageDTO.setRecords(comments);
        return pageDTO;
    }

    /**
     * @param userId  评论者id
     * @param movieId 评论电影id
     * @param content 评论内容
     * @param score   评分
     * @return
     */
    public boolean addComment(Integer userId, Integer movieId, String content, double score) {
        Comment comment = new Comment();
        comment.setMovieId(movieId);
        comment.setUserId(userId);
        comment.setContent(content);
        comment.setScore(score);
        comment.setTime(new Date());
        return insert(comment);
    }

    public boolean deleteComment(Integer commentId) {
        return deleteById(commentId);
    }

    public boolean updateComment(Comment comment) {
        return updateById(comment);
    }

    public List<Movie> getRecommendMovies(Integer userId) {
        List<Comment> comments = selectList(null);
        BufferedWriter csvFileOutputStream  = null;
        try {
            csvFileOutputStream =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./data.csv")), "UTF-8"), 1024);
            for (int i = 0; i < comments.size() ; i++) {
                csvFileOutputStream.write(comments.get(i).getUserId()+","+comments.get(i).getMovieId()+","+comments.get(i).getScore());
                if(i != comments.size()-1){
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (IOException e) {
            try {
                csvFileOutputStream.close();
            } catch (IOException e1) {
            }
        }

        List<Movie> movies = new ArrayList<>();
        try {
            List<Integer> main = Main.main(userId);
            for (Integer integer : main) {
                Movie movie = movieService.selectById(integer);
                movies.add(movie);
            }
        } catch (Exception e) {
        }
        return movies;
    }
}
