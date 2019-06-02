package com.vectors.Shapes;
import com.vectors.userInterface;

import java.awt.*;

import static com.vectors.userInterface.*;

/**
 * Class for Ellipse object. Inherits from class Shapes.
 */
public class Line {


    /**
     * Creating a plot, which is just a point in specified color. Coordinates
     * is given in vector format (values between 0 and 1)
     * @param = x coordinate
     * @param = y coordinatte
     * @param = color of the plot
     */

    public Line(Graphics2D g2, int x1, int y1, int x2, int y2) {
        g2.drawLine( Math.min(x1, x1), Math.min(y1, y1), Math.min(x2, x2), Math.min(y2, y2));
        userInterface.content.add("line" + " " + (double)Math.min(x1, x1)/screenWidth + " " + (double)Math.min(y1, y1)/screenHeight + " " + (double)Math.min(x2, x2)/screenWidth + " " + (double)Math.min(y2, y2)/screenHeight + "\n");
    }

}

