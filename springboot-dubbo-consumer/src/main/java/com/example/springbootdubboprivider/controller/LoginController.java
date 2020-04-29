package com.example.springbootdubboprivider.controller;


import com.sergei.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sergei
 * @create 2020-03-01
 */
@Controller
@Slf4j
public class LoginController {

    @RequestMapping({"/","login"})
    public String index(Model model){
        model.addAttribute("user",new User());
        log.info("登录。。。");
        return "login";
    }

//    @RequestMapping("/")
//    public String login(HttpServletRequest request){
//        request.getSession().setAttribute("user","1");
//        return "ok";
//    }

//    @RequestMapping("/get")
//    public String getUserId(HttpServletRequest request){
//        String a = (String) request.getSession().getAttribute("user");
//        return "consumer1 user ="+a+"";
//    }


}
