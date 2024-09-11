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
		     System.out.print("Ruin rate from the simulations: " + ruinPercentage + "%");
		     double expectedRuinRate = 0;
		     double a = 0;
		     if(winChance == 0.5) {
		    	 expectedRuinRate = 1 - (startAmount/winLimit);
		     } else {
		    	 a = (1-winChance)/winChance;
		    	 expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		     }
		     System.out.println("Expected Ruin Rate: " + expectedRuinRate + "%");
		     in.close();
	}
}