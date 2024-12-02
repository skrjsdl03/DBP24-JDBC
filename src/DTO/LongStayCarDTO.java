package DTO;

public class LongStayCarDTO {
    private String stayId;
    private String carNumber;
    private String parkingLotId;
    private String spaceId;
    private String entryTime;
    private String stayTime;
    private String alertSent;

    public String getStayId() {
        return stayId;
    }
    public void setStayId(String stayId) {
        this.stayId = stayId;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getParkingLotId() {
        return parkingLotId;
    }
    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    public String getSpaceId() {
        return spaceId;
    }
    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }
    public String getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }
    public String getStayTime() {
        return stayTime;
    }
    public void setStayTime(String stayTime) {
        this.stayTime = stayTime;
    }
    public String getAlertSent() {
        return alertSent;
    }
    public void setAlertSent(String alertSent) {
        this.alertSent = alertSent;
    }
}
