package com.active.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter public class Moto implements VehicleType {

    private String brand = "INCONUE";
    private String type = "MOTO";
}
