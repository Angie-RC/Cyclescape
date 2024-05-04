package com.cyclescape.bike.application.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

    private Long id;

    private String bikeName;

    private String bikeDescription;

    private double bikePrice;

    private String bikeModel;

    private String bikeImage;

    //private Long userId;
}
