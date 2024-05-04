package com.cyclescape.bike.application.service;

import com.cyclescape.bike.application.domain.model.Bike;
import com.cyclescape.bike.application.domain.persistence.BikeRepository;
import com.cyclescape.bike.application.domain.service.BikeService;
import com.cyclescape.bike.application.mapping.BikeMapper;
import com.cyclescape.bike.infrastructure.entity.BicycleEntity;
import com.cyclescape.bike.shared.exeptions.ResourceNotFoundException;
import jakarta.xml.bind.ValidationException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }


    @Override
    public Bike createBike(Bike bike) {
        validateBicycle(bike);
        BicycleEntity bikeEntity = BikeMapper.INSTANCE.bicycleModelToEntity(bike);
        return BikeMapper.INSTANCE.bikeEntityToModel(bikeRepository.save(bikeEntity));
    }

    @Override
    public Bike getBikeById(Long bikeId) {
        existBikeByBikeId(bikeId);
        BicycleEntity bikeEntity = bikeRepository.findById(bikeId).orElse(null);
        return BikeMapper.INSTANCE.bikeEntityToModel(bikeEntity);
    }

    @Override
    public Bike updateBike(Long bikeId, Bike bike) {
        existBikeByBikeId(bikeId);
        bike.setId(bikeId);
        BicycleEntity bikeEntity = BikeMapper.INSTANCE.bicycleModelToEntity(bike);
        bikeRepository.save(bikeEntity);
        return bike;
    }

    @Override
    public void deleteBike(Long bikeId) {
        existBikeByBikeId(bikeId);
        bikeRepository.deleteById(bikeId);
    }

    @Override
    public List<Bike> getAllBikes() {
        List<BicycleEntity> bikeEntities = bikeRepository.findAll();
        return BikeMapper.INSTANCE.bicycleEntityListToModelList(bikeEntities);
    }
/*
    @Override
    public List<Bike> getAllAvailableBikes(LocalDate start_date, LocalDate end_date) {
        return List.of();
        //to complete
    }
*/
    //
    private void existBikeByBikeId(Long bikeId) {
        if (!bikeRepository.existsById(bikeId)) {
            throw new ResourceNotFoundException("No existe la bicicleta con el id: " + bikeId);
        }
    }
    @SneakyThrows
    private void validateBicycle(Bike bike) {
        if (bike.getBikeName() == null || bike.getBikeName().isEmpty()) {
            throw new ValidationException("El nombre de la bicicleta debe ser obligatorio");
        }
        if (bike.getBikeName().length() > 50) {
            throw new ValidationException("El nombre de la bicicleta no debe exceder los 50 caracteres");
        }
        if (bike.getBikeDescription() == null || bike.getBikeDescription().isEmpty()) {
            throw new ValidationException("La descripción de la bicicleta debe ser obligatoria");
        }
        if (bike.getBikeDescription().length() > 200) {
            throw new ValidationException("La descripción de la bicicleta no debe exceder los 200 caracteres");
        }
        if (bike.getBikePrice() == 0) {
            throw new ValidationException("El precio de la bicicleta debe ser obligatorio");
        }
        if (bike.getBikePrice() < 0) {
            throw new ValidationException("El precio de la bicicleta no debe ser negativo");
        }
    }
}
