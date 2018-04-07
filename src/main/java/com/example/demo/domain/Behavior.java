package com.example.demo.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * Created by Summer on 2018/4/7.
 */

@TableName("behavior")
public class Behavior {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("userId")
    private Integer userId;

    @TableField("romanceType")
    private Integer romanceType;

    @TableField("actionType")
    private Integer actionType;

    @TableField("thrillerType")
    private Integer thrillerType;

    @TableField("comedyType")
    private Integer comedyType;

    @TableField("scifiType")
    private Integer scifiType;

    @TableField("crimeType")
    private Integer crimeType;

    @TableField("warType")
    private Integer warType;

    @TableField("animationType")
    private Integer animationType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRomanceType() {
        return romanceType;
    }

    public void setRomanceType(Integer romanceType) {
        this.romanceType = romanceType;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Integer getThrillerType() {
        return thrillerType;
    }

    public void setThrillerType(Integer thrillerType) {
        this.thrillerType = thrillerType;
    }

    public Integer getComedyType() {
        return comedyType;
    }

    public void setComedyType(Integer comedyType) {
        this.comedyType = comedyType;
    }

    public Integer getScifiType() {
        return scifiType;
    }

    public void setScifiType(Integer scifiType) {
        this.scifiType = scifiType;
    }

    public Integer getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(Integer crimeType) {
        this.crimeType = crimeType;
    }

    public Integer getWarType() {
        return warType;
    }

    public void setWarType(Integer warType) {
        this.warType = warType;
    }

    public Integer getAnimationType() {
        return animationType;
    }

    public void setAnimationType(Integer animationType) {
        this.animationType = animationType;
    }

}
