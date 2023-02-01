package com.sasha.spring.bike_shop.service;

import com.sasha.spring.bike_shop.entity.Bike;

import java.util.List;

public interface BikeService {
    public List<Bike> getAllBikes();
    public void saveBike(Bike bike);
    public Bike getBike(int id);
    public void deleteBike(int id);
}
