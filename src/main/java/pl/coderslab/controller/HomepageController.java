package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.UserRepository;

import javax.validation.Validator;

@Controller
public class HomepageController {

    @Autowired
    private Validator validator;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String main(){

        return "main";
    }
}
