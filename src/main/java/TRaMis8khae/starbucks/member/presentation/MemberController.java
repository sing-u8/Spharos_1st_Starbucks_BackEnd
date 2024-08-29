package TRaMis8khae.starbucks.member.presentation;

import TRaMis8khae.starbucks.member.application.MemberService;
import TRaMis8khae.starbucks.member.dto.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("api/v1/member") // 임시
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/sign-up") // 임시
    public String signUpForm(Model model) {
        model.addAttribute("memberSignUpDto", new MemberSignUpDto());
        return "signup_form";
    }

    @PostMapping("/sign-up") // 임시
    public ResponseEntity<String> signUp(@ModelAttribute MemberSignUpDto memberSignUpDto) {
        log.info("memberSignUpDto : {}", memberSignUpDto);
        memberService.signUp(memberSignUpDto);
        return ResponseEntity.ok("Member registered successfully.");
    }
}
