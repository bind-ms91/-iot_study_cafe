package bind.iotstudycafe.member.controller;

import bind.iotstudycafe.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    @GetMapping("/sign-up")
    public String findByMemberId() {

        return "members/signUpMemberForm";
    }

}
