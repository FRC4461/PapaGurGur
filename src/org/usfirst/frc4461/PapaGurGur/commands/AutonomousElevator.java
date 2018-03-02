package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousElevator extends Command {

	private static final int COUNTS_PER_REVOLUTION = 4096;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double GEAR_REDUCTION = 1/63;
	/** Number of encoder ticks per inch */
	private static final double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION * GEAR_REDUCTION / WHEEL_CIRCUMFERENCE;
	private static final int DEAD_ZONE = (int) COUNTS_PER_INCH * 1;
	private double countsToMove;

	private AutonomousElevator(double inchesToMove) {
		requires(Robot.elevator);
		countsToMove = inchesToMove * COUNTS_PER_INCH;
	}

	public static AutonomousElevator goDown(double inchesToMove) {
		return new AutonomousElevator(-inchesToMove);
	}

	public static AutonomousElevator goUp(double inchesToMove) {
		return new AutonomousElevator(inchesToMove);
	}

	protected void initialize() {
		Robot.elevator.configEncoder();
	}

	public void execute() {
		Robot.elevator.setElevatorTarget(countsToMove);
	}

	protected boolean isFinished() {
		return Robot.elevator.isStalled() || (Robot.elevator.getEncoderValue() > countsToMove - DEAD_ZONE
				&& Robot.elevator.getEncoderValue() < countsToMove + DEAD_ZONE);
	}

	protected void end() {
		Robot.elevator.resetMotor();
	}

	protected void interrupted() {
		end();
	}
}
