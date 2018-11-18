package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/showUser")
    public String showUserDetails(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.findOne(id);
        List<Tweet> userTweets = tweetRepository.findAllByUserOrderByDateDesc(user);
        model.addAttribute("tweets", userTweets);
        model.addAttribute("user",user);
        return "user";
    }
}
