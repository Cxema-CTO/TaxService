package com.example.taxservice.controller;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.command.factory.PagesFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    public static boolean methodOfRedirectForward = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String location = handleRequest(req, resp);
        if (!methodOfRedirectForward) resp.sendRedirect(location);
        if (methodOfRedirectForward) req.getRequestDispatcher(location).forward(req, resp);
        methodOfRedirectForward = false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String location = handleRequest(req, resp);
        if (!methodOfRedirectForward) resp.sendRedirect(location);
        if (methodOfRedirectForward) req.getRequestDispatcher(location).forward(req, resp);
        methodOfRedirectForward = false;
    }

    private String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        OpenPage openPage = PagesFactory.getURL(req);
        return openPage.execute(req, resp);
    }


}
