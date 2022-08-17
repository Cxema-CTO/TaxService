package com.example.taxservice;

import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.User;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "InspectorViewServlet", value = "/inspector")
public class InspectorViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receiveRequest = request.getParameter("sendRequest");
        if(Objects.equals(receiveRequest, "users")){
            List<User> users = UserDAO.getAllUsers();

            request.setAttribute("users",users);
            request.getRequestDispatcher("tableView.jsp").forward(request,response);

//            Gson gson = new Gson();
//            String answer = gson.toJson(users);
//            response.getWriter().write(answer);
//            response.getWriter().flush();
//            response.getWriter().close();
        }
    }
}
