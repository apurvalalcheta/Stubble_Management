import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
public class detailpage extends JFrame implements ActionListener
{
    JFrame frame =new JFrame(); 
    JPanel panel2=new JPanel(new GridBagLayout());
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel=new JPanel(new GridBagLayout());
    JLabel l1=new JLabel("WELCOME TO SITE");
    JLabel l2=new JLabel("If you are a farmer then please click here");
    JLabel l3=new JLabel("If you are an Industrialist then please click here");
    JButton b1= new JButton("Farmer");
    JButton b2 = new JButton("Industrialist");  
    detailpage()
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 5, 10, 10);
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(20, 10, 10, 10);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);    
        constraints.gridx = 2;
        constraints.gridy = 0; 
        panel1.add(l1,constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel1.add(l2,constraints);
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel1.add(b1,constraints);
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel1.add(l3,constraints);
        constraints.gridy = 4;
        panel1.add(b2,constraints);            
        //panel2.add(panel1);
        //panel2.add(panel); 
        frame.setLayout( new GridBagLayout());
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Detail page"));      
        panel1.setPreferredSize(new Dimension(450, 450));      
        frame.add(panel1);      
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }  
    public static void main(String[] args)
    {
        detailpage j=new detailpage();
    }
public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1)
        {
                farmerlogin f1=new farmerlogin();
                frame.dispose();
        }
        else if(e.getSource()==b2)
        {            
                industrylogin i=new industrylogin();
                frame.dispose();  
                
       }
    } 
    
}
