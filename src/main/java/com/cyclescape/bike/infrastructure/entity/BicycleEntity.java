package com.cyclescape.bike.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="bicycles")
public class BicycleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="bicycle_name", nullable = false, length = 50)
    private String bicycleName;

    @Column(name="bicycle_description", nullable = false, length = 200)
    private String bicycleDescription;

    @Column(name="bicycle_price", nullable = false)
    private double bicyclePrice;

    @Column(name="bicycle_model", nullable = true, length = 50)
    private String bicycleModel;

    @Column(name="image_data", nullable = true)
    private String imageData;

}
