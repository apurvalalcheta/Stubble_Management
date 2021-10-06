import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class farmerregister extends JFrame implements ActionListener
{
    JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel(); 
    JLabel l1=new JLabel("NAME");   
    JLabel l2=new JLabel("PHONE NO.");
    JLabel l3=new JLabel("VILLAGE");
    JLabel l4=new JLabel("CITY");
    JLabel l5=new JLabel("STATE");
    JLabel l6=new JLabel("PINCODE");
    JLabel l7=new JLabel("SIZE OF FARM");
    JTextField t1=new JTextField(30);
    JTextField t2=new JTextField(15);
    JTextField t3=new JTextField(15);
    JTextField t4=new JTextField(15);
    JTextField t5=new JTextField(15);
    JTextField t6=new JTextField(15);
    JTextField t7=new JTextField(15);
    JButton b1=new JButton("Submit");
    JButton b2=new JButton("Clear");
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/farmer";
    
    farmerregister()
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(10, 10, 10, 10);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
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
        constraints.gridy = 6;
        panel.add(l7,constraints);      
         constraints.gridx = 1;
        panel.add(t7,constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel1.add(b1,constraints);
        constraints.gridx=2;
        panel1.add(b2,constraints);      
        b2.addActionListener(this); 
        panel2.add(panel);
        panel2.add(panel1); 
        frame.setLayout( new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Farmer registration"));
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public static void main(String[] args)
    {
        farmerregister j=new farmerregister();
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
        }
        else if (e.getSource()==b1)
        {
            Connection conn;
                try        
                {
                    conn= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                    String insert = "INSERT INTO register(NAME,TELEPHONE,VILLAGE,CITY,STATE,PINCODE,SIZEOFFARM) values (?,?,?,?,?,?,?)";               
                    PreparedStatement pst = conn.prepareStatement(insert);
                    pst.setString(1,t1.getText());
                    pst.setInt(2,Integer.parseInt(t2.getText()));
                    pst.setString(3, t3.getText());
                    pst.setString(4, t4.getText());
                    pst.setString(5,t5.getText());
                    pst.setInt(6,Integer.parseInt(t6.getText()));
                    pst.setInt(7,Integer.parseInt(t7.getText()));
                    pst.executeUpdate(); 
                    JOptionPane.showMessageDialog(null,"Done");            
                    System.out.print("Connected");
                    farmerlogin a1=new farmerlogin();
                    frame.dispose();
                }
                catch(SQLException g)
                {
                      JOptionPane.showMessageDialog(null,"Please enter all values correctly"); 

                } 	

    } 
}
}