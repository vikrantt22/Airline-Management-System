package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener {
    
    JButton close, submit, login;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public SignUp() {
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
        
        login = new JButton("Login");
        login.setBounds(75, 115, 100, 20);
        login.addActionListener(this);
        image.add(login);
        
        submit = new JButton("Submit");
        submit.setBounds(195, 115, 100, 20);
        submit.addActionListener(this);
        image.add(submit);
        
        close = new JButton("Close");
        close.setBounds(135, 155, 100, 20);
        close.addActionListener(this);
        image.add(close);
        
        setTitle("Register");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String username = tfusername.getText().trim();
            String password = new String(tfpassword.getPassword()).trim();
            
            // Application-level validation
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username cannot be empty!");
                return;
            }
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty!");
                return;
            }
            
            try {
               Conn c = new Conn();
               String query = "insert into login values('"+username+"','"+password+"')";
               int result = c.s.executeUpdate(query);
               if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Sign Up successful!");
                    new Login();  // Redirect to login page after successful signup
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Sign Up failed. Please try again.");
                }
        } catch(Exception e) {
            e.printStackTrace();
        } 
        }else if(ae.getSource() == close) {
            setVisible(false);
        }else if(ae.getSource() == login) {
            new Login();
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
        new SignUp();
    }
}
