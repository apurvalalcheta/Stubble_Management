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
public class industryorder extends JFrame implements ActionListener
{
    JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel();
    JLabel l1=new JLabel("NAME:");   
    JLabel l2=new JLabel("REQUIRED ITEM:");
    JLabel l3=new JLabel("REQUIRED ON WHICH DATE?");
    JLabel l4=new JLabel("QUANTITY WANTED IN kg:");
    JLabel l5=new JLabel("TOTAL AMOUNT in Rs:");
    JLabel l6=new JLabel("PLACE ORDER:");
    JLabel l8=new JLabel("The price of 1 kg stubble is 150");
    JLabel l9=new JLabel();  
    JTextField t1=new JTextField(30);
    JTextField t2=new JTextField(5);
    JTextField t3=new JTextField(8);
    JTextField t4=new JTextField(5);
    JLabel l7=new JLabel();
    JCheckBox c1=new JCheckBox("WHEAT");
    JCheckBox c2=new JCheckBox("RICE");
    JButton b1=new JButton("YES");
    JButton b2=new JButton("NO");
    JButton b3=new JButton("Check total price");
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/industrydetails";
    industryorder()
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
        panel.add(l8,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1; 
        panel.add(l1,constraints);
        constraints.gridx = 1;
        panel.add(t1,constraints); 
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(l2,constraints);
        constraints.gridx = 1;
        panel.add(c1,constraints);
        constraints.gridy = 3;
        panel.add(c2,constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(l3,constraints);
        constraints.gridx = 1;
        panel.add(t3,constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(l4,constraints);
        constraints.gridx = 1;
        panel.add(t4,constraints);       
        constraints.gridx=1;
        constraints.gridy=6;
        panel.add(b3,constraints);       
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(l5,constraints);     
        constraints.gridx = 1;
        constraints.gridy = 7;
        panel.add(l9,constraints);
        b3.addActionListener(new ActionListener()
        {
            float a;
	public void actionPerformed(ActionEvent e)
                {
                   float n1 = Float.parseFloat(t4.getText());   
                   a=150*n1;
                   l9.setText(" "+a);
	}
        });
        
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel1.add(l6,constraints);
        constraints.gridx = 1;
        panel1.add(b1,constraints);
        constraints.gridx = 2;
        panel1.add(b2,constraints);
        panel2.add(panel);
        panel2.add(panel1); 
        b2.addActionListener(this); 
        b1.addActionListener(this);
        frame.setLayout( new GridBagLayout() );
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Order Panel"));
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        c1.addActionListener(this);
        c2.addActionListener(this);
    }
    public static void main(String[] args)
    {
        industryorder a1=new industryorder();
    }    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b2)
        {
            InterIndustry f1=new InterIndustry();
            frame.dispose();
        }
        else if(e.getSource()==b1)
        {
             Connection conn;
            try        
            {
                conn= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                String insert = "INSERT INTO orders(NAME,Requirement,Date,Quantity,total) values (?,?,?,?,?)";               
                PreparedStatement pst = conn.prepareStatement(insert);
                pst.setString(1,t1.getText());
                if (c1.isSelected()==true)
                    pst.setString(2, c1.getText());
                else if(c2.isSelected()==true)
                    pst.setString(2, c2.getText());
                pst.setString(3, t3.getText());
                pst.setFloat(4, Float.parseFloat(t4.getText()));
                pst.setDouble(5,Double.parseDouble(l9.getText()));
                pst.executeUpdate(); 
                JOptionPane.showMessageDialog(null,"Order placed successfully");            
                System.out.print("Connected");
                startingpage j=new startingpage();
                frame.dispose();
            }
            catch(SQLException g)
            {
                  JOptionPane.showMessageDialog(null,"Please insert all values correctly");
                  
            } 
        }
        
    } 
}