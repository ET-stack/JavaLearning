package com.xiao.controller;/**
 * Created by 小飞 on 2019/8/2.
 */

import com.xiao.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 小飞
 * @Auther: 小飞
 * @Date: 2019/8/2 23:20
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    //创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private List<User> getUserList() {
        //获得用户列表
        List<User> uSers = new ArrayList<User>(users.values());
        return uSers;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private String postUser(@ModelAttribute User user) {
        //POST 创建User
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private User getUser(@PathVariable Long id) {
        // 处理/users/{id}的get请求 获得user的id信息
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    private String putUser(@PathVariable Long id, @ModelAttribute User user) {
        //PUT 更新 User
        User user1 = users.get(id);
        user1.setName("put 更新数据");
        user1.setAge(999999999);
        users.put(id, user1);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }


}
