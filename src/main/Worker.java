package main;

/**
 * Worker thread updating the location of one ball in a background
 * process. Also checks if the ball reaches the edges of the screen.
 * Each thread sleeps for a specific time.
 *
 * @author Janos Benyovszki
 * */
public class Worker extends Thread implements Runnable {

    /*
    * Reference to the animation panel. Needed to call its
    * coordinate setter and border check methods.
    * */
    private final AnimationPanel _panel;
    private Ball _ball;
    private static int _delay = -1;

    ////////////DEBUGGING START///////////////

    private boolean debugOn = false;

    /////////////DEBUGGING END/////////////////

    public Worker(AnimationPanel panel, Ball ball) {
        this._panel = panel;
        this._ball = ball;
    }

    public static void setDelay(int delay) {
        Worker._delay = delay;
    }

    @Override
    public void run() {
        ////////////DEBUGGING START///////////////

        if (debugOn) {
            System.out.printf(
                    "%s running with ball %d\n",
                    Thread.currentThread().getName(),
                    _ball.getId()
            );
        }

        /////////////DEBUGGING END/////////////////

        while (true) {
            _panel.setCoordinates(_ball);
            _panel.borderCheck(_ball);

            ////////////DEBUGGING START///////////////

            if (debugOn) {
                System.out.printf(
                        "%s sleeping with ball %d\n",
                        Thread.currentThread().getName(),
                        _ball.getId()
                );
            }

            /////////////DEBUGGING END/////////////////

            nap(_delay != -1 ? _delay : 100);

            ////////////DEBUGGING START///////////////

            if (debugOn) {
                System.out.printf(
                        "%s awake with ball %d\n",
                        Thread.currentThread().getName(),
                        _ball.getId()
                );
            }

            /////////////DEBUGGING END/////////////////

        }
    }

    private void nap(int interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
