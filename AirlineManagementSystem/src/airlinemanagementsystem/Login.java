package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton close, login, signup;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/FrontPage.jpg"));
        JLabel image = new JLabel(img);
        image.setBounds(0,0,400,250);
        add(image);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,35,100,20);
        image.add(lblusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50,75,100,20);
        image.add(lblpassword);
        
        tfusername = new JTextField();
        tfusername.setBounds(130,35,200, 20);
        add(tfusername);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,75,200, 20);
        add(tfpassword);
        
        signup = new JButton("Sign Up");
        signup.setBounds(75, 115, 100, 20);
        signup.addActionListener(this);
        image.add(signup);
        
        login = new JButton("Login");
        login.setBounds(195, 115, 100, 20);
        login.addActionListener(this);
        image.add(login);
        
        close = new JButton("Close");
        close.setBounds(135, 155, 100, 20);
        close.addActionListener(this);
        image.add(close);
        
        setTitle("Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String username = tfusername.getText();
            String password = new String(tfpassword.getPassword());
            
            try {
               Conn c = new Conn();
               String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
               ResultSet rs = c.s.executeQuery(query);
               
               if(rs.next()) {
                   new Home();
                   setVisible(false);
               } else {
                   JOptionPane.showMessageDialog(null, "Invalid username or password!");
                   setVisible(false);
               }
        } catch(Exception e) {
            e.printStackTrace();
        } 
        }else if(ae.getSource() == close) {
            setVisible(false);
        }else if(ae.getSource() == signup) {
            new SignUp();
            setVisible(false);
        }
    
//    tfusername.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent fe) {
//                if (fe.getKeyCode() == KeyEvent.VK_ENTER) {
//                    tfpassword.requestFocus();  // Move focus to password field
//                }
//            }
//        });
//        
//    tfpassword.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent ze) {
//                if(ze.getKeyCode() == KeyEvent.VK_ENTER) {
//                    submit.doClick();  // Simulate button click
//                }
//            }
//        });
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
