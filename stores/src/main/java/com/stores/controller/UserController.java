package com.stores.controller;

import com.stores.model.Store;
import com.stores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/{userId}/stores", method = RequestMethod.GET)
    public Iterable<Store> getStoresByUserId(@PathVariable("userId") long userId) {
        return userService.getStoresByUserId(userId);
    }

    @RequestMapping(value = "/users/{userId}/stores/{storeId}", method = RequestMethod.PUT)
    public void markFavouriteStoreForUser(@PathVariable("userId") long userId,
                                          @PathVariable("storeId") long storeId) {
        userService.markFavouriteStoreForUser(userId, storeId);
    }

    @RequestMapping(value = "/users/{userId}/stores/{storeId}", method = RequestMethod.DELETE)
    public void unmarkFavouriteStoreForUser(@PathVariable("userId") long userId,
                                            @PathVariable("storeId") long storeId) {
        userService.unmarkFavouriteStoreForUser(userId, storeId);
    }
}
