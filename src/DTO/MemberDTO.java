package DTO;
import java.util.Date;
//CREATE TABLE 등록이용객 (
//        회원ID   VARCHAR2(20)    NOT NULL,
//        이름     VARCHAR2(50)    NOT NULL,
//        생년월일  DATE ,  -- '2024-05-28' <-- 이런식으로 삽입
//        연락처    VARCHAR2(15),
//        소속      VARCHAR2(50),
//        소속번호  VARCHAR2(20),
//        주소     VARCHAR2(100),
//        이용형태  VARCHAR2(20),
//        PRIMARY KEY(회원ID)
//);
public class MemberDTO {
    private String memberId;
    private String name;
    private Date birthDate;
    private String phone;
    private String affiliation;
    private String affiliationNumber;
    private String address;
    private String usageType;

    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAffiliation() {
        return affiliation;
    }
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    public String getAffiliationNumber() {
        return affiliationNumber;
    }
    public void setAffiliationNumber(String affiliationNumber) {
        this.affiliationNumber = affiliationNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getUsageType() {
        return usageType;
    }
    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }
}
