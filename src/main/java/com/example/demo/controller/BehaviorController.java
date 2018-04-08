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
     * 修改用户行为记录
     */
    @RequestMapping("/update")
    public ResponseDO updateUser(@RequestParam(value = "userId", required = true) Integer userId,
                                 @RequestParam(value = "romanceTypeNum", required = false, defaultValue = "false") Boolean romanceTypeNum,
                                 @RequestParam(value = "actionTypeNum", required = false, defaultValue = "false") Boolean actionTypeNum,
                                 @RequestParam(value = "thrillerTypeNum", required = false, defaultValue = "false") Boolean thrillerTypeNum,
                                 @RequestParam(value = "comedyTypeNum", required = false, defaultValue = "false") Boolean comedyTypeNum,
                                 @RequestParam(value = "scifiTypeNum", required = false, defaultValue = "false") Boolean scifiTypeNum,
                                 @RequestParam(value = "crimeTypeNum", required = false, defaultValue = "false") Boolean crimeTypeNum,
                                 @RequestParam(value = "warTypeNum", required = false, defaultValue = "false") Boolean warTypeNum,
                                 @RequestParam(value = "animationTypeNum", required = false, defaultValue = "false") Boolean animationTypeNum
    ) {
        boolean result = behaviorService.updateBehaviorById(userId, romanceTypeNum, actionTypeNum, thrillerTypeNum, comedyTypeNum, scifiTypeNum, crimeTypeNum, warTypeNum, animationTypeNum);
        return new ResponseDO(result);
    }

    /**
     * 获取用户行为记录
     */
    @RequestMapping("/getBehavior")
    public ResponseDO getBehavior(@RequestParam(value = "userId") Integer userId) {
        return new ResponseDO(behaviorService.getBehaviorById(userId));
    }
}
