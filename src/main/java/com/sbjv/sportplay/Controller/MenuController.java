package com.sbjv.sportplay.Controller;

import com.alibaba.fastjson.JSON;
import com.sbjv.sportplay.Dao.MenuDao;
import com.sbjv.sportplay.bean.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDao menudao;
    @CrossOrigin
    @RequestMapping("/menus")
     public String getAllMenus(){
         HashMap<String,Object> data = new HashMap<>();
         List<MainMenu> menus = menudao.getMenus();
         int status = 200;// 成功 404 错误 200
         if(menus != null){
             data.put("data",menus);
             data.put("status",status);
         }
         else data.put("flag",404);
         String s = JSON.toJSONString(data);

          return s;
     }
}
