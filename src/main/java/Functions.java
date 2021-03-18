import java.math.BigDecimal;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Functions {
    public static final double DEFAULT_THRESHOLD = 0.0001;

    public double sec(double x) {
        if (Double.isNaN(x) || Math.abs((x - PI/2) % PI) < DEFAULT_THRESHOLD) {
            return Double.NaN;
        }

        x = x % (2*PI);

        double result = 0d;
        for (int n = 0; n < 15; n++) {
            result += pow(-1, n) * pow(x, 2*n) / factorial(2*n);
            System.out.println(result);
        }
        return 1 / result;
    }

    public long factorial(int n) {
        long fact = 1;
        for (long i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
