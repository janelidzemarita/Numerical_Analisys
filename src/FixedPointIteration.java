import java.util.function.Function;

public class FixedPointIteration{
    public static void main(String[] args) {
        double tolerance = 1e-8; // desired tolerance
        double x = 0.6; // initial guess
        int maxIterations = 1000; // maximum number of iterations

        Function<Double, Double> g_a = (Double a) -> 1 - Math.pow(a, 5);
        Function<Double, Double> g_b = (Double a) -> (Math.sin(a) - 5) / 6;
        Function<Double, Double> g_c = (Double a) -> Math.sqrt(3 - Math.log(a));


        for (int i = 0; i < maxIterations; i++) {
            double xPrev = x;
            x = g_b.apply(xPrev);
            if (Math.abs(x - xPrev) < tolerance) {
                // convergence achieved, print result and exit loop
                System.out.printf("Solution Found: x =  %.8f", x);
                break;
            }
        }
    }
}
