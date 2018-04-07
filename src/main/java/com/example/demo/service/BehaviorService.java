package com.example.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.domain.Behavior;
import com.example.demo.mapper.BehaviorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Summer on 2018/4/7.
 */
@Service
public class BehaviorService  extends ServiceImpl<BehaviorMapper, Behavior> {
    @Autowired
    private BehaviorMapper behaviorMapper;

    public boolean updateBehaviorById(Integer id,Integer num) {
        Behavior behavior = selectById(id);
        behavior.setActionType(num);
        return updateById(behavior);
    }

}
