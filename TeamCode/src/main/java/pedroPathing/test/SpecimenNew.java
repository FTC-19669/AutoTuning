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

@Autonomous(name = "SpecimenNew")
public class SpecimenNew extends OpMode {

    private Follower follower;
    private Timer pathTimer, opmodeTimer;
    private int pathState;

    private Pose startingPose = new Pose(6.661, 66.220, Math.toRadians(0));
    private Pose scorePose = new Pose(42.300, 68.220, Math.toRadians(0));
    private Pose pushSampleOnePose;
    private Pose pushSampleOneEndPose;
    private Pose pushSampleTwoPose;
    private Pose pushSampleTwoEndPose;
    private Pose pushSampleThreePose;
    private Pose pushSampleThreeEndPose;
    private Pose pickupSampleOnePose;
    private Pose pickup;
    private final Pose park;

    private PathChain scorePreload, pushSamples, line8, line9, line10, line11, line12, line13, line14, park;

    public void buildPaths() {
        scorePreload = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(startingPose.getX(), startingPose.getY(), Point.CARTESIAN),
                                new Point(13.518, 119.510, Point.CARTESIAN),
                                new Point(scorePose.getX(), scorePose.getY(), Point.CARTESIAN)
                        )
                )
                .setLinearHeadingInterpolation(scorePose.getHeading(), scorePose.getHeading())
                .build();

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
        park = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(6.269, 6.269, Point.CARTESIAN),
                                new Point(6.269, 6.269, Point.CARTESIAN)
                        )
                )
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                follower.followPath(scorePreload, .5, true);
                setPathState(1);
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(pushSamples, .9,true);
                    setPathState(2);
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(line8, true);
                    setPathState(3);
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(line9, true);
                    setPathState(4);
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(line10, true);
                    setPathState(5);
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(line11, true);
                    setPathState(6);
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(line12, true);
                    setPathState(7);
                }
                break;
            case 7:
                if (!follower.isBusy()) {
                    follower.followPath(line13, true);
                    setPathState(8);
                }
                break;
            case 8:
                if (!follower.isBusy()) {
                    follower.followPath(line14, true);
                    setPathState(9);
                }
                break;
            case 9:
                if (!follower.isBusy()) {
                    follower.followPath(park, 1, true);
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
        follower.setStartingPose(startingPose);
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
