package src.entities;

import java.io.Serializable;

public class Password implements Serializable {
   // private static final long serialVersionUID = 9151170513668626160L;

    private String password;
    private String securityQuestion;
    private String securityQuestionAnswer;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }

    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + password.hashCode();
        result = prime * result + ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
        result = prime * result + ((securityQuestionAnswer == null) ? 0 : securityQuestionAnswer.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Password other = (Password) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (securityQuestion == null) {
            if (other.securityQuestion != null)
                return false;
        } else if (!securityQuestion.equals(other.securityQuestion))
            return false;
        if(securityQuestionAnswer == null) {
            if(other.securityQuestionAnswer != null) {
                return false;
            }
        }else if(!securityQuestionAnswer.equals(other.securityQuestionAnswer)) {
            return false;
        }
        return true;
    }
}
