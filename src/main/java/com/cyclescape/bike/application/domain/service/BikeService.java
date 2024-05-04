package com.cyclescape.bike.application.domain.service;

import com.cyclescape.bike.application.domain.model.Bike;

import java.time.LocalDate;
import java.util.List;

public interface BikeService {
    public abstract Bike createBike(Bike bike);
    public abstract Bike getBikeById(Long bikeId);
    public abstract Bike updateBike(Long bikeId, Bike bike);
    public abstract void deleteBike(Long bikeId);
    public abstract List<Bike> getAllBikes();
    //public abstract List<Bike> getAllAvailableBikes(LocalDate start_date, LocalDate end_date);
}
