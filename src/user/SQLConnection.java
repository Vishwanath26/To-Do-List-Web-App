package user;

public class SQLConnection {
        public String Url;
        public String User;
        public String Password;

        public SQLConnection(){
            this.Url =  "jdbc:mysql://localhost:3306/vishwanath";
            this.User = "root";
            this.Password = "qwerty";
        }
};
