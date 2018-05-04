package com.legally.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
class Register{

    public String firstName = null;
    public String lastName = null;
    public String email = null;
    public String password = null;
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public @ResponseBody void Register(HttpServletRequest request)
    {
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        email = request.getParameter("email");
        password = request.getParameter("password");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
    }
};
