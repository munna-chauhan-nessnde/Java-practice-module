package org.sample.solution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigDecimalSample {

    public static void main(String[] args) {
        BigDecimal decimal = BigDecimal.ZERO;
        List<BigDecimal> decimalList = Arrays.asList(new BigDecimal(1),new BigDecimal(1),new BigDecimal(3),new BigDecimal(6));

        for(BigDecimal bigDecimal : decimalList){
            if(bigDecimal.intValue()%2==0){
                decimal = decimal.add(bigDecimal);
            }else{
                decimal = decimal.subtract(bigDecimal);
            }
        }
        System.out.println(decimal);
    }
}
