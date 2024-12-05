package service;
//비즈니스 로직 처리 , 컨트롤러와 데이터 계층 사이 연결

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
