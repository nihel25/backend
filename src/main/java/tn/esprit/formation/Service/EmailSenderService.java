package tn.esprit.formation.Service;

public interface EmailSenderService {

    void sendEmail(String to, String subject, String message);
}

