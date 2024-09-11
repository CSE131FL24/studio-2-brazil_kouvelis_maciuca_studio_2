package studio2;

import java.util.Random;

public class Darts {
    public static double computePi(int numThrows) {
        int insideCircle = 0;
        Random random = new Random();

        // Iterate for each dart throw
        for (int i = 0; i < numThrows; i++) {
            // Generate random x and y coordinates between 0 and 1
            double x = random.nextDouble();
            double y = random.nextDouble();

            // Check if the dart falls inside the quarter circle
            if (Math.sqrt(x * x + y * y) <= 1) {
                insideCircle++;
            }
        }

        // The ratio of darts inside the circle to total darts is approximately Pi/4
        double piEstimate = 4.0 * insideCircle / numThrows;
        return piEstimate;
    }
}