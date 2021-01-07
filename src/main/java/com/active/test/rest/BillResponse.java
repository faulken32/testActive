package com.active.test.rest;

import com.active.test.domain.VehicleType;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Log4j2 @ToString @Builder
public class BillResponse<T extends VehicleType> {

    private T      vehiclesType;
    private String energy;
    private String pastTime;
    private Long   price;

    @Override public String toString() {

        return "- véhicule :  " + vehiclesType + " " + energy +  "\n - temps passé : " + pastTime + " minute \n -montant dû : "+ price+" euros";
    }
}
