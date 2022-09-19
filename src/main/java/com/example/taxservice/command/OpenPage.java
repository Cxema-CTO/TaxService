package com.example.taxservice.command;

import com.example.taxservice.controller.MethodsOfRedirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OpenPage {

    String execute(HttpServletRequest req, HttpServletResponse resp);
}
