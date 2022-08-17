package com.example.taxservice;

import com.example.taxservice.dao.UserDAO;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateUserServlet", value = "/create_user")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        boolean isLegal = false;
        try {
            if (request.getParameter("is_legal").equals("on")) isLegal = true;
        } catch (NullPointerException exception) {
//            System.out.println("is_legal null");
        }


        if (UserDAO.assertHasUserInDBbyUserName(userName)) {
            request.getSession().setAttribute("error_message", "error.assert_username");
            response.sendRedirect("error.jsp");
        } else {
            if (!password.equals(confirmPassword)) {
                request.getSession().setAttribute("error_message", "error.incorrect_password");
                response.sendRedirect("error.jsp");
            } else {
                try {
                    UserDAO.createNewUserInDB(userName, password, isLegal);
                    request.getSession().setAttribute("role", "user");
                    request.getSession().setAttribute("user_name", userName);
                    response.sendRedirect("index.jsp");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

