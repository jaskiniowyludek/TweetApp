package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

@Controller
public class LoginController {
    @Autowired
    private Validator validator;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLogin(){

        return "login";
    }

    @PostMapping("/login")
    public String verifyLogin(HttpServletRequest request, HttpServletResponse response, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userRepository.findByUsername(username);
        if (user!=null){
            if (BCrypt.checkpw(password, user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

            }else {
                String errorMessge = "Wrong username or password!";
                model.addAttribute("errorMessage", errorMessge);
                return "login";
            }
        }else {
            String errorMessge = "Wrong username or password!";
            model.addAttribute("errorMessage", errorMessge);
            return "login";
        }
        return "redirect:/homepage";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String processingRegistregion(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "register";
        }
        userRepository.save(user);
        return "redirect:/userAdded";
    }

    @RequestMapping("/userAdded")
    public String userAdded(){
        return "registrationConfirmed";
    }
}
