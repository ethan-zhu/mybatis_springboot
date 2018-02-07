package cn.no7player.service;

import cn.no7player.mapper.UserMapper;
import cn.no7player.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ethan on 2018/2/06.
 */

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(String name){
        User user=userMapper.findUserInfo(name);
        log.info("user.name:",user.getName());
        //User user=null;
        return user;
    }

}
