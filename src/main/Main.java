package main;

import javax.swing.*;

/**
 * Main class to start the application.
 *
 * @author Janos Benyovszki
 * */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Two");
        frame.add(new AnimationPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
