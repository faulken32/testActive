package com.active.test.rest;

import lombok.*;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Log4j2 @ToString public class BillRequest {


    private String        type;
    private LocalDateTime start;
    private LocalDateTime end;

}
