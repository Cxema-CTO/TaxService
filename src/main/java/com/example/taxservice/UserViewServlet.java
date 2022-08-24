package com.example.taxservice;

import com.example.taxservice.dao.UserDAO;
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
//    static int currentPage = 0;
//    int totalPages = 0;
//    List<User> users = null;
//    List<User> sendUsers = new ArrayList<>();
//    User sendUser = new User();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        users = UserDAO.getAllUsers();
//        request.setAttribute("size", users.size());
//        String receiveRequest = request.getParameter("sendRequest");
//
//
//        if (Objects.equals(receiveRequest, "user")) {
//            String receiveGetUser = request.getParameter("userName");
//            sendUser = UserDAO.getUserFromDB(receiveGetUser);
//            request.setAttribute("user", sendUser);
////            System.out.println(sendUser+ " "+receiveGetUser);
//            request.getRequestDispatcher("tableViewUser.jsp").forward(request, response);
//        }
//
//        if (Objects.equals(receiveRequest, "users")) {
//            request.setAttribute("view", "users");
//            if (users.size() > 10) {
//                totalPages = users.size() / 10;
////                System.out.println(sendUsers.size() % 10);// test delete!!!!
//                // щоб не показувало наступну чисту сторінку у таблиці
////                if (sendUsers.size() % 10 == 0 && totalPages > 0) totalPages--;
//                request.setAttribute("pagination", "yes");
//                pagination(request);
//            } else {
//                request.setAttribute("pagination", "no");
//                sendUsers.addAll(users);
//            }
//
////            System.out.println(totalPages);
//            request.setAttribute("users", sendUsers);
//            request.getRequestDispatcher("tableViewUsers.jsp").forward(request, response);
//        }
//    }
//
//    private void pagination(HttpServletRequest request) {
//        String receiveRequest = request.getParameter("page");
//        if (Objects.equals(receiveRequest, "current")) {
//            preparationListSendUsers(currentPage);
//        }
//        if (Objects.equals(receiveRequest, "next")) {
//            currentPage++;
//            if (currentPage >= totalPages) currentPage = totalPages;
//            preparationListSendUsers(currentPage);
//        }
//        if (Objects.equals(receiveRequest, "before")) {
//            currentPage--;
//            if (currentPage < 0) currentPage = 0;
//            preparationListSendUsers(currentPage);
//        }
//    }
//
//    private void preparationListSendUsers(int currentPage) {
//        sendUsers.clear();
//        if (users.size() < 10) {
//            sendUsers.addAll(users);
//        } else {
//            if (currentPage >= totalPages) {
//                for (int i = (currentPage * 10); i < users.size(); i++) {
//                    sendUsers.add(users.get(i));
//                }
//            } else {
//                for (int i = (currentPage * 10); i < 10 + (currentPage * 10); i++) {
//                    sendUsers.add(users.get(i));
//                }
//            }
//        }
////        System.out.println("fUckinDruckenTable");
//    }
    //end
}
