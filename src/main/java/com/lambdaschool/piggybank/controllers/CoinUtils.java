package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;

import java.util.Iterator;

public class CoinUtils {
    public static double getTotal(Iterator<Coin> coins) {
        final double[] total = {0.0};
        coins.forEachRemaining(coin -> total[0] += coin.getQuantity() * coin.getValue());
        return total[0];
    }

    public static String getDisplayString(Coin coin) {
        int quantity = coin.getQuantity();
        String name;
        if (quantity == 1) {
            name = coin.getName();
        } else {
            name = coin.getNameplural();
        }
        return quantity + " " + name;
    }
}
