package pedroPathing.constants;

import com.pedropathing.localization.Localizers;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.util.CustomFilteredPIDFCoefficients;
import com.pedropathing.util.CustomPIDFCoefficients;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class FConstants {
    static {
        FollowerConstants.localizers = Localizers.PINPOINT;

        FollowerConstants.leftFrontMotorName = "frontleft";
        FollowerConstants.leftRearMotorName = "rearleft";
        FollowerConstants.rightFrontMotorName = "frontright";
        FollowerConstants.rightRearMotorName = "rearright";

        FollowerConstants.leftFrontMotorDirection = DcMotorSimple.Direction.REVERSE;
        FollowerConstants.leftRearMotorDirection = DcMotorSimple.Direction.REVERSE;
        FollowerConstants.rightFrontMotorDirection = DcMotorSimple.Direction.FORWARD;
        FollowerConstants.rightRearMotorDirection = DcMotorSimple.Direction.FORWARD;

        FollowerConstants.mass = 12.35;

        FollowerConstants.xMovement = 84.40907596001061;
        FollowerConstants.yMovement = 61.024646283747906;

        FollowerConstants.forwardZeroPowerAcceleration = -25.418726731642277;
        FollowerConstants.lateralZeroPowerAcceleration = -65.19877594716175;

        /*
        FollowerConstants.translationalPIDFCoefficients.setCoefficients(0.05,0,0.0001,0);
        FollowerConstants.useSecondaryTranslationalPID = true;
        FollowerConstants.secondaryTranslationalPIDFCoefficients.setCoefficients(0.075,0,0.01,0);

        FollowerConstants.headingPIDFCoefficients.setCoefficients(2.5,0,0.2,0);
        FollowerConstants.useSecondaryHeadingPID = true;
        FollowerConstants.secondaryHeadingPIDFCoefficients.setCoefficients(1.2,0,0.04,0);

        FollowerConstants.drivePIDFCoefficients.setCoefficients(0.02,0,0.0001,0.6,0);
        FollowerConstants.useSecondaryDrivePID = true;
        FollowerConstants.secondaryDrivePIDFCoefficients.setCoefficients(0.02,0,0.0001,0.6,0);

         */

        FollowerConstants.translationalPIDFCoefficients.setCoefficients(0.16,0,0.01,0);
        FollowerConstants.useSecondaryTranslationalPID = true;
        FollowerConstants.secondaryTranslationalPIDFCoefficients.setCoefficients(0.13,0,0.015,0);

        FollowerConstants.headingPIDFCoefficients.setCoefficients(1.5,0,0.1,0);
        FollowerConstants.useSecondaryHeadingPID = true;
        FollowerConstants.secondaryHeadingPIDFCoefficients.setCoefficients(0.9,0,0.08,0);

        FollowerConstants.drivePIDFCoefficients.setCoefficients(0.018,0,0.0000012,0.6,0);
        FollowerConstants.drivePIDFFeedForward = 0.06;
        FollowerConstants.useSecondaryDrivePID = true;
        FollowerConstants.secondaryDrivePIDFCoefficients.setCoefficients(0.01,0,0.000001,0.6,0);

        FollowerConstants.zeroPowerAccelerationMultiplier = 4;
        FollowerConstants.centripetalScaling = 0.00025;

        FollowerConstants.pathEndTimeoutConstraint = 50;
        FollowerConstants.pathEndTValueConstraint = 0.98;
        FollowerConstants.pathEndVelocityConstraint = 0.1;
        FollowerConstants.pathEndTranslationalConstraint = 0.1;
        FollowerConstants.pathEndHeadingConstraint = 0.006;
    }
}
