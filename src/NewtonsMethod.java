import java.util.function.Function;

public class NewtonsMethod {

    public static void main(String[] args) {
        double x0 = 0.6; // initial guess
        double tolerance = 1e-8; // desired tolerance
        int maxIterations = 1000; // maximum number of iterations

        // define the function f(x) = x^5 + x - 1 and its derivative f'(x) = 5x^4 + 1
        Function<Double, Double> f = (Double x) -> Math.pow(x, 5) + x - 1;
        Function<Double, Double> fPrime = (Double x) -> 5 * Math.pow(x, 4) + 1;

        // define the function f(x) = sin(x) - 6x - 5 and its derivative f'(x) = cos(x) - 6
        Function<Double, Double> f_b = (Double x) -> Math.sin(x) - 6 * x - 5;
        Function<Double, Double> f_bPrime = (Double x) -> Math.cos(x) - 6;

        // define the function f(x) = ln(x) + x^2 - 3 and its derivative f'(x) = 1/x + 2x
        Function<Double, Double> f_c = (Double x) -> Math.log(x) + x * x - 3;
        Function<Double, Double> f_cPrime = (Double x) -> 1/x + 2 * x;

        // iterate until convergence or maximum iterations reached
        double x = x0;
        for (int i = 0; i < maxIterations; i++) {
            //change the function accordingly for b > f_b, f_bPrime and for c f_c, f_cPrime
            double deltaX = -f.apply(x) / fPrime.apply(x);
            x += deltaX;
            if (Math.abs(deltaX) < tolerance) {
                // convergence achieved, print result and exit loop
                System.out.printf("Solution found: x = %.8f", x);
                break;
            }
        }
    }
}
