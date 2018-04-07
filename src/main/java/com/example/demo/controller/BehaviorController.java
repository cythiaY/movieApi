package com.example.demo.controller;

import com.example.demo.service.BehaviorService;
import com.example.demo.utils.ResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Summer on 2018/4/7.
 */
@RestController
@RequestMapping("/behavior")
public class BehaviorController {

    @Autowired
    private BehaviorService behaviorService;

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    public ResponseDO updateUser(@RequestParam(value = "userId", required = true) Integer userId,
                                 @RequestParam(value = "romanceTypeNum", required = false) Integer romanceTypeNum,
                                 @RequestParam(value = "actionTypeNum", required = false) Integer actionTypeNum,
                                 @RequestParam(value = "thrillerTypeNum", required = false) Integer thrillerTypeNum,
                                 @RequestParam(value = "comedyTypeNum", required = false) Integer comedyTypeNum,
                                 @RequestParam(value = "scifiTypeNum", required = false) Integer scifiTypeNum,
                                 @RequestParam(value = "crimeTypeNum", required = false) Integer crimeTypeNum,
                                 @RequestParam(value = "warTypeNum", required = false) Integer warTypeNum,
                                 @RequestParam(value = "animationTypeNum", required = false) Integer animationTypeNum
    ) {

        boolean result = behaviorService.updateBehaviorById(userId, actionTypeNum);
        return new ResponseDO(result);
    }
}
