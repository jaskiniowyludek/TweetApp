package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

@Controller
public class LoginController {
    @Autowired
    private Validator validator;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PostMapping("/login")
    public String userLogged(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userRepository.findByUsername(username);
        if (user!=null){

        }
        return "homepage";
    }
}
