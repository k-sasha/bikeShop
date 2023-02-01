package com.sasha.spring.bike_shop.dao;

import com.sasha.spring.bike_shop.entity.Bike;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BikeDAOImpl implements BikeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bike> getAllBikes() {
        Session session = sessionFactory.getCurrentSession();
        List<Bike> allBikes = session.createQuery("from Bike", Bike.class).
                getResultList();

        return allBikes;
    }

    @Override
    public void saveBike(Bike bike) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(bike);
    }

    @Override
    public Bike getBike(int id) {
        Session session = sessionFactory.getCurrentSession();
        Bike bike= session.get(Bike.class, id);
        return bike;
    }

    @Override
    public void deleteBike(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Bike> query = session.createQuery("delete from Bike "+
                "where id=:bicycleId");
        query.setParameter("bicycleId", id);
        query.executeUpdate();

    }
}
