package com.vectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.filechooser.*;

public class userInterface extends Frame implements MouseMotionListener,MouseListener,ActionListener,KeyListener
{

    private static int selectedShape =0;
    private static int shapeStyle =0;

    // canvas
    private static userInterface canvas = new userInterface();

    // menu bar
    private static MenuBar menuBar = new MenuBar();

    // file
    private static Menu File = new Menu("File");
    private static MenuItem open = new MenuItem("Open File");
    private static MenuItem Save = new MenuItem("Save File");
    private static MenuItem undo = new MenuItem("Undo");
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

        //quick start guide
        Box quickStartBox= Box.createVerticalBox();
        canvas.add( quickStartBox );

        JLabel howToNill = new JLabel("-");
        howToNill.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        howToNill.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        howToNill.setHorizontalAlignment(SwingConstants.CENTER);
        quickStartBox.add( howToNill );

        JLabel howToFirst = new JLabel("Quick Start Guide");
        howToFirst.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        howToFirst.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        howToFirst.setHorizontalAlignment(SwingConstants.CENTER);
        quickStartBox.add( howToFirst );

        JLabel howToSecond = new JLabel("1. Select a shape from the 'Shape' drop-down above");
        howToSecond.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        howToSecond.setHorizontalAlignment(SwingConstants.CENTER);
        quickStartBox.add( howToSecond );

        JLabel howToThird = new JLabel("2. Select the shape's color and style from the 'Style' drop-down above");
        howToThird.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        howToThird.setHorizontalAlignment(SwingConstants.CENTER);
        quickStartBox.add( howToThird );

        JLabel howToFour = new JLabel("3. Save the .vec file by clicking the 'File' drop-down option and finally click 'Save'");
        howToFour.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        howToFour.setHorizontalAlignment(SwingConstants.CENTER);
        quickStartBox.add( howToFour );

        //hide quick start guide
        int delay = 5000;

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                howToNill.setVisible(false);
                howToFirst.setVisible(false);
                howToSecond.setVisible(false);
                howToThird.setVisible(false);
                howToFour.setVisible(false);
            }
        };

        new javax.swing.Timer(delay, taskPerformer).start();

        //setup canvas
        canvas.setMenuBar(menuBar);
        canvas.setTitle("Vector Design Tool");
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
        File.add(undo);
        undo.addActionListener(canvas);
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
        style.add(Static);
        Static.addActionListener(canvas);
        style.add(Fill);
        Fill.addActionListener(canvas);
        style.add(changeColor);
        changeColor.addActionListener(canvas);




    }

    public void undoShape() {
    }

    public void actionPerformed(ActionEvent e) {

        MenuItem selectedMenuItem = (MenuItem) e.getSource();

        //reset canvas
        if(selectedMenuItem== undo){
            undoShape();
        }
        else if(selectedMenuItem== reset)
            repaint();

            //shape
        else if(selectedMenuItem== plot)
            selectedShape =0;

        else if(selectedMenuItem== line)
            selectedShape =1;

        else if(selectedMenuItem== rectangle)
            selectedShape =2;

        else if(selectedMenuItem== ellipse)
            selectedShape =3;

        else if(selectedMenuItem== poly)
            selectedShape =4;

        //style
        if(selectedMenuItem== Static)
            shapeStyle =0;
        else if(selectedMenuItem== Fill)
            shapeStyle =1;
    }

    public void update(Graphics g) {}

    public void canvas(Graphics g) {}

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

