package tests;

import SolvingLinearSystem.ConjugateGradientMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConjugateGradientMethodTest {

    @Test(dataProvider = "matrixProvider")
    public void solveLinearSystemTest(double[][] a, double[] b, double[] x) {
        assertEquals(new ConjugateGradientMethod().solveLinearSystem(a, b), x);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        double[][] a = {{0.1061, -0.0667, -0.1209, 0.1528},
                        {-0.0667, 0.0674, 0.0723, -0.1466},
                        {-0.1209, 0.0723, 0.1946, -0.2132},
                        {0.1528, -0.1466, -0.2132, 0.4769}};

        double[] b = {0.2412, -0.1689, -0.4778, 0.7876};

        double[] x = {-1.0,
                       3.0,
                      -2.0,
                       2.0};

        return new Object[][]{{a, b, x}};
    }

}