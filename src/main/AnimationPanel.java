package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main animation panel. Draws an array of balls and moves them around by periodically
 * repainting itself. It relies on worker threads updating the balls coordinates in the
 * same interval as it repaints itself. This can be off of course based on the availability
 * of threads on the processor.
 * The class implements ActionListener interface to be able to respond to the
 * periodic action events of the Timer by repainting itself.
 *
 * @author Janos Benyovszki
 * */
public class AnimationPanel extends JPanel implements ActionListener {

    private Timer _timer;
    //interval to update ball coordinates
    private final int _delay = 10;

    private int _numberOfBalls = 20;

    private ArrayList<Ball> _balls;

    private final Direction[] _directionPool = {
            Direction.POSITIVE,
            Direction.NEGATIVE,
            Direction.STAND_STILL
    };

    private final Random random = new Random();

    private Worker[] _workers;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public AnimationPanel() {
        initialisePanel();
        initialiseFields();
        _timer.setInitialDelay(0);
        _timer.start();
        for (Worker worker : _workers) {
            executorService.execute(worker);
        }
    }

    /**
     * Utility method to outsource non-final fields setup.
     */
    private void initialisePanel() {
        /*
         * Setting both size and preferred size. Size cannot be queried
         * in initialiseFields unless set here, as preferred size only
         * sets size once the frame allocates it. Preferred size is needed
         * to enforce the size of the panel.
         * */
        Dimension size = new Dimension(400, 300);
        setSize(size);
        setPreferredSize(size);
        setBackground(new Color(12, 210, 150));
    }

    /**
     * Utility method to outsource non-final fields setup.
     */
    private void initialiseFields() {
        int _ballSize = 25;

        _balls = new ArrayList<>();
        _workers = new Worker[_numberOfBalls];
        Worker.setDelay(_delay);

        for (int i = 0; i < _numberOfBalls; i++) {
            _balls.add(
                    new Ball(
                            new LocationParameter(
                                    random.nextInt(getWidth() - _ballSize),
                                    random.nextInt(getHeight() - _ballSize)
                            ),
                            _ballSize,
                            Colors.createColor(),
                            new DirectionParameter(
                                    _directionPool[random.nextInt(3)],
                                    _directionPool[random.nextInt(3)]
                            ),
                            new SpeedParameter(
                                    random.nextInt(5) + 1,
                                    random.nextInt(5) + 1
                            )
                    )
            );

            _workers[i] = new Worker(this, _balls.get(i));
        }
        _timer = new Timer(0, this);


    }

    /**
     * Paints all balls to the screen with their current X and Y locations.
     * */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //used ony for smoother edges for the ball
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Ball ball : _balls) {
            graphics.setColor(ball.getColor());
            graphics.fillOval(
                    ball.getLocations().getX(),
                    ball.getLocations().getY(),
                    ball.getSize(),
                    ball.getSize()
            );
        }
    }

    /**
     * Response to the timers action event trigger.
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Takes over the setting of X and Y coordinates of a ball object.
     * */
    void setCoordinates(Ball currentBall) {

        ///////////////////////////
        //// SET X COORDINATE ////
        //////////////////////////

        DirectionParameter currentDirections = currentBall.getDirections();
        LocationParameter currentLocation = currentBall.getLocations();
        SpeedParameter currentSpeed = currentBall.getSpeed();

        switch (currentDirections.getDirectionX()) {
            case POSITIVE:
                currentLocation.setX(currentLocation.getX() + currentSpeed.getSpeedX());
                break;
            case NEGATIVE:
                currentLocation.setX(currentLocation.getX() - currentSpeed.getSpeedX());
                break;
            case STAND_STILL:
                currentLocation.setX(currentLocation.getX());
        }

        ///////////////////////////
        //// SET Y COORDINATE ////
        //////////////////////////

        switch (currentDirections.getDirectionY()) {
            case POSITIVE:
                currentLocation.setY(currentLocation.getY() + currentSpeed.getSpeedY());
                break;
            case NEGATIVE:
                currentLocation.setY(currentLocation.getY() - currentSpeed.getSpeedY());
                break;
            case STAND_STILL:
                currentLocation.setY(currentLocation.getY());
        }

    }


    /**
     * Checks if either X or Y reached the edges of the screen, and
     * if yes, reverses the appropriate direction.
     */
    void borderCheck(Ball currentBall) {

        //store variables, so that they don't have to be queried continuously
        int ballSize = currentBall.getSize();
        int ballTotalX = currentBall.getLocations().getX() + ballSize;
        int ballTotalY = currentBall.getLocations().getY() + ballSize;
        DirectionParameter currentDirections = currentBall.getDirections();

        //check X coordinate
        if (ballTotalX >= getWidth()) {
            currentDirections.setDirectionX(Direction.NEGATIVE);
        } else if (ballTotalX <= ballSize) {
            currentDirections.setDirectionX(Direction.POSITIVE);
        }

        //check Y coordinate
        if (ballTotalY >= getHeight()) {
            currentDirections.setDirectionY(Direction.NEGATIVE);
        } else if (ballTotalY <= ballSize) {
            currentDirections.setDirectionY(Direction.POSITIVE);
        }

    }

}
