package com.example.taxservice.command.factory;

import com.example.taxservice.command.OpenPage;
import com.example.taxservice.command.PagesEnum;
import com.example.taxservice.controller.MethodsOfRedirect;

import javax.servlet.http.HttpServletRequest;

public final class PagesFactory {

    private PagesFactory() {
    }

    public static OpenPage getURL(HttpServletRequest req) {
        String command = req.getParameter("open");
        OpenPage openPage = null;

        if (command != null) {
            try {
                openPage = PagesEnum.valueOf(command).getPage();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                openPage = PagesEnum.ERROR_404.getPage();
            }
        } else {
            openPage = PagesEnum.ERROR_404.getPage();
        }
        return openPage;
    }

}
