package com.sbjv.sportplay.Controller;

import com.alibaba.fastjson.JSON;
import com.sbjv.sportplay.Dao.UserDao;
import com.sbjv.sportplay.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;
    @CrossOrigin
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag = "error";
        User us = userDao.getUserByMessage(user.getName(),user.getPassword());
        HashMap<String,Object> res = new HashMap<>();
        if(us!= null){
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",user);
        String res_json = JSON.toJSONString(res);
        System.out.println("user"+us + "flag" + flag);
        return res_json;
    }
}
