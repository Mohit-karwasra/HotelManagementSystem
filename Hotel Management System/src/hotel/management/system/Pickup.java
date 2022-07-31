/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;

/**
 *
 * @author mohit
 */
public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit ;
    Choice carModel ;
    
    Pickup(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Pickup Service");
        heading.setFont(new Font("Tahoma", Font.PLAIN,20));
        heading.setBounds(400, 30, 200, 30);
        add(heading);
        
        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
  
        carModel = new Choice();
        carModel.setBounds(150, 100, 200,25);
        add(carModel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                carModel.add(rs.getString("model"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
     
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Model");
        l5.setBounds(630, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Availibility");
        l6.setBounds(740, 160, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver ;") ;
            /**
             * using rs2xml.jar(package) file and importing (net.proteanit.sql.*) for entering data in table automatically
             */
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            try{
                String query = "select * from driver where model = '"+carModel.getSelectedItem()+"'" ;
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
              e.printStackTrace();
            }
        } 
        else if (ae.getSource()== back){
            setVisible(false);
            new Reception();
        }
        
    
    }
    
    public static void main(String[] args){
        new Pickup();
    }
}
