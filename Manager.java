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
import java.util.HashMap;
import java.util.Map;

//this ↓↓ makes the angry yellows go away :) 
//@SuppressWarnings("unused")

public class Manager extends JPanel implements KeyListener , MouseMotionListener {
    private JFrame myFrame;
    private double mouseSensitivity=1.0;

    private Random r = new Random();
    Geomentry geo = new Geomentry();//geometry instance, for making shapes easily


    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)size.getWidth();
    int screenHeight = (int)size.getHeight();
    int screenCenterWidth = screenWidth/2;
    int screenCenterHeight = screenHeight/2;    

    Matrix projectionMatrix; //projection matrix, duh 
    
    Camera c; //camera object, will be initalized in initalizeScreen()


    //as far as i know, VertexPool will not work for moving vertices
    static Map<VertexPool, TriangleGroup> staticMeshHashmap = new HashMap<>();


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
    //this ↓↓ is the drawing method that is called every frame
    //i apologize for the shitty code that follows, i tried my best
    public void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.GREEN);
        g2.fillRect(0, 0, getWidth(), getHeight()); //fill the screen with black, then
        g2.translate(getWidth() / 2, getHeight() / 2);          //center the image

        //this converts the worldspace hashmap into a temporary screen space hashmap
        //recalculated each frame
        Map<VertexPool, TriangleGroup> screenSpaceHashmap = new HashMap<>();
        for (Map.Entry<VertexPool, TriangleGroup> entry : staticMeshHashmap.entrySet()) {
            screenSpaceHashmap.put(entry.getKey(), entry.getValue());
        }
        //applying the projection matrix and view matrix to each vertex
        for (Map.Entry<VertexPool, TriangleGroup> entry : screenSpaceHashmap.entrySet()) { 
            VertexPool value = entry.getKey();
            for (Map.Entry<Vector3, Vector3> vertexEntry : value.sharedVertices.entrySet()) {
                Vector3 vertex = vertexEntry.getValue();
                //make a matrix from the x y and z

                //apply the projection matrix

                //apply the view matrix

                //????
                //profit
            }
        }



        //orthogantic rendering, dont use
        // for (Map.Entry<VertexPool, TriangleGroup> entry : staticMeshHashmap.entrySet()) { 
        //     TriangleGroup value = entry.getValue();
        //     for(Triangle t: value.triangles){
        //         Path2D.Double path = new Path2D.Double();
        //         path.moveTo(t.v1.x, t.v1.y);
        //         path.lineTo(t.v2.x, t.v2.y);
        //         path.lineTo(t.v3.x, t.v3.y);
        //         path.lineTo(t.v1.x, t.v1.y);
        //         path.closePath();
        //         g2.setColor(t.color);
        //         g2.fill(path);
        //     }
        //  }
        
    }
    public void initalizeScreen(){
        // yo so this ↓↓ is the camera
        c = new Camera(0, 0, 0, new Vector3(0, 0, 0));
        projectionMatrix = c.calculateProjectionMatrix(screenWidth, screenHeight);
        geo.makeStaticPlane(100,-100,100,-100,100,-100,Color.RED,Color.BLUE);


        //for testing, this will print the whole projection matrix if needed
        //projectionMatrix.display();
        
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
