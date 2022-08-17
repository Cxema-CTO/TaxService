package com.example.taxservice;

import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserDAO.getUserFromDB(userName);

        if (user != null) {
            if (Objects.equals(user.getUserName(), userName) && Objects.equals(user.getPassword(), password)) {
                request.getSession().setAttribute("user_name", user.getUserName());
                if (user.isInspector()) {
                    request.getSession().setAttribute("role", "inspector");
                } else {
                    request.getSession().setAttribute("role", "user");
                }
                response.sendRedirect("index.jsp");
            }
            if (Objects.equals(user.getUserName(), userName) && !Objects.equals(user.getPassword(), password)) {
                request.getSession().setAttribute("error_message", "error.incorrect_password");
                response.sendRedirect("error.jsp");
            }
        } else {
            request.getSession().setAttribute("error_message", "error.don't_find_user");
            response.sendRedirect("error.jsp");
        }
    }
}
