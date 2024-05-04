package com.cyclescape.bike.application.domain.persistence;

import com.cyclescape.bike.infrastructure.entity.BicycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<BicycleEntity, Long> {

}
