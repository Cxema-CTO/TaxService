package com.example.taxservice.command.implementation;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RegistrationNewUser implements OpenPage {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String whichJSPtoRedirect = "";

        boolean isLegal = false;
        try {
            if (request.getParameter("is_legal").equals("on")) isLegal = true;
        } catch (NullPointerException exception) {
//            System.out.println("is_legal null");
        }


        if (UserDAO.assertHasUserInDBbyUserName(userName)) {
            request.getSession().setAttribute("error_message", "error.assert_username");
            whichJSPtoRedirect ="error.jsp";
        } else {
            if (!password.equals(confirmPassword)) {
                request.getSession().setAttribute("error_message", "error.incorrect_password");
                whichJSPtoRedirect ="error.jsp";
            } else {
                try {
                    UserDAO.createNewUserInDB(userName, password, isLegal);
                    request.getSession().setAttribute("role", "user");
                    request.getSession().setAttribute("user_name", userName);
                    whichJSPtoRedirect ="index.jsp";
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return whichJSPtoRedirect;
    }
}
