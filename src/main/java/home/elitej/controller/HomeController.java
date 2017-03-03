package home.elitej.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends BaseController {
    private static final String PAGE_HOME = "home.jsp";
//    private static final String PAGE_HOME = "test.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(FOLDER + PAGE_HOME);
        dispatcher.forward(req, resp);
    }
}
