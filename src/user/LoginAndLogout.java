package user;

import com.google.gson.Gson;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Controller
public class LoginAndLogout {


    public static LoginUser loginUser = new LoginUser();
//login controller
    @RequestMapping(value = "/Login", method = RequestMethod.POST)

    public @ResponseBody String showLogin(@RequestBody LoginUser user , HttpServletRequest request , HttpServletResponse response) throws Exception {
        String Email = user.getEmail();
        String pswd = user.getPassword();
        loginUser.setEmail(Email);
        loginUser.setPassword(pswd);
        DAO dao = new DAO();
        dao.GetUser(Email, pswd);
        loginUser.setUserId((dao.userId));
        if (dao.result != null) {
            ResultSet rs = dao.executeSelectFilterSql("Tasks", "task , taskId", Arrays.asList("userId", "action"), Arrays.asList(dao.userId, "insert"));
            FetchList fetchList = new FetchList();//getting hashmap from resultset
            String json = new Gson().toJson(fetchList.Fetch(rs));//casting map to json using gson
            System.out.println(json);
            return json;
        }

        return (new Gson().toJson("Error"));
    }
    //Logout Controller
    @RequestMapping(value = "/Logout", method = RequestMethod.POST)
    public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        loginUser = null;

        return mv;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson("Error"));
    }

}
