package DTO;

//CREATE TABLE 관리자 (
//        관리자ID   VARCHAR2(20)    NOT NULL,
//        PW     VARCHAR2(20)    NOT NULL,
//        이름     VARCHAR2(50)    NOT NULL,
//        연락처    VARCHAR2(15),
//        주소     VARCHAR2(100),
//        PRIMARY KEY(관리자ID)
//);
public class AdminDTO {
    private String adminId;
    private String password;
    private String name;
    private String phone;
    private String address;

    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
