package tn.esprit.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.formation.Repository.MessageRepository;
import tn.esprit.formation.Service.MessageService;
import tn.esprit.formation.Service.UserServiceimpl;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("send")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserServiceimpl userService;


    @GetMapping("/ask")
    public String askQuestion(@RequestParam("question") String question) {
        return messageService.getResponse(question);
    }


}












//






//    @GetMapping("/messages")
//    public ResponseEntity<List<Message>> getMessages(
//            @RequestParam Long senderId,
//            @RequestParam Long receiverId) {
//
//        User sender = userService.getUserById(senderId);
//        User receiver = userService.getUserById(receiverId);
//
//
//
//        List<Message> messages = messageService.getChat(sender, receiver);
//        return ResponseEntity.ok(messages);
//    }


















