package home.elitej.controller;

import home.elitej.annotation.Inject;
import home.elitej.model.entity.Restaurant;
import home.elitej.controller.service.MockRestaurantServiceImpl;
import home.elitej.controller.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RatingController extends BaseController{
    private static final String PAGE_RATING = "rating.jsp";
    @Inject
    private RestaurantService restaurantService = new MockRestaurantServiceImpl();

    private static Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("retrieves data from the storage");
        List<Restaurant> restaurantList = restaurantService.selectOrderedBundle(1, 4);
        req.setAttribute("restaurantList", restaurantList);

        logger.debug("forwards data to the {}", PAGE_RATING);
        RequestDispatcher dispatcher = req.getRequestDispatcher(FOLDER + PAGE_RATING);
        dispatcher.forward(req, resp);
    }
}
