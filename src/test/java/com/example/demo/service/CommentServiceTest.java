package com.example.demo.service;

import com.example.demo.BaseTest;
import com.example.demo.domain.Comment;
import com.example.demo.dto.PageDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceTest extends BaseTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void getComment() throws Exception {
        PageDTO<Comment> comment = commentService.getComment(111116, 1, 10);
        System.out.println(comment.getRecords().size());
        System.out.println(comment.getTotal());
    }

    @Test
    public void addComment() throws Exception {
    }

    @Test
    public void deleteComment() throws Exception {
    }

    @Test
    public void updateComment() throws Exception {
    }

}