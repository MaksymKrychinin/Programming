package com.example.lab3ee;

import Exceptions.WrongParameterExceptions;

public abstract class Formulas {

   static double solve(double a,double b,double c,double d) throws WrongParameterExceptions {
            if(a==0){
                throw new WrongParameterExceptions("a");
            }
            if(b == 0) {
                throw new WrongParameterExceptions("b");
            }
            return 3 * (Math.log(Math.abs(b / a)) + Math.sqrt(Math.sin(c) + Math.pow(Math.E, d)));

    }
}
