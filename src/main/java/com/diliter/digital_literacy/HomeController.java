package com.diliter.digital_literacy;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.diliter.digital_literacy.MemberDto;

import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "main.html";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "Login.html";
    }

    @GetMapping("/resister")
    public String saveForm() {
        return "Resister.html";
    }

    @PostMapping("/resister")
    public String save(@ModelAttribute MemberDto memberDto) {
        memberService.save(memberDto);
        return "Login.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
        MemberDto loginResult = memberService.login(memberDto);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberID());
            return "main.html";
        }
        else {
            return "Login.html";
        }
    }


}
