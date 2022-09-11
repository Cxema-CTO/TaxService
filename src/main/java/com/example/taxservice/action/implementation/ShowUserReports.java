package com.example.taxservice.action.implementation;

import com.example.taxservice.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.taxservice.constant.ActionConstant.SHOW_USER_REPORTS;

public class ShowUserReports implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(SHOW_USER_REPORTS);
    }
}
