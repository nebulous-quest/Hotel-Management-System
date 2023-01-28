
package hotelmanagementsystem;

import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author ashraf
 */
public class customerInfo {
    int customerId ,customerNid , customerMobileNo , customerRoomNumber , roomPrice ;
    String fullName , customerNationality , customerEmail , customerAdress , rmType , rmSize ,checkIndate ;

    public customerInfo(int customerId, int customerNid, int customerMobileNo, int customerRoomNumber, int roomPrice, String fullName, String customerNationality, String customerEmail, String customerAdress, String rmType, String rmSize, String checkIndate) {
        this.customerId = customerId;
        this.customerNid = customerNid;
        this.customerMobileNo = customerMobileNo;
        this.customerRoomNumber = customerRoomNumber;
        this.roomPrice = roomPrice;
        this.fullName = fullName;
        this.customerNationality = customerNationality;
        this.customerEmail = customerEmail;
        this.customerAdress = customerAdress;
        this.rmType = rmType;
        this.rmSize = rmSize;
        this.checkIndate = checkIndate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerNid() {
        return customerNid;
    }

    public void setCustomerNid(int customerNid) {
        this.customerNid = customerNid;
    }

    public int getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(int customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public int getCustomerRoomNumber() {
        return customerRoomNumber;
    }

    public void setCustomerRoomNumber(int customerRoomNumber) {
        this.customerRoomNumber = customerRoomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public String getRmType() {
        return rmType;
    }

    public void setRmType(String rmType) {
        this.rmType = rmType;
    }

    public String getRmSize() {
        return rmSize;
    }

    public void setRmSize(String rmSize) {
        this.rmSize = rmSize;
    }

    public String getCheckIndate() {
        return checkIndate;
    }

    public void setCheckIndate(String checkIndate) {
        this.checkIndate = checkIndate;
    }

}