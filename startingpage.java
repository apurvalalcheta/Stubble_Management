import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;

public class startingpage extends JFrame implements ActionListener
{
    JFrame frame =new JFrame();
  
    JPanel panel2=new JPanel();
    JPanel panel1=new JPanel(new GridBagLayout());
    JPanel panel=new JPanel(new GridBagLayout());
    JLabel l1=new JLabel("STUBBLE MANAGEMENT");
    JLabel l2=new JLabel("ADD TEXT");   
    JButton b1= new JButton("Go to Details Page");
      
    JTextArea a=new JTextArea("This website is to connect the farmers\n and Industrialist."
            + "Here farmers can\nsell the stubble and Industrialist\n can purchase the same and by this\n we have tried to reduce the stubble waste"
            + "\n and the pollution can be reudced.\n\n\tCONTACT US\n\n\tTeam members\n     Akshit Dhruv-akshit.dce18@sot.pdpu.ac.in\n"
            + "     Apurva Lalcheta-apurva.lce18@sot.pdpu.ac.in\n     Deep Gandhi-deep.gce18@sot.pdpu.ac.in");
 startingpage()
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 5, 10, 10);
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(20, 10, 10, 10);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel background;
        JLabel s;
        JLabel l;
        ImageIcon img =new ImageIcon("E:\\OOCP\\javaproject\\final1.jpeg");
        ImageIcon img1 =new ImageIcon("E:\\OOCP\\javaproject\\final2.jpeg");
        ImageIcon img2 =new ImageIcon("E:\\OOCP\\javaproject\\final3.jpeg");
        background=new JLabel("",img,JLabel.CENTER);
             l=new JLabel("",img1,JLabel.CENTER);
        s=new JLabel("",img2,JLabel.CENTER);

        l1.setFont(new Font("Serif",Font.BOLD,44));
        l1.setForeground(Color.BLUE);

        panel1.setPreferredSize(new Dimension(600, 48));
        panel.setPreferredSize(new Dimension(600, 550));
        panel2.setPreferredSize(new Dimension(1000, 1000));
        constraints.gridx=1;
        constraints.gridy=0;
        panel1.add(l1,constraints);

        constraints.gridx=0;
        constraints.gridy=0;
        panel.add(background,constraints);

        constraints.gridx=1;
        constraints.gridy=0;
        panel.add(l,constraints);

        constraints.gridx=2;
        constraints.gridy=0;
        panel.add(s,constraints);
        constraints.gridx=1;
        constraints.gridy=1;
        panel.add(b1,constraints);
        constraints.gridx=1;
        constraints.gridy=3;
        panel.add(a,constraints);
        panel.setBackground(Color.ORANGE);
        panel1.setBackground(Color.ORANGE);
        panel2.add(panel1);
        panel2.add(panel);

        b1.addActionListener(this);
        frame.setLayout( new GridBagLayout());
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
        frame.add(panel2);
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public static void main(String[] args)
    {
        startingpage j=new startingpage();
        
    }
public void actionPerformed(ActionEvent e)
    {
        detailpage j=new detailpage();
        frame.dispose();    
    } 
}