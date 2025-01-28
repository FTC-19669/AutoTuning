package pedroPathing.test;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import  com.qualcomm.robotcore.eventloop.opmode.OpMode;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous(name = "SpecimenTest")
public class Specimen extends OpMode {

    private Follower follower;
    private Timer pathTimer, opmodeTimer;
    private int pathState;

    private Path scoreSpecimen, line8, line9, line10, line11, line12, line13, line14, park;
    private PathChain pushSamples;

    public void buildPaths() {
        // Line 1
        scoreSpecimen = new Path(
                new BezierLine(
                        new Point(6.661, 66.220, Point.CARTESIAN),
                        new Point(42.300, 66.220, Point.CARTESIAN)
                )
        );
        scoreSpecimen.setConstantHeadingInterpolation(Math.toRadians(0));
        scoreSpecimen.setPathEndVelocityConstraint(0.5);

        // PathChain for Lines 2–7
        pushSamples = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(42.300, 66.220, Point.CARTESIAN),
                                new Point(19.788, 20.767, Point.CARTESIAN),
                                new Point(62.302, 43.102, Point.CARTESIAN),
                                new Point(60.931, 22.531, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .addPath(
                        new BezierLine(
                                new Point(60.931, 22.531, Point.CARTESIAN),
                                new Point(18.416, 22.727, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .addPath(
                        new BezierCurve(
                                new Point(18.416, 22.727, Point.CARTESIAN),
                                new Point(62.694, 24.294, Point.CARTESIAN),
                                new Point(60.343, 12.735, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .addPath(
                        new BezierLine(
                                new Point(60.343, 12.735, Point.CARTESIAN),
                                new Point(18.024, 12.343, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .addPath(
                        new BezierCurve(
                                new Point(18.024, 12.343, Point.CARTESIAN),
                                new Point(59.951, 13.127, Point.CARTESIAN),
                                new Point(59.363, 6.269, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(0))
                .addPath(
                        new BezierLine(
                                new Point(59.363, 6.269, Point.CARTESIAN),
                                new Point(6.269, 6.269, Point.CARTESIAN)
                        )
                )
                .build();

        // Remaining Lines (8–15)
        line8 = new Path(
                new BezierCurve(
                        new Point(6.269, 6.269, Point.CARTESIAN),
                        new Point(19.984, 72.686, Point.CARTESIAN),
                        new Point(42.300, 69.159, Point.CARTESIAN)
                )
        );
        line8.setConstantHeadingInterpolation(Math.toRadians(0));
        line8.setPathEndVelocityConstraint(0.5);

        line9 = new Path(
                new BezierCurve(
                        new Point(42.300, 69.159, Point.CARTESIAN),
                        new Point(21.355, 72.098, Point.CARTESIAN),
                        new Point(29.976, 38.008, Point.CARTESIAN),
                        new Point(6.857, 33.502, Point.CARTESIAN)
                )
        );
        line9.setConstantHeadingInterpolation(Math.toRadians(0));

        line10 = new Path(
                new BezierCurve(
                        new Point(6.857, 33.502, Point.CARTESIAN),
                        new Point(29.976, 38.008, Point.CARTESIAN),
                        new Point(21.355, 72.098, Point.CARTESIAN),
                        new Point(42.300, 71.159, Point.CARTESIAN)
                )
        );
        line10.setConstantHeadingInterpolation(Math.toRadians(0));
        line10.setPathEndVelocityConstraint(0.5);

        line11 = new Path(
                new BezierCurve(
                        new Point(42.300, 71.159, Point.CARTESIAN),
                        new Point(21.355, 72.098, Point.CARTESIAN),
                        new Point(29.976, 38.008, Point.CARTESIAN),
                        new Point(6.857, 33.502, Point.CARTESIAN)
                )
        );
        line11.setConstantHeadingInterpolation(Math.toRadians(0));

        line12 = new Path(
                new BezierCurve(
                        new Point(6.857, 33.502, Point.CARTESIAN),
                        new Point(29.976, 38.008, Point.CARTESIAN),
                        new Point(21.355, 72.098, Point.CARTESIAN),
                        new Point(42.300, 73.159, Point.CARTESIAN)
                )
        );
        line12.setConstantHeadingInterpolation(Math.toRadians(0));
        line12.setPathEndVelocityConstraint(0.5);

        line13 = new Path(
                new BezierCurve(
                        new Point(42.300, 73.159, Point.CARTESIAN),
                        new Point(21.355, 72.098, Point.CARTESIAN),
                        new Point(29.976, 38.008, Point.CARTESIAN),
                        new Point(6.857, 33.502, Point.CARTESIAN)
                )
        );
        line13.setConstantHeadingInterpolation(Math.toRadians(0));

        line14 = new Path(
                new BezierCurve(
                        new Point(6.857, 33.502, Point.CARTESIAN),
                        new Point(29.192, 36.637, Point.CARTESIAN),
                        new Point(21.355, 72.098, Point.CARTESIAN),
                        new Point(42.300, 75.159, Point.CARTESIAN)
                )
        );
        line14.setConstantHeadingInterpolation(Math.toRadians(0));
        line14.setPathEndVelocityConstraint(0.5);

        park = new Path(
                new BezierLine(
                        new Point(42.300, 75.159, Point.CARTESIAN),
                        new Point(6.857, 37.420, Point.CARTESIAN)
                )
        );
        park.setConstantHeadingInterpolation(Math.toRadians(0));
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                follower.followPath(scoreSpecimen, true);
                follower.setMaxPower(1); // Set max power
                setPathState(1);
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(pushSamples, true);
                    follower.setMaxPower(1); // Set max power
                    setPathState(2);
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(line8, true);
                    follower.setMaxPower(1);
                    setPathState(3);
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(line9, true);
                    follower.setMaxPower(1);
                    setPathState(4);
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(line10, true);
                    follower.setMaxPower(1);
                    setPathState(5);
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(line11, true);
                    follower.setMaxPower(1);
                    setPathState(6);
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(line12, true);
                    follower.setMaxPower(1);
                    setPathState(7);
                }
                break;
            case 7:
                if (!follower.isBusy()) {
                    follower.followPath(line13, true);
                    follower.setMaxPower(1);
                    setPathState(8);
                }
                break;
            case 8:
                if (!follower.isBusy()) {
                    follower.followPath(line14, true);
                    follower.setMaxPower(1);
                    setPathState(9);
                }
                break;
            case 9:
                if (!follower.isBusy()) {
                    follower.followPath(park, true);
                    follower.setMaxPower(1);
                    setPathState(-1);
                }
                break;
        }
    }

    public void setPathState(int newState) {
        pathState = newState;
        pathTimer.resetTimer();
    }

    public void init() {
        pathTimer = new Timer();
        opmodeTimer = new Timer();
        opmodeTimer.resetTimer();

        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap);
        follower.setStartingPose(new Pose(6.661, 66.220, Math.toRadians(0)));
        buildPaths();
    }

    @Override
    public void start() {
        opmodeTimer.resetTimer();
        setPathState(0);
    }

    public void loop() {
        follower.update();
        autonomousPathUpdate();

        telemetry.addData("path state", pathState);
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.update();
    }
}
