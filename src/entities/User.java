package src.entities;

import java.io.Serializable;

public class User implements Serializable {
   // private static final long serialVersionUID = 9151170513668626160L;
	private Integer id;
	private String userName;
    private String password;
    private String securityQuestion;
    private String securityQuestionAnswer;
    
    public User() {
    		this.id = null;
    		this.userName = null;
    		this.password = null;
    		this.securityQuestion = null;
    		this.securityQuestionAnswer = null;
    }

    public User(String userName, String password, String securityQuestion, String securityQuestionAnswer) {
    		this.id = null;
    		this.userName = userName;
    		this.password = password;
    		this.securityQuestion = securityQuestion;
    		this.securityQuestionAnswer = securityQuestionAnswer;
    }
    
    public User(String userName, String password) {
    		this();
    		this.userName = userName;
    		this.password = password;
    }
    public void setId(Integer id) {
    		this.id = id;
    }
    
    public Integer getId() {
    		return this.id;
    }
    
    public void setUserName(String userName) {
    		this.userName = userName;
    }
    
    public String getUserName() {
    		return this.userName;
    }

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
    public String toString() {
    		return "User{userId = " + this.id +
    				", userName = " + this.userName +
    				", password = " + this.password +
    				", securityQuestion = " + this.securityQuestion +
    				", securityQuestionAnswer = " + this.securityQuestionAnswer;
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
        User other = (User) obj;
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
