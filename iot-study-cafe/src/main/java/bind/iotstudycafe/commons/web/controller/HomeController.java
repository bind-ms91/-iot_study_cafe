package bind.iotstudycafe.commons.web.controller;

import bind.iotstudycafe.commons.login.domain.LoginDTO;
import bind.iotstudycafe.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {

    @GetMapping
    public String home(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
        return "/home";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("member") LoginDTO member) {
//
//    }


}
