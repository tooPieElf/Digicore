package com.digicore.digicore.service;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DefaultAccountNumberGenerator implements AccountNumberGenerator {

    @Override
     public String generateAccount() {
        Random random = new Random();
        return  String.format("%010d", random.nextInt(10000000));
    }
}
