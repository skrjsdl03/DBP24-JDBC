package controller;

import DTO.MemberDTO;
import service.MemberService;

public class MemberController {
    private final MemberService memberService;

    public MemberController() {
        this.memberService = new MemberService();
    }

    public String registerMember(MemberDTO member) {
        return memberService.registerMember(member);
    }
}
