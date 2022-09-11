package com.example.taxservice.controller;

import com.example.taxservice.action.Action;
import com.example.taxservice.action.ActionFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AppController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        getAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        getAction(request, response);
    }

    private void getAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            Action action = ActionFactory.getInstance().getAction(request);
            action.execute(request, response);
        } catch (IOException | ServletException exception) {
            LOGGER.error(exception, exception);
        }
    }
}
