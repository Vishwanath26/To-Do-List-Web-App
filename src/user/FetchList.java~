package user;


import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class FetchList {

    public String json = null;
    HashMap Fetch(ResultSet rs) throws SQLException {
        HashMap<Integer, String> map = new HashMap<>();
        while(rs.next())
        {
            String task = rs.getString("task");
            Integer taskId = rs.getInt("taskId");
            map.put(taskId,task);
        }
        json = new Gson().toJson(map);
        System.out.println(json);

        return map;
    }



}
/*
HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate();
        }
        //generate a new session
        HttpSession newSession = request.getSession(true);

        //setting session to expiry in 5 mins
        newSession.setMaxInactiveInterval(5 * 60);

        Cookie message = new Cookie("firstName", dao.result);
        response.addCookie(message);
        response.sendRedirect("To-Do List.jsp");
 */
