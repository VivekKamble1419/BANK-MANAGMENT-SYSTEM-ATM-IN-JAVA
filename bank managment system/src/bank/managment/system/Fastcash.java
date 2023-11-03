
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener {
    
    JButton rupees1,rupees2,rupees3,rupees4,rupees5,rupees6,back;
    String pinnumber;
    Fastcash(String pinnumber){// creating constructore and getting pin number from login page using String 
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
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(350,150,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text); 
        
        //Buttons starts
         rupees1 = new JButton("Rs 100");
         rupees1.setFont(new Font("System",Font.BOLD,14));
         rupees1.setBounds(230,200,200,35);
         rupees1.addActionListener(this);
         image.add(rupees1);
       
         rupees2 = new JButton("Rs 500");
         rupees2.setFont(new Font("System",Font.BOLD,14));
         rupees2.setBounds(500,200,200,35);
         rupees2.addActionListener(this);
         image.add(rupees2);
         
         rupees3 = new JButton("Rs 1000");
         rupees3.setFont(new Font("System",Font.BOLD,14));
         rupees3.setBounds(230,250,200,35);
         rupees3.addActionListener(this);
         image.add(rupees3);
         
         rupees4 = new JButton("Rs 2000");
         rupees4.setFont(new Font("System",Font.BOLD,14));
         rupees4.setBounds(500,250,200,35);
         rupees4.addActionListener(this);
         image.add(rupees4);
        
         rupees5 = new JButton("Rs 5000");
         rupees5.setFont(new Font("System",Font.BOLD,14));
         rupees5.setBounds(230,300,200,35);
         rupees5.addActionListener(this);
         image.add(rupees5);
         
         rupees6 = new JButton("Rs 10000");
         rupees6.setFont(new Font("System",Font.BOLD,14));
         rupees6.setBounds(500,300,200,35);
         rupees6.addActionListener(this);
         image.add(rupees6);
         
         back = new JButton("Back");
         back.setForeground(Color.red);
         back.setFont(new Font("System",Font.BOLD,15));
         back.setBounds(350,350,200,35);
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
        if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount= ((JButton)ae.getSource()).getText().substring(3);// get values from button by ignoring first three charactors
            Conn c=new Conn();
            try{
                ResultSet rs= c.s.executeQuery("SELECT * FROM bank WHERE pin= '"+pinnumber+"'");// java.sql.* package
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficent Balance...!");
                    return;
                }
                
                Date date= new Date();//from java.util package
                String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')"; 
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs. "+ amount + " Debited Sucessfully..");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.print(e);
            }
        }
            
    }
    public static void main(String args[]){
        new Fastcash("");
    }
}
