package home.elitej.controller;

import home.elitej.annotation.Inject;
import home.elitej.model.Restaurant;
import home.elitej.service.MockRestaurantServiceImpl;
import home.elitej.service.RestaurantService;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Restaurant> restaurantList = restaurantService.selectBunchRestaurant(1, 5);
        req.setAttribute("restaurantList", restaurantList);
        RequestDispatcher dispatcher = req.getRequestDispatcher(FOLDER + PAGE_RESTAURANTS);
        dispatcher.forward(req, resp);
    }
}
