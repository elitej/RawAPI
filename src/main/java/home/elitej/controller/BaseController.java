package home.elitej.controller;

import home.elitej.configuration.BeanHolder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public abstract class BaseController extends HttpServlet {
    static final String FOLDER = "/views/";
    private static volatile BeanHolder beanHolder;
    private static final Object lock = new Object();

    @Override
    public void init(ServletConfig config) {
        if (beanHolder == null) {
            synchronized (lock) {
                if (beanHolder == null) {
                    String pathToXmlConfig = config.getServletContext().getInitParameter("pathToXmlConfig");
                    beanHolder = new BeanHolder(pathToXmlConfig);
                }
            }
        }
        configureController(this);
    }

    private void configureController(HttpServlet controller) {
        beanHolder.tuneBean(this);
    }
}
