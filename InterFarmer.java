import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class InterFarmer extends JFrame implements ActionListener
{
     JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel();
    
    JLabel l1=new JLabel("WHERE DO YOU WANT TO GO?");
    JButton b1=new JButton("TO CHECK YOUR STUBBLE SELLING HISTORY");
    JButton b2=new JButton("TO SELL THE STUBBLE");
    
    InterFarmer()
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(10, 10, 10, 10);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);      
        constraints.gridx=1;
        constraints.gridy=2;
        panel.add(l1,constraints);  
        constraints.gridx=1;
        constraints.gridy=3;  
        panel.add(b1,constraints);
        constraints.gridx=1;
        constraints.gridy=5;
        panel.add(b2,constraints);
        panel2.add(panel);
        panel2.add(panel1); 
        frame.setLayout( new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Farmer"));
        frame.add(panel2);
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public static void main(String[] args)
    {
        InterFarmer f1=new InterFarmer();
    }

    public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                farmerhistory i1=new farmerhistory();
                frame.dispose();
            }
            else if(e.getSource()==b2)
            {
                farmersell f1=new farmersell();
                frame.dispose();
                
            }     
 	}
}
