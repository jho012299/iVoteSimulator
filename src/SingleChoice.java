import java.util.ArrayList;

public class SingleChoice extends Question {
    private ArrayList<String> options;

    public SingleChoice(String question, ArrayList<String> o) {
        super(question);
        options = o;
    }

    @Override
    public boolean validateAnswer(String answer) {
        return answer.length() == 1 && options.contains(answer);
    }

}
