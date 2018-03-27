package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Comment;
import com.example.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment>{

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 获取评论列表
     *
     * @return
     */
    public List<Comment> getComment(Integer movieId, Integer pageNo, Integer pageSize){
        Page <Comment> page = new Page<>();
        page.setSize(pageNo);
        page.setCurrent(pageSize);
        return commentMapper.getComment(page,movieId);
    }

    /**
     *
     * @param userId 评论者id
     * @param movieId 评论电影id
     * @param content 评论内容
     * @param score 评分
     * @return
     */
    public boolean addComment(Integer userId, Integer movieId,String content,double score){
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
}
