package com.example.taxservice.controller;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.command.factory.PagesFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String request = handleRequest(req, resp);
        MethodsOfRedirect methods = methods();
        if (methods == MethodsOfRedirect.REDIRECT) resp.sendRedirect(request);
//        if (methods == MethodsOfRedirect.FORWARD) req.getRequestDispatcher(request).forward(req, resp);
        resp.sendRedirect(request);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String request = handleRequest(req, resp);
//        if (methods == MethodsOfRedirect.REDIRECT) resp.sendRedirect(request);
//        if (methods == MethodsOfRedirect.FORWARD) req.getRequestDispatcher(request).forward(req, resp);
        resp.sendRedirect(request);
    }

    private String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        OpenPage openPage = PagesFactory.getURL(req);
        return openPage.execute(req, resp);
    }

    private  MethodsOfRedirect methods(){
//        MethodsOfRedirect mor = OpenPage;
        return MethodsOfRedirect.REDIRECT;
    }
}
