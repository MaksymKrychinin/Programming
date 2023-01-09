package ClassPackage;

public class Formules {
    public double y(Param param) throws ArithmeticException {
        if (param.a == 0) {
            throw new ArithmeticException("a=0");
        } else if (param.b == 0) {
            throw new ArithmeticException("b=0");
        }
        return 3 * (Math.log(Math.abs(param.b / param.a)) + Math.sqrt(Math.sin(param.c) + Math.pow(Math.E, param.d)));

    }
}
