package webLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webLogin.dto.MemberDTO;
import webLogin.member.Member;
import webLogin.repository.MemberRepository;
import webLogin.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String defaultHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            Member member = memberRepository.findByEmail(username).orElse(null);
            if (member != null) {
                model.addAttribute("username", member.getName());
            }
        }
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            Member member = memberRepository.findByEmail(username).orElse(null);
            if (member != null) {
                model.addAttribute("username", member.getName());
            }
        }
        return "home";
    }

    @PostMapping("/member")
    public String signup(MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("No user found with the email: " + email));
        model.addAttribute("username", member.getName());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/myPage")
    public String myPage(){
        return "myPage";
    }

    @GetMapping("/forgot_password")
    public String rePassword(){
        return "reset_password";
    }

    @GetMapping("/edit-profile")
    public String showEditProfileForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("No user found with the email: " + email));

        model.addAttribute("member", member);

        return "edit-profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/login";
    }

    @PostMapping("/delete-account")
    public String deleteAccount(Authentication authentication) {
        String email = authentication.getName();
        memberService.deleteByEmail(email);
        return "redirect:/login?logout";
    }
}