package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateGripMotors extends Command {

    public OperateGripMotors() {
	requires(Robot.gripMotors);
    }

    protected void initialize() {
    }

    protected void execute() {
	boolean rightBumper = OI.getRightBumper();
	boolean leftBumper = OI.getLeftBumper();
	
	if(rightBumper){
	    Robot.gripMotors.runIntake();
	} else if (leftBumper){
	    Robot.gripMotors.runOuttake();
	} else {
	    Robot.gripMotors.stopMotors();
	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}