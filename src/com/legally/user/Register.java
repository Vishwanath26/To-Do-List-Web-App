package com.legally.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
class Register{

    public String firstName = null;
    public String lastName = null;
    public String email = null;
    public String password = null;
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public @ResponseBody ModelAndView Register(HttpServletRequest request)
    {
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        email = request.getParameter("newEmail");
        password = request.getParameter("newPassword");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        //For checking registered user
        try {
            DAO dao = new DAO(email,password);
            if(dao.result != null)
            {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("index");
                mv.addObject("RegisterError", "You are already registered please Login");
                return mv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //For registering new user
        RegisterDAO registerDAO = new RegisterDAO(user);
        ModelAndView mv = new ModelAndView();
            mv.setViewName("To-Do List");
            mv.addObject("firstName", registerDAO.firstName);
            return mv;
    }
};
