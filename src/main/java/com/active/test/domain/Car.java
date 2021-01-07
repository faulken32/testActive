package com.active.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Getter
@Setter
@Log4j2
@ToString
public class Car  implements VehicleType{

   private String brand = "INCONUE";
   private String type = "CAR";




}
