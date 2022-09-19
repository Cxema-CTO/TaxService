package com.example.taxservice.command.implementation;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.controller.FrontController;
import com.example.taxservice.controller.MethodsOfRedirect;
import com.example.taxservice.dao.ReportDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DBAddReport implements OpenPage {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)  {
        String userName = (String) req.getSession().getAttribute("user_name");
        String report = req.getParameter("report");
        int type = Integer.parseInt(req.getParameter("report_type"));

        try {
            ReportDAO.createNewReportInDB(userName, report, type);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "index.jsp";
    }
}
