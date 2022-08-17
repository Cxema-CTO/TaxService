package AAAA_test;

import com.example.taxservice.dao.UserDAO;

import java.sql.SQLException;

public class test {


    public static void main(String[] args) throws SQLException {
//        UserDAO.updateUserLogin("Vasia", "tosia");
        UserDAO.createNewUserInDB("figaro","pass",false);
//        UserDAO.deleteUserInDB("figaro");
    }
}

