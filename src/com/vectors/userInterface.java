package com.vectors;

import java.awt.*;
import java.awt.event.*;


public class userInterface extends Frame implements MouseMotionListener,MouseListener,ActionListener,KeyListener
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
        canvas.addMouseListener(canvas);
        canvas.addMouseMotionListener(canvas);
        canvas.addKeyListener(canvas);
        canvas.setVisible(true);
        canvas.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });

        //add menu items to canvas
        //file
        menuBar.add(File);
        File.add(open);
        open.addActionListener(canvas);
        File.add(Save);
        Save.addActionListener(canvas);
        File.add(reset);
        reset.addActionListener(canvas);

        //shape
        menuBar.add(shape);
        shape.add(plot);
        plot.addActionListener(canvas);
        shape.add(line);
        line.addActionListener(canvas);
        shape.add(rectangle);
        rectangle.addActionListener(canvas);
        shape.add(ellipse);
        ellipse.addActionListener(canvas);
        shape.add(poly);
        poly.addActionListener(canvas);

        //style
        menuBar.add(style);
        style.add(changeColor);
        changeColor.addActionListener(canvas);
        style.add(Static);
        Static.addActionListener(canvas);
        style.add(Fill);
        Fill.addActionListener(canvas);

    }

    public void actionPerformed(ActionEvent e) {}

    public void update(Graphics g) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
}

