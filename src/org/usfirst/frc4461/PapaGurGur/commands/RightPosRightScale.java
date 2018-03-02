package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosRightScale extends CommandGroup {

    public RightPosRightScale() {
    	addSequential(EncoderDrive.goForwardInches(302));
    	addSequential(new Delay(0));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(new Delay(0));
    	addSequential(AutonomousElevator.goUp(55));
    	addSequential(new Delay(0));
    	addSequential(EncoderDrive.goForwardInches(5));
    	addSequential(new Delay(0));
    	addSequential(new PlaceCube());
    	addSequential(new CloseGripper());
    	addSequential(EncoderDrive.goBackwardInches(5));
    	addSequential(AutonomousElevator.goDown(55));
    }
}
