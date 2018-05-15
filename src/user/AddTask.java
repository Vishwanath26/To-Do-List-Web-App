package user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

import static user.LoginAndLogout.loginUser;


@Controller
public class AddTask {
    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public @ResponseBody void Add(@RequestBody NewTask task ,HttpServletRequest request)throws Exception
    {
        DAO dao = new DAO();
        String userId = loginUser.getUserId();
        String Task = task.getTask();

        String Query = "INSERT INTO Tasks(userId,task,action) VALUES(?,?,?);";

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection(dao.con.Url, dao.con.User, dao.con.Password);
                PreparedStatement psmt = connection.prepareStatement(Query);
                psmt.setString(1,userId);
                psmt.setString(2,Task);
                psmt.setString(3,"insert");
                psmt.executeUpdate();
    }
}
