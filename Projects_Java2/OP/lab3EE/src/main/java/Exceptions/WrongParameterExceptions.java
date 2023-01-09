package Exceptions;

public class WrongParameterExceptions extends Exception {

    public WrongParameterExceptions( String parameter) {
       super("Variable \""+parameter+"\" can not be equal to zero");
    }
}
