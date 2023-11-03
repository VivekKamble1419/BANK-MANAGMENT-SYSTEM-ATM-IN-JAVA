
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        
       setLayout(null);
        
        //Background Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1250, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1250,800);
        add(image);
        
        // Label on Image
        JLabel text = new JLabel("Balance Enquiry");
        text.setBounds(400,150,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,22));
        image.add(text);        
        
        JLabel text2 = new JLabel("C.V BANK, SANGLI");
        text2.setBounds(400,30,700,60);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System",Font.BOLD,45));
        image.add(text2);
        
        
        back = new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(new Font("System",Font.BOLD,16));
        back.setBounds(500,350,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c=new Conn();
        int balance = 0;
            try{
                ResultSet rs= c.s.executeQuery("SELECT * FROM bank WHERE pin= '"+pinnumber+"'");// java.sql.* package
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch (Exception e){
                        System.out.println(e);
                }
                       
        JLabel text3 = new JLabel("Your Current Account Balance is Rs:  " + balance);
        text3.setBounds(250,250,900,30);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("System",Font.BOLD,18));
        image.add(text3);
        
        
        //Frame
        setSize(1250,800);
        setLocation(50,0);
        setResizable(false);
        setUndecorated(true);// to remove all buttons like close on top of window
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");{
            
        }
    }
}
