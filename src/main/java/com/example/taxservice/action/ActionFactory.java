package com.example.taxservice.action;

import com.example.taxservice.action.implementation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionFactory {

    private static final Map<String, Action> actions = new ConcurrentHashMap<>();

    private static ActionFactory instance = null;

    private ActionFactory() {
    }


    static {
        actions.put("/show_test", new ShowTest());
        actions.put("/show_user_reports", new ShowUserReports());
        actions.put("/500", new ShowError500());
    }


    public static ActionFactory getInstance() {

        if (instance == null) {
            instance = new ActionFactory();
        }
        return instance;
    }

    public Action getAction(HttpServletRequest request) {

        return actions.get(request.getPathInfo().toLowerCase());
    }
}
