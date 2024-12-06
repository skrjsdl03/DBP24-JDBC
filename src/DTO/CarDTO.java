package DTO;
//CREATE TABLE 차량 (
//        차량번호 VARCHAR2(20)    NOT NULL,
//        회원ID    VARCHAR2(20),   -- NULL이면 외부 차량
//        차종       VARCHAR2(50),
//        경고누적수 NUMBER,
//        불이익단계 NUMBER,
//        PRIMARY KEY(차량번호),
//        FOREIGN KEY(회원ID) REFERENCES 등록이용객(회원ID)
//);
public class CarDTO {
    private String carNumber;
    private String memberId;
    private String carType;
    private int warningCount;
    private int penaltyLevel;

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public int getWarningCount() {
        return warningCount;
    }
    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }
    public int getPenaltyLevel() {
        return penaltyLevel;
    }
    public void setPenaltyLevel(int penaltyLevel) {
        this.penaltyLevel = penaltyLevel;
    }
}
