package hotelmanagementsystem;

/**
 *
 * @author User
 */
public class CustomerBillDetails {
    
    int id , phone ,roomnumber , price , days , totalamount ;
    String namee , maill , ckindate , ckoutdate , rtype , btype ;

    public CustomerBillDetails(int id, int phone, int roomnumber, int price, int days, int totalamount, String namee, String maill, String ckindate, String ckoutdate, String rtype, String btype) {
        this.id = id;
        this.phone = phone;
        this.roomnumber = roomnumber;
        this.price = price;
        this.days = days;
        this.totalamount = totalamount;
        this.namee = namee;
        this.maill = maill;
        this.ckindate = ckindate;
        this.ckoutdate = ckoutdate;
        this.rtype = rtype;
        this.btype = btype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getMaill() {
        return maill;
    }

    public void setMaill(String maill) {
        this.maill = maill;
    }

    public String getCkindate() {
        return ckindate;
    }

    public void setCkindate(String ckindate) {
        this.ckindate = ckindate;
    }

    public String getCkoutdate() {
        return ckoutdate;
    }

    public void setCkoutdate(String ckoutdate) {
        this.ckoutdate = ckoutdate;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

}
