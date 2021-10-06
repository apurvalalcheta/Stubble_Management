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
public class farmersell extends JFrame implements ActionListener
{
    JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel();
    JLabel l1=new JLabel("NAME:");   
    JLabel l2=new JLabel("WHAT DO YOU HAVE?");
    JLabel l3=new JLabel("HOW MUCH DO YOU HAVE?");
    JLabel l4=new JLabel("PUT THIS ON SELL?");
    JTextField t1=new JTextField(30);
    JTextField t2=new JTextField(5);
    JTextField t3=new JTextField(8);
    JCheckBox c1=new JCheckBox("WHEAT");
    JCheckBox c2=new JCheckBox("RICE");
    JButton b1=new JButton("YES");
    JButton b2=new JButton("NO");
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/farmer";  
    farmersell()
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
        panel.add(c1,constraints);
        constraints.gridy = 2;
        panel.add(c2,constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(l3,constraints);
        constraints.gridx = 1;
        panel.add(t3,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(l4,constraints);
        constraints.gridx = 1;
        
        constraints.gridx = 1;
        panel1.add(b1,constraints);
        
        constraints.gridx = 2;
        panel1.add(b2,constraints);
        panel2.add(panel);
        panel2.add(panel1); 
        b2.addActionListener(this);   
        frame.setLayout( new GridBagLayout() );
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Selling Panel"));
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        c1.addActionListener(this);
        c2.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            Connection conn;
            try        
            {
                conn= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                String insert = "INSERT INTO sell(Name,Item,Quantity) values (?,?,?)";               
                PreparedStatement pst = conn.prepareStatement(insert);
                pst.setString(1,t1.getText());
                if (c1.isSelected()==true)
                    pst.setString(2, c1.getText());
                else if(c2.isSelected()==true)
                    pst.setString(2, c2.getText());
                pst.setInt(3,Integer.parseInt(t3.getText()));
                pst.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"Done");            
                System.out.print("Connected");
                startingpage j=new startingpage();
                frame.dispose();
            }
            catch(SQLException g)
            {
                  System.out.println(g);
                  
            } 
        }
        if(e.getSource()==b2)
        {
            InterFarmer f1=new InterFarmer();
            frame.dispose();
        }
    }  
    public static void main(String[] args)
       {
           farmersell f1=new farmersell();
           
    }
    
}
