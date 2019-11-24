package tests;

import SolvingLinearSystem.GaussianElimination;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static SolvingLinearSystem.GaussianElimination.*;
import static org.testng.Assert.assertEquals;

public class GaussianEliminationTest {
    @Test(dataProvider = "matrixProvider")
    public void solveLinearSystemTest(double[][] a, double[] f, double[] x){
        GaussianElimination.TwoMatrix res;
        notNull(a);
        res = divisionAndSubstraction(a, f);
        a = res.getA();
        f = res.getF();
        assertEquals(new GaussianElimination().findX(a, f), x);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        double[][] a = {{0.25, -0.16, -0.38, 0.17},
                {0.19, -0.22, -0.02, 0.41},
                {0.13, 0.08, -0.08, -0.13},
                {0.13, -0.1, -0.32, 0.65}};
        double[][] a1 = {{0.25, -0.16, -0.38, 0.17},
                {0.19, -0.22, -0.02, 0.41},
                {0.13, 0.08, 0, -0.13},
                {0.13, -0.1, -0.32, 0.65}};


        double[] f = {0.37, 0.01, 0.01, 1.51};
        double[] f1 = {0.37, 0.01, 0.32, 1.51};

        double[] x = {-0.9999999999999998,
                       2.9999999999999996,
                      -1.9999999999999998,
                       1.9999999999999998};
        double[] x1 = {7.575808819673849,
                       7.690695296523529,
                       1.0823108384458173,
                       0.6931597713806372};


        return new Object[][]{{a, f, x}, {a1, f1, x1}};
    }
}