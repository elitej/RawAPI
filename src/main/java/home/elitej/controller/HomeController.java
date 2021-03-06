package home.elitej.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends BaseController {
    private static final String PAGE_HOME = "home.jsp";

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("forwards request to the {}", PAGE_HOME);
        RequestDispatcher dispatcher = req.getRequestDispatcher(FOLDER + PAGE_HOME);
        dispatcher.forward(req, resp);
    }
}
