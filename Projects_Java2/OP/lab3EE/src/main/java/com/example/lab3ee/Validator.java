package com.example.lab3ee;

import java.util.List;

public class Validator {

    public static void validate(Params param){
        double[] paramsToValidate = param.toArray();
        List<String> keysNames = Keys.getNames();
        int variableRepeatTo = 4;
        int variableRepeatStep = 8;
        for(int i=0;i<variableRepeatTo;i++){
            if(paramsToValidate[i+variableRepeatTo]>paramsToValidate[i] && paramsToValidate[i+variableRepeatStep] < 0) {
                throw new IllegalArgumentException("Variable"+keysNames.get(i + variableRepeatTo)
                        + " is bigger than" + keysNames.get(i) + " but " + keysNames.get(i+variableRepeatStep)
                        + "is less than zer0");
            }
            if(paramsToValidate[i+variableRepeatTo]<paramsToValidate[i] && paramsToValidate[i+variableRepeatStep] > 0) {
                throw new IllegalArgumentException("Variable"+keysNames.get(i + variableRepeatTo)
                        + " is less than" + keysNames.get(i) + " but " + keysNames.get(i+variableRepeatStep)
                        + "is bigger than zer0");
            }
            if((paramsToValidate[i+variableRepeatTo]-paramsToValidate[i])%paramsToValidate[i+variableRepeatStep]!=0){
                throw new IllegalArgumentException("Variable " + keysNames.get(i + variableRepeatStep)
                        + " is incorrect. "+keysNames.get(i)+" cant reach " + keysNames.get(i + variableRepeatTo) + " correctly");
            }



        }
    }
}
