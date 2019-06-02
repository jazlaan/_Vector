package com.vectors;

import com.vectors.Shapes.Line;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class userInterfaceTest {


    @Test
    public void Line() {
        //Shapes.Line line = new Shapes.Line(0, 0, 0.5, 0.5, Color.black);

        //String lineStr = line.toVecFormat();

        Graphics g = getGraphics();

        Graphics2D g2 = (Graphics2D) g.create();

        Line line = new Line(g2, 1, 1, 1, 1);
        //System.out.println(line);


        assertEquals(line, "PEN #000000\n" + "LINE 0.0 0.0 0.5 0.5\n");


    }



}