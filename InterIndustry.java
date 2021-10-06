import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class InterIndustry extends JFrame implements ActionListener
{
     JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel2=new JPanel();
    
    JLabel l1=new JLabel("WHERE DO YOU WANT TO GO?");
    JButton b1=new JButton("TO CHECK YOUR STUBBLE BUYING HISTORY");
    JButton b2=new JButton("TO BUY STUBBLE");
    InterIndustry()
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
        b1.addActionListener(this);
        panel.add(b1,constraints);  
        constraints.gridx=1;
        constraints.gridy=5;
        b2.addActionListener(this);       
        panel.add(b2,constraints);
        panel2.add(panel);
        panel2.add(panel1); 
        frame.setLayout( new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Industry"));
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public static void main(String[] args)
    {
        InterIndustry f1=new InterIndustry();
    }

    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource()==b1)
            {
                industryhistory i1=new industryhistory();
                frame.dispose();
            }
            else if(e.getSource()==b2)
            {
                industryorder a1=new industryorder();
                frame.dispose();
            }  
    }
}
