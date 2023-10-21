package tn.esprit.formation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.formation.Repository.MessageRepository;
import tn.esprit.formation.Repository.UserRepository;
import tn.esprit.formation.entity.Message;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    UserServiceimpl userService;


    public String getResponse(String question) {
        Message message = messageRepository.findByQuestion(question);
        return (message != null) ? message.getResponse() : "Je ne comprends pas la question.";
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}