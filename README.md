# BouncingBalls

## Features
Swing, Concurrency

## Description
My take on the classic bouncing balls application. The
balls are moved in their own thread and the update of the
UI is triggered in regular intervals. The balls can pass
through each other, they are only aware of the border, but
not the limits of other balls.

## Structure

### Classes
- Main: starts the application
- Ball: the ball object
- SpeedParameter, DirectionParameter, LocationParameter: attributes
of the ball object (it is a composite class)
- Direction: enum class to determine the balls direction
on the X or Y axis
- Worker: thread that updates the balls location on the
animation panel
- AnimationPanel: the panel that displays the balls and their
movements
- Colors: provides a random way to set the colors of the balls

## Hands On

![Bouncing Balls] (https://github.com/bjanos/Screenshots/blob/master/BouncingBalls/2018-04-20_14-54-23.png)


