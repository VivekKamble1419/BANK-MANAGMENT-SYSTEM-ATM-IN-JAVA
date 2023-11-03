
package bank.managment.system;
//JD basic connectivity


import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;// import calender from libraries which is stored from external sources
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
// public class SignupOne extends JFrame ActionListener{

    
    
    long random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);// remove bydefault layout
        
        
        Random ran = new Random();// used for random number printing
        
        random = Math.abs(ran.nextLong() % 9000L);//for printing random number
        
        JLabel formno = new JLabel("APPLICATION FORM NO.: " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name = new JLabel("Full Name:");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,18));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Fathers Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser(); // creating object of datechooser
        dateChooser.setBounds(300, 240, 200, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup(); // grouping gender for only one selected
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel Marital = new JLabel("Marital Status:");
        Marital.setFont(new Font("Raleway",Font.BOLD,18));
        Marital.setBounds(100,390,200,30);
        add(Marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup(); // grouping marital for only one selected
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Raleway",Font.BOLD,18));
        Address.setBounds(100,440,200,30);
        add(Address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway",Font.BOLD,18));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Ralway", Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        //getContentPane().setBackground(Color.WHITE);
         setLayout(new BorderLayout());
        ImageIcon backgroundIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/formbaground1.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon1);
        backgroundLabel.setBounds(0, 0, 850, 800);
        add(backgroundLabel);
      
        
        setSize(850,800);
        setResizable(false);// fix size of frame which cant changed after click on maximize window button
        setLocation(250,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; // long convert
        String name = nameTextField.getText();//get value from text field
        String fname = fnameTextField.getText();//get value from text field
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String Marital = null;
        if(married.isSelected()){
            Marital ="Married";
        }else if(unmarried.isSelected()){
            Marital ="Unmarried";
        }else if(other.isSelected()){
            Marital="Other";
        }
        
        String Address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinTextField.getText();
        
        try{
            // add validation for form
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required...!");// use validator
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father Name is required...!");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is required...!");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "E-mail is required...!");
            }else if(Address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required...!");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "city is required in Address...!");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required in Address...!");
            }else if(pinCode.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code is required in Address...!");
            }else{
              Conn c = new Conn();
              String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+Marital+"','"+Address+"','"+city+"','"+state+"','"+pinCode+"')";
              c.s.executeUpdate(query);
              setVisible(false);// hidind and jump on next form
              new SignupTwo(formno).setVisible(true);// senf values to next form
            }
         }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
    }
    public static void main(String args[]){
        new SignupOne();
    }
}
