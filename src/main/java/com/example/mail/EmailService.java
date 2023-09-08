package com.example.mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EmailService {
    private final Properties properties;
    private final Session session;

    public EmailService(String host, String port, String username, String password) {
        properties = configureProperties(host, port);
        session = configureSession(username, password);
    }

    public EmailService(String username, String password) {
        properties = configureProperties();
        session = configureSession(username, password);
    }

    private Properties configureProperties() {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        return properties;
    }

    private Properties configureProperties(String host, String port) {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        return properties;
    }

    private Session configureSession(String username, String password) {
        return Session.getInstance(this.properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private Message configureMessage(String from, String to, String cc, String bcc, List<File> files, String subject, String body) throws MessagingException {
        Message message = new MimeMessage(this.session);

        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
        message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
        message.setSubject(subject);

        Multipart multipart = new MimeMultipart();
        files.forEach(file -> {
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            try {
                attachmentBodyPart.attachFile(file);
                multipart.addBodyPart(attachmentBodyPart);
            } catch (IOException | MessagingException e) {
                throw new RuntimeException(e);
            }
        });
        MimeBodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setContent(body, "text/html; charset=utf-8");
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

        return message;
    }

    public Message configureMessage(EmailPayload emailPayload) throws MessagingException {
        return configureMessage(
                emailPayload.getFrom(),
                emailPayload.getTo(),
                emailPayload.getCc(),
                emailPayload.getBcc(),
                emailPayload.getFiles(),
                emailPayload.getSubject(),
                emailPayload.getBody()
        );
    }

    public void configureMessageAndSend(EmailPayload emailPayload) throws MessagingException {
        Transport.send(configureMessage(emailPayload));
    }
}
