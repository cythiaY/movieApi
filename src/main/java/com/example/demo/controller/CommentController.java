package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.utils.ResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Summer on 2018/3/23.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/getComment")
    public ResponseDO getComment(@RequestParam(value = "movieId", required = false) Integer movieId,
                                 @RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(value = "page_no", required = false, defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "page_size", required = false, defaultValue = "10") Integer pageSize) {
        return new ResponseDO(commentService.getComment(movieId, keyword, pageNo, pageSize));
    }

    @RequestMapping("/addComment")
    public ResponseDO addComment(@RequestParam(value = "userId") Integer userId,
                                 @RequestParam(value = "movieId") Integer movieId,
                                 @RequestParam(value = "content") String content,
                                 @RequestParam(value = "score") double score) {
        return new ResponseDO(commentService.addComment(userId, movieId, content, score));
    }

    @RequestMapping("/deleteComment")
    public ResponseDO deleteComment(@RequestParam(value = "comment_id") Integer commentId) {
        return new ResponseDO(commentService.deleteComment(commentId));
    }
}
