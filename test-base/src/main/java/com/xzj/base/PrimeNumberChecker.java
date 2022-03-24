package com.xzj.base;

public class PrimeNumberChecker {
    public boolean validate(final Integer number){
        for (int i = 2; i < (number/2); i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
