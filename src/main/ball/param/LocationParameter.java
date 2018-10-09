package main.ball.param;

import main.ball.Ball;

/**
 * Encapsulates initial location parameters of an individual {@link Ball} object.
 * Added to reduce clutter in Ball constructor.
 *
 * @author Janos Benyovszki
 * */
public class LocationParameter {

    private int x;
    private int y;

    public LocationParameter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
