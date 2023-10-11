package net.perry.online_class.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.perry.online_class.service.UserService;
import net.perry.online_class.utils.JsonData;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){

        int rows = userService.save(userInfo);
        if (rows == 1){
            return JsonData.buildSuccess();
        }else{
            return JsonData.buildError("注册失败,请重试");
        }
    }
}
