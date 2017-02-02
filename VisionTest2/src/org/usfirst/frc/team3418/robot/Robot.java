package org.usfirst.frc.team3418.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	Vision mVision;

	

 @Override
 public void robotInit() {
	 mVision = Vision.getInstance();
 }

 @Override
 public void autonomousInit() {
	 
 }

 @Override
 public void autonomousPeriodic() {
	 
 }

}

