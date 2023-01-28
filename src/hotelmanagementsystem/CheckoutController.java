package hotelmanagementsystem;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author amhas
 */
public class CheckoutController implements Initializable {

    @FXML
    private TextField roomno;
    @FXML
    private TextField cusName;
    @FXML
    private TextField checkDate;
    @FXML
    private TextField cusmobile;
    @FXML
    private TextField priceperday;
    @FXML
    private TextField stayday;
    @FXML
    private TextField amount;
    @FXML
    private TextField outdate;
    @FXML
    private TextField eemail;
    @FXML
    private TextField RoomType;
    @FXML
    private TextField BedType;
    @FXML
    private TextField cusid;
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
        // TODO
    }

    @FXML
    private void checkOut(ActionEvent event) {
        try {
            String roomNo = roomno.getText();
            String cusNam = cusName.getText();
            String cusmobi = cusmobile.getText();
            String checkdate = checkDate.getText();
            String checkoutd = outdate.getText();
            String price = priceperday.getText();
            String noStay = stayday.getText();
            String amountv = amount.getText();
            String mail = eemail.getText();
            String cusId = cusid.getText();
            String rtype = RoomType.getText();
            String btype = BedType.getText();
            select s1 = new select();
            String str = "insert into hmanagement.billinfo values( '" + cusId + "','" + cusNam + "' , '" + cusmobi + "','" + mail + "','" + checkdate + "' , '" + checkoutd + "' , '" + roomNo + "', '" + rtype + "' , '" + btype + "', '" + price + "' , '" + noStay + "' , '" + amountv + "')";
            s1.st.executeUpdate(str);

            String str1 = "update hmanagement.roomdetails set Room_Status='Available' where Room_no='" + roomNo + "'";
            s1.st.executeUpdate(str1);

            String str2 = "update hmanagement.checkin set Booking_Room='000' where Booking_Room='" + roomNo + "'";
            s1.st.executeUpdate(str2);
            String path = "G:\\";
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                //PdfWriter.getInstance(doc, new FileOutputStream(path+""+cusid+".pdf)) ;
                PdfWriter.getInstance(doc, new FileOutputStream(path + "" + cusid.getText() + ".pdf"));
                doc.open();
                Paragraph paragraph1 = new Paragraph("                                          Burj Al DhaKa                                     ");
                doc.add(paragraph1);
                Paragraph paragraph2 = new Paragraph("*******************************");
                doc.add(paragraph2);
                Paragraph paragraph3 = new Paragraph("\tBill ID: " + cusid.getText() + "\nCustomer Details:\nName: " + cusName.getText() + "\nMobile Number: " + cusmobile.getText() + "\nEamil: " + eemail.getText() + "\n");
                doc.add(paragraph3);
                doc.add(paragraph2);
                Paragraph paragraph4 = new Paragraph("\tRoom Details: \nNumber: " + roomno.getText() + "\nRoom Type: " + RoomType.getText() + "\nBed: " + BedType.getText() + "\nPrice Per Day: " + priceperday.getText() + "\n");
                doc.add(paragraph4);
                doc.add(paragraph2);
                PdfPTable tb1 = new PdfPTable(4);
                tb1.addCell("Check In Date: " + checkDate.getText());
                tb1.addCell("Check Out Date: " + outdate.getText());
                tb1.addCell("No Of Day Stays: " + stayday.getText());
                tb1.addCell("Total Amount Paid: " + amount.getText());
                doc.add(tb1);
                doc.add(paragraph2);
                Paragraph paragraph5 = new Paragraph("Thank You . Please Visit Again");
                doc.add(paragraph5);

                   }
        catch (DocumentException | FileNotFoundException e)
        {
          JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
            JOptionPane.showMessageDialog(null, "Checkout Completed");
            int a = JOptionPane.showConfirmDialog(null,"Do you want to print Bill","Select", JOptionPane.YES_NO_OPTION);
            if(a==0)
            {
            try
            {
               if((new File("G:\\"+cusid.getText()+".pdf")).exists())
               {
                  Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler G:\\"+cusid.getText()+".pdf");
               }
               else
                    System.out.println("File not found");
            }
            catch(IOException e)
            {
                  JOptionPane.showMessageDialog(null, e);
            }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clear(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("checkout.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void roomSearch(ActionEvent event) throws ParseException {
        try {
            String romNo = roomno.getText();
            select s = new select();
            ResultSet rs = s.st.executeQuery("select* from checkin where Booking_Room='" + romNo + "'");
            if (rs.next()) {
                cusName.setText(rs.getString(2));
                checkDate.setText(rs.getString(8));
                cusmobile.setText(rs.getString(4));
                priceperday.setText(rs.getString(12));
                eemail.setText(rs.getString(6));
                RoomType.setText(rs.getString(9));
                BedType.setText(rs.getString(10));
                cusid.setText(rs.getString(1));

                SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar cal = Calendar.getInstance();
                outdate.setText(myFormat.format(cal.getTime()));
                String dateBeforeString = rs.getString(8);
                Date dateBefore = myFormat.parse(dateBeforeString);
                String dateAfterString = myFormat.format(cal.getTime());
                Date dateAfter = myFormat.parse(dateAfterString);

                long difference = dateAfter.getTime() - dateBefore.getTime();
                int noOfDayStay = (int) (difference / (1000 * 60 * 60 * 24));
                if (noOfDayStay == 0) {
                    noOfDayStay = 1;
                }
                System.out.println(noOfDayStay);
                stayday.setText(String.valueOf(noOfDayStay));
                float price = Float.parseFloat(priceperday.getText());
                amount.setText(String.valueOf(noOfDayStay * price));
            }
        } catch (Exception ex) {
            System.out.println(ex);
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
