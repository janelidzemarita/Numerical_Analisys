
public class LagrangeInterpolation {

    public static void main(String[] args) {

        double[] x1 = {0, 2, 3}; // x-coordinates of the given points
        double[] y1 = {1, 3, 0}; // y-coordinates of the given points

        double[] x2 = {-1, 2, 3, 5}; // x-coordinates of the given points
        double[] y2 = {0, 1, 1, 2}; // y-coordinates of the given points
        /*
        Call the function printLagrange() to see the results for a and b
         */
//        printLagrange(x1,y1);
        printLagrange(x2,y2);

    }
    public static double[] computeCoefficients(double[] x, double[] y){
        int n = x.length; // number of points
        double[] coefficients = new double[n]; // coefficients of the Lagrange polynomial
        for (int i = 0; i < n; i++) {
            double term = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    /*
                    From lagrange formula:
                    term0 = (x0 - x1)(x0 - x2)(x0 - x3)...
                    term1 = (x1 - x0)(x1 - x2)(x1 - x3)...
                    term2 = (x2 - x0)(x2 - x1)(x2 - x3)...
                    term3 = (x3 - x0)(x3 - x1)(x2 - x2)...
                    .........
                     */
                    term *= (x[i] - x[j]);
                }
            }
            /*
            from formula y1 / term
             */
            coefficients[i] = y[i] / term;

        }

        return coefficients;
    }

    public static void printLagrange(double[] x, double[] y){
        double[] cof1 = computeCoefficients(x, y);
        int n = x.length;
        // Print the Lagrange polynomial
        System.out.print("Lagrange polynomial: L(x) = ");
        //Needs work for the printing but the numbers are correct.
        for (int i = 0; i < n; i++) {
            if(cof1[i] == 0.0){
                continue;
            }
            System.out.print(cof1[i]);
            for (int j = 0; j < n; j++) {
                if (i != j && x[j] != 0.0) {
                    if(x[j] > 0 ){
                        System.out.print("(x - " + Math.abs(x[j]) + ")");
                    }else {
                        System.out.print("(x + " + Math.abs(x[j]) + ")");
                    }

                }
            }
            if (i != n - 1) {
                System.out.print(" + ");
            }
        }
    }
}
