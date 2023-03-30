public class BisectionMethod {
    private static final int MAX_ITERATIONS = 100;
    public static void main(String[] args) {
        //Too lazy to use Scanner
        double leftEndpoint = -10.0; // left endpoint of interval. We can change the value.
        double rightEndpoint = 10.0; // right endpoint of interval. We can change the value.
        double tolerance = 1e-6; // tolerance for error
        double root;
        //For the bisection method we need the function values at endpoints to have opposite values
        if(functionValue(leftEndpoint) * functionValue(rightEndpoint) < 0){
            root = bisectionMethod(leftEndpoint, rightEndpoint, tolerance);
            System.out.printf("Root is approximately: %.6f", root);
        }else {
            System.out.println("Please Change the left endpoint and right endpoint!");
        }
    }
    public static double bisectionMethod(double leftEndpoint, double rightEndpoint, double tolerance) {
        int iterations = 0;
        double midpoint = midpoint(leftEndpoint, rightEndpoint);// midpoint of interval
        while (Math.abs(rightEndpoint - leftEndpoint) > tolerance) {
            if (functionValue(leftEndpoint) * functionValue(midpoint) < 0) {
                rightEndpoint = midpoint;
            } else {
                leftEndpoint = midpoint;
            }
            midpoint = midpoint(leftEndpoint, rightEndpoint) ;
            iterations ++;
            if(iterations > MAX_ITERATIONS){
                System.err.println("Error: Maximum Iterations Reached!");
            }
        }
        return midpoint;
    }
    public static double midpoint (double leftEndpoint, double rightEndpoint){
        return (leftEndpoint + rightEndpoint) / 2.0;
    }
    public static double functionValue(double x) {
        return 3 * Math.pow(x, 3) + Math.pow(x,2) - x -5; //a
        //Change the return value to ->  Math.pow(Math.cos(x), 2) + 6 - x for the b

    }
}
