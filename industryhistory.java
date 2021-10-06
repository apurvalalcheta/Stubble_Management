
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
public class industryhistory extends JFrame implements ActionListener {
    JFrame frame =new JFrame();
    JPanel panel=new JPanel(new GridBagLayout());
    JTextField tf1, tf2, tf3, tf4,tf5;
    JLabel l1=new JLabel("NAME:");   
    JLabel l2=new JLabel("PASSWORD:");
    JButton b2=new JButton("check");
    JButton b1=new JButton("Back to home page");
    
    static JTextField t1=new JTextField(30);
    JTextField t2=new JTextField(30);
    private static final String USERNAME = "root";
    private static final String PASSWORD ="";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/industrydetails";
    static JTable table;
    String[] columnNames = {"Name", "Requirement", "Date", "Quantity","Total"};
    industryhistory()
    {     
        GridBagConstraints constraints = new GridBagConstraints(); 
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);     
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField(); 
        tf5 = new JTextField();    
        
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
        constraints.gridx = 2;
        constraints.gridy = 4;
        panel.add(b1,constraints);
        frame.add(panel); 
        frame.setLayout( new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));     
        frame.pack();
        frame.setVisible(true);  
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b2.addActionListener(this); 
        b1.addActionListener(this); 
    }
    public void actionPerformed(ActionEvent e)
    {    
        if(e.getSource()==b2)
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
        if(e.getSource()==b1)
        {
            startingpage j=new startingpage();
            frame.dispose();
        }
        
    } 
     public void showData() {

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
        String Requirement = "";
        String Date = "";
        String Quantity = "";
        String total="";   
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f1.setLayout( new GridBagLayout());  
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Your order history")); 
        f1.pack();
        GridBagConstraints constraints1 = new GridBagConstraints(); 
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(10, 10, 10, 10); 
        constraints1.gridx = 0;
        constraints1.gridy = 0; 
        panel1.add(scroll); 
        f1.add(panel1);
        
        f1.setVisible(true); 
        Connection conne;
        try {
            conne= DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            String query = "Select * from orders where NAME=?";
            PreparedStatement ps = conne.prepareStatement(query);  
            ps.setString(1, t1.getText());
            ResultSet rs = ps.executeQuery();
            int i=0;
            while(rs.next())
            {
                    Name = rs.getString("NAME");
                    Requirement = rs.getString("Requirement");
                    Date = rs.getString("Date");
                    Quantity = rs.getString("Quantity");
                    total = rs.getString("total"); 
                    model.addRow(new Object[]{Name, Requirement, Date, Quantity,total});
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
        industryhistory i1=new industryhistory();
    }
    
}
