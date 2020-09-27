import java.util.ArrayList;

public abstract class Question{
    private String question;

    public Question() {}

    public Question(String q) {
        question = q;
    }

    public String getQuestion() {
        return question;
    }

    public abstract boolean validateAnswer(String answer); // checks if answer submitted is correct type

    public abstract void printQuestionResult(ArrayList<String> answers); // prints result of question

}
