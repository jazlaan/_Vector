package com.vectors;


//Imports
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Dependencies
import com.vectors.IO.inputOutput;
import com.vectors.Shapes.Ellipse;
import com.vectors.Shapes.Line;
import com.vectors.Shapes.Plot;
import com.vectors.Shapes.Polygon;
import com.vectors.Shapes.Rectangle;


public class userInterface extends Frame implements MouseMotionListener,MouseListener,ActionListener,KeyListener
{

    //Drawing Settings
    Graphics g=getGraphics();
    private static java.io.File file;
    private static Color penColor;
    private static Color fillColor;
    private static Color outlineColour;
    public static Color fillColour;
    private static int borderThickness =4;
    private static int shapeStyle =0;
    private static int selectedShape =0;
    private boolean fillShape = false;
    public static int screenWidth = 800;
    public static int screenHeight = 800;
    public static Point pointStart = null;
    public static Point pointEnd   = null;
    private final JFileChooser chooseFile = new JFileChooser();

    //Arrays to store drawn and loaded shapes
    public static ArrayList<String> content = new ArrayList<>();
    public static ArrayList<String> importc = new ArrayList<>();

    // canvas
    private static userInterface canvas = new userInterface();

    // menu bar
    private static MenuBar menuBar = new MenuBar();

    // file
    private static Menu File = new Menu("File");
    private static MenuItem open = new MenuItem("Open File");
    private static MenuItem Save = new MenuItem("Save File");
    private static MenuItem reset = new MenuItem("Reset");
    private static MenuItem undo = new MenuItem("Undo");

    // shape
    private static Menu shape = new Menu("Shape");
    private static MenuItem plot = new MenuItem("Plot");
    private static MenuItem line = new MenuItem("Line");
    private static MenuItem rectangle = new MenuItem("Rectangle");
    private static MenuItem ellipse = new MenuItem("Ellipse");
    private static MenuItem poly = new MenuItem("Polygon");

    // filled
    private static Menu fill = new Menu("Fill");
    private static MenuItem fillEnable = new MenuItem("Enable");
    private static MenuItem fillDisable = new MenuItem("Disable");

    // outlineColour
    private static Menu outlineColourChange = new Menu("Color");
    private static MenuItem outlineColor = new MenuItem("Change Outline Color");
    private static MenuItem fillColorChange = new MenuItem("Change Fill Color");


    public static void main(String[] args)
    {

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
        File.add(reset);
        reset.addActionListener(canvas);
        File.add(undo);
        undo.addActionListener(canvas);

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

        //fill
        menuBar.add(fill);
        fill.add(fillEnable);
        fillEnable.addActionListener(canvas);
        fill.add(fillDisable);
        fillDisable.addActionListener(canvas);

        //Colour Change
        menuBar.add(outlineColourChange);
        outlineColourChange.add(outlineColor);
        outlineColor.addActionListener(canvas);
        outlineColourChange.add(fillColorChange);
        fillColorChange.addActionListener(canvas);

    }

    /**
     * Checks the size of the array that contains shapes
     * and subtracts one from the total size of the array.
     */
    public void undoShape() {
        if (!content.isEmpty()) {
            int size = content.size() - 1;
            content.remove(size);
            repaint();
        }
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

        //file
        if(selectedMenuItem== open) {
        }
        else if(selectedMenuItem== Save)
        {
        }
    }

    public void read(){

        Graphics g=getGraphics();
        for (String str : importc) {
            String[] part = str.split("\\s+");
            if (part[0].equals("LINE")) {
                shapeStyle = 1;
//                x1 = (int)Double.parseDouble(part[1]) * screenWidth;
//                x2 = (int)Double.parseDouble(part[3]) * screenWidth;
//                y1 = (int)Double.parseDouble(part[2]) * screenHeight;
//                y2 = (int)Double.parseDouble(part[4]) * screenHeight;
            }
        }
        canvas(g);
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

