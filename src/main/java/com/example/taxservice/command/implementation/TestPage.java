package com.example.taxservice.command.implementation;

import com.example.taxservice.command.OpenPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPage implements OpenPage {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "test.jsp";
	}


}
