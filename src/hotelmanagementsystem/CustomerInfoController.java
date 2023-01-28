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
public class CustomerInfoController implements Initializable {

    @FXML
    private TableView<customerInfo> customerinfoTable;
    @FXML
    private TableColumn<customerInfo , String> c_id;
    @FXML
    private TableColumn<customerInfo , String> c_name;
    @FXML
    private TableColumn<customerInfo , String> c_nid;
    @FXML
    private TableColumn<customerInfo , String> c_num;
    @FXML
    private TableColumn<customerInfo , String> c_nation;
    @FXML
    private TableColumn<customerInfo , String> c_mail;
    @FXML
    private TableColumn<customerInfo , String> c_adrs;
    @FXML
    private TableColumn<customerInfo , String> c_rmtype;
    @FXML
    private TableColumn<customerInfo , String> c_rmsize;
    @FXML
    private TableColumn<customerInfo , String> c_date;
    @FXML
    private TableColumn<customerInfo, String> c_rmnmbr;
    @FXML
    private TableColumn<customerInfo, String> c_prc;
    
    ObservableList< customerInfo > oblist = FXCollections.observableArrayList();
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
            rs = s1.st.executeQuery("SELECT * FROM hmanagement.checkin;");
            while(rs.next())
            {
                oblist.add(new customerInfo(rs.getInt("Customer_Id") , rs.getInt("NID") , rs.getInt("Mobile No") ,rs.getInt("Booking_Room") , rs.getInt("Price") , rs.getString("Full_Name"), rs.getString("Nationality") , rs.getString("Email") ,  rs.getString("Adress") , rs.getString("Bed_type") , rs.getString("Room_Type") , rs.getString("Date_Pick"))) ;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
           //colNo.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
        c_id.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        
        c_nid.setCellValueFactory(new PropertyValueFactory<>("customerNid"));
        c_num.setCellValueFactory(new PropertyValueFactory<>("customerMobileNo"));
        c_rmnmbr.setCellValueFactory(new PropertyValueFactory<>("customerRoomNumber"));
       
        c_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        c_mail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
         c_nation.setCellValueFactory(new PropertyValueFactory<>("customerNationality"));
        c_adrs.setCellValueFactory(new PropertyValueFactory<>("customerAdress"));
        c_rmtype.setCellValueFactory(new PropertyValueFactory<>("rmType"));
        c_rmsize.setCellValueFactory(new PropertyValueFactory<>("rmSize"));
        c_date.setCellValueFactory(new PropertyValueFactory<>("checkIndate"));
        c_prc.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));
      
        
        customerinfoTable.setItems(oblist);
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
    }

    @FXML
    private void minimise(MouseEvent event) {
    }
    
}
