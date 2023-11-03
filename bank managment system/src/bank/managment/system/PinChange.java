
package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JTextField pin;
    JPasswordField repin;
    JButton change,back;
    
    String pinnumber;
   PinChange(String pinnumber){
       
       this.pinnumber=pinnumber;
       setLayout(null);
        
        //Background Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1250, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1250,800);
        add(image);
        
        
        JLabel text2 = new JLabel("C.V BANK, SANGLI");
        text2.setBounds(400,30,700,60);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System",Font.BOLD,45));
        image.add(text2);
        
        // Label on Image
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(400,150,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text); 
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(220,200,700,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext); 
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(400,200,250,25);
        image.add(pin);
        
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(220,250,700,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(400,250,250,25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setFont(new Font("System",Font.BOLD,16));
        change.setBounds(290,350,150,30);
        change.addActionListener(this);
        image.add(change);
         
        back = new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(new Font("System",Font.BOLD,16));
        back.setBounds(500,350,150,30);
        back.addActionListener(this);
        image.add(back);
        
        //Frame
        setSize(1250,800);
        setLocation(50,0);
        setResizable(false);
        setUndecorated(true);// to remove all buttons like close on top of window
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
            try{
                String npin= pin.getText();
                String rpin = repin.getText();
            
                 if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not matched");
                return;
            }
             if(npin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Enter New PIN");
             }
             if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
             }
             
             Conn conn = new Conn();
             String query1 = "update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
             String query2 = "update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
             String query3 = "update signupthree set pin='"+rpin+"' where PIN='"+pinnumber+"'";
             
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
             
             JOptionPane.showMessageDialog(null, "PIN Changed Sucessfully...");
             setVisible(false);
             new Transactions(rpin).setVisible(true);
             
            }catch(Exception e){
            System.out.println(e);
        }
    }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
                new PinChange("").setVisible(true);

    }
}
            
        
    
    

