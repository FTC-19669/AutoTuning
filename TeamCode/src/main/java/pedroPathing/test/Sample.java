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

@Autonomous(name = "SampleTest")
public class Sample extends OpMode {
    private Follower follower;
    private int pathState;
    private Timer pathTimer, opmodeTimer;

    private Path scorePreload;
    private Path line2, line3, line4, line5, line6, line7, line8, line9, line10, line11;
    private Path park;

    public void buildPaths() {
        // Line 1
        scorePreload = new Path(
                new BezierCurve(
                        new Point(6.700, 113.900, Point.CARTESIAN),
                        new Point(13.518, 119.510, Point.CARTESIAN),
                        new Point(13.322, 130.090, Point.CARTESIAN)
                )
        );
        scorePreload.setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(316));

        // Line 2
        line2 = new Path(
                new BezierLine(
                        new Point(13.322, 130.090, Point.CARTESIAN),
                        new Point(20.571, 118.000, Point.CARTESIAN)
                )
        );
        line2.setLinearHeadingInterpolation(Math.toRadians(316), Math.toRadians(0));

        // Line 3
        line3 = new Path(
                new BezierLine(
                        new Point(20.571, 118.000, Point.CARTESIAN),
                        new Point(20.571, 123.000, Point.CARTESIAN)
                )
        );
        line3.setConstantHeadingInterpolation(Math.toRadians(0));

        // Line 4
        line4 = new Path(
                new BezierLine(
                        new Point(20.571, 123.000, Point.CARTESIAN),
                        new Point(13.322, 130.090, Point.CARTESIAN)
                )
        );
        line4.setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(316));

        // Line 5
        line5 = new Path(
                new BezierLine(
                        new Point(13.322, 130.090, Point.CARTESIAN),
                        new Point(20.571, 129.000, Point.CARTESIAN)
                )
        );
        line5.setLinearHeadingInterpolation(Math.toRadians(316), Math.toRadians(0));

        // Line 6
        line6 = new Path(
                new BezierLine(
                        new Point(20.571, 129.000, Point.CARTESIAN),
                        new Point(20.571, 134.000, Point.CARTESIAN)
                )
        );
        line6.setConstantHeadingInterpolation(Math.toRadians(0));

        // Line 7
        line7 = new Path(
                new BezierLine(
                        new Point(20.571, 134.000, Point.CARTESIAN),
                        new Point(13.322, 130.090, Point.CARTESIAN)
                )
        );
        line7.setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(316));

        // Line 8
        line8 = new Path(
                new BezierLine(
                        new Point(13.322, 130.090, Point.CARTESIAN),
                        new Point(45.453, 129.306, Point.CARTESIAN)
                )
        );
        line8.setLinearHeadingInterpolation(Math.toRadians(316), Math.toRadians(90));

        // Line 9
        line9 = new Path(
                new BezierLine(
                        new Point(45.453, 129.306, Point.CARTESIAN),
                        new Point(13.322, 130.090, Point.CARTESIAN)
                )
        );
        line9.setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(316));

        // Line 10
        line10 = new Path(
                new BezierCurve(
                        new Point(13.322, 130.090, Point.CARTESIAN),
                        new Point(27.037, 110.302, Point.CARTESIAN),
                        new Point(61.322, 119.706, Point.CARTESIAN),
                        new Point(59.755, 93.453, Point.CARTESIAN)
                )
        );
        line10.setLinearHeadingInterpolation(Math.toRadians(316), Math.toRadians(270));

        // Line 11
        line11 = new Path(
                new BezierCurve(
                        new Point(59.755, 93.453, Point.CARTESIAN),
                        new Point(61.322, 119.706, Point.CARTESIAN),
                        new Point(27.037, 110.302, Point.CARTESIAN),
                        new Point(13.322, 130.090, Point.CARTESIAN)
                )
        );
        line11.setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(316));

        // Line 12
        park = new Path(
                new BezierCurve(
                        new Point(13.322, 130.090, Point.CARTESIAN),
                        new Point(27.037, 110.302, Point.CARTESIAN),
                        new Point(61.322, 119.706, Point.CARTESIAN),
                        new Point(59.755, 93.453, Point.CARTESIAN)
                )
        );
        park.setLinearHeadingInterpolation(Math.toRadians(316), Math.toRadians(90));
    }

    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                follower.followPath(scorePreload, true);
                follower.setMaxPower(1);
                setPathState(1);
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(line2, true);
                    setPathState(2);
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(line3, true);
                    follower.setMaxPower(0.3);
                    setPathState(3);
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(line4, true);
                    setPathState(4);
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(line5, true);
                    follower.setMaxPower(0.3);
                    setPathState(5);
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(line6, true);
                    setPathState(6);
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(line7, true);
                    setPathState(7);
                }
                break;
            case 7:
                if (!follower.isBusy()) {
                    follower.followPath(line8, true);
                    setPathState(8);
                }
                break;
            case 8:
                if (!follower.isBusy()) {
                    follower.followPath(line9, true);
                    setPathState(9);
                }
                break;
            case 9:
                if (!follower.isBusy()) {
                    follower.followPath(line10, true);
                    setPathState(10);
                }
                break;
            case 10:
                if (!follower.isBusy()) {
                    follower.followPath(line11, true);
                    setPathState(11);
                }
                break;
            case 11:
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
        follower.setStartingPose(new Pose(6.700, 113.900, Math.toRadians(0)));
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

