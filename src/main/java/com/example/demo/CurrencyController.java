package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @GetMapping("/rate/{currency}")
    public ResponseEntity<Double> getAverageRate(
            @PathVariable String currency,
            @RequestParam(defaultValue = "1") int firstday, int lastday) {
        double averageRate = service.getAverageRate(currency, firstday, lastday);
        return ResponseEntity.ok(averageRate);
    }
}
