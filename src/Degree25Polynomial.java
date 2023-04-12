public class Degree25Polynomial {
    public static void main(String[] args) {
        double[] coefficients = findCoefficients();
        double y = evaluatePolynomial(coefficients, 3.14);
        System.out.println("p(3.14) = " + y);
    }
    public static double[] findCoefficients() {
        double[] coefficients = new double[26];
        coefficients[25] = -25;

        // Set up matrix of coefficients
        double[][] matrix = new double[25][25];
        for (int i = 0; i < 25; i++) {
            matrix[i][i] = 1;
            for (int j = 0; j < i; j++) {
                matrix[i][j] = Math.pow(i + 1, j);
                matrix[j][i] = matrix[i][j];
            }
        }

        // Set up vector of constants
        double[] constants = new double[25];
        for (int i = 0; i < 25; i++) {
            constants[i] = -(i + 1);
        }

        // Solve matrix equation
        double[] solution = gaussianElimination(matrix, constants);

        // Copy coefficients to output array
        for (int i = 0; i < 24; i++) {
            coefficients[i + 1] = -solution[i];
        }

        return coefficients;
    }

    public static double[] gaussianElimination(double[][] matrix, double[] constants) {
        int n = matrix.length;
        double[] solution = new double[n];

        // Gaussian elimination with partial pivoting
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = j;
                }
            }
            double[] tempRow = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = tempRow;
            double tempConstant = constants[i];
            constants[i] = constants[maxRow];
            constants[maxRow] = tempConstant;

            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                constants[j] -= factor * constants[i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }

        // Back substitution
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (constants[i] - sum) / matrix[i][i];
        }

        return solution;
    }

    public static double evaluatePolynomial(double[] coefficients, double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

}
