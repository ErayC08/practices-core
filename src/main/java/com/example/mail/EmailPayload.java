package com.example.mail;

import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.util.List;

public class EmailPayload {
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private List<File> files;
    private String subject;
    private String body;

    private String emailsReduced(List<String> emails) {
        EmailValidator validator = EmailValidator.getInstance();
        StringBuilder builder = new StringBuilder();

        emails.forEach(email -> {
            if (!validator.isValid(email)) {
                throw new InvalidEmailException("The following email is invalid: " + email);
            }
            builder.append(email).append(",");
        });
        return builder.substring(0, builder.length() - 1);
    }

    private List<File> filePathsConverted(List<String> filePaths) {
        return filePaths.stream().map(File::new).toList();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new InvalidEmailException("The following email is invalid: " + email);
        }
        this.from = email;
    }

    public String getTo() {
        return to;
    }

    public void setTo(List<String> emails) {
        this.to = emailsReduced(emails);
    }

    public String getCc() {
        return cc;
    }

    public void setCc(List<String> emails) {
        this.cc = emailsReduced(emails);
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(List<String> emails) {
        this.bcc = emailsReduced(emails);
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<String> filePaths) {
        this.files = filePathsConverted(filePaths);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
