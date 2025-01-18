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

//this ↓↓ makes the angry yellows go away :) 
//@SuppressWarnings("unused")

public class Manager extends JPanel implements KeyListener , MouseMotionListener {
    private JFrame myFrame;
    private double mouseSensitivity=1.0;

    private Random r = new Random();

    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)size.getWidth();
    int screenHeight = (int)size.getHeight();
    int screenCenterWidth = screenWidth/2;
    int screenCenterHeight = screenHeight/2;    

    //constructor
    private Manager() {
        myFrame = new JFrame("Game!");
        Matrix projecMatrix;
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
    //this ↓↓ is the drawing method that is called every frame
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.PINK);
        g2.fillRect(0, 0, getWidth(), getHeight());

    }
    public void initalizeScreen(){
        
    }
    public double[][] calculateProjectionMatrix() {
        double fov = 90;
        double aspectRatio = screenWidth / screenHeight;
        double near = 0.1;
        double far = 10000;
        double f = 1 / Math.tan(Math.toRadians(fov) / 2);
        double[][] projectionMatrix = {
            {f / aspectRatio, 0, 0, 0},
            {0, f, 0, 0},
            {0, 0, (far + near) / (near - far), (2 * far * near) / (near - far)},
            {0, 0, -1, 0}
        };
        return projectionMatrix;
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
