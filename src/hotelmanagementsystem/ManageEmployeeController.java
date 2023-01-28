package hotelmanagementsystem;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class ManageEmployeeController implements Initializable {

    @FXML
    private JFXButton ademployee;
    @FXML
    private JFXButton showEmployee;
    @FXML
    private TextField fullName;
    @FXML
    private TextField age;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private ComboBox<String> jobType;
    @FXML
    private TextField nidNo;
    @FXML
    private TextField mail;
    @FXML
    private TextField salary;
    @FXML
    private Pane adEmployepane;
    @FXML
    private TextField eId;
    @FXML
    private ImageView Exit;
    @FXML
    private ImageView miniMise;
    @FXML
    private Pane tablepane;
    @FXML
    private TableView<employeeDetails> employeeTable;
    @FXML
    private TableColumn<employeeDetails, String> col_id;
    @FXML
    private TableColumn<employeeDetails, String> col_fullname;
    @FXML
    private TableColumn<employeeDetails, String> col_age;
    @FXML
    private TableColumn<employeeDetails, String> col_gender;
    @FXML
    private TableColumn<employeeDetails, String> col_jobtype;
    @FXML
    private TableColumn<employeeDetails, String> col_salary;
    @FXML
    private TableColumn<employeeDetails, String> col_NID;
    @FXML
    private TableColumn<employeeDetails, String> col_email;
    @FXML
    private Pane titlepane;

    ObservableList< employeeDetails> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Exit.setCursor(Cursor.HAND);
        miniMise.setCursor(Cursor.HAND);
        gender.setItems(FXCollections.observableArrayList("Male", "Female"));
        jobType.setItems(FXCollections.observableArrayList("Manager", "Front Desk Clerks", "Housekeeping", "Room Service", "Kitchen Staff", "Security Guard"));
        select s1 = new select();
        ResultSet rs;
        try {
            rs = s1.st.executeQuery("SELECT * FROM hmanagement.employee;");
            while (rs.next()) {
                oblist.add(new employeeDetails(rs.getInt("ID"), rs.getInt("Age"), rs.getInt("Salary"), rs.getInt("NID"), rs.getString("Full Name"), rs.getString("Gender"), rs.getString("Job Type"), rs.getString("Email")));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //colNo.setCellValueFactory(new PropertyValueFactory<>("RoomID"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        col_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_jobtype.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_NID.setCellValueFactory(new PropertyValueFactory<>("nid"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employeeTable.setItems(oblist);
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
    private void AddEmployee(ActionEvent event) {
        ademployee.setVisible(false);
        showEmployee.setVisible(false);
        adEmployepane.setVisible(true);
        tablepane.setVisible(false);
        titlepane.setVisible(false);
    }

    @FXML
    private void showAllEmployee(ActionEvent event) {
        ademployee.setVisible(false);
        showEmployee.setVisible(false);
        adEmployepane.setVisible(false);
        tablepane.setVisible(true);
        titlepane.setVisible(true);
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManageEmployee.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ademployee.setVisible(true);
        showEmployee.setVisible(true);
        adEmployepane.setVisible(false);
    }

    @FXML
    private void submit(ActionEvent event) {
        try {
            String fname = fullName.getText();
            String aGe = age.getText();
            String genDer = gender.getValue();
            String jobtype = jobType.getValue();
            String nid = nidNo.getText();
            String email = mail.getText();
            String salaRy = salary.getText();
            String eid = eId.getText();

            select s = new select();
            String str = "insert into employee values('" + eid + "', '" + fname + "','" + aGe + "','" + genDer + "','" + jobtype + "','" + salaRy + "','" + nid + "','" + email + "')";
            s.st.executeUpdate(str);

            fullName.clear();
            age.clear();
            gender.setValue("");
            jobType.setValue("");
            nidNo.clear();
            mail.clear();
            salary.clear();
            eId.clear();
            JOptionPane.showMessageDialog(null, "Employee Appointed Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
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

    @FXML
    private void employee_exit(MouseEvent event) {
        ademployee.setVisible(true);
        showEmployee.setVisible(true);
        adEmployepane.setVisible(false);
        tablepane.setVisible(false);
        titlepane.setVisible(false);
    }

}
