package com.stores.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "storeId")
public class Store {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "store_id", nullable = false)
    private Long storeId;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_address", nullable = false)
    private String storeAddress;

    @Column(name = "state_name")
    private String stateName;

    private String postcode;

    @ManyToMany(mappedBy = "likedStores", cascade = CascadeType.ALL)
    private Set<User> followedUsers;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long id) {
        this.storeId = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String name) {
        this.storeName = name;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String address) {
        this.storeAddress = address;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String state) {
        this.stateName = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getStoreId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(!(obj instanceof Store)) return false;
        Store store = (Store)obj;
        return Objects.equals(this.getStoreId(), store.getStoreId());
    }
}
