import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Industryregister extends JFrame implements ActionListener
{
    JFrame frame =new JFrame("Hello world");
    JPanel panel=new JPanel(new GridBagLayout());
    JLabel l1=new JLabel("NAME:");   
    JLabel l2=new JLabel("TELEPHONE NO:");
    JLabel l3=new JLabel("ADDRESS:");
    JLabel l4=new JLabel("CITY:");
    JLabel l5=new JLabel("STATE:");
    JLabel l6=new JLabel("PINCODE:");
    JLabel l7=new JLabel("Password");
    JTextField t1=new JTextField(30);
    JTextField t2=new JTextField(30);
    JTextField t3=new JTextField(30);
    JTextField t4=new JTextField(30);
    JTextField t5=new JTextField(30);
    JTextField t6=new JTextField(30);
    JTextField t7=new JTextField(30);
    JButton b1=new JButton("SUBMIT");
    JButton b2=new JButton("CLEAR");
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/industrydetails";  
    Industryregister()
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        constraints.gridx = 0;
        constraints.gridy = 0; 
        panel.add(l1,constraints);
        constraints.gridx = 1;
        panel.add(t1,constraints); 
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(l2,constraints);
        constraints.gridx = 1;
        panel.add(t2,constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(l3,constraints);
        constraints.gridx = 1;
        panel.add(t3,constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(l4,constraints);
        constraints.gridx = 1;
        panel.add(t4,constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(l5,constraints);
        constraints.gridx = 1;
        panel.add(t5,constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(l6,constraints);
        constraints.gridx = 1;
        panel.add(t6,constraints);
        constraints.gridx = 0;
        constraints.gridy =6;
        panel.add(l7,constraints);
        constraints.gridx = 1;
        panel.add(t7,constraints);
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(b1,constraints);
        constraints.gridx = 1;
        panel.add(b2,constraints);     
        b2.addActionListener(this);  
        b1.addActionListener(this);       
        frame.setLayout( new GridBagLayout() );
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Industry Registration Panel"));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b2)
        {
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);
        }
        else if (e.getSource()==b1)
        {
            Connection conn;
            try        
            {
                conn= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                String insert = "INSERT INTO buyers(NAME,TELEPHONE,ADDRESS,CITY,STATE,PINCODE,PASSWORD) values (?,?,?,?,?,?,?)";               
                PreparedStatement pst = conn.prepareStatement(insert);
                pst.setString(1,t1.getText());
                pst.setInt(2,Integer.parseInt(t2.getText()));
                pst.setString(3, t3.getText());
                pst.setString(4, t4.getText());
                pst.setString(5,t5.getText());
                pst.setInt(6,Integer.parseInt(t6.getText()));
                pst.setString(7,t7.getText());
                pst.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"Done");            
                System.out.print("Connected");   
                industrylogin i1=new industrylogin();
                frame.dispose();
            }
            catch(SQLException g)
            {
                  System.out.println(g);
                  
            } 
        } 
    } 
    public static void main(String[] args)
    {
        Industryregister a1=new Industryregister();
    }      
}