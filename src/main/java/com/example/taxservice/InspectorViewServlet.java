package com.example.taxservice;

import com.example.taxservice.dao.ReportDAO;
import com.example.taxservice.dao.UserDAO;
import com.example.taxservice.entity.Report;
import com.example.taxservice.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;


@WebServlet(name = "InspectorViewServlet", value = "/inspector")
public class InspectorViewServlet extends HttpServlet {
    static int currentPage = 0;
    int totalPages = 0;
    List<User> users = null;
    List<User> sendUsers = new ArrayList<>();
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


        if (Objects.equals(receiveRequest, "users")) {
            sendUsers.clear();
            users = UserDAO.getAllUsers();
            request.setAttribute("size", users.size());
            request.setAttribute("view", "users");
            if (users.size() > 10) {
                totalPages = users.size() / 10;
                request.setAttribute("pagination", "yes");
                paginationUsers(request);
            } else {
                request.setAttribute("pagination", "no");
                sendUsers.addAll(users);
            }
            request.setAttribute("users", sendUsers);
            request.getRequestDispatcher("tableViewUsers.jsp").forward(request, response);
        }


        if (Objects.equals(receiveRequest, "reports")) {
            sendReports.clear();
            reports = ReportDAO.getAllReports();
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
            request.getRequestDispatcher("tableViewReports.jsp").forward(request, response);
        }
    }

    private void paginationUsers(HttpServletRequest request) {
        String receiveRequest = request.getParameter("page");
        if (currentPage > totalPages) currentPage = totalPages;
        if (Objects.equals(receiveRequest, "current")) {
            preparationListSendUser(currentPage);
        }
        if (Objects.equals(receiveRequest, "next")) {
            currentPage++;
            if (currentPage >= totalPages) currentPage = totalPages;
            preparationListSendUser(currentPage);
        }
        if (Objects.equals(receiveRequest, "before")) {
            currentPage--;
            if (currentPage < 0) currentPage = 0;
            preparationListSendUser(currentPage);
        }
    }

    private void preparationListSendUser(int currentPage) {
        sendUsers.clear();
        if (users.size() < 10) {
            sendUsers.addAll(users);
        } else {
            if (currentPage >= totalPages) {
                for (int i = (currentPage * 10); i < users.size(); i++) {
                    sendUsers.add(users.get(i));
                }
            } else {
                for (int i = (currentPage * 10); i < 10 + (currentPage * 10); i++) {
                    sendUsers.add(users.get(i));
                }
            }
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
