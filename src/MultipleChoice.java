import java.util.ArrayList;

public class MultipleChoice extends Question {
    private ArrayList<String> options;

    public MultipleChoice(String question, ArrayList<String> o) {
        super(question);
        options = o;
    }

    @Override
    public boolean validateAnswer(String answer) {
        return answer.length() > 0 && isValidOption(answer);
    }

    private boolean isValidOption(String answer) {
        for(int i = 0; i < answer.length(); i++) {
            if(!options.contains(Character.toString(answer.charAt(i)))) {
                return false;
            }
            for(int j = i; j < answer.length(); j++) {
                if(answer.charAt(i) == answer.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
