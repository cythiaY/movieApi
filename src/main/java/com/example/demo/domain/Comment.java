package com.example.demo.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * Created by Summer on 2018/3/22.
 */

@TableName("comment")
public class Comment {

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer id;

    @TableField("comment_content")
    private String content;

    @TableField("comment_userid")
    private String userId;

    @TableField("comment_username")
    private String userName;

    @TableField("comment_movieid")
    private String movieId;

    @TableField("comment_moviename")
    private String movieName;

    @TableField("comment_score")
    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @TableField("comment_time")
    private Date time;

}
