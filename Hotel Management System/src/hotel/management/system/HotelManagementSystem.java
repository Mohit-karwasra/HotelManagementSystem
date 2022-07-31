/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

/**
 * @author mohit karwasra
 */
import java.awt.*;
import javax.swing.* ;
import java.awt.event.* ;

public class HotelManagementSystem extends JFrame implements ActionListener { // interface ActionListener is to catch the action/event happening 
    
    HotelManagementSystem(){
        //setSize(1366 , 565) ; // to set size of frame 
       // setLocation(100,150) ; //wrt window's top left origin
        setLayout(null) ; // to remove the default layout provided by swing 
        setBounds(100,150,1366,565);
        
        // adding image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);   //(x,y) coordinates wrt frame , (l,b) size .
        add(image);
        
        // adding text on frame
        JLabel text = new JLabel("Hotel Management System") ;
        text.setBounds(20,430,800,70) ;
        text.setForeground(Color.WHITE); // import awt class 
        text.setFont(new Font("serif" , Font.PLAIN , 50)) ;
        image.add(text);
        
        // adding button on frame
        JButton next = new JButton("Next") ;
        next.setBounds(1150, 450, 100, 40);
        next.setBackground(Color.white);
        next.setForeground(Color.magenta);
        next.addActionListener(this);       // to catch the action/event done on this button
        next.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(next) ;
        
        setVisible(true); // to set frame 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){   // method in ActionListener interface to set what to do if an action is performed
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();   // calling constructor of class so as to directly open the frame
    }
    
}
