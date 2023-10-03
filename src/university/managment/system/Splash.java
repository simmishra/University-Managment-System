package university.managment.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t ;
    Splash () {
        
        //attach image over frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);//scaled image
        ImageIcon i3 = new ImageIcon(i2);//we cant pass an object of image class in jlabel so we make image icon
        JLabel image = new JLabel(i3);//used becuase we directly cant place imageicon over frame
        add(image);//to place any component on frame
        
        
        t = new Thread(this);
        t.start();
        
        
        //Frame's visisbility is hidden by default
        setVisible(true);
        
        
//        setLocation(270,60);//distance from left, distance from top
//        setSize(1000,700);//length , width
        
        int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(600 - ((i + x)/2), 350 - (i/2));
            setSize(i + 3*x, i + x/2);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }  
    }
    
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            
            //next frame
            new Login();
            
        }catch(Exception e){
            
        }
    }
    public static void main(String [] args){
        new Splash();
    }
}
