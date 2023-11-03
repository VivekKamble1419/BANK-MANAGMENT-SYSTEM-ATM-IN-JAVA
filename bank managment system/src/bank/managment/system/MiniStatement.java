
package bank.managment.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statmet");
        
        setLayout(null);
        
        JLabel mini= new JLabel();
        mini.setBounds(20,140,300,500);
        add(mini);
        
        JLabel bank = new JLabel("C.V Bank,Sangli");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,70,200,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,600,350,20);
        add(balance);
        

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            int bal=0;
            while(rs.next()){
               // card.setText("CardNumber");
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX"+ rs.getString("cardnumber").substring(12));
                             
                    if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));   
                }            
            }
            balance.setText("Your Current Account balance is Rs: "+ bal);
    
         }
        catch (Exception e){
            System.out.println(e);
        }
        try{
            Conn c= new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from bank where pin= '"+pinnumber+"'" );
            
            while(rs1.next()){
                mini.setText(mini.getText()+ "<html>" + rs1.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("amount") + "<br><br><html>");
                
            }
        }catch(Exception e){
            System.out.print(e);
        }
       
        
        setSize(400,700);
        setLocation(20,20);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
