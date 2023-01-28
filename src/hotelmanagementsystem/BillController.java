
package hotelmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amhas
 */
public class BillController implements Initializable {

   @FXML
    private TableView<CustomerBillDetails> BillTable;
    @FXML
    private TableColumn<CustomerBillDetails, String> customer_id;
    @FXML
    private TableColumn<CustomerBillDetails, String> customer_name;
    @FXML
    private TableColumn<CustomerBillDetails, String> customer_mobile;
    @FXML
    private TableColumn<CustomerBillDetails, String> customer_email;
    @FXML
    private TableColumn<CustomerBillDetails, String> checkindate;
    @FXML
    private TableColumn<CustomerBillDetails, String> checkoutdate;
    @FXML
    private TableColumn<CustomerBillDetails, String> cusroom;
    @FXML
    private TableColumn<CustomerBillDetails, String> cusrmtype;
    @FXML
    private TableColumn<CustomerBillDetails, String> cusbedtype;
    @FXML
    private TableColumn<CustomerBillDetails, String> rmprice;
    @FXML
    private TableColumn<CustomerBillDetails, String> cusstaydays;
    @FXML
    private TableColumn<CustomerBillDetails, String> bill_amount;
    ObservableList< CustomerBillDetails > oblist = FXCollections.observableArrayList();
    @FXML
    private ImageView exit;
    @FXML
    private ImageView miniMise;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exit.setCursor(Cursor.HAND);
        miniMise.setCursor(Cursor.HAND);
        
        select s1 = new select();
        ResultSet rs;
        
        try { 
            rs = s1.st.executeQuery("SELECT * FROM hmanagement.billinfo;");
            while(rs.next())
            {
                oblist.add(new CustomerBillDetails(rs.getInt("Customer_ID") , rs.getInt("Mobile_NO") , rs.getInt("Room_No") ,rs.getInt("Price_Per_Day") , rs.getInt("No_Of_Days_Stay") , rs.getInt("Total_Amount"), rs.getString("Name") , rs.getString("Email") ,  rs.getString("Check_In_Date") , rs.getString("Checkout_Date") , rs.getString("Room_Type") , rs.getString("Bed_Type"))) ;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
           //colNo.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
        customer_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        customer_name.setCellValueFactory(new PropertyValueFactory<>("namee"));
        customer_mobile.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customer_email.setCellValueFactory(new PropertyValueFactory<>("maill"));
       
        checkindate.setCellValueFactory(new PropertyValueFactory<>("ckindate"));
        checkoutdate.setCellValueFactory(new PropertyValueFactory<>("ckoutdate"));
        cusroom.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
        cusrmtype.setCellValueFactory(new PropertyValueFactory<>("rtype"));
        cusbedtype.setCellValueFactory(new PropertyValueFactory<>("btype"));
        rmprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cusstaydays.setCellValueFactory(new PropertyValueFactory<>("days"));
        bill_amount.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
      
        
        BillTable.setItems(oblist);
    }     

    @FXML
    private void back(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
     private void Exit(MouseEvent event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.close();
    }

    @FXML
    private void minimise(MouseEvent event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.setIconified(true);
    }
    
}
