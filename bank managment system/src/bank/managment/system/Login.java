package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear; // globaly declare buttons
    JTextField cardTextField;
    JPasswordField PinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE(ATM)");// to give title for application
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo1.png"));// used to pic image from location by creating object
        Image i2 = i1.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label= new JLabel(i3); // creating label of i1
        label.setBounds(70, 10, 100, 100);// used for custome layout
        add(label);// calling i1
       
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osword",Font.BOLD,38));
        text.setBounds(200, 50, 400, 40);
        add(text);
        
        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Releway",Font.BOLD,28));
        cardno.setBounds(120, 150, 400, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Releway",Font.BOLD,28));
        pin.setBounds(120, 220, 400, 30);
        add(pin);
        
        PinTextField = new JPasswordField();
        PinTextField.setBounds(300, 220, 250, 30);
        PinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(PinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);// define button action
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);// define button action
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this); // define button action
        add(signup);
              
        //getContentPane().setBackground(Color.WHITE);// change background color
        setLayout(new BorderLayout());
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/Loginbackgroun.jpeg"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 500, 800);
        add(backgroundLabel);
        
        setSize(800,500);// set size of frame length and width
        setResizable(false);// fix size of frame which cant changed after click on maximize window button
        setVisible(true);//to visible frame
        setLocation(300,180);//used to set frame opening location on screen
    }
    
    public void actionPerformed(ActionEvent ae){ // what are actions defined under this
        if (ae.getSource()== clear){
            cardTextField.setText("");
            PinTextField.setText("");
            
        }else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = PinTextField.getText();//pin is not an text field it is password field
            String query = "select * from login where cardnumber='"+cardnumber+"'and pin ='"+pinnumber+"'";
            try{
                ResultSet rs= conn.s.executeQuery(query);// Resultset is under sql package
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);// tranfer pin number to Transaction
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()== signup){
            setVisible(false);// if click on signup login window is closed
            new SignupOne().setVisible(true);
            
            
        }

        
    }
    public static void main(String args[]){
         new Login();
    }
    
}
