package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String processingRegistregion(@Valid User user, BindingResult result, Model model){
        String email = user.getEmail();
        User user1 = userRepository.findByEmail(email);
        if (result.hasErrors()||user1.getEmail().equals(user.getEmail())){
            String errorMessge = "Somebody is already using this email!";
            model.addAttribute("errorMessage", errorMessge);
            return "register";
        }
        userRepository.save(user);
        return "redirect:/userAdded";
    }

    @RequestMapping("/userAdded")
    public String userAdded(){
        return "registrationConfirmed";
    }

    @RequestMapping("/showProfile")
    public String showProfile(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("currentUser", user);
        return "profile";
    }
    @GetMapping("/changeUsername")
    public String changeUsername(HttpServletRequest request, Model model){
//        int id = Integer.parseInt(request.getParameter("userId"));
//        User user = userRepository.findOne(id);
//        model.addAttribute("currentUser", user);
        return "profile/confirmationUsername";
    }
    @PostMapping("/changeUsername")
    public String confirmChange(HttpServletRequest request,
                                Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        int id = user.getId();
       if (BCrypt.checkpw(password, user.getPassword())){
           userRepository.changeUsername(username, user.getId());
           String errorMessge = "Username changed successfully!";
           user = userRepository.findOne(id);
           session.setAttribute("user", user);
           model.addAttribute("currentUser", user);
           model.addAttribute("errorMessage", errorMessge);
           return "profile";
        }
        String errorMessge = "Wrong password!";
        model.addAttribute("errorMessage", errorMessge);
        return "profile/confirmationUsername";
    }
    @GetMapping("/changeEmail")
    public String changeEmail(){
        return "profile/confirmationEmail";
    }
    @PostMapping("/changeEmail")
    public String confirmChangeEmail(HttpServletRequest request,
                                Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int id = user.getId();
        User user1 = userRepository.findByEmail(email);
        if (user1!=null){
            String errorMessge = "Somebody is already using this email!";
            model.addAttribute("errorMessage", errorMessge);
            return "profile/confirmationEmail";
        }
        if (BCrypt.checkpw(password, user.getPassword())){
            userRepository.changeEmail(email, user.getId());
            String errorMessge = "Email address changed successfully!";
            user = userRepository.findOne(id);
            session.setAttribute("user", user);
            model.addAttribute("currentUser", user);
            model.addAttribute("errorMessage", errorMessge);
            return "profile";
        }
        String errorMessge = "Wrong password!";
        model.addAttribute("errorMessage", errorMessge);
        return "profile/confirmationEmail";
    }

    @GetMapping("/changePassword")
    public String changePassword(){
        return "profile/confirmationPassword";
    }
    @PostMapping("/changePassword")
    public String confirmChangePassword(HttpServletRequest request,
                                        Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String password = request.getParameter("newPassword");
        String password2 = request.getParameter("newPassword2");
        String currentPassword = request.getParameter("password");
        int id = user.getId();
        if (!(password.equals(password2))){
            String errorMessge = "Passwords not equals!";
            model.addAttribute("errorMessage", errorMessge);
            return "profile/confirmationPassword";
        }
        if (BCrypt.checkpw(currentPassword, user.getPassword())){
            password = BCrypt.hashpw(password,BCrypt.gensalt());
            userRepository.changePassword(password, user.getId());
            String errorMessge = "Password changed successfully!";
            user = userRepository.findOne(id);
            session.setAttribute("user", user);
            model.addAttribute("currentUser", user);
            model.addAttribute("errorMessage", errorMessge);
            return "profile";
        }
        String errorMessge = "Wrong password!";
        model.addAttribute("errorMessage", errorMessge);
        return "profile/confirmationPassword";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(){
        return "profile/confirmationDelete";
    }
    @PostMapping("/deleteUser")
    public String deleteUserConfirmed(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String password = request.getParameter("password");
        if (BCrypt.checkpw(password,user.getPassword())){
            userRepository.delete(user);
            session.invalidate();
            return "main";
        }
        String errorMessge = "Wrong password!";
        model.addAttribute("errorMessage", errorMessge);
        return "profile/confirmationDelete";
    }

}
//TODO change password- validate new password?? send email to user if forget password. Comments fix!! filter login user