import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class industrylogin  extends JFrame implements ActionListener
{
    
    
    JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel();
    JLabel l1=new JLabel("NAME:");   
    JLabel l2=new JLabel("PASSWORD:");
    JLabel l3=new JLabel("DON'T HAVE ACCOUNT?");
    JButton b1=new JButton("CLICK HERE");
    JButton b2=new JButton("Login");
    static JTextField t1=new JTextField(30);
    JTextField t2=new JTextField(30);
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/industrydetails";
    industrylogin()
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
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(b2,constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(l3,constraints);
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(b1,constraints);
        panel2.add(panel);
        panel2.add(panel1); 
        frame.setLayout( new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Industry Login"));
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            Industryregister a1=new Industryregister();
            frame.dispose();
        }
        else if(e.getSource()==b2)
        {
            
            Connection conn;
            try
            {
                conn= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                String query = "Select * from buyers where NAME=?";
                PreparedStatement pst = conn.prepareStatement(query);  
                pst.setString(1, t1.getText());
                ResultSet r=pst.executeQuery();
                if(r.next())
                {
                    String pass=r.getString("PASSWORD");
                    
                    if(pass.equals(t2.getText()))
                    {
                        JOptionPane.showMessageDialog(null,"SUCCESSFULL");
                        InterIndustry f1=new InterIndustry();
                        frame.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Password/username not found");
                }               
            }
            catch(Exception f)
            {
                System.out.print(f);
            }
        }
    }
    
    public static void main(String[] args)
    {
        industrylogin i1=new industrylogin();
        
    }
    
}
