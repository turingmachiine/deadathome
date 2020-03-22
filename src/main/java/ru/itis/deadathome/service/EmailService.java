package ru.itis.deadathome.service;

public interface EmailService {
    void sendMail(String subject, String text, String email);
}
