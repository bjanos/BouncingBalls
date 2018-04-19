package main;

import java.awt.*;

/**
 * Ball class representing a ball object.
 *
 * @author Janos Benyovszki
 */
public class Ball {

    private LocationParameter _locations;
    private Color _color;
    private DirectionParameter _directions;
    private SpeedParameter _speeds;
    private int _size;

    /*
    * class variable count and instance variable id are used to
    * identify a ball object for printing out more meaningful
    * thread messages to the console
    *
    * */
    private static int _count = 0;
    private int _id;

    //advanced specs constructor
    public Ball(LocationParameter locations,
                int size,
                Color color,
                DirectionParameter directions,
                SpeedParameter speeds) {
        this._locations = locations;
        this._size = size;
        this._color = color;
        this._directions = directions;
        this._speeds = speeds;
        _id = _count++;
    }

    public LocationParameter getLocations() {
        return _locations;
    }

    public int getSize() {
        return _size;
    }

    public Color getColor() {
        return _color;
    }

    public DirectionParameter getDirections() {
        return _directions;
    }

    public SpeedParameter getSpeed() {
        return _speeds;
    }

    public int getId() {
        return _id;
    }
}

