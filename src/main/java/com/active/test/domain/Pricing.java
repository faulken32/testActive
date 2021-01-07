package com.active.test.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * normaly manage in db
 * @param <T>
 */
@Getter @Setter public class Pricing<T> {


    private T          type;
    private BigDecimal priceByMinute;
    private Boolean after4Hour;

    /**
     * exemple to manage price per vehicle type
     * @param t
     */
    public  Pricing(T  t ,  boolean after4Hour) throws NoSuchMethodException {

         if (t instanceof Car){
             this.priceByMinute = new BigDecimal("0.033333333");
         }

         if (t instanceof Moto){
             this.priceByMinute = new BigDecimal("0.033333333");
         }
        this.type = t;

         if(after4Hour){

             throw new NoSuchMethodException("non géré");
         }


     }
 }
