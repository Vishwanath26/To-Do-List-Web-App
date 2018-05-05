package user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@Controller
public class LoginAndLogout {


    @RequestMapping(value = "/Login", method = RequestMethod.POST)

    public @ResponseBody
    ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException, IOException, ClassNotFoundException {
        String email = request.getParameter("email");
        String pswd = request.getParameter("password");
        LoginUser loginUser = new LoginUser();
        loginUser.setEmail(email);
        loginUser.setPassword(pswd);
        DAO dao = new DAO();
        dao.GetUser(email,pswd);
       // dao.excecuteSql("Tasks" , "*" , "" , 'S');
       if(dao.result!=null) {
           dao.executeSelectFilterSql("Tasks", "task , messageId", Arrays.asList("userId", "action"), Arrays.asList(dao.userId, "insert"));
       }
        ModelAndView mv = new ModelAndView();
        if(dao.result!=null) {
            mv.setViewName("To-Do List");
            mv.addObject("task", dao.task);
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);

            //setting session to expiry in 5 mins
            newSession.setMaxInactiveInterval(5*60);

            Cookie message = new Cookie("firstName",  dao.result);
            response.addCookie(message);
            response.sendRedirect("To-Do List.jsp");
        }
        else
        {
            mv.setViewName("index");
            mv.addObject("LoginError", "Invalid username and password!");
        }
        return  mv;

    }
    @RequestMapping(value = "/Logout", method = RequestMethod.POST)
    public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        ModelAndView mv = new ModelAndView();
            mv.setViewName("index");

            return mv;
    }

}
