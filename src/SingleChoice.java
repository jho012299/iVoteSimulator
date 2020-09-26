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

    @Override
    public void printQuestionResult(ArrayList<String> answers) {
        int[] resultCount = new int[options.size()];
        for(int i = 0; i < options.size(); i++) {
            for (String answer : answers) {
                if (options.get(i).equals(answer)) {
                    resultCount[i]++;
                }
            }
        }

        for(int i = 0; i < options.size(); i++) {
            System.out.print(options.get(i) + ": " + resultCount[i] + "  ");
        }
        System.out.println("");
    }

}
