package AAAA_test;

import com.example.taxservice.dao.UserDAO;

import java.sql.SQLException;

import static com.example.taxservice.dao.UserDAO.assertHasUserByLogin;

public class test {


    public static void main(String[] args) throws SQLException {
        UserDAO.updateUserByLogin("Vasia","tosia");
        UserDAO.createNewUser("figaro");
    }
}

