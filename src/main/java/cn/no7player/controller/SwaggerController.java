package cn.no7player.controller;

import cn.no7player.model.User;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethan on 2018/2/6.
 */
@RestController
@RequestMapping(value = "/users")
public class SwaggerController {

    /*
     *  http://localhost:8080/swagger/index.html
     */

    /**
     * @return
     */
    @ApiOperation(value = "Get all users", notes = "requires noting")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();

        User user = new User();
        user.setName("hello1");
        user.setPassword("pwd");
        user.setBalance(new BigDecimal("500000"));
        list.add(user);

        User user2 = new User();
        user2.setName("hello2");
        user2.setPassword("pwd");
        user2.setBalance(new BigDecimal("200000"));
        list.add(user2);

        User user3 = new User();
        user3.setName("hello3");
        user3.setPassword("pwd");
        user3.setBalance(new BigDecimal("100000"));
        list.add(user3);

        return list;
    }

    @ApiOperation(value = "Get user with id", notes = "requires the id of user")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String name) {
        List<User> list = getUsers();
        for (User user : list) {
            if(user.getName().equals(name))
            return user;
        }
        User user = new User();
        user.setName("hello world");
        return user;
    }

    @ApiOperation(value = "Get user with user object", notes = "requires the id of user")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User getUser(@RequestBody User name) {
        List<User> list = getUsers();
        for (User user : list) {
            user.equals(name);
            return user;
        }
        User user = new User();
        user.setName("hello world");
        return user;
    }

}
