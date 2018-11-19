package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/messages")
    public String showMessages(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Message> received = messageRepository.findAllByReceiverOrderByDateDesc(user);
        List<Message> send = messageRepository.findAllBySenderOrderByDateDesc(user);
        model.addAttribute("received", received);
        model.addAttribute("sent", send);
        return "messages";
    }

    @GetMapping("/sendmsg")
    public String sendMessage(Model model, HttpServletRequest request){
        Message message = new Message();
        int id = Integer.parseInt(request.getParameter("userId"));
        User userReceiver = userRepository.findOne(id);
        model.addAttribute("userReceiver", userReceiver);
        model.addAttribute("message", message);
        return "messageForm";
    }

    @PostMapping("/sendmsg")
    public String sendingMessage(@Valid Message message, BindingResult result, HttpServletRequest request,
                                 Model model){
        if (result.hasErrors()){
//            String confirmation = "Tu jest jakiś błąd!!";
//            model.addAttribute("confirmation", confirmation);
//            return "messageForm";
        }
        HttpSession session = request.getSession();
        User sender = (User) session.getAttribute("user");
        if (sender.getId()==message.getReceiver().getId()){
            String confirmation = "You are trying to send a message to yourself!";
            model.addAttribute("confirmation", confirmation);
            return "messageForm";
        }
        message.setDate(new Date());
        message.setSender(sender);
        messageRepository.save(message);
        String confirmation = "Your message has been sent successfully";
        model.addAttribute("confirmation", confirmation);
        return "messageForm";
    }
}
