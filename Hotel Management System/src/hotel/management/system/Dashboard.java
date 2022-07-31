package hotel.management.system;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent ;
/**
 * @author mohit karwasra
 */
public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard() {
        setBounds(0,0,1550,950) ;
        setLayout(null) ;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,1550,950) ;
        add(image) ;
        
        
        JLabel text = new JLabel("THE TAJ WELCOMES YOU") ;
        text.setBounds(400,80,1000,50) ;
        text.setFont(new Font("Tahoma" , Font.PLAIN , 46)) ;
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar mb = new JMenuBar() ;
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT") ;
        hotel.setForeground(Color.RED);
        mb.add(hotel) ;
        
        JMenuItem reception = new JMenuItem("RECEPTION") ;
        reception.addActionListener(this);
        hotel.add(reception) ;
        
        
        setVisible(true);
    }

    /**
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand() ;
        if(command.equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Dashboard() ;
    }
}
