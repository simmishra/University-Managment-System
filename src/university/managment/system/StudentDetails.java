package university.managment.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
        //to insert values in dropdown we have to fetch the data from the database
        try{
            Conn c = new Conn();//establish connection to database
            ResultSet rs = c.s.executeQuery("select * from student");//storing the result of query in resultset
            
            
            //while there are values in rs
            while(rs.next()){
                crollno.add(rs.getString("rollno"));//rolno column se sari values utha utha ke dropdown ke andar dalte jayega
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        //Creating a Table
        table = new JTable();
        
        
        //Inserting values in table
        try{
            Conn c = new Conn();//establish connection to database
            ResultSet rs = c.s.executeQuery("select * from student");//storing the result of query in resultset
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Scroll
        JScrollPane jsp = new JScrollPane(table);//creating a scroll and giving the component on which you want to place the scroll
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        
        
        //Buttons
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == add){
            setVisible(false);//Close the current frame
            new AddStudent();//open the addStudent page
        }else if(ae.getSource() == update){
            setVisible(false);//Close the current frame
            new UpdateStudent();//open the addStudent page
        }else{
            setVisible(false);
        }
    }
    
    
    public static void main(String [] args){
        new StudentDetails();
    }
}
