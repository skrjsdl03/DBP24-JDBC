package DTO;
import java.util.Date;
//CREATE TABLE 주차 (
//        차량번호  VARCHAR2(20)   NOT NULL,
//        공간번호  VARCHAR2(20)   NOT NULL,
//        주차장ID  VARCHAR2(20)   NOT NULL,
//        입차일시  DATE           NOT NULL,
//        출차일시  DATE,
//        PRIMARY KEY(차량번호, 공간번호, 주차장ID, 입차일시),
//        FOREIGN KEY(차량번호) REFERENCES 차량(차량번호),
//        FOREIGN KEY(공간번호, 주차장ID) REFERENCES 주차공간(공간번호, 주차장ID)
//);
public class ParkingRecordDTO {
    private String carNumber;
    private String spaceNumber;
    private String parkingSpaceId;
    private Date entryTime;
    private Date exitTime;

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getSpaceNumber() {
        return spaceNumber;
    }
    public void setSpaceNumber(String spaceNumber) {
        this.spaceNumber = spaceNumber;
    }
    public String getParkingSpaceId() {
        return parkingSpaceId;
    }
    public void setParkingSpaceId(String parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public Date getExitTime() {
        return exitTime;
    }
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}
