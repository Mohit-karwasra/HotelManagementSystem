package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
/**
 *
 * @author mohit
 */
public class Department extends JFrame implements ActionListener {
    JTable table ;
    JButton back ;
    Department(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(180, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(480, 10, 100, 20);
        add(l2);
        
        
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from department ;") ;
            /**
             * using rs2xml.jar(package) file and importing (net.proteanit.sql.*) for entering data in table automatically
             */
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        setBounds(400,200,700,480);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Department();
    }
    
}
