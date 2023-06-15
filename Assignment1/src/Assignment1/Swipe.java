package Assignment1;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Swipe {
    private int swipeid;
    private String phoneNo;
    private SwipeKind swipekind;
    public enum SwipeKind {
        IN,
        OUT
    }
    private LocalDateTime swipeTimestamp;

    public Swipe(){

    }
    public Swipe(int swipeid, String phoneNo, SwipeKind swipekind, LocalDateTime swipeTimestamp) {
        this.swipeid = swipeid;
        this.phoneNo = phoneNo;
        this.swipekind = swipekind;
        this.swipeTimestamp = swipeTimestamp;
    }

    public int getSwipeid() {
        return swipeid;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public SwipeKind isSwipekind() {
        return swipekind;
    }
    public LocalDateTime getSwipeTimestamp() {
        return swipeTimestamp;
    }

}
