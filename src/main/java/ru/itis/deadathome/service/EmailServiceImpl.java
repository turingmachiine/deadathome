package ru.itis.deadathome.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private Configuration configuration;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userName;

    @Override
    public void sendMail(String subject, String text, String email) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(userName);
            messageHelper.setTo(email);
            messageHelper.setSubject(subject);
            messageHelper.setText(getEmailText(text), true);

        };

        javaMailSender.send(messagePreparator);
    }

    private String getEmailText(String text) {
        try {
            Template template = configuration.getTemplate("mail.ftl");
            System.out.println("template loaded successfully");
            Map<String, Object> root = new HashMap<>();
            root.put("confirm_code", text);
            StringWriter out = new StringWriter();
            template.process(root, out);
            System.out.println("data inserted successfully");
            return out.toString();
        } catch (IOException | TemplateException e) {
            return "failed to load html-template, but you need to open this link http://localhost:8081/confirm/" + text;
        }
    }
}
