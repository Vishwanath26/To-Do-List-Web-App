package com.legally.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class Login {


    @RequestMapping(value = "/Login", method = RequestMethod.POST)

    public @ResponseBody ModelAndView showLogin(HttpServletRequest request) throws SQLException {
        String email = request.getParameter("email");
        String pswd = request.getParameter("password");

        DAO dao = new DAO(email,pswd);
        ModelAndView mv = new ModelAndView();
        if(dao.result!=null) {
            mv.setViewName("To-Do List");
            mv.addObject("firstName", dao.result);
        }
        else
        {
            mv.setViewName("index");
            mv.addObject("LoginError", "Invalid username and password!");
        }
        return  mv;

    }

}
