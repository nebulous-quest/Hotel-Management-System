package hotelmanagementsystem;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Salman
 */
public class LoginController implements Initializable {

    @FXML
    private JFXPasswordField login_pass;
    @FXML
    private JFXTextField login_mail;
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
    }

    @FXML
    private void new_reg(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void login_btn(ActionEvent event) throws IOException {
        try {
            String Mail = login_mail.getText();
            String pass = login_pass.getText();
            select s = new select();
            String str = "select* from login where username='" + Mail + "' and password='" + pass + "'";
            ResultSet rs = s.st.executeQuery(str);
            if (rs.next()) {
                login_mail.setText("");
                login_pass.setText("");
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void forgot(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forgotPass.fxml"));
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
