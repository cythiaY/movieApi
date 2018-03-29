package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> getComment(Page<Comment> page, @Param("movieId") Integer movieId);

    List<Comment> getComments(Page<Comment> page);
}
