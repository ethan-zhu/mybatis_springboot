package cn.no7player.mapper;

import cn.no7player.model.User;

import java.util.List;

/**
 * Created by ethan on 2018/2/06.
 */
public interface UserMapper {
    public User findUserInfo(String name);
}
