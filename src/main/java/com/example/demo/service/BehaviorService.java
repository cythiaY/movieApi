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
public class BehaviorService extends ServiceImpl<BehaviorMapper, Behavior> {
    @Autowired
    private BehaviorMapper behaviorMapper;

    /**
     * 更新用户行为记录
     */
    public boolean updateBehaviorById(Integer id, Boolean romanceTypeNum, Boolean actionTypeNum, Boolean thrillerTypeNum, Boolean comedyTypeNum, Boolean scifiTypeNum, Boolean crimeTypeNum, Boolean warTypeNum, Boolean animationTypeNum) {
        Behavior behavior = behaviorMapper.selectByUserId(id);
        if (behavior.getIsNew() == 1) {
            behavior.setIsNew(0);
        }
        if (romanceTypeNum) {
            if (behavior.getRomanceType() != null) {
                behavior.setRomanceType(behavior.getRomanceType() + 1);
            } else {
                System.out.println(behavior.getRomanceType());
                behavior.setRomanceType(1);
            }
        }
        if (actionTypeNum) {
            if (behavior.getAnimationType() != null) {
                behavior.setActionType(behavior.getAnimationType() + 1);
            } else {
                behavior.setActionType(1);
            }
        }
        if (thrillerTypeNum) {
            if (behavior.getThrillerType() != null) {
                behavior.setThrillerType(behavior.getThrillerType() + 1);
            } else {
                behavior.setThrillerType(1);
            }
        }
        if (comedyTypeNum) {
            if (behavior.getComedyType() != null) {
                behavior.setComedyType(behavior.getComedyType() + 1);
            } else {
                behavior.setComedyType(1);
            }
        }
        if (scifiTypeNum) {
            if (behavior.getScifiType() != null) {
                behavior.setScifiType(behavior.getScifiType() + 1);
            } else {
                behavior.setScifiType(1);
            }
        }
        if (crimeTypeNum) {
            if (behavior.getCrimeType() != null) {
                behavior.setCrimeType(behavior.getCrimeType() + 1);
            } else {
                behavior.setCrimeType(1);
            }
        }
        if (warTypeNum) {
            if (behavior.getWarType() != null) {
                behavior.setWarType(behavior.getWarType() + 1);
            } else {
                behavior.setWarType(1);
            }
        }
        if (animationTypeNum) {
            if (behavior.getAnimationType() != null) {
                behavior.setAnimationType(behavior.getAnimationType() + 1);
            } else {
                behavior.setAnimationType(1);
            }
        }
        return updateById(behavior);
    }

    public Behavior getBehaviorById(Integer userId) {
        if (behaviorMapper.selectByUserId(userId) == null) {
            Behavior behavior = new Behavior();
            behavior.setUserId(userId);
            behavior.setIsNew(1);
            insert(behavior);
            return behavior;
        } else {
            Behavior behavior = behaviorMapper.selectByUserId(userId);
            return behavior;
        }
    }
}
