package university.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//dont want to use the swings layout
        
        
        //when we want to write something on frame we use JLabel
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,20);//placing lblusername explicitly on frame
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        
        
        //PASSWORD
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);//placing lblusername explicitly on frame
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        
        
        //BUTTONS
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("tahoma",Font.BOLD,15));
        add(login);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        
        // image icon right side
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
        
        //how you place your components in frame have some layouts
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tfusername.getText(); // getText helps in extracting the values from the input field
            String password = tfpassword.getText();
            
            
            //DDL command
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            // 4. Executing MySQL Queries
            try{
                //create a connecction with mysql before hitting mysql with our query
                Conn c = new Conn(); //to create the connection we already have the class Conn
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    //next frame
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                // 5. Closing the Connection
//                c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    
    public static void main(String [] args){
        new Login();
    }
}
