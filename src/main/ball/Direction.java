package main.ball;

/**
 * Enum class to control ball direction.
 *
 * @author Janos Benyovszki
 */
public enum Direction {

    /**
     * The ball is moving either on the X or Y axis in a positive direction
     */
    POSITIVE,

    /**
     * The ball is moving either on the X or Y axis in a negative direction
     */
    NEGATIVE,

    /**
     * The ball does not move on the X and / or Y axis
     */
    STAND_STILL
}
