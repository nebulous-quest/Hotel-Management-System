package hotelmanagementsystem;

import java.sql.*;
import javax.swing.JOptionPane;


public class select {
        Connection c=null;
        Statement st=null;
        ResultSet rs=null;
    public select() {
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hmanagement","root","Sajid148");
            st=c.createStatement();
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
    }
}
