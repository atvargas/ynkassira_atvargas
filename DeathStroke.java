package ynkassira_atvargas;
import java.awt.*;
import robocode.*;
import java.awt.Color;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import robocode.RateControlRobot;
import robocode.HitWallEvent;
import robocode.Rules;
import robocode.util.Utils;
import java.util.Random;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.awt.*;

/**
 * DeathStroke - a robot by Jo Kassira and Alex Vargas
 */
public class DeathStroke extends Robot {
	int count = 0;
	double gunTurnAmt;
	String trackName;
	static double direction;

	/**
	 * run: DeathStroke's default behavior
	 */
	public void run() {
		// Robot initialization

		setColors(Color.black,Color.orange,Color.black); // body,gun,radar
		setBulletColor(Color.blue); // bullet color
	
		trackName = null; 
		setAdjustGunForRobotTurn(true); 
		gunTurnAmt = 10;
	
		// Robot main loop
		while (true) {
			// Generate random values for later...
			Random rand = new Random(); 
			Random rand2 = new Random();
			int n = rand.nextInt(10) + 50;
			int n2 = rand2.nextInt(10) + 50;
			double rn = (double)(n);
			double rn2 = (double)(n2);
		 
			ahead(n);
			turnRight(n2);
			back(n);
			ahead(n2);
			turnGunRight(360);
			
			count++;
			
			if (count > 2) {
				gunTurnAmt = -10;
			}
			if (count > 5) {
				gunTurnAmt = 10;
			}
			if (count > 11) {
				trackName = null;
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(10);
	
		if (trackName != null && !e.getName().equals(trackName)) {
			return;
		}
		if (trackName == null) {
			trackName = e.getName();
		}
	
		count = 0;
	
		

		if (e.getDistance() < 100) {
			if (e.getBearing() > -90 && e.getBearing() <= 90) {
				back(40);
			} else {
				ahead(40);
			}
		}
		scan();
	}

	/**
	 * onHitRobot: What to do when you're hit by a bullet
	 */
	public void onHitRobot(HitRobotEvent e) {
	
		if (trackName != null && !trackName.equals(e.getName())) {
			out.println("Tracking " + e.getName() + " due to collision");
		}
	
		trackName = e.getName();
	
		gunTurnAmt = normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
		turnGunRight(gunTurnAmt);
		fire(3);
		back(30);
	}

	/**
	 * onHitWall: What to do when encountering wall
	 */
	public void onHitWall(HitWallEvent e) {
		back(350);
		turnRight(180); 
		turnGunRight(180);
	}
	
	/**
	 * onWin: Victory dance
	 */	
	public void onWin(WinEvent e) {
		back(100);
		turnRight(720);  
		ahead(100); 
		turnLeft(720); 
	}
	
}
