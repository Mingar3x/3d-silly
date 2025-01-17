//imports
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D; //used for wireframe rendering
import java.awt.image.BufferedImage;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;
import java.util.ArrayList;

public class Manager extends JPanel implements KeyListener , MouseMotionListener {
    private JFrame myFrame;
    private double sensitivity=2;

    private Random r = new Random();

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)size.getWidth();
    int screenHeight = (int)size.getHeight();
    int screenCenterWidth = screenWidth/2;
    int screenCenterHeight = screenHeight/2;    

    //constructor
    private Manager() {
        myFrame = new JFrame("Game!");

        myFrame.add(this);
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);

        myFrame.setSize(screenWidth, screenHeight);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setUndecorated(true);
        myFrame.setVisible(true);
        
        initalizeScreen();
        
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.PINK);
        g2.fillRect(0, 0, getWidth(), getHeight());

    }
    public void initalizeScreen(){
        
    }
    
    

    public void keyTyped(KeyEvent e) {
        //Hey! I'm not implemented! Fix that!
    }

    public void keyPressed(KeyEvent e) {
        //Hey! I'm not implemented! Fix that!
    }

    public void keyReleased(KeyEvent e) {
        //Hey! I'm not implemented! Fix that!
    }
    public void mouseDragged(MouseEvent e) {
        //Hey! I'm not implemented! Fix that!
        //System.out.println("hi"); 
}
    public void mouseMoved(MouseEvent e) {
        //nothing doing, buster
        myFrame.repaint();
    }
    public static void main(String[] args) {
        
        new Manager();
    }
}
