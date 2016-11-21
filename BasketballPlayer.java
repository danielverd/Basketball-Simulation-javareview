import java.util.*;
import java.io.*;
//=====================================================================
public class BasketballPlayer {
//---------------------------------------------------------------------
private String name;
private double dribbleTendency;
private double shootingTendency;
private double passTendency;
private double shootingPercentage;
private double threePtShootingPercentage;
private double passAccuracy;
private BasketballPlayer[] teammates;
//---------------------------------------------------------------------
public BasketballPlayer() {

    name = null;
    dribbleTendency = 0.0;
    shootingTendency = 0.0;
    passTendency = 0.0;
    shootingPercentage = 0.0;
    threePtShootingPercentage = 0.0;
    passAccuracy = 0.0;
	teammates = null;
}
//----input from main sets all player stats-----------------------------
public BasketballPlayer(String input, double tendency1, double tendency2, double tendency3, double percentage1, double percentage2, double accuracy) {

    name = input;
    dribbleTendency = tendency1;
    shootingTendency = tendency2;
    passTendency = tendency3;
    shootingPercentage = percentage1;
    threePtShootingPercentage = percentage2;
    passAccuracy = accuracy;

}
//----allows a player to know who's on his team------------------------
public void setTeammates(BasketballPlayer[] players) {

    teammates = players;
	
}
//----shoot first, then dribble, then pass-----------------------------
public int tripleThreat() {

    double playerDecision = 0.0;

    playerDecision = Math.random();
    
    if(playerDecision < shootingTendency) {
      return(shootBall()); 
    } else if (playerDecision < shootingTendency + dribbleTendency) {
      return(dribbleDrive());
    } else if (playerDecision < shootingTendency + dribbleTendency + passTendency) {
      return(passBall());
    } else {
	  return(0);
	}

}
//----player takes the ball off the dribble, the drive is guarded------
public int offTheDribble() {

    double playerDecisionDrbl = 0.0;
    double shootOffDribbleTendency = (shootingTendency) / (1 - dribbleTendency);
    double passOffDribbleTendency = (passTendency) / (1 - dribbleTendency);

    playerDecisionDrbl = Math.random();

    if(playerDecisionDrbl < shootOffDribbleTendency) {
      return(shootBall());
    } else if(playerDecisionDrbl < shootOffDribbleTendency + passOffDribbleTendency) {
      return(passBall());
    } else {
	  return(0);
	}

}
//----an exact copy of offTheDribble, represents PG starting a play----
public int advanceBall() {

    double playerDecisionDrbl = 0.0;
    double shootOffDribbleTendency = (shootingTendency) / (1 - dribbleTendency);
    double passOffDribbleTendency = (shootingTendency) / (1 - dribbleTendency);

    playerDecisionDrbl = Math.random();

    if(playerDecisionDrbl < shootOffDribbleTendency) {
      return(shootBall());
    } else if(playerDecisionDrbl < shootOffDribbleTendency + passOffDribbleTendency) {
      return(passBall());
    } else {
	  return(0);
	}

}
//----player with the ball shoots it, possession switches--------------
public int shootBall() {
	
	double shotSuccess = 0.0;
	
	System.out.println(name + " goes for a jump shot.");
	shotSuccess = Math.random();
	
	if(shotSuccess < shootingPercentage) {
		System.out.println("It goes in.");
		System.out.println("2 points for " + name + ".");
		return(2);
	} else {
	    System.out.println("The shot misses.");
		System.out.println("The opposing team grabs the rebound.");
		return(0);
	}
	
}
//----player with the ball passes to another player--------------------
public int passBall() {
	
	double passSuccess = 0.0;
	int recievingPlayer = 0;
	double recipient = 0.0;
	
	passSuccess = Math.random();
	recipient = Math.random()*4;
	recievingPlayer = (int)recipient;
	
	System.out.println(name + " passes the ball.");
	
	if(passSuccess < passAccuracy) {
      if(teammates[recievingPlayer].name == name && recievingPlayer < teammates.length) {
        recievingPlayer += 1;
      }
	  if(teammates[recievingPlayer].name == name && recievingPlayer == teammates.length) {
		recievingPlayer -= 1;
	  }
	
		System.out.println("It was caught by " + teammates[(int)recievingPlayer].name + ".");
		
		return(teammates[recievingPlayer].tripleThreat());
		
	} else {
		System.out.println("The pass was picked off.");
		return(0);
	}

}
//----player with the ball drives to the basket------------------------
public int dribbleDrive() {
	
	double layupSuccess = 0.0;
	
	System.out.println(name + " drives to the basket.");
	
	layupSuccess = Math.random();
	
	if(layupSuccess < shootingPercentage + 0.15) {
		System.out.println("Shoots a layup.");
		System.out.println(name + " scores from point-blank range.");
		return(2);
	} else {
		System.out.println("He misses the layup.");
		return(0);
	}
	
}
//---------------------------------------------------------------------
}
//=====================================================================
