package com.vectors.Shapes;
import com.vectors.userInterface;

import java.awt.*;

import static com.vectors.userInterface.fillColour;

/**
 * Class for Ellipse object. Inherits from class Shapes.
 */
public class Polygon {


    /**
     * Creating a plot, which is just a point in specified color. Coordinates
     * is given in vector format (values between 0 and 1)
     * @param = x coordinate
     * @param = y coordinatte
     * @param = color color of the plot
     */
    public Polygon(Graphics2D g2, int x1, int y1, int x2, int y2 , boolean filled) {

        int polyXpoints[] = {x1, x2, x1, x2, x1};
        int polyYpoints[] = {y2, y2, y1, y1, y2};
        int nPoints = 5;

        if (filled){
            g2.setColor(fillColour);
            g2.fillPolygon(polyXpoints, polyYpoints, nPoints);
        }
        else {
            g2.drawPolygon(polyXpoints, polyYpoints, nPoints);
        }
        userInterface.content.add("polygon" + " " + x1 + " " + x2 + " " + y1 + " " + y2 + "\n");
    }


}

