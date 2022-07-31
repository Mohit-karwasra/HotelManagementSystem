/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.* ;
import javax.swing.* ;

/*
 * @author mohit
 */
public class AddRooms extends JFrame implements ActionListener{
    
    JButton addr, cancel ;
    JTextField tfroom, tfprice ;
    JComboBox typecombo , availablecombo , cleancombo ;
   
    AddRooms(){
        getContentPane().setBackground(Color.white);
         setLayout(null) ;
         
         JLabel heading = new JLabel("Add Rooms");
         heading.setFont(new Font("Tahoma" , Font.BOLD , 18));
         heading.setBounds(150,20,200,20);
         add(heading) ;
         
         JLabel lblroomno = new JLabel("Room Number");
         lblroomno.setFont(new Font("Tahoma" , Font.PLAIN , 16));
         lblroomno.setBounds(60,80,120,30);
         add(lblroomno) ;
         
         tfroom = new JTextField();
         tfroom.setBounds(200, 80, 150, 30);
         add(tfroom) ;
         
         
         JLabel lblavailable = new JLabel("Available");
         lblavailable.setFont(new Font("Tahoma" , Font.PLAIN , 16));
         lblavailable.setBounds(60,130,120,30);
         add(lblavailable) ;
         
         String[] availableOptions = {"Available","Occupied"} ;
         availablecombo = new JComboBox(availableOptions);
         availablecombo.setBounds(200, 130, 150, 30);
         availablecombo.setBackground(Color.WHITE);
         add(availablecombo);
         
         JLabel lblclean = new JLabel("Cleaning Status");
         lblclean.setFont(new Font("Tahoma" , Font.PLAIN , 16));
         lblclean.setBounds(60,180,120,30);
         add(lblclean) ;
         
         String[] cleanOptions = {"Cleaned","Dirty"} ;
          cleancombo = new JComboBox(cleanOptions);
         cleancombo.setBounds(200, 180, 150, 30);
         cleancombo.setBackground(Color.WHITE);
         add(cleancombo);
         
         JLabel lblprice = new JLabel("Price");
         lblprice.setFont(new Font("Tahoma" , Font.PLAIN , 16));
         lblprice.setBounds(60,230,120,30);
         add(lblprice) ;
         
         tfprice = new JTextField();
         tfprice.setBounds(200, 230, 150, 30);
         add(tfprice) ;
         
         JLabel lbltype = new JLabel("Bed Type");
         lbltype.setFont(new Font("Tahoma" , Font.PLAIN , 16));
         lbltype.setBounds(60,280,120,30);
         add(lbltype) ;
         
         String[] typeOptions = {"Single Bed","Double Bed"} ;
          typecombo = new JComboBox(typeOptions);
         typecombo.setBounds(200, 280, 150, 30);
         typecombo.setBackground(Color.WHITE);
         add(typecombo);
         
         addr = new JButton("Add Room");
         addr.setForeground(Color.WHITE);
         addr.setBackground(Color.BLACK);
         addr.setBounds(60, 350, 130, 30);
         addr.addActionListener(this);
         add(addr);
         
         cancel = new JButton("Cancel");
         cancel.setForeground(Color.WHITE);
         cancel.setBackground(Color.BLACK);
         cancel.setBounds(220, 350, 130, 30);
         cancel.addActionListener(this);
         add(cancel);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
         JLabel image = new JLabel(i1);
         image.setBounds(400, 30, 500, 300);
         add(image);
         
        setBounds(330,200,940,470);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addr){
            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();
            
            try{
                Conn c = new Conn();
                
                
                String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"' )";
                
               c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added") ;
                
                setVisible(false);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
}
}
