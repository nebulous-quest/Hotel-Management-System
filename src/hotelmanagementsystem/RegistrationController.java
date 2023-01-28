package hotelmanagementsystem;


import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class RegistrationController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField mobile;
    @FXML
    private TextField email;
    @FXML
    private TextField uname;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView miniMise;
    @FXML
    private PasswordField upassword;
    @FXML
    private TextField otpDisable;
    @FXML
    private TextField otpid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exit.setCursor(Cursor.HAND);
        miniMise.setCursor(Cursor.HAND);
    }

    @FXML
    private void signupbtn(ActionEvent event) {
       if (otpDisable.getText().equals(otpid.getText())) {
            try {
                String nam = name.getText();
                String mob = mobile.getText();
                String mail = email.getText();
                String unam = uname.getText();
                String pass = upassword.getText();

                select s = new select();
                String str = "insert into login values('" + nam + "','" + mob + "','" + mail + "','" + unam + "','" + pass + "')";
                s.st.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Successfully Registered");
                name.clear();
                mobile.clear();
                email.clear();
                uname.clear();
                upassword.clear();
                otpid.clear();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Registration Failed");
        }
    }

    @FXML
    private void signin_btn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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
    
    public void Random() {
        Random rd = new Random();
        otpDisable.setText("" + rd.nextInt(100000 + 1));
    }

    public void sendotp() throws MessagingException, javax.mail.MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.user", "burjaldhaka@gmail.com");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.debug", true);
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", false);

        try {
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setText("To verify your email address, please use the following One Time Password (OTP): " + otpDisable.getText());
            message.setSubject("Verify your new Burj Al Dhaka account");
            message.setFrom(new InternetAddress("burjaldhaka@gmail.com"));
            message.addRecipient(RecipientType.TO, new InternetAddress(email.getText().trim()));
            message.saveChanges();
            try {
                Transport transport = session.getTransport("smtps");
                transport.connect("smtp.gmail.com", "burjaldhaka@gmail.com", "burjal@22");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                JOptionPane.showMessageDialog(null, "OTP has send to your Email id");
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Please check your internet connection");
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    private void OTP(ActionEvent event) {
        try {
            Random();
            sendotp();
        } catch (MessagingException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
