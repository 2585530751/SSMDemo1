package com.neusoft.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.entity.EasybuyUser;
import com.neusoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    //声明用户的业务逻辑接口  使用注解注入对象
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get",method = {RequestMethod.POST})
    public @ResponseBody String getUser(@RequestParam(required = true) Integer uid){
        //1取  2调  3转
        //2
        EasybuyUser user=userService.getUser(uid);
        //3
        return JSONObject.toJSONString(user);
     }

     @RequestMapping(value = "/loginservice",method = {RequestMethod.POST})
     public void loginService(@RequestParam(required = true) String uname,
                                @RequestParam(required = true) String upwd,
                                HttpSession session,
                                HttpServletResponse response) throws IOException {

        //1取  取参数  见形参
         // 2调 调用业务逻辑层
        EasybuyUser user=userService.getUser(uname,upwd);
        //不为空则登录成功
        if(user!=null){
            //记录登录状态 让后面访问的页面都知道我已登录
            // 将用户信息存放入session中
            // session对象存储在服务端
            session.setAttribute("user",user);

            //如需要免登录则需要在客户端记录登录信息
            //通过cookie对象实现
            Cookie cookie=new Cookie("userId",String.valueOf(user.getId()));
            Cookie cookie2=new Cookie("userName",user.getLoginname());
            cookie.setMaxAge(120);
            cookie2.setMaxAge(120);

            response.addCookie(cookie);
            response.addCookie(cookie2);

            response.sendRedirect("/index.jsp");
        }
        else
        {
            //登录不成功,返回登录页面
            response.sendRedirect("/login.html");
        }

     }

     //现在都不使用cookie登录 此处只教大家cookie怎么读写
     @RequestMapping("/index")
     public String userLoginForCookie(HttpServletRequest request,
                                    HttpServletResponse response,
                                    HttpSession session) throws IOException {
        Cookie[] cookies=request.getCookies();
        Integer uid=0;
        if(cookies!=null)
            for (Cookie cookie:cookies) {
                 if("userId".equals(cookie.getName())){
                     uid=Integer.parseInt(cookie.getValue());
                     break;
                 }
             }

         if(uid==0) {
             return "redirect:/login.html";
         }

         EasybuyUser user=userService.getUser(uid);
         if(user!=null){
             //记录登录状态 让后面访问的页面都知道我已登录
             // 将用户信息存放入session中
             // session对象存储在服务端
             session.setAttribute("user",user);
             return "redirect:/index.jsp";
         }
         else
         {
             return "redirect:/login.html";
         }

     }

     @RequestMapping("/logout")
     public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
     }
}
