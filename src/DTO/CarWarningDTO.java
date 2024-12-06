package DTO;

import java.util.Date;

//CREATE TABLE 차량경고 (
//        경고ID   VARCHAR2(20)  NOT NULL,
//        관리자ID  VARCHAR2(20)  NOT NULL,
//        차량번호  VARCHAR2(20)  NOT NULL,
//        경고일시  DATE DEFAULT CURRENT_TIMESTAMP ,
//        경고사유  VARCHAR2(255)  NOT NULL,
//        PRIMARY KEY(주차권ID),
//        FOREIGN KEY(차량번호) REFERENCES 차량(차량번호),
//        FOREIGN KEY(관리자ID) REFERENCES 관리자(관리자ID)
//);
public class CarWarningDTO {
    private String warningId;
    private String adminId;
    private String carNumber;
    private Date warningTimestamp;
    private String warningReason;

    public String getWarningId() {
        return warningId;
    }
    public void setWarningId(String warningId) {
        this.warningId = warningId;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public Date getWarningTimestamp() {
        return warningTimestamp;
    }
    public void setWarningTimestamp(Date warningTimestamp) {
        this.warningTimestamp = warningTimestamp;
    }
    public String getWarningReason() {
        return warningReason;
    }
    public void setWarningReason(String warningReason) {
        this.warningReason = warningReason;
    }
}

