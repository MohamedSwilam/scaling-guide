
package Guest;

import hotel.code.*;
import hotel.gui.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginAsGuest extends JFrame{
    private JLabel jlname=new JLabel("Enter your username");
    private JLabel jlpass=new JLabel("Password");
    private JTextField jtname=new JTextField("Type your username");
    private JTextField jtpass=new JTextField("Type your password");
    private JButton jbsign=new JButton("LOGIN");
    private JButton jbgoback=new JButton("BACK");
    public LoginAsGuest(){
     setTitle("Login as guest");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
    
    Container cp=getContentPane();
    cp.setBackground(Color.pink);
    
    
    setLayout(new BorderLayout());
    setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\outdoor_furniture-wallpaper-960x600 (Custom).jpg")));
   
    
    jlname.setBounds(150, 100, 175, 50);
    jtname.setBounds(jlname.getX(), jlname.getY()+50, jlname.getWidth(), jlname.getHeight()-20);
    jlpass.setBounds(jlname.getX(), jtname.getY()+50, jlname.getWidth(), jlname.getHeight()); 
    jtpass.setBounds(jlname.getX(), jlpass.getY()+50, jtname.getWidth(), jtname.getHeight());
    
     jbsign.setBounds(300,400,175, 50);
     jbgoback.setBounds(10,400,175, 50);
     
    jlname.setForeground(Color.WHITE);
    jlpass.setForeground(Color.WHITE);
    
    jbsign.setBackground(Color.darkGray);
    jbsign.setForeground(Color.white);
    jbgoback.setBackground(Color.darkGray);
    jbgoback.setForeground(Color.white);
    
    
    this.add(jlname);
    this.add(jlpass);
    this.add(jtname);
    this.add(jtpass);
    this.add(jbsign);
    this.add(jbgoback);
    
    
    jbsign.addActionListener(handler);
    jtname.addMouseListener(mw);
    jtpass.addMouseListener(mw);
    jbgoback.addActionListener(handler);
   
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    
    
     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            String username=jtname.getText();
            String password=jtpass.getText();
            GuestMenu gm=new GuestMenu(username);
            HomeScreen home=new HomeScreen();
            Guest G1=new Guest();
            if(x.equals(jbsign)){
                if(G1.SignIn(username, password)==true){
                gm.setVisible(true);
                dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Wrong username or Password!");
            }
            else if(x.equals(jbgoback)){
                    home.setVisible(true);
                    dispose();
                    }
        }
    }
     private class mousewatch implements MouseListener
            {
        public void mouseClicked(MouseEvent e)
        {
            Object o =e.getSource();
            if( o.equals(jtname)){
            jtname.setText("");
            }
            else if(o.equals(jtpass)){
                jtpass.setText("");
            }
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){  }
        public void mouseDragged(MouseEvent e){  }
   
    }
}