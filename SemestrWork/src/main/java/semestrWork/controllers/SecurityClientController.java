package semestrWork.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import semestrWork.model.User;
import semestrWork.security.UserDetailImpl;
import semestrWork.security.UserDetailsServiseImpl;
import semestrWork.service.UserService;

@Controller
@RequestMapping("/client")
public class SecurityClientController {

    Logger log = LoggerFactory.getLogger(SecurityClientController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiseImpl userDetailsServise;

    @Autowired
    private AuthenticationManager authenticationManager;

    private HttpSessionSecurityContextRepository contextRepository = new HttpSessionSecurityContextRepository();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String mainPage(Model model) {
        return "clientmain";
    }

    @GetMapping("/registration")
    public String regPage(Model model) {
        log.debug("registration debug");
        log.warn("registration");
        return "clientregpage";
    }

    @RequestMapping("/registercheck")
    String register(HttpServletRequest request, HttpServletResponse response, Model model) {
        if (userService.existsUserByUsername(request.getParameter("name"))) {
            model.addAttribute("error", "Такой пользователь уже есть");
            return "clientregpage";
        }
        String password = request.getParameter("password");
        String encodedPassword = passwordEncoder.encode(request.getParameter("password"));
        User user = new User();
        user.setUsername(request.getParameter("name"));
        user.setPassword(encodedPassword);
        user.setEmail(request.getParameter("email"));

        try {
            user = userService.save(user);

            UserDetailImpl userDetail = new UserDetailImpl(user);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userDetail, password);
            Authentication authentication = authenticationManager.authenticate(authRequest);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            SecurityContext securityContext = SecurityContextHolder.getContext();

            contextRepository.saveContext(securityContext, request, response);
            log.warn("context : " + SecurityContextHolder.getContext());
            return "redirect:clientaccount";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "clientregpage";
        }
    }

    @GetMapping("/clientaccount")
    public String clientAccountPage() {
        return "clientaccount";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        log.info("login");
        return "clientlogin";
    }
}
