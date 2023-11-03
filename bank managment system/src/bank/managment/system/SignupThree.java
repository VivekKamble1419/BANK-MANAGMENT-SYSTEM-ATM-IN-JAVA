
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,declaration;
    JButton submit,cancle;
    String formno,facility,facility1,facility2,facility3,facility4,facility5,facility6;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page No 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,10,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,100,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,160,200,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,160,200,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,200,200,20);
        add(r3);
        
        r4 = new JRadioButton("Student Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,200,200,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,260,200,30);
        add(card);
        
        
        JLabel number = new JLabel("XXXX XXXX XXXX 0143");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,260,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,290,300,20);
        add(carddetail);
        
        JLabel cardpin = new JLabel("Card PIN:");
        cardpin.setFont(new Font("Raleway",Font.BOLD,22));
        cardpin.setBounds(100,330,300,30);
        add(cardpin);        
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,330,300,30);
        add(pinnumber);
        
        JLabel carddetail2 = new JLabel("Your 4 Digit Card PIN");
        carddetail2.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail2.setBounds(100,360,300,20);
        add(carddetail2);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,420,300,30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,450,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,450,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,200,30);
        add(c3);
        
        c4 = new JCheckBox("SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,490,200,30);
        add(c4);
        
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,530,200,30);
        add(c5);
        
        
        c6 = new JCheckBox("E-Statment");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,530,200,30);
        add(c6);
        
        declaration = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway",Font.BOLD,14));
        declaration.setBounds(50,600,700,30);
        add(declaration);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(260,670,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancle = new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway",Font.BOLD,14));
        cancle.setBounds(430,670,100,30);
        cancle.addActionListener(this);
        add(cancle);
        
                
        //getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        ImageIcon backgroundIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/formbaground1.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon1);
        backgroundLabel.setBounds(0, 0, 850, 800);
        add(backgroundLabel);
      
        //creating frame
        setSize(850,820);
        setLocation(250,0);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
           String accountType= null;
           if(r1.isSelected()){
               accountType= "Saving Account";
           }else if(r2.isSelected()){
               accountType="Fixed Deposit Account";
           }else if(r3.isSelected()){
               accountType="Current Account";
           }else if(r4.isSelected()){
               accountType="Student Account";
           }
            if (accountType == null) {
            JOptionPane.showMessageDialog(null, "Please select an account type.");
                return;
            }
            
            if(!declaration.isSelected()){
                JOptionPane.showMessageDialog(null, "Please check the declaration.");
                return;
            }
       //Randome Card number and Pin genrate
           Random random= new Random();
           String cardnumber = "" + Math.abs((random.nextLong()%90000000L)+ 1419000000000L);//card number starts from 142003
           String pinnumber =  "" + Math.abs((random.nextLong()%9000L)+10000L);
        
           facility="";
           if(c1.isSelected()){
               facility = facility  + "  ATM Card";
           }else
           if(c2.isSelected()){
               facility = facility + "  Internet Banking";
           }else
           if(c3.isSelected()){
               facility = facility + "  Mobile Banking";
           }else
           if (c4.isSelected()){
               facility = facility + "  SMS Alerts";
           }else 
           if(c5.isSelected()){
               facility = facility +  "  Cheque Book";
           }else 
           if(c6.isSelected()){
               facility6 = facility5 +"  E-Statments";
           }
         
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account type not selected");
               }else                      
                {
                    Conn c = new Conn();
                    String query = "INSERT INTO signupthree VALUES('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query1 = "INSERT INTO login VALUES('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Card Number:" + cardnumber + "\n Pin Number: " + pinnumber );
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
           }catch(Exception e){
               System.out.println(e);
           }
           
        }else if (ae.getSource() == cancle) {
        // Handle cancel button action
           setVisible(false);
           new Login().setVisible(true);
    }if(ae.getSource()== submit){
            setVisible(false);// if click on signup login window is closed
            new Login().setVisible(true);
        
        
    }}
    public static void main(String args[]){
        new SignupThree("");
    }
}
