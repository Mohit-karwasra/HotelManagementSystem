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
public class Checkout extends JFrame implements ActionListener{
    
    Choice ccroomid ;
    JLabel lblcid ,lblcheckin,lblcheckout;
    JButton checkout , back ;
    
    Checkout(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel lblroom = new JLabel("Room id");
        lblroom.setBounds(30,80, 100, 30);
        add(lblroom);
        
        ccroomid = new Choice();
        ccroomid.setBounds(150,80,150,25);
        add(ccroomid);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tickimage = new JLabel(i3);
        tickimage.setBounds(310, 80, 20, 20);
        add(tickimage);
        
        JLabel lblcustomerid = new JLabel("Customer id");
        lblcustomerid.setBounds(30,130, 100, 30);
        add(lblcustomerid);
        
        lblcid = new JLabel();
        lblcid.setBounds(150,130, 100, 30);
        add(lblcid);
        
        JLabel lblcheckintime = new JLabel("Checkin Time");
        lblcheckintime.setBounds(30,180, 100, 30);
        add(lblcheckintime);
        
        lblcheckin = new JLabel();
        lblcheckin.setBounds(150,180, 100, 30);
        add(lblcheckin);
        
        JLabel lblcheckouttime = new JLabel("Checkout Time");
        lblcheckouttime.setBounds(30,230, 100, 30);
        add(lblcheckouttime);
        
        // done to remove ambiguity between java.util.Date and java.sql.Date 
        java.util.Date date = new java.util.Date();
        lblcheckout = new JLabel(""+date);
        lblcheckout.setBounds(150,230, 150, 30);
        add(lblcheckout);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                ccroomid.add(rs.getString("room"));
                lblcid.setText(rs.getString("number"));
                lblcheckin.setText(rs.getString("checkintime"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.png"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== checkout ){
          String query1 = "delete from customer where room = '"+ccroomid.getSelectedItem()+"'" ;
          String query2 = "update room set availibility = 'Available' where roomnumber ='"+ccroomid.getSelectedItem()+"'";
          
          try{
              Conn c = new Conn();
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              
              JOptionPane.showMessageDialog(null, "Checkout Done");
              setVisible(false);
              new Reception();
          }
          catch(Exception e){
              e.printStackTrace();
          }
           
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }  
}
