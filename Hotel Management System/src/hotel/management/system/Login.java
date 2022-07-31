/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;
import java.sql.* ;
/**
 * @author mohit karwasra
 */
public class Login extends JFrame implements ActionListener{
    
    JTextField username  ;
    JPasswordField password ;
    JButton login, cancel ;
    
    Login() {
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        // label and textfield of username
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        username = new JTextField() ;
        username.setBounds(150 , 20 , 150 , 30);
        add(username);
        
        // label and textfield of password
        JLabel pass = new JLabel("Password") ;
        pass.setBounds(40 , 70, 100 , 30);
        add(pass);
        
        password = new JPasswordField() ;
        password.setBounds(150 , 70 , 150 , 30);
        add(password);
        
        // login button
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        // add Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT) ; // scale the image
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(350,10,200,200);
        add(image) ;
        
        
        
        setBounds(500,200,600,300) ;
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){ // .getSource to check action is performed on which button
            setVisible(false);
        }
        else if(ae.getSource() == login){
            String user = username.getText(); // gets text from textfield
            String pass = String.valueOf(password.getPassword());
            try{
                Conn c = new Conn(); // to call constructor of Conn class and use Statment class 
                
                String query = "select * from login where username = '"+user+"' and password = '"+pass+"'" ; 
                
                ResultSet rs = c.s.executeQuery(query);// exexutes statement i.e. sql query using Statement class
                                                       //executeQuery used to retrieve data
                
                if(rs.next() == true){ // to check if executed query is true 
                     if(username.getText().equals("admin")){
                       setVisible(false);
                       new DashboardAdmin();
                     }
                     else{
                       setVisible(false);
                       new Dashboard();
                     }
                    
                }else if(rs.next() == false){
                    JOptionPane.showMessageDialog(null, "Invalid username or password ") ;
                   setVisible(false);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new Login() ;
    }

}