import java.util.Arrays;

/* 
To use functional iteration to find solutions to this system of equations, 
we can define a function F that maps the current 
estimate of the solution x to the next estimate F(x), as follows:
F(x) = (sqrt(x2/3), (3x1x22 - 1)^(1/3))

We can then iterate this function starting from some 
initial estimate of the solution x^(0), 
until the difference between successive e
stimates of the solution is smaller than a certain tolerance level.
*/

  public class NonlinearSystemSolver {
    /*
     * This code defines a function F that maps the current estimate of the solution x 
     * to the next estimate F(x). 
     * The solveSystemLInfNorm function iterates this function starting from an initial guess x0, 
     * until the difference between successive estimates of the solution is smaller 
     * than the specified tolerance tol. 
     * The lInfNorm function computes the L∞ norm between two vectors.
     */

    public static double[] solveSystemLInfNorm(double tol) {
        double[] x0 = {1, 1}; // initial guess
        double[] x = Arrays.copyOf(x0, x0.length);
        while (true) {
            double[] xNew = F(x);
            if (lInfNorm(xNew, x) < tol) {
                break;
            }
            x = xNew;
        }
        return x;
    }


    public static double[] F(double[] x) {
        double x1 = Math.sqrt(x[1] / 3);
        double x2 = Math.pow((3 * x[0] * Math.pow(x[1], 2) - 1), 1.0 / 3.0);
        return new double[]{x1, x2};
    }

    public static double lInfNorm(double[] x, double[] y) {
        double maxDiff = 0;
        for (int i = 0; i < x.length; i++) {
            double diff = Math.abs(x[i] - y[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        double tol = 1e-5;
        double[] solution = solveSystemLInfNorm(tol);
        System.out.println("Solution: " + Arrays.toString(solution));
    }
}
