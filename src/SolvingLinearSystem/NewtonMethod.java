package SolvingLinearSystem;

public class NewtonMethod {

    public static class TwoNumbers {
        double x;
        double y;

        public TwoNumbers(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    public static double max(double x, double y) {
        if (x >= y)
            return x;
        return y;
    }

    public static final double EPSILON = 0.0001;

    public static double equation1(double x, double y) {
        return y - 0.5 * x * x + x - 0.5;
    }

    public static double equation2(double x, double y) {
        return 2 * x + y - ((y * y * y) / 6) - 1.6 ;
    }

    public static double derivFirstFuncX(double x) {
        return 1 - x;
    }

    public static double derivFirstFuncY(double y) {
        return 1;
    }

    public static double derivSecondFuncX(double x) {
        return 2;
    }

    public static double derivSecondFuncY(double y) {
        return 1 - ((y * y) / 3);
    }

    public static TwoNumbers findDeltas(double x, double y) {
        double delta1, delta2;

        delta2 = (derivFirstFuncX(x) * equation2(x, y) - 2 * equation1(x, y)) /
                (derivFirstFuncX(x) * derivSecondFuncY(y) - 2);

        delta1 = (equation1(x, y) / derivFirstFuncX(x)) - (delta2 / derivFirstFuncX(x));

        return new TwoNumbers(delta1, delta2);
    }

    public static TwoNumbers newtonRaphson(double x, double y) {
        double delta1 = 0, delta2 = 0;

        do {
            //derivFirstFuncX(x) * delta1 + derivFirstFuncY(y) * delta2 = - equation1(x, y);
            //derivSecondFuncX(x) * delta1 + derivSecondFuncY(y) * delta2 = - equation2(x, y);
            TwoNumbers deltas = findDeltas(x, y);
            delta1 = deltas.getX();
            delta2 = deltas.getY();

            x += delta1;
            y += delta2;
        } while (max(delta1, delta2) > EPSILON);

        return new TwoNumbers(x, y);
    }

    public static void main(String[] args) {
        double x0 = 0.75, y0 = 0.0045;
        TwoNumbers result = newtonRaphson(x0, y0);

        System.out.println("x = " + result.getX());
        System.out.println("y = " + result.getY());
    }
}