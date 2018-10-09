package main.ball;

import java.awt.*;
import java.util.Random;

/**
 * Generates a random color from a predefined set of 10 colors.
 *
 * @author Janos Benyovszki
 * */
public class Colors {

    private static final Color[] colors = {
            new Color(33, 199, 30),
            new Color(244, 128, 56),
            new Color(53, 187, 211),
            new Color(230, 227, 96),
            new Color(205, 93, 165),
            new Color(112, 39, 210),
            new Color(0, 203, 184),
            new Color(242, 242, 242),
            new Color(38, 235, 118),
            new Color(120, 15, 200)
    };

    private static final Random random = new Random();


    public static Color createColor() {
        return colors[random.nextInt(colors.length)];
    }


}
