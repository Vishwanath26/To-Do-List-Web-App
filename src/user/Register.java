package user;

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
    public @ResponseBody
    ModelAndView Register(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String columValue = "";
        firstName = request.getParameter("firstName");
        columValue +=  "'" +firstName + "'"  +",";
        lastName = request.getParameter("lastName");
        columValue += "'" +lastName + "'" + ",";
        email = request.getParameter("newEmail");
        columValue += "'" +email + "'" + ",";
        password = request.getParameter("newPassword");
        columValue += "'" +password + "'";


        String columnList = "";
        User user = new User();
        columnList += "firstName" + ",";
        user.setFirstName(firstName);
        columnList += "lastName" + ",";
        user.setLastName(lastName);
        columnList += "email" + ",";
        user.setEmail(email);
        columnList += "password";
        user.setPassword(password);
        //For checking registered user
        DAO dao = new DAO();
        try {

            dao.GetUser(email, password);
            if (dao.result != null) {
                mv.setViewName("index");
                mv.addObject("RegisterError", "You are already registered please Login");
                return mv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //For registering new user
        //RegisterDAO registerDAO = new RegisterDAO(user);
        //Class<?> c = user.getClass();
        //Field[] fields = c.getDeclaredFields();
        //String columnList  = "";
        //String columnValue = "";
        //for( Field field : fields ) {
        //  columnList +=field.getName() + ",";
        //}


        try {
            dao.excecuteSql("user", columnList, columValue, 'I');


            mv.setViewName("index");
            mv.addObject("msg", user.getFirstName()+",you are successfully registered,please Login");
            return mv;
        }
        catch (Exception exp){
            exp.printStackTrace();
            return mv;
        }
    }
};
