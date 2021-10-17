public class NnMath {
    public static double sigmod(double nnValue) {
        return 1/(1+Math.exp(-nnValue));
    }
    public static double sigmodDerivative(double nnValue) {
        return nnValue/(1-nnValue);
    }
}
