package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the amount of money that you start with?");
		double startAmount = in.nextDouble();
		
		System.out.println("What is the win probability, or the probability that you win a single play?");
		double winChance = in.nextDouble();
		
		System.out.println("What is the amount of money that if reached, you will consider it a good day?");
		double winLimit = in.nextDouble();
		
		System.out.println("What is the number of days you will simulate?");
		int totalSimulations = in.nextInt();
		
		int winCount = 0;
		int ruinCount = 0;
		
			for (int simulationNumber = 1; simulationNumber <= totalSimulations; simulationNumber++) {
				double currentAmount = startAmount;
	            int plays = 0;
	            String dayResult = null;
				while (currentAmount > 0 && currentAmount < winLimit) {
			            plays++;
			            if (Math.random() < winChance) {
			                currentAmount++;
			            } else {
			                currentAmount--;
			            }
			        }
				if (currentAmount <= 0) {	
					dayResult = "ruin";
					ruinCount++;
				} else if (currentAmount >= winLimit) {
					dayResult = "success";
					winCount++;
				}
				System.out.println("It is day " + simulationNumber + "." + " Number of plays is " + plays + "." + " The day is a " + dayResult + ".");
			}
			 System.out.println("Total ruins: " + ruinCount + " out of " + totalSimulations + " simulations.");
		     System.out.println("Total successes: " + winCount + " out of " + totalSimulations + " simulations.");
		     double ruinPercentage = (double) ruinCount / totalSimulations * 100;
		     System.out.println("Estimated probability of ruin: " + ruinPercentage + "%");

		     in.close();
	}
}