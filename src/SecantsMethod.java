public class SecantsMethod {
    private static final int MAX_ITERATIONS = 1000;
    public static void main(String[] args) {
        double x0 = 0.5; // initial guess
        double x1 = 1.0; // initial guess
        double eps = 1e-6; // tolerance
        double root = secantsMethod(x0, x1, eps);
        System.out.printf("Root Found: %.6f", root);
    }
    public static double secantsMethod(double x0, double x1, double eps){
        double f0 = functionValue(x0);
        double f1 = functionValue(x1);
        int iter = 0;
        while (Math.abs(f1) > eps){
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0); //formula
            //Change x0 and x1
            x0 = x1;
            x1 = x2;
            f0 = f1;
            f1 = functionValue(x1);
            iter++;
            if(iter > MAX_ITERATIONS){
                System.err.println("Failed to find root");
            }
        }
        return x1;
    }

    public static double functionValue(double x) {
        return 3 * Math.pow(x, 3) + Math.pow(x,2) - x -5;
        //Change the return value to ->  Math.pow(Math.cos(x), 2) + 6 - x for the b
    }
}

