package main.ball.param;

import main.ball.Ball;

/**
 * Encapsulates speed parameters of an individual {@link Ball} object.
 * Added to reduce clutter in Ball constructor.
 *
 * @author Janos Benyovszki
 * */
public class SpeedParameter {

    private int speedX;
    private int speedY;

    public SpeedParameter(int speedX, int speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }
}
