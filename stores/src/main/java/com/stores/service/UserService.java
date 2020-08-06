package com.stores.service;

import com.stores.model.Store;
import com.stores.model.User;
import com.stores.repository.StoreRepository;
import com.stores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private UserRepository userRepository;
    private StoreRepository storeRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
    }

    public Iterable<Store> getStoresByUserId(long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id: " + userId));
        return user.getLikedStores();
    }

    public void markFavouriteStoreForUser(long userId, long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid store id: " + storeId));
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id: " + userId));
        user.getLikedStores().add(store);
        userRepository.save(user);
    }

    public void unmarkFavouriteStoreForUser(long userId, long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid store id: " + storeId));
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id: " + userId));
        if (user.getLikedStores().remove(store)) {
            userRepository.save(user);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User: " + userId + " has no favourite store: " + storeId);
        }
    }
}
