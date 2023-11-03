
package bank.managment.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {
   JTextField amount;
   JButton deposit,back;
   
    String pinnumber;
    Deposit(String pinnumber){
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
        
        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setBounds(230,150,700,60);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(230,210,450,25);
        image.add(amount);        
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System",Font.BOLD,15));
        deposit.setBounds(530,300,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        back = new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(new Font("System",Font.BOLD,15));
        back.setBounds(530,350,150,30);
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
        if(ae.getSource()== deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
             JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                
            }else{
                try{
                Conn conn = new Conn();
                String query= "INSERT INTO bank VALUES('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
               // String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS.  "+ number+ "  Depositted Successfully ");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
                
            }
            }
        }else if (ae.getSource()== back){
            setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
}
