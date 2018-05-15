package user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static user.LoginAndLogout.loginUser;

@Controller
public class DeleteToDo {
    @RequestMapping(value = "/Delete", method = RequestMethod.POST)
    public @ResponseBody
    void Delete(@RequestBody DeleteTask task , HttpServletRequest request)throws Exception
    {
        DAO dao = new DAO();
        String action = task.getAction();
        int taskId = task.getTaskId();
        String Query = "UPDATE Tasks SET action = ? WHERE taskId = ?;";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection(dao.con.Url, dao.con.User, dao.con.Password);
        PreparedStatement psmt = connection.prepareStatement(Query);
        psmt.setString(1,action);
        psmt.setInt(2, taskId);

        psmt.executeUpdate();
    }
}
