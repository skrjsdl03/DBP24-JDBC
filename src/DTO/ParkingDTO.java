package DTO;

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
