import java.util.ArrayList;

public class VotingService {
    private ArrayList<Student> studentList; // list of participating students
    private ArrayList<Question> questionBank; // list of questions available to ask
    private ArrayList<String> answers; // list of submitted answers

    public VotingService() {
        studentList = new ArrayList<>();
        questionBank = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void addStudent(){ // generates students to add to list
        studentList.add(new Student());
    } // generates a new student

    public void addSingleQuestion(String q, ArrayList<String> options) { // adds Single Choice Question to bank
        questionBank.add(new SingleChoice(q, options));
    }

    public void addMultiQuestion(String q, ArrayList<String> options) { // adds Multiple Choice Question to bank
        questionBank.add(new MultipleChoice(q, options));
    }

    public void submitAnswer(String id, String answer, int questionNum){
        if(!questionBank.get(questionNum).validateAnswer(answer)) {
            System.out.println("Student ID: " + id + " submitted an invalid answer."); // checks if answer can be accepted or not
            return;
        }

        for(Student student: studentList) {
            if(student.getId().equals(id)) {
                if(student.getHasAnswered()) {
                    System.out.println("Student ID: " + id  + " has resubmitted their answer."); // notifies whenever a student resubmits
                }
                student.setAnswer(answer);
                student.setHasAnswered(true); // confirms that student has answered and will check if student submits again
            }
        }
    }

    public void printResults(int questionNum){
        for(Student student: studentList) {
            if(student.getAnswer() != null) {
                answers.add(student.getAnswer()); // adds answers from students that answered
            }
        }
        System.out.println(questionBank.get(questionNum).getQuestion()); // prints question
        questionBank.get(questionNum).printQuestionResult(answers); // prints results
    }

    public String getStudentAt(int i) {
        return studentList.get(i).getId(); // returns the id of a student through index
    }

    public void reset() { // resets student and wipes answer bank
        for(Student student: studentList) {
            student.setAnswer(null);
            student.setHasAnswered(false);
        }
        answers.clear();
    }
}
