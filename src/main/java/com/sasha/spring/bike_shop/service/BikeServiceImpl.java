package com.sasha.spring.bike_shop.service;

import com.sasha.spring.bike_shop.dao.BikeDAO;
import com.sasha.spring.bike_shop.entity.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeDAO bikeDAO;

    @Override
    @Transactional
    public List<Bike> getAllBikes() {
        return bikeDAO.getAllBikes();
    }

    @Override
    @Transactional
    public void saveBike(Bike bike) {
        bikeDAO.saveBike(bike);
    }

    @Override
    @Transactional
    public Bike getBike(int id) {
        return bikeDAO.getBike(id);
    }

    @Override
    @Transactional
    public void deleteBike(int id) {
        bikeDAO.deleteBike(id);
    }
}
