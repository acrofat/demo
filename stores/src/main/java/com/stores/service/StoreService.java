package com.stores.service;

import com.stores.model.Store;
import com.stores.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Iterable<Store> getStores() {
        return storeRepository.findAll();
    }
}
