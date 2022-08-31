package com.example.taxservice;

import com.example.taxservice.dao.ReportDAO;
import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.Report;
import com.example.taxservice.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@WebServlet(name = "UserViewServlet", value = "/user")
public class UserViewServlet extends HttpServlet {
    static int currentPage = 0;
    int totalPages = 0;
    User sendUser = new User();
    List<Report> reports = null;
    List<Report> sendReports = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String receiveRequest = request.getParameter("sendRequest");

        if (Objects.equals(receiveRequest, "user")) {
            String receiveGetUser = request.getParameter("userName");
            sendUser = UserDAO.getUserFromDB(receiveGetUser);
            request.setAttribute("user", sendUser);
            sendReports.clear();
            reports = ReportDAO.getAllUserReports(sendUser.getUserName());
            request.setAttribute("sizeReports", reports.size());
            request.setAttribute("view", "reports");
            if (reports.size() > 10) {
                totalPages = reports.size() / 10;
                request.setAttribute("pagination", "yes");
                paginationReports(request);
            } else {
                request.setAttribute("pagination", "no");
                sendReports.addAll(reports);
            }
            request.setAttribute("reports", sendReports);
            request.getRequestDispatcher("tableViewUser.jsp").forward(request, response);
        }

    }

    private void paginationReports(HttpServletRequest request) {
        String receiveRequest = request.getParameter("page");
        if (currentPage > totalPages) currentPage = totalPages;
        if (Objects.equals(receiveRequest, "current")) {
            preparationListSendReport(currentPage);
        }
        if (Objects.equals(receiveRequest, "next")) {
            currentPage++;
            if (currentPage >= totalPages) currentPage = totalPages;
            preparationListSendReport(currentPage);
        }
        if (Objects.equals(receiveRequest, "before")) {
            currentPage--;
            if (currentPage < 0) currentPage = 0;
            preparationListSendReport(currentPage);
        }
    }

    private void preparationListSendReport(int currentPage) {

        sendReports.clear();
        if (reports.size() < 10) {
            sendReports.addAll(reports);
        } else {
            if (currentPage >= totalPages) {
                for (int i = (currentPage * 10); i < reports.size(); i++) {
                    sendReports.add(reports.get(i));
                }
            } else {
                for (int i = (currentPage * 10); i < 10 + (currentPage * 10); i++) {
                    sendReports.add(reports.get(i));
                }
            }
        }
    }
    //end
}
