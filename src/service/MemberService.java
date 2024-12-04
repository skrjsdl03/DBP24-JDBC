package service;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class MemberService {
    private final MemberDAO memberDAO;

    public MemberService() {
        this.memberDAO = new MemberDAO();
    }

    public String registerMember(MemberDTO member) {
        try {
            return memberDAO.registerMember(member);
        } catch (Exception e) {
            e.printStackTrace();
            return "회원 등록 중 오류가 발생했습니다.";
        }
    }
}
