package bind.iotstudycafe.member.controller;

import bind.iotstudycafe.commons.login.domain.LoginDTO;
import bind.iotstudycafe.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    @GetMapping("/add")
    public String addFrom(@ModelAttribute("member") LoginDTO member) {
        return "members/addMemberFrom";
    }

}
