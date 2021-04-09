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
        final double[] coinsTotal = {0.0};
        coinRepository.findAll().iterator().forEachRemaining(coin -> {
            coinsTotal[0] += coin.getValue() * coin.getQuantity();
            System.out.println(coin.getQuantity() + " " + coin.getName());
        });
        System.out.println("The piggy bank holds " + coinsTotal[0]);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
