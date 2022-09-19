package com.example.taxservice.utils;

import com.example.taxservice.dao.ReportDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteReportByIDServlet", value = "/DeleteReportByID")
public class DeleteReportByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ReportDAO.deleteReportInDB(id);
        response.sendRedirect("index.jsp");
    }
}
