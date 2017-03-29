package home.elitej.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BaseController extends HttpServlet {
    static final String FOLDER = "/views/";
    private static final String PAGE_NOT_FOUND = "404.jsp";

    private final Map<String, String> pathsToFullNames = new ConcurrentHashMap<>();
    private final Map<String, HttpServlet> controllers = new ConcurrentHashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        getPaths(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpServlet controller = getController(path);
        if (controller != null) {
            controller.service(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(FOLDER + PAGE_NOT_FOUND);
            requestDispatcher.forward(req, resp);
        }

    }

    private void getPaths(ServletConfig config) {
        Enumeration<String> initName = config.getInitParameterNames();
        while (initName.hasMoreElements()) {
            String path = initName.nextElement();
            if (path.startsWith("path:")) {
                String exactPath = path.substring(6);
                String controllerName = config.getInitParameter(path);
                pathsToFullNames.putIfAbsent(exactPath, controllerName);
            }
        }
    }

    private HttpServlet getController(String path) {
        if (!controllers.containsKey(path)) {

        }
    }

    private HttpServlet initController(String name) {

    }
}
