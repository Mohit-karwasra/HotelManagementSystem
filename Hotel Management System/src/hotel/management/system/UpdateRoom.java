
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author mohit
 */
public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccroomid;
    JTextField tfavailibiity,tfstatus ;
    JButton check,update,back ;
    
    UpdateRoom(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN, 25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.red);
        add(text);
        
        JLabel lblid = new JLabel("Room number");
        lblid.setBounds(30,90,100,20);
        add(lblid);
        
        ccroomid = new Choice();
        ccroomid.setBounds(200,90,150,25);
        add(ccroomid);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccroomid.add(rs.getString("room"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel lblcleaning = new JLabel("Cleaning Status");
        lblcleaning.setBounds(30,170,100,20);
        add(lblcleaning);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200,170,150,25);
        add(tfstatus);
        
        JLabel lblavalibility = new JLabel("Availibility");
        lblavalibility.setBounds(30,130,100,20);
        add(lblavalibility);
        
        tfavailibiity = new JTextField();
        tfavailibiity.setBounds(200,130,150,25);
        add(tfavailibiity);
        
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30, 240, 100, 30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150, 240, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(80, 300, 100, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,420);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        Conn c = new Conn();
        if(ae.getSource()== check){
            String id = ccroomid.getSelectedItem();
            String query1 = "select * from room where roomnumber = '"+id+"'";
            try{
                ResultSet rs = c.s.executeQuery(query1);
                
                while(rs.next()){
                    
                    tfavailibiity.setText(rs.getString("availibility"));
                    tfstatus.setText(rs.getString("cleaning_status"));

                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== update){
            
            String roomid = ccroomid.getSelectedItem();
            String available = tfavailibiity.getText();
            String status = tfstatus.getText();
            
            String query2 = "update room set availibility = '"+available+"', cleaning_status = '"+status+"' where roomnumber = '"+roomid+"'" ;
            
            try{
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Data Updated");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else {
            setVisible(false);
            new Reception();
        }

    }
    
    public static void main(String[] args){
        new UpdateRoom(); 
    }
}
