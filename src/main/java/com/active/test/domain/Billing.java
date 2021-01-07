package com.active.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@Log4j2
@ToString
public class Billing {

    private String vId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;



}
