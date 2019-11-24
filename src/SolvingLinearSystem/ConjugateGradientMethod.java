package SolvingLinearSystem;

import java.text.DecimalFormat;

public class ConjugateGradientMethod {

    private static final int N = 4;

    public static double[] multiplyMatrices(double[][] firstMatrix, double[] secondMatrix) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i] += firstMatrix[j][i] * secondMatrix[j];
            }
        }
        return result;
    }

    public static double[] multiplyNumberByMatrix(double[] matrix, double number) {
        double[] result = new double[N];


        for (int i = 0; i < N; i++) {
            result[i] += matrix[i] * number;
        }
        return result;
    }

    public static double[] subtractMatrices(double[] firstMatrix, double[] secondMatrix) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            result[i] = firstMatrix[i] - secondMatrix[i];
        }
        return result;
    }

    public static double[] addMatrices(double[] firstMatrix, double[] secondMatrix) {
        double[] result = new double[N];
        for (int i = 0; i < N; i++) {
            result[i] = firstMatrix[i] + secondMatrix[i];
        }
        return result;
    }

    public static double multiplyStrings(double[] firstMatrix, double[] secondMatrix) {
        double result = 0;
        for (int i = 0; i < N; i++) {
            result += firstMatrix[i] * secondMatrix[i];
        }
        return result;
    }

    public static double[] solveLinearSystem(double[][] a, double[] b) {
        double[] x0 = new double[N];
        for (int i = 0; i < N; i++) {
            x0[i] = Math.random() * 2;
        }

        double[] r0 = subtractMatrices(b, multiplyMatrices(a, x0));
        double[] p0 = r0;
        double alpha0 = multiplyStrings(r0, r0) / multiplyStrings(p0, multiplyMatrices(a, p0));

        double[] x = x0;
        double[] r = r0;
        double[] _r = r0;
        double[] p = p0;
        double alpha = alpha0;
        double betha = 0;

        int n = N;
        while (n >= 0) {
            x = addMatrices(x, multiplyNumberByMatrix(p, alpha));
            r = subtractMatrices(r, multiplyNumberByMatrix(multiplyMatrices(a, p), alpha));
            betha = multiplyStrings(r, r) / multiplyStrings(_r, _r);
            _r = r;
            p = addMatrices(r, multiplyNumberByMatrix(p, betha));
            alpha = multiplyStrings(r, r) / multiplyStrings(p, multiplyMatrices(a, p));
            n--;
        }

        x = addMatrices(x, multiplyNumberByMatrix(p, alpha));

        for (int i = 0; i < N; i++) {
            x[i] = Double.parseDouble(new DecimalFormat("#.").format(x[i]));
        }

        return x;
    }

}



