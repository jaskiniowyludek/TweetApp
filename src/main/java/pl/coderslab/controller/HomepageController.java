package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.sql.Date;
import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private Validator validator;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String main(){

        return "main";
    }
    @GetMapping("/homepage")
    public String showHomepage(Model model){
        List<Tweet> tweets = tweetRepository.findAllByOrderByDateDesc();
        Tweet tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        model.addAttribute("tweets", tweets);
        return "homepage";
    }

    @PostMapping("/homepage")
    public String processingNewTweet(@Valid Tweet tweet, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()){
            return "homepage";
        }
     //   tweet.setDate(new Date());
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        tweet.setUser(user);
        tweetRepository.save(tweet);
        return "redirect:/homepage";
    }
}
