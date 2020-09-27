import java.util.ArrayList;

public class MultipleChoice extends Question { // class for question that can have multiple answers
    private ArrayList<String> options;

    public MultipleChoice(String question, ArrayList<String> o) {
        super(question);
        options = o;
    }

    @Override
    public boolean validateAnswer(String answer) {
        return answer.length() > 0 && isValidOption(answer);
    }

    @Override
        public void printQuestionResult(ArrayList<String> answers) {
            int[] resultCount = new int[options.size()]; // counts how many answers for each options
            for(int i = 0; i < options.size(); i++) {
                for (int j = 0; j < answers.size(); j++) {
                    for(int k = 0; k < answers.get(j).length(); k++){
                        if (options.get(i).charAt(0) == answers.get(j).charAt(k)) {
                            resultCount[i]++;
                        }
                    }
                }
            }

        for(int i = 0; i < options.size(); i++) {
            System.out.print(options.get(i) + ": " + resultCount[i] + "  ");
        }
        System.out.println("");
        System.out.println("");
    }

    private boolean isValidOption(String answer) { // checks if answer has duplicates or passes an illegal answer
        for(int i = 0; i < answer.length(); i++) {
            if(!options.contains(Character.toString(answer.charAt(i)))) {
                return false;
            }
            for(int j = i + 1; j < answer.length(); j++) {
                if(answer.charAt(i) == answer.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
