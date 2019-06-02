package com.vectors.Shapes;
import com.vectors.userInterface;

import java.awt.*;

import static com.vectors.userInterface.*;
/**
 * Class for Ellipse object. Inherits from class Shapes.
 */
public class Rectangle {


    /**
     * Creating a plot, which is just a point in specified color. Coordinates
     * is given in vector format (values between 0 and 1)
     * @param = x coordinate
     * @param = y coordinatte
     * @param = color of the plot
     */

    public Rectangle(Graphics2D g2, int x1, int y1, int x2, int y2 , boolean filled) {

        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);

        if (filled){
            g2.setColor(fillColour);
            g2.fillRect(Math.min(x1, x2), Math.min(y1, y2), width, height);

        }
        else {
            g2.drawRect(Math.min(x1, x2), Math.min(y1, y2), width, height);
        }

        userInterface.content.add("rectangle" + " " + (double)Math.min(x1, x2)/screenWidth + " " + (double)Math.min(y1, y2)/screenHeight + " " + (double)width/screenWidth + " " + (double)height/screenHeight + "\n");
    }


}

