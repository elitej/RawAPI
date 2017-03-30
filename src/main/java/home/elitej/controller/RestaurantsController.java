package home.elitej.controller;

import home.elitej.annotation.Inject;
import home.elitej.model.entity.Restaurant;
import home.elitej.service.MockRestaurantServiceImpl;
import home.elitej.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RestaurantsController extends BaseController {

    private static final String PAGE_RESTAURANTS = "restaurants.jsp";
    @Inject
    private RestaurantService restaurantService = new MockRestaurantServiceImpl();

    private static Logger logger = LoggerFactory.getLogger(RestaurantsController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("retrieves data from the storage");
        List<Restaurant> restaurantList = restaurantService.selectOrderedBundle(1, 5);
        req.setAttribute("restaurantList", restaurantList);

        logger.debug("forwards data to {}", PAGE_RESTAURANTS);
        RequestDispatcher dispatcher = req.getRequestDispatcher(FOLDER + PAGE_RESTAURANTS);
        dispatcher.forward(req, resp);
    }
}
