package DTO;
//CREATE TABLE 동의대주차장 (
//        주차장ID VARCHAR2(20)   NOT NULL,
//        주차장위치 VARCHAR2(50)   NOT NULL,
//        최대주차가능수 NUMBER,
//        현재주차가능수 NUMBER,
//        PRIMARY KEY(주차장ID)
//);

public class ParkingDTO {
    private String spaceNumber;
    private String parkingSpaceId;
    private String availabilityMax;
    private String availabilityNow;

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
    public String getAvailabilityMax() {
        return availabilityMax;
    }
    public void setAvailabilityMax(String availabilityMax) {
        this.availabilityMax = availabilityMax;
    }
    public String getAvailabilityNow() {
        return availabilityNow;
    }
    public void setAvailabilityNow(String availabilityNow) {
        this.availabilityNow = availabilityNow;
    }
}
