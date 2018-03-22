package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.domain.Comment;

import java.util.List;

/**
 * Created by Summer on 2018/3/22.
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> getComment();
}
