
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit,withdrowl,fastcash,ministatment,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){// creating constructore and getting pin number from login page using String 
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
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(350,150,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text); 
        
        //Buttons starts
         deposit = new JButton("Deposit");
         deposit.setFont(new Font("System",Font.BOLD,14));
         deposit.setBounds(230,200,200,35);
         deposit.addActionListener(this);
         image.add(deposit);
       
         withdrowl = new JButton("Cash Withdrowl");
         withdrowl.setFont(new Font("System",Font.BOLD,14));
         withdrowl.setBounds(500,200,200,35);
         withdrowl.addActionListener(this);
         image.add(withdrowl);
         
         fastcash = new JButton("Fast Cash");
         fastcash.setFont(new Font("System",Font.BOLD,14));
         fastcash.setBounds(230,250,200,35);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministatment = new JButton("Mini Statment");
         ministatment.setFont(new Font("System",Font.BOLD,14));
         ministatment.setBounds(500,250,200,35);
         ministatment.addActionListener(this);
         image.add(ministatment);
        
         pinchange = new JButton("Pin Change");
         pinchange.setFont(new Font("System",Font.BOLD,14));
         pinchange.setBounds(230,300,200,35);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balanceenquiry = new JButton("Balance Enquiry");
         balanceenquiry.setFont(new Font("System",Font.BOLD,14));
         balanceenquiry.setBounds(500,300,200,35);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         exit = new JButton("Exit");
         exit.setForeground(Color.red);
         exit.setFont(new Font("System",Font.BOLD,15));
         exit.setBounds(350,350,200,35);
         exit.addActionListener(this);
         image.add(exit);
         
        //Frame
        setSize(1250,800);
        setLocation(50,0);
        setResizable(false);
        setUndecorated(true);// to remove all buttons like close on top of window
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()== withdrowl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()== fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()== ministatment){
            new MiniStatement(pinnumber).setVisible(true);
        }
            
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
