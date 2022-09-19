package com.example.taxservice.command;

import com.example.taxservice.command.implementation.*;
import com.example.taxservice.controller.MethodsOfRedirect;

public enum PagesEnum {

    USER_ADD_REPORT(new UserAddReportPage()),
    //    USER_EDIT_REPORT(new UserEditReportPage()),
    //    USER_DELETE_REPORT(new UserDeleteReportPage()),
    DB_ADD_REPORT(new DBAddReport()),
    REGISTRATION_NEW_USER(new RegistrationNewUser()),
    REGISTRATION_PAGE(new RegistrationPage()),
    LOGIN(new Login()),
    EXIT(new Exit()),
    HOME_PAGE(new TestPage()),
    ERROR_404(new Error404Page());


    private OpenPage page;

    PagesEnum(OpenPage page) {
        this.page = page;
    }

    public OpenPage getPage() {
        return page;
    }
}
