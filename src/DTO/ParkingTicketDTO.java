package DTO;

public class ParkingTicketDTO {
    private String ticketId;      // 주차권ID
    private String carNumber; // 차량번호
    private String isUsed;        // 사용여부
    private int discountAmount;   // 할인금액
    private String adminId;       // 관리자ID

    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getIsUsed() {
        return isUsed;
    }
    public void setIsUsed(String isUsed) {
        this.isUsed = this.isUsed;
    }
    public int getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
