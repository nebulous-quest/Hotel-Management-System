package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author amhas
 */
public class ManageRoomController implements Initializable {

    @FXML
    private JFXButton adroom;
    @FXML
    private JFXButton showRoom;
    @FXML
    private Pane adpane;
    @FXML
    private JFXComboBox<String> bedType;
    @FXML
    private JFXComboBox<String> roomType;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField roomNo;
    @FXML
    private JFXComboBox<String> roomStatus;
    @FXML
    private TableView<roomDetails> roomTable;
    @FXML
    private TableColumn<roomDetails, String> colNo;
    @FXML
    private TableColumn<roomDetails, String> colBed;
    @FXML
    private TableColumn<roomDetails, String> colroom;
    @FXML
    private TableColumn<roomDetails, String> colPrice;
    @FXML
    private TableColumn<roomDetails, String> colSta;
    @FXML
    private Pane showpane;

    /**
     * Initializes the controller class.
     */
    ObservableList< roomDetails> oblist = FXCollections.observableArrayList();
    @FXML
    private ImageView exit;
    @FXML
    private ImageView miniMise;
    @FXML
    private ImageView bedpic;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exit.setCursor(Cursor.HAND);
        miniMise.setCursor(Cursor.HAND);

        
        select s1 = new select();
        ResultSet rs;
        bedType.setItems(FXCollections.observableArrayList("Single", "Double"));
        roomType.setItems(FXCollections.observableArrayList("AC", "Non AC"));
        roomStatus.setItems(FXCollections.observableArrayList("Available", "Booked"));
        try {
            rs = s1.st.executeQuery("select * from roomdetails;");
            while (rs.next()) {
                oblist.add(new roomDetails(rs.getInt("Room_No"), rs.getInt("Price"), rs.getString("Bed_Type"), rs.getString("Room_Type"), rs.getString("Room_Status")));
            }

            colNo.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
            colBed.setCellValueFactory(new PropertyValueFactory<>("BedType"));
            colroom.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            colSta.setCellValueFactory(new PropertyValueFactory<>("RoomStat"));

            roomTable.setItems(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(roomDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Addroom(ActionEvent event) {
        adroom.setVisible(false);
        showRoom.setVisible(false);
        adpane.setVisible(true);
        showpane.setVisible(false);
        bedpic.setVisible(true);
    }

    @FXML
    private void showAllRoom(ActionEvent event) {
        adroom.setVisible(false);
        showRoom.setVisible(false);
        showpane.setVisible(true);
        adpane.setVisible(false);
        bedpic.setVisible(true);
    }

    @FXML
    private void submit(ActionEvent event) {
        try {
            String roomid = roomNo.getText();
            String roomt = roomType.getValue();
            String bedt = bedType.getValue();
            String Price = price.getText();
            String roomst = roomStatus.getValue();

            select s = new select();
            String str = "insert into roomdetails values('" + roomid + "','" + bedt + "','" + roomt + "','" + Price + "','" + roomst + "')";
            s.st.executeUpdate(str);

            roomNo.clear();
            roomType.setValue("");
            bedType.setValue("");
            roomStatus.setValue("");
            price.clear();
            JOptionPane.showMessageDialog(null, "Room Added Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManageRoom.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        adroom.setVisible(true);
        showRoom.setVisible(true);
        adpane.setVisible(false);
        bedpic.setVisible(false);
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
    private void room_exit(MouseEvent event) {
        adroom.setVisible(true);
        showRoom.setVisible(true);
        adpane.setVisible(false);
        showpane.setVisible(false);
        bedpic.setVisible(false);
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
