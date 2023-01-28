
package hotelmanagementsystem;

/**
 *
 * @author amhas
 */
public class roomDetails {
    int RoomID , Price;
    String BedType , RoomType , RoomStat ;

    public roomDetails(int RoomID, int Price, String BedType, String RoomType, String RoomStat) {
        this.RoomID = RoomID;
        this.Price = Price;
        this.BedType = BedType;
        this.RoomType = RoomType;
        this.RoomStat = RoomStat;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getBedType() {
        return BedType;
    }

    public void setBedType(String BedType) {
        this.BedType = BedType;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public String getRoomStat() {
        return RoomStat;
    }

    public void setRoomStat(String RoomStat) {
        this.RoomStat = RoomStat;
    }    
}
