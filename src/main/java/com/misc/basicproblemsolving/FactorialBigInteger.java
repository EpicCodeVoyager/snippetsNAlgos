package com.misc.basicproblemsolving;

import java.math.BigInteger;

public class FactorialBigInteger {

    public static BigInteger getFactorial(BigInteger number) throws Exception {

        if(number.compareTo(BigInteger.ZERO)<0){
            throw new Exception("Can't be less than zero");
        }

        BigInteger multiplication = BigInteger.ONE;

        while(!number.equals(BigInteger.ONE)){
            multiplication=multiplication.multiply(number);
            number=number.subtract(BigInteger.ONE);
        }
        return multiplication;
    }


    public static void main(String[] args) throws Exception {
        BigInteger b = BigInteger.valueOf(98990L);

        System.out.println(getFactorial(b).toString());
    }

}
