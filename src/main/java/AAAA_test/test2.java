package AAAA_test;

import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.User;

import java.sql.*;

public class test2 {

    static String url = "jdbc:postgresql://localhost:5432/postgres";
    //    String dbDriver = "org.postgresql.Driver";
    static String user = "postgres";
    static String pass = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_users");

            User user = null;
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("login") + resultSet.getString("password"));
                user = UserDAO.getUserByLogin(resultSet.getString("login"));
                System.out.println(user);
            }

        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}

