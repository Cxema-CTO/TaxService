package com.example.taxservice.command.implementation;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.User;
import com.example.taxservice.password.EncodePassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class Login implements OpenPage {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserDAO.getUserFromDB(userName);
        String whichJSPtoRedirect = "";

        if (user != null) {
            if (Objects.equals(user.getUserName(), userName) && Objects.equals(user.getPassword(), EncodePassword.getHashPassword(password))) {
                request.getSession().setAttribute("user_name", user.getUserName());
                if (user.isInspector()) {
                    request.getSession().setAttribute("role", "inspector");
                } else {
                    request.getSession().setAttribute("role", "user");
                }
                whichJSPtoRedirect = "index.jsp";
            }
            if (Objects.equals(user.getUserName(), userName) && !Objects.equals(user.getPassword(), EncodePassword.getHashPassword(password))) {
                request.getSession().setAttribute("error_message", "error.incorrect_password");
                whichJSPtoRedirect = "error.jsp";
            }
        } else {
            request.getSession().setAttribute("error_message", "error.don't_find_user");
            whichJSPtoRedirect = "error.jsp";
        }

        return whichJSPtoRedirect;
    }
}
