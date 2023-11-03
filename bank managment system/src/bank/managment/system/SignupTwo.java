
package bank.managment.system;
//JD basic connectivity


import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
// public class SignupOne extends JFrame ActionListener{

    
    
    JTextField panTextField,addharTextField;
    JButton next;
    JRadioButton nothaveanacc,haveanacc;
    JComboBox religion,catagory1,income1,education1,occupation1;
    String formno;
    
    SignupTwo(String formno){// getting values from first form
        
        this.formno = formno;
        
        setLayout(null);// remove bydefault layout
               
        setTitle("NEW ACCOUNT APPLICATION: PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religionname = new JLabel("Religion:");
        religionname.setFont(new Font("Raleway",Font.BOLD,18));
        religionname.setBounds(100,140,100,30);
        add(religionname);
        
        String valReligion[]= {"Select Religion","Hindu","Muslim","Sikh","Christin","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel catagory = new JLabel("Category:");
        catagory.setFont(new Font("Raleway",Font.BOLD,18));
        catagory.setBounds(100,190,200,30);
        add(catagory);
        
        String valcatagory[]= {"Select Catagory","General","SC","ST","NT-B/C","OBC","EWS","Other"};
        catagory1 = new JComboBox(valcatagory);
        catagory1.setBounds(300,190,400,30);
        catagory1.setBackground(Color.WHITE);
        add(catagory1);
        
       
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,18));
        income.setBounds(100,240,200,30);
        add(income);
        
        String incomecategory[]= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income1 = new JComboBox(incomecategory);
        income1.setBounds(300,240,400,30);
        income1.setBackground(Color.WHITE);
        add(income1);
        
      
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,18));
        education.setBounds(100,290,200,30);
        add(education);
                
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,18));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String educationalValues[]= {"Select Education","Non-Graduation","Graduation","Post-Graduation","Doctorate","Others"};
        education1 = new JComboBox(educationalValues);
        education1.setBounds(300,315,400,30);
        education1.setBackground(Color.WHITE);
        add(education1);
        
             
        JLabel Marital = new JLabel("Occupation:");
        Marital.setFont(new Font("Raleway",Font.BOLD,18));
        Marital.setBounds(100,390,200,30);
        add(Marital);
        
        String occupationValues[]= {"Select Occupation","Salaried","Self-Employed","Bussiness","Student","Others"};
        occupation1 = new JComboBox(occupationValues);
        occupation1.setBounds(300,390,400,30);
        occupation1.setBackground(Color.WHITE);
        add(occupation1);

                
        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway",Font.BOLD,18));
        panno.setBounds(100,440,200,30);
        add(panno);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel addharno = new JLabel("Addhar Number:");
        addharno.setFont(new Font("Raleway",Font.BOLD,18));
        addharno.setBounds(100,490,200,30);
        add(addharno);
        
        addharTextField = new JTextField();
        addharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addharTextField.setBounds(300,490,400,30);
        add(addharTextField);
        
        JLabel exacc = new JLabel("Existing Account:");
        exacc.setFont(new Font("Raleway",Font.BOLD,18));
        exacc.setBounds(100,540,200,30);
        add(exacc);
        
        haveanacc = new JRadioButton("Yes");
        haveanacc.setBounds(300,540,100,30);
        haveanacc.setBackground(Color.WHITE);
        add(haveanacc);
        
        nothaveanacc = new JRadioButton("No");
        nothaveanacc.setBounds(400,540,100,30);
        nothaveanacc.setBackground(Color.WHITE);
        add(nothaveanacc);
        
        ButtonGroup haveanaccount = new ButtonGroup(); // grouping marital for only one selected
        haveanaccount.add(haveanacc);
        haveanaccount.add(nothaveanacc);
       
        
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Ralway", Font.BOLD,14));
        next.setBounds(620, 640, 80, 30);
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
        String sreligion = (String)religion.getSelectedItem();
        String scatagory1 = (String)catagory1.getSelectedItem();
        String sincome1 = (String) income1.getSelectedItem();
        String seducation1 = (String) education1.getSelectedItem();
        String soccupation1 = (String) occupation1.getSelectedItem();
        String span = panTextField.getText();
        String sadd = addharTextField.getText();
        String exacc = null;// you have existing account or not
        if(haveanacc.isSelected()){
             exacc ="Have an Account";
        }else if(nothaveanacc.isSelected()){
             exacc ="Not Have an Account";
        }
        try{
              Conn c = new Conn();
              String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+sreligion+"','"+scatagory1+"','"+sincome1+"','"+seducation1+"','"+soccupation1+"','"+span+"','"+sadd+"','"+exacc+"')";
              c.s.executeUpdate(query);
            //Signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);// senf values to next form

         }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}
