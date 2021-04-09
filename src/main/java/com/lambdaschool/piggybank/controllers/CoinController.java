package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> getCoinsTotal() {
        coinRepository.findAll().iterator().forEachRemaining(coin -> {
            System.out.println(CoinUtils.getDisplayString(coin));
        });

        double total = CoinUtils.getTotal(coinRepository.findAll().iterator());
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
