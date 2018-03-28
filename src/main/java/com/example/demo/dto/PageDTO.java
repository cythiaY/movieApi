package com.example.demo.dto;

import java.util.Collections;
import java.util.List;

/**
 * Created by lenovo on 2017/3/27.
 */
public class PageDTO<T> {
    /* 总数 */
    private int total;

    /* 每页显示条数，默认 10 */
    private int size = 10;

    /* 当前页 */
    private int current = 1;

    // 当前页数据
    private List<T> records = Collections.emptyList();

    public PageDTO() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
