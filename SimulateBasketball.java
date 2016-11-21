import java.util.*;
import java.io.*;
//=====================================================================
public class SimulateBasketball {
//---------------------------------------------------------------------
private static Scanner keyboard = new Scanner(System.in);
//---------------------------------------------------------------------
public static void main(String[] args) {
	
	String[] positions = {"POINT GUARD", "SHOOTING GUARD", "SMALL FORWARD", "POWER FORWARD", "CENTER"};
	BasketballPlayer[] homeTeam = new BasketballPlayer[5];
	BasketballPlayer[] visitingTeam = new BasketballPlayer[5];
	String input, filth;
	char command;
	double percentage1, percentage2, accuracy, tendency1, tendency2, tendency3;
	int index;
	boolean homePossession = true;
	int homeScore;
	int visitingScore;
	
//----creates a player at each position, 1PG 5C, and adds variables----

    for(index = 0; index < homeTeam.length; index++) {
	  System.out.print("Who is the " + positions[index] + " for the home team?");
	  input = keyboard.nextLine();
	  System.out.print("What is " + input + "'s shooting percentage (As a decimal)?");
	  percentage1 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s 3-PT shooting percentage (As a decimal)?");
	  percentage2 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s pass accuracy (As a decimal)?");
	  accuracy = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s tendency to drive to the basket (As a decimal)?");
	  tendency1 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s tendency to shoot (As a decimal)?");
	  tendency2 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s tendency to pass (As a decimal)?");
	  tendency3 = keyboard.nextDouble();
	  
	  homeTeam[index] = new BasketballPlayer(input, tendency1, tendency2, tendency3, percentage1, percentage2, accuracy);
	  filth = keyboard.nextLine();
	}
	
	for(index = 0; index < homeTeam.length; index++) {
	  homeTeam[index].setTeammates(homeTeam);	
	}
	
	for(index = 0; index < visitingTeam.length; index++) {
	  System.out.print("Who is the " + positions[index] + " for the visiting team?");
	  input = keyboard.nextLine();
	  System.out.print("What is " + input + "'s shooting percentage (As a decimal)?");
	  percentage1 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s 3-PT shooting percentage (As a decimal)?");
	  percentage2 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s pass accuracy (As a decimal)?");
	  accuracy = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s tendency to drive to the basket (As a decimal)?");
	  tendency1 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s tendency to shoot (As a decimal)?");
	  tendency2 = keyboard.nextDouble();
	  System.out.print("What is " + input + "'s tendency to pass (As a decimal)?");
	  tendency3 = keyboard.nextDouble();
	  
	  visitingTeam[index] = new BasketballPlayer(input, tendency1, tendency2, tendency3, percentage1, percentage2, accuracy);
	  filth = keyboard.nextLine();
	}
	
	for(index = 0; index < visitingTeam.length; index++) {
	  visitingTeam[index].setTeammates(visitingTeam);	
	}
	
//---------------------------------------------------------------------

    System.out.println("The game is about to start.");
    System.out.println("The home team wins the opening tip-off.");	
	homeScore = 0;
	visitingScore = 0;
	
//----simulates possessions as requested by user-----------------------	
	do {
	  System.out.print("Press p, then Enter to simulate a possession (or press x, then Enter to quit)");
	  command = keyboard.next().toUpperCase().charAt(0);
	  if(homePossession) {
	    homeScore += homeTeam[0].advanceBall();
		homePossession = !homePossession;
	  } else {
	    visitingScore += visitingTeam[0].advanceBall();	 
		homePossession = !homePossession;
	  }
	  
	  System.out.println("Home - " + homeScore + "; Visitor - " + visitingScore);
	  
	} while (command != 'X');
	
    System.out.println("The final buzzer sounds.");
	System.out.println("Game over.");
	

}
//---------------------------------------------------------------------
}
//=====================================================================
