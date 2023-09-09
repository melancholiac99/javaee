package com.sbjv.sportplay.Controller;
import com.alibaba.fastjson.JSON;
import com.sbjv.sportplay.bean.QueryInfo;
import com.sbjv.sportplay.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sbjv.sportplay.Dao.UserDao;

import java.util.HashMap;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    private UserDao udao;
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数与当前编号
        int numbers=udao.getUserCounts("%"+queryInfo.getQuery()+"%");
        int pageStart=(queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users=udao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object>res=new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        System.out.println(res_string);
        return res_string;
    }
    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("state") Boolean state){
        int i = udao.updateState(id, state);
        String str = i >0?"success":"error";
           return str;
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = udao.addUser(user);
        return i>0?"success":"error";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = udao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }
    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        User user = udao.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
    }
    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = udao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }
    @RequestMapping("/editRules")
    public String editRules(@RequestBody User user){
        int i = udao.editRules(user);
        return i > 0 ? "success" : "fail";
    }

}
