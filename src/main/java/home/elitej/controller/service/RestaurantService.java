package home.elitej.controller.service;

import home.elitej.model.entity.Restaurant;

import java.util.List;

public interface RestaurantService extends AbstractService<Restaurant>{
    List<Restaurant> selectOrderedBundle(int fromId, int num);
}
