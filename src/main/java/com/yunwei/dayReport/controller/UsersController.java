package com.yunwei.dayReport.controller;

import com.yunwei.dayReport.dao.UsersService;
import com.yunwei.dayReport.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller

@ResponseBody

@RequestMapping({"users"})
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping({"weiLogin"})

    @ResponseBody
    public Users login(String userName, String passWord) throws IOException {

        Users user = new Users();

        System.out.print("这是微信小程序前端填入的用户名和密码" + userName + passWord);


        String rightUserName = this.usersService.getUserName(userName);

        String rightPassword = this.usersService.getPassWord(userName);


        user.setUserName(rightUserName);

        user.setPassWord(rightPassword);


        System.out.print(user.getUserName());

        System.out.print(user.getPassWord());


        System.out.print("这是通过输入的用户名从数据库查到的用户名和密码" + rightUserName + rightPassword);

        return user;

    }


    @PostMapping({"selectUserLogin"})

    @ResponseBody
    public Users selectUserlogin(@RequestParam String userName, @RequestParam String passWord, HttpSession httpSession) {

        Users user = this.usersService.selectUserlogin(userName, passWord);

        return user;

    }


    @GetMapping({"selectUserByDate"})

    @ResponseBody
    public List<Users> selectUserByDate(String date) {

        List<Users> listuser = this.usersService.selectUserByDate(date);

        return listuser;

    }


    @GetMapping({"selectUsers"})

    @ResponseBody
    public List<Users> selectUsers() {

        List<Users> listuser1 = this.usersService.selectUsers();

        return listuser1;

    }

}
