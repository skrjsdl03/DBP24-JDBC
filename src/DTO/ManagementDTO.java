package DTO;
//CREATE TABLE 관리 (
//        주차장ID  VARCHAR2(20)   NOT NULL,
//        관리자ID  VARCHAR2(20)    NOT NULL,
//        점검일시  DATE            NOT NULL,
//        PRIMARY KEY(주차장ID, 관리자ID, 점검일시),
//        FOREIGN KEY(주차장ID)   REFERENCES   동의대주차장(주차장ID),
//        FOREIGN KEY(관리자ID)   REFERENCES   관리자(관리자ID)
//);

public class ManagementDTO {
    private String parkingSpaceId;
    private String adminId;
    private String inspectionTime;

    public String getParkingSpaceId() {
        return parkingSpaceId;
    }
    public void setParkingSpaceId(String parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getInspectionTime() {
        return inspectionTime;
    }
    public void setInspectionTime(String inspectionTime) {
        this.inspectionTime = inspectionTime;
    }
}
