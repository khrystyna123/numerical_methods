package SolvingLinearSystem;

public class GaussianElimination {

    private static final int N = 4;

    public static class TwoMatrix {
        double[][] a;
        double[] f;

        public TwoMatrix(double[][] a, double[] f) {
            this.a = a;
            this.f = f;
        }

        public double[][] getA() {
            return a;
        }

        public double[] getF() {
            return f;
        }
    }

    public static void switchTwoRows(double[][] a, int row) {
        int next_row;

        if (row + 1 < N)
            next_row = row + 1;
        else next_row = 0;

        for (int i = 0; i < N; i++) {
            double t = a[row][i];

            a[row][i] = a[next_row][i];
            a[next_row][i] = t;
        }
    }

    public static void notNull(double[][] a) {
        for (int row = 0; row < N; row++) {
            if (a[row][row] == 0)
                switchTwoRows(a, row);
        }
    }

    public static TwoMatrix divisionAndSubstraction(double[][] a, double[] f) {
        for (int n = N; n > 0; n--) {

            for (int row = n - 1; row >= 0; row--) {
                double temp = a[row][n - 1];
                for (int col = n - 1; col >= 0; col--) {
                    a[row][col] /= temp;
                }
                f[row] /= temp;
            }

            for (int row = n - 2; row >= 0; row--) {
                for (int col = n - 1; col >= 0; col--) {
                    a[row][col] -= a[n - 1][col];
                }
                f[row] -= f[n - 1];
            }
        }

        return new TwoMatrix(a, f);
    }

    public static double[] findX(double[][] a, double[] f) {
        double[] x = new double[N];

        x[0] = f[0];
        for (int row = 1; row < N; row++) {
            x[row] = f[row] - sum(x, a[row], row);
        }

        return x;
    }

    public static double sum(double[] x, double[] a, int i) {
        double sum = 0;

        for (int j = 0; j < i; j++) {
            sum += x[j] * a[j];
        }

        return sum;
    }

}
