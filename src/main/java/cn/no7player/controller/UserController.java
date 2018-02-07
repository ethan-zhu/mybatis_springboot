package cn.no7player.controller;

import cn.no7player.model.User;
import cn.no7player.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ethan on 2018/2/06.
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get user with id", notes = "requires the id of user")
    @RequestMapping("/getUserInfo/{name}")
    @ResponseBody
    public User getUserInfo(@PathVariable String name) {
        User user = userService.getUserInfo(name);
        log.info("user:{}",user);
        if(user==null) {
            user = new User();
            user.setName("hello world!");
            return user;
        }
        return user;
    }
}
