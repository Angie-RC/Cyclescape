package com.cyclescape.bike.application.mapping;

import com.cyclescape.bike.application.domain.model.Bike;
import com.cyclescape.bike.infrastructure.entity.BicycleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
@Mapper
public interface BikeMapper {
    BikeMapper INSTANCE = Mappers.getMapper(BikeMapper.class);
    BicycleEntity bicycleModelToEntity(Bike bike);

    Bike bikeEntityToModel(BicycleEntity bikeEntity);

    List<Bike> bicycleEntityListToModelList(List<BicycleEntity> bikeEntities);
}
