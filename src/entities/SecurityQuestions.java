package src.entities;

import java.util.ArrayList;
import java.util.Random;

public class SecurityQuestions
{
    private Random randomGenerator;
    private ArrayList<String> questions;

    public SecurityQuestions()
    { 
    	randomGenerator = new Random();
    	questions = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
		{
    		add("What is your favorite Course?");
    		add("What is your favorite Color?");
    		add("What is your favorite Pet?");
    	}};
    }

    public String getSecurityQuestion()
    {
        int index = randomGenerator.nextInt(questions.size());
        String item = questions.get(index);
        return item;
    }
    
    public ArrayList<String> getAllQuestions() {
    	return questions;
    }
    
    public void addQuestions(String s) {
    	questions.add(s);
    }
}



