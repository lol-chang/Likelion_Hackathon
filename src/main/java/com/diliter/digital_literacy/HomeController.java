package com.diliter.digital_literacy;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


//            loginResult.setMemberX(loginResult.getMemberX()+20);
//            MemberEntity memberEntity = MemberEntity.toMemberEntity(loginResult);
//            memberService.updateMember(memberEntity);

            return "main.html";
        }
        else {
            return "Login.html";
        }
    }



//   클라이언트에서 클릭하면 서버로 통신

    @GetMapping("/test")
    public String testPage() {
        return "test.html";
    }

    @PostMapping("/test")
    @ResponseBody
    public String receiveDataFromClient(@RequestBody String dataFromClient, HttpSession session) {
        System.out.println("Data received from client: " + dataFromClient);
//        MemberDto loginResult = (MemberDto) session.getAttribute("loginId"); // 세션에서 loginResult를 가져옴
//        System.out.println("_______LoginResult : " + loginResult);
//        if (loginResult != null) {
//            loginResult.setMemberX(loginResult.getMemberX() + 20);
//            MemberEntity memberEntity = MemberEntity.toMemberEntity(loginResult);
//            memberService.updateMember(memberEntity);
//        }
        return "Data received";
    }

}
