
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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshit Dhruv
 */
public class farmerhistory extends JFrame implements ActionListener {
    String s ="";
    JFrame frame =new JFrame("Hello world");
    JPanel panel=new JPanel(new GridBagLayout());   
    JLabel l1=new JLabel("Enter registered mobile number");
    JTextField t1=new JTextField(20);
    JButton b1=new JButton("check");
    JButton b2=new JButton("Back to home page");
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/farmer";
    static JTable table;
    String[] columnNames = {"Name", "Item", "Quantity"};
    farmerhistory()
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
        constraints.gridy =1;
        panel.add(b1,constraints);
        constraints.gridx = 1;
        panel.add(b2,constraints);
        
        frame.setLayout( new GridBagLayout() );
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Farmer Registration Panel"));
        frame.add(panel);
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
            
            Connection conn;
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
                        s=r.getString("NAME");
                        JOptionPane.showMessageDialog(null,"SUCCESSFULL");
           
                        showData();
                      
                        
                       
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
        if(e.getSource()==b2)
        {
            startingpage j=new startingpage();
            frame.dispose();
        }
        
    } 
    public void showData() {
        JButton b2=new JButton("Back to home Page");
        JFrame f1 =new JFrame("Hello world");
        JPanel panel1=new JPanel(new GridBagLayout());
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String Name = "";
        String Item = "";  
        String Quantity = "";
          
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f1.setLayout( new GridBagLayout());  
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Your selling history")); 
        f1.pack();
        GridBagConstraints constraints1 = new GridBagConstraints(); 
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(10, 10, 10, 10); 
        constraints1.gridx = 0;
        constraints1.gridy = 0; 
        f1.add(scroll); 
        
        f1.add(panel1);
        
        f1.setVisible(true); 
        Connection conne;
        try {
            conne= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String query = "Select * from sell where NAME=?";
            PreparedStatement ps = conne.prepareStatement(query);  
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            int i=0;
            while(rs.next())
            {
                    Name = rs.getString("NAME");
                    Item = rs.getString("Item");
                    Quantity = rs.getString("Quantity"); 
                    model.addRow(new Object[]{Name, Item,Quantity});
                    i+=1;
            }
             if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                JOptionPane.showMessageDialog(null, "Record Found");

            } else {

                JOptionPane.showMessageDialog(null, "Records Found");

            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
     }
   
    public static void main(String[] args)
    {
        farmerhistory i1=new farmerhistory();
        
    }
    
}
