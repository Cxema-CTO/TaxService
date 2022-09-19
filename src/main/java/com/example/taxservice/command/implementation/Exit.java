package com.example.taxservice.command.implementation;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.User;
import com.example.taxservice.password.EncodePassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class Exit implements OpenPage {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("role", "guest");
        return "index.jsp";
    }
}
