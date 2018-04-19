package main;

/**
 * Encapsulates direction parameters of an individual {@link Ball} object.
 * Added to reduce clutter in Ball constructor.
 *
 * @author Janos Benyovszki
 * */
class DirectionParameter {

    private Direction directionX;
    private Direction directionY;

    public DirectionParameter(Direction directionX, Direction directionY) {
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public Direction getDirectionX() {
        return directionX;
    }

    public Direction getDirectionY() {
        return directionY;
    }

    public void setDirectionX(Direction directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(Direction directionY) {
        this.directionY = directionY;
    }
}
