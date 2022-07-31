
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author mohit
 */
public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccroomid;
    JTextField tfidnum,tfname,tfcheckintime,tfdeposit,tfpending ;
    JButton check,update,back ;
    
    UpdateCheck(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN, 20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.red);
        add(text);
        
        JLabel lblid = new JLabel("Room number");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccroomid = new Choice();
        ccroomid.setBounds(200,80,150,25);
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
        
        JLabel lblcustomer = new JLabel("Customer id");
        lblcustomer.setBounds(30,120,100,20);
        add(lblcustomer);
        
        tfidnum = new JTextField();
        tfidnum.setBounds(200,120,150,25);
        add(tfidnum);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblcheckintime = new JLabel("Checkin Time");
        lblcheckintime.setBounds(30,200,100,20);
        add(lblcheckintime);
        
        tfcheckintime = new JTextField();
        tfcheckintime.setBounds(200,200,150,25);
        add(tfcheckintime);
        
        JLabel lbldeposit = new JLabel("Amount Paid");
        lbldeposit.setBounds(30,240,100,20);
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,240,150,25);
        add(tfdeposit);
        
        JLabel lblpending = new JLabel("Amount Pending");
        lblpending.setBounds(30,280,100,20);
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        Conn c = new Conn();
        if(ae.getSource()== check){
            String id = ccroomid.getSelectedItem();
            String query1 = "select * from customer where room = '"+id+"'";
            try{
                ResultSet rs = c.s.executeQuery(query1);
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+ccroomid.getSelectedItem()+"';");
                while(rs.next()){
                    tfidnum.setText(rs.getString("number"));
                    tfname.setText(rs.getString("name"));
                    tfcheckintime.setText(rs.getString("checkintime"));
                    tfdeposit.setText(rs.getString("deposit"));
                }
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfdeposit.getText());
                    tfpending.setText(""+amountPaid);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== update){
            String roomid = ccroomid.getSelectedItem();
            String number = tfidnum.getText();
            String name = tfname.getText();
            String checkIn = tfcheckintime.getText();
            String deposit = tfdeposit.getText();
            
            String query2 = "update customer set number = '"+number+"', name = '"+name+"',checkintime'"+checkIn+"',deposit'"+deposit+"'where room = '"+roomid+"'" ;
            
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
        new UpdateCheck(); 
    }
}
