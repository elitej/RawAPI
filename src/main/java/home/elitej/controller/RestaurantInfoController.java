package home.elitej.controller;

import home.elitej.annotation.Inject;
import home.elitej.controller.service.MockRestaurantServiceImpl;
import home.elitej.controller.service.RestaurantService;
import home.elitej.model.entity.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestaurantInfoController extends BaseController {
    private static final String PAGE_RESTAURANT_INFO = "restaurant_info.jsp";
    @Inject
    private RestaurantService restaurantService = new MockRestaurantServiceImpl();

    private static Logger logger = LoggerFactory.getLogger(RestaurantInfoController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String restaurantId = req.getPathInfo().substring(1);
        logger.debug("retrieves the restaurant with id={}", restaurantId);
        try {
            int id = Integer.parseInt(restaurantId);
            Restaurant restaurant = restaurantService.selectById(id);
            req.setAttribute("restaurant", restaurant);

            logger.debug("forwards request to the {}", PAGE_RESTAURANT_INFO);
            RequestDispatcher dispatcher = req.getRequestDispatcher(FOLDER + PAGE_RESTAURANT_INFO);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.error("the restaurant with id={} not found", restaurantId);
        }
    }
}
