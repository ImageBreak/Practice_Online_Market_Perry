package net.perry.online_class.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.perry.online_class.model.request.LoginRequest;
import net.perry.online_class.service.UserService;
import net.perry.online_class.utils.JsonData;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){

        int rows = userService.save(userInfo);
        if (rows == 1){
            return JsonData.buildSuccess();
        }else{
            return JsonData.buildError("注册失败,请重试");
        }
    }

    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        if (token == null){
            return JsonData.buildError("登录失败，账号密码错误");
        }else{
            return JsonData.buildSuccess(token);
        }
    }
}
