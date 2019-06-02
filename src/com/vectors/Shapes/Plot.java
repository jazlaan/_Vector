package com.vectors.Shapes;

import com.vectors.userInterface;

import java.awt.*;

/**
 * Class for Ellipse object. Inherits from class Shapes.
 */
public class Plot {


    /**
     * Creating a plot, which is just a point in specified color. Coordinates
     * is given in vector format (values between 0 and 1)
     * @param = x coordinate
     * @param = y coordinatte
     * @param = color of the plot
     */


    public Plot(Graphics2D g2, int x, int y) {
        g2.fillOval( Math.min(x, x), Math.min(y, y), 5, 5);
        userInterface.content.add("plot" + " " + (double)Math.min(x, x)/userInterface.screenWidth + " " + (double)Math.min(y, y)/userInterface.screenHeight + "\n");
    }

}

