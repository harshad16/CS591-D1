package com.company.entities;

public class Credential {

    private Integer id;
    private String password;
    private String answerToSecurityQuestion;

    private final String  securityQuestion = "What's name of your mother?";

    public Credential() {
        this.id = null;
        this.password = null;
        this.answerToSecurityQuestion = null;
    }

    public Integer getId() {
        return id;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "Credential{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", answerToSecurityQuestion='" + answerToSecurityQuestion + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnswerToSecurityQuestion() {
        return answerToSecurityQuestion;
    }

    public void setAnswerToSecurityQuestion(String answerToSecurityQuestion) {
        this.answerToSecurityQuestion = answerToSecurityQuestion;
    }

    public Credential(Integer id, String password, String answerToSecurityQuestion) {
        this.id = id;
        this.password = password;
        this.answerToSecurityQuestion = answerToSecurityQuestion;
    }
}
