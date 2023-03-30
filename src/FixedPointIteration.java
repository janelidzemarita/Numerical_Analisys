import java.util.function.Function;

public class FixedPointIteration extends BisectionMethod{
    public static void main(String[] args) {
        double tolerance = 1e-8; // desired tolerance
        double x0 = bisectionMethod(0, 2, tolerance) ;
        // initial guess (x = 0.5, )
        double x = 0.6; // initial guess
        int maxIterations = 1000; // maximum number of iterations

        Function<Double, Double> g = (Double a) -> 1 - Math.pow(a, 5);
        Function<Double, Double> g1 = (Double a) -> (Math.sin(a) - 5) / 6;
        Function<Double, Double> g2 = (Double a) -> Math.sqrt(3 - Math.log(a));


        for (int i = 0; i < maxIterations; i++) {
            double xPrev = x;
            x = g.apply(xPrev);
            if (Math.abs(x - xPrev) < tolerance) {
                // convergence achieved, print result and exit loop
                System.out.println("Solution found: x = " + x);
                break;
            }
        }
    }
}
