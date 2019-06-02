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


    public void actionPerformed(ActionEvent e)
    {
        MenuItem selectedMenuItem = (MenuItem) e.getSource();
        if(selectedMenuItem== open ) {
            if(importc.size() > 0 || content.size() > 0 ) {
                repaint();
                canvas.removeAll();
                importc.clear();
                content.clear();
                repaint();
            }
        }
        //undo canvas
        if(selectedMenuItem== undo){
            undoShape();
        }
        //reset canvas
        else if(selectedMenuItem== reset)
            repaint();

            //shapes
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

        //fill
        if(selectedMenuItem== fillDisable)
            shapeStyle =0;
        else if(selectedMenuItem== fillEnable)
            shapeStyle =1;

        //open .vec file
        if(selectedMenuItem== open) {
            loadFile();
        }

        //save .vec file
        else if(selectedMenuItem== Save)
        {
            inputOutput.saveFile();
        }

        //outlineColour
        if(selectedMenuItem== outlineColor){
            outlineColour = JColorChooser.showDialog(userInterface.this,
                    "Choose a outlineColour", penColor);
            if (outlineColour != null) {
                penColor = outlineColour;
            }
        }

        //fill color
        else if (selectedMenuItem== fillColorChange) {
            shapeStyle =1;
            fillColour = JColorChooser.showDialog(userInterface.this,
                    "Choose a outlineColour", fillColor);
            if (fillColour != null) {
                fillColor = fillColour;
            }
        }
    }

    public void read(){

        Graphics g=getGraphics();
        Graphics2D g2 = (Graphics2D) g.create();

        for (String str : importc) {
            g.setColor(penColor);
            String[] part = str.split("\\s+");
            if (part[0].equals("plot")) {
                new Plot (g2, Math.min((int)(Double.parseDouble(part[1]) * screenWidth ), (int)(Double.parseDouble(part[1]) * screenWidth )), Math.min((int)(Double.parseDouble(part[2])* screenHeight ), (int)(Double.parseDouble(part[2])* screenHeight )));
            }
            else if (part[0].equals("line")) {
                new Line(g2,  Math.min((int)(Double.parseDouble(part[1]) * screenWidth ), (int)(Double.parseDouble(part[1]) * screenWidth ))   ,   Math.min((int)(Double.parseDouble(part[2]) * screenHeight ), (int)(Double.parseDouble(part[2]) * screenHeight )) ,Math.min((int)(Double.parseDouble(part[3]) * screenWidth ), (int)(Double.parseDouble(part[3]) * screenWidth )) ,Math.min((int)(Double.parseDouble(part[4]) * screenHeight ), (int)(Double.parseDouble(part[4]) * screenHeight )));
            }
            else if (part[0].equals("rectangle")) {
                g2.drawRect(  (int)(Double.parseDouble(part[1]) * screenWidth) , (int)(Double.parseDouble(part[2]) * screenWidth)  , (int)(Double.parseDouble(part[3]) * screenWidth) , (int)(Double.parseDouble(part[4]) * screenWidth) );
            }
            else if (part[0].equals("ellipse")) {
                g.drawOval(  (int)(Double.parseDouble(part[1]) * screenWidth) , (int)(Double.parseDouble(part[2]) * screenWidth)  , (int)(Double.parseDouble(part[3]) * screenWidth) , (int)(Double.parseDouble(part[4]) * screenWidth) );
            }
            else if (part[0].equals("polygon")) {
                int polyXpoints[] = { (int)(Double.parseDouble(part[1]) ), (int)(Double.parseDouble(part[2]) ), (int)(Double.parseDouble(part[1]) ), (int)(Double.parseDouble(part[2]) ), (int)(Double.parseDouble(part[1]) )};
                int polyYpoints[] = {(int)(Double.parseDouble(part[4]) ), (int)(Double.parseDouble(part[4]) ), (int)(Double.parseDouble(part[3]) ), (int)(Double.parseDouble(part[3]) ), (int)(Double.parseDouble(part[4]) )};
                g.drawPolygon(polyXpoints, polyYpoints, 5);
            }
        }
        paint(g);
    }

    public void loadFile() {
        JFileChooser chooseFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        chooseFile.setAcceptAllFileFilterUsed(false);
        chooseFile.setDialogTitle("Open .vec file");
        FileNameExtensionFilter restrict = new FileNameExtensionFilter(".vec file", "vec");
        chooseFile.addChoosableFileFilter(restrict);
        if(chooseFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            file = chooseFile.getSelectedFile();
            try {
                Scanner reader = new Scanner(file);
                while(reader.hasNext()){
                    userInterface.importc.add(reader.nextLine());
                }
                read();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void update(Graphics g) {}

    public void canvas(Graphics g) {

        g.setColor(penColor);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(borderThickness));

        //Plot
        if(selectedShape ==0) {
            try{
                new Plot(g2,(int)pointStart.x,(int)pointStart.y);
            } catch (NullPointerException e) {}
        }
        //Line
        else if(selectedShape ==1) {
            new Line(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y);
        }
        //Rectangle
        else if(selectedShape ==2){
            if(shapeStyle ==0) {
                new Rectangle(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,false);
            } else {
                fillShape = true;
                new Rectangle(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,false);
                new Rectangle(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,true);
            }
        }
        //Ellipse
        else if(selectedShape ==3){
            if(shapeStyle ==0) {
                new Ellipse(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,false);
            }else{
                fillShape = true;
                new Ellipse(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,false);
                new Ellipse(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,true);
            }

        }
        //Polygon
        else if(selectedShape ==4){
            if(shapeStyle ==0) {
                new Polygon(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,false);
            }else{
                fillShape = true;
                new Polygon(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,false);
                new Polygon(g2,(int)pointStart.x,(int)pointStart.y,(int)pointEnd.x,(int)pointEnd.y,true);
            }
        }
    }

    public void mousePressed(MouseEvent e)
    {
        pointStart = e.getPoint();
    }

    public void mouseDragged(MouseEvent e)
    {
        Graphics g=getGraphics();
        pointEnd = e.getPoint();
    }
    public void mouseMoved(MouseEvent e) {}

    public void mouseReleased(MouseEvent e){
        Graphics g=getGraphics();
        pointEnd.x=e.getX();
        pointEnd.y=e.getY();
        canvas(g);
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}
}

