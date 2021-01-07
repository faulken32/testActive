package com.active.test.rest;

import com.active.test.domain.VehicleType;
import com.active.test.service.BillingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2 @RestController public class BillController {

    private final BillingService billingService;

    public BillController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/api/bill")
    public ResponseEntity<BillResponse<VehicleType>> bill(@Validated @RequestBody BillRequest billRequest)
            throws NoSuchMethodException {

        log.debug("start request for {}" , billRequest);

        final BillResponse<VehicleType> bill = billingService.bill(billRequest);
        log.info("{}" , bill);
        return ResponseEntity.ok().body(bill);

    }
}
