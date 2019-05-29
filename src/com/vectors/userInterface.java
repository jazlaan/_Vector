package com.vectors;

import java.awt.*;
import java.awt.event.*;

public class userInterface extends Frame
{

    // canvas
    private static userInterface canvas = new userInterface();

    // menu bar
    private static MenuBar menuBar = new MenuBar();

    // file
    private static Menu File = new Menu("File");
    private static MenuItem open = new MenuItem("Open File");
    private static MenuItem Save = new MenuItem("Save File");
    private static MenuItem reset = new MenuItem("Reset Canvas");

    // shape
    private static Menu shape = new Menu("Shape");
    private static MenuItem plot = new MenuItem("Plot");
    private static MenuItem line = new MenuItem("Line");
    private static MenuItem rectangle = new MenuItem("Rectangle");
    private static MenuItem ellipse = new MenuItem("Ellipse");
    private static MenuItem poly = new MenuItem("Polygon");

    // edit
    private static Menu style = new Menu("Style");
    private static MenuItem changeColor = new MenuItem("Change Color");
    private static MenuItem Static = new MenuItem("Static Shape");
    private static MenuItem Fill = new MenuItem("Fill Shape");



    public static void main(String[] args)
    {

        //setup canvas
        canvas.setMenuBar(menuBar);
        canvas.setTitle("Canvas");
        canvas.setSize(800,800);
        canvas.setResizable(false);
        canvas.setVisible(true);
        canvas.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });

        //add menu items to canvas
        //file
        menuBar.add(File);
        File.add(open);
        File.add(Save);
        File.add(reset);

        //shape
        menuBar.add(shape);
        shape.add(plot);
        shape.add(line);
        shape.add(rectangle);
        shape.add(ellipse);
        shape.add(poly);

        //style
        menuBar.add(style);
        style.add(changeColor);
        style.add(Static);
        style.add(Fill);

    }


}

