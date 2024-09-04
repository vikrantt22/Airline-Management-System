package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    
    public Home() {
       
        setLayout(null);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/FrontPage1.jpg"));
        JLabel image1 = new JLabel(img1);
        image1.setBounds(0, 0, 1920, 1080);
        add(image1);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenu("Flight Details");
        details.add(flightDetails);
        
        JMenuItem customerDeatils = new JMenu("Customer Deatils");
        details.add(customerDeatils);
        
        JMenuItem bookFlight = new JMenu("Book Flight");
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenu("Journey Details");
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenu("Ticket Camcellation");
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenu("Boarding Pass");
        ticket.add(boardingPass);
        
        setTitle("Airline Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
