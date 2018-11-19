package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private Validator validator;

    @GetMapping("/showUser")
    public String showUserDetails(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.findOne(id);
        List<Tweet> userTweets = tweetRepository.findAllByUserOrderByDateDesc(user);
        model.addAttribute("tweets", userTweets);
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/tweet")
    public String showTweet(HttpServletRequest request, Model model){
        int id= Integer.parseInt(request.getParameter("id"));
        Tweet tweet = tweetRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByTweetOrderByDateDesc(tweet);
        Comment comment = new Comment();
        model.addAttribute("comments", comments);
        model.addAttribute("tweet", tweet);
        model.addAttribute("newComment", comment);
        return "tweet";
    }
    @PostMapping("/tweet")
    public String saveComment(@Valid Comment newComment, BindingResult result, HttpServletRequest request, Model model){
        if (result.hasErrors()){
            return "tweet";
        }
        newComment.setDate(new Date());
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        newComment.setUser(user);
        int id= Integer.parseInt(request.getParameter("tweetId"));
        Tweet tweet = tweetRepository.findOne(id);
        newComment.setTweet(tweet);
        commentRepository.save(newComment);
        model.addAttribute("id", id);
        return "redirect:/tweet";
    }
}
