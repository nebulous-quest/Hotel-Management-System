package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CheckInController implements Initializable {

    @FXML
    private TextField customerID;
    @FXML
    private TextField fullName;
    @FXML
    private TextField nid;
    @FXML
    private TextField mobileNo;
    @FXML
    private TextField nationality;
    @FXML
    private TextField email;
    @FXML
    private JFXComboBox<String> roomType;
    @FXML
    private JFXComboBox<String> roomSize;
    @FXML
    private JFXComboBox<String> roomAvailable;
    @FXML
    private JFXDatePicker datePick;
    @FXML
    private TextField adress;
    @FXML
    private JFXButton submit_btn;
    @FXML
    private TextField priceckin;
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

        roomType.setItems(FXCollections.observableArrayList("AC", "Non AC"));
        roomSize.setItems(FXCollections.observableArrayList("Single", "Double"));
        roomAvailable.setItems(FXCollections.observableArrayList());
        exit.setCursor(Cursor.HAND);
        miniMise.setCursor(Cursor.HAND);
    }

    @FXML
    private void Submit(ActionEvent event) {
        try {
            String cusid = customerID.getText();
            String fname = fullName.getText();
            String nidNo = nid.getText();
            String mblNo = mobileNo.getText();
            String nation = nationality.getText();
            String mil = email.getText();
            String adrs = adress.getText();
            LocalDate ddte = datePick.getValue();
            String rtyp = roomType.getValue();
            String bedtyp = roomSize.getValue();
            String availrm = roomAvailable.getValue();
            String Price = priceckin.getText();

            select s = new select();
            String str = "insert into hmanagement.checkin values( '" + cusid + "','" + fname + "' , '" + nidNo + "','" + mblNo + "','" + nation + "' , '" + mil + "' , '" + adrs + "', '" + ddte + "' , '" + rtyp + "', '" + bedtyp + "' , '" + availrm + "' , '" + Price + "')";
            s.st.executeUpdate(str);
            customerID.clear();
            fullName.clear();
            nid.clear();
            mobileNo.clear();
            nationality.clear();
            email.clear();
            roomType.setValue("");
            roomSize.setValue("");
            roomAvailable.setValue("");
            datePick.setValue(ddte);
            adress.clear();
            priceckin.clear();

            //Update query for any table 
            String str1 = "update hmanagement.roomdetails set Room_Status='Booked' where Room_no='" + availrm + "'";

            s.st.executeUpdate(str1);
            JOptionPane.showMessageDialog(null, "Booking Successfully");
            Parent root = FXMLLoader.load(getClass().getResource("CheckIn.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    private void checkBtn(ActionEvent event) throws SQLException {
        String rtyp = roomType.getValue();
        String bedtyp = roomSize.getValue();

        select s1 = new select();
        ResultSet rs;
        rs = s1.st.executeQuery("select* from roomdetails where Room_Type='" + rtyp + "' and Bed_Type='" + bedtyp + "' and Room_Status='Available'");
        while (rs.next()) {
            roomAvailable.getItems().addAll(FXCollections.observableArrayList(rs.getString("Room_No")));
        }
    }

    @FXML
    private void pricebtn(ActionEvent event) throws SQLException {
        String availrm = roomAvailable.getValue();
        select s2 = new select();
        ResultSet rs1;
        String str1 = "select* from hmanagement.roomdetails where Room_no='" + availrm + "'";
        rs1 = s2.st.executeQuery(str1);

        while (rs1.next()) {
            priceckin.setText(rs1.getString(4));
        }
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
