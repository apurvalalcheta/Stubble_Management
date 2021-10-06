
import com.sun.jdi.connect.spi.Connection;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class farmerlogin extends JFrame implements ActionListener
{
    JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());   
    JLabel l1=new JLabel("Enter registered mobile number");
    JTextField t1=new JTextField(20);
    JButton b1=new JButton("login");
    JLabel l2=new JLabel("DON'T HAVE ACCOUNT?");
    JButton b2=new JButton("CLICK HERE");
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/farmer";
    farmerlogin()
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
        constraints.gridx = 1;
        constraints.gridy =1;
        panel.add(b1,constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(l2,constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(b2,constraints);
        frame.setLayout( new GridBagLayout() );
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Farmer Login Panel"));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
           java.sql.Connection conn;
            try
            {
                conn= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                String query = "Select * from register where TELEPHONE=?";
                PreparedStatement pst = conn.prepareStatement(query);  
                pst.setString(1, t1.getText());
                ResultSet r=pst.executeQuery();
                if(r.next())
                {
                    String pass=r.getString("TELEPHONE");
                    
                    if(pass.equals(t1.getText()))
                    {
                        JOptionPane.showMessageDialog(null,"SUCCESSFULL");
                        InterFarmer f1=new InterFarmer();
                        frame.dispose();
                    }
                    
                } 
                else
                        JOptionPane.showMessageDialog(null,"Password/username not found");
            }
            catch(Exception f)
            {
                System.out.print(f);
            }
        }
        else if(e.getSource()==b2)
        {
            farmerregister j=new farmerregister();
            frame.dispose();
        }
    }
    
    public static void main(String[] args)
    {
        farmerlogin a1=new farmerlogin();
    } 
}

