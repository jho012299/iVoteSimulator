import java.util.ArrayList;

public class VotingService {
    private ArrayList<Student> studentList;
    private ArrayList<Question> questionBank;
    private ArrayList<String> answers;

    public VotingService() {
        studentList = new ArrayList<>();
        questionBank = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void addStudent(){ // generates students to add to list
        studentList.add(new Student());
    }

    public void addSingleQuestion(String q, ArrayList<String> options) { // adds Single Choice Question to bank
        questionBank.add(new SingleChoice(q, options));
    }

    public void addMultiQuestion(String q, ArrayList<String> options) { // adds Multiple Choice Question to bank
        questionBank.add(new MultipleChoice(q, options));
    }

    public void submitAnswer(String id, String answer, int questionNum){
        if(!questionBank.get(questionNum).validateAnswer(answer)) {
            System.out.println("Student ID: " + id + " submitted an invalid answer.");
            return;
        }

        for(Student student: studentList) {
            if(student.getId().equals(id)) {
                if(student.getHasAnswered()) {
                    System.out.println("Student ID: " + id  + " has resubmitted their answer.");
                }
                student.setAnswer(answer);
                student.setHasAnswered(true);
            }
        }
    }

    public void printResults(int questionNum){
        for(Student student: studentList) {
            if(student.getAnswer() != null) {
                answers.add(student.getAnswer());
            }
        }
        System.out.println(questionBank.get(questionNum).getQuestion());
        questionBank.get(questionNum).printQuestionResult(answers);
    }

    public String getStudentAt(int i) {
        return studentList.get(i).getId();
    }

    public void reset() {
        for(Student student: studentList) {
            student.setAnswer(null);
            student.setHasAnswered(false);
        }
        answers.clear();
    }

    // no hash map, use regular arraylist or array of students
    // bank of questions (arraylist? array? how to add question to bank?)
    // list of students; how to add student to roster? need methods
    // store answers

    /*// "When a student submits an answer, the program : "
public void submitAnswer(String studentId, String answer, int questionNum){

  // "it should also make sure the answer is a valid answer"
  if(!questions.get(questionNum).validateAnswer(answer)){
    sout("Student " + studentId + " did not give a valid answer.");
    return;
  }

  // "Let me know if the user already answered and changed their mind"
  for( Student stu: ArrayList<Student>){
    if(stu.getID().equals(studentId)){
      if(stu.hasAnswered()){
        sout("Student " + studentId + " rewrote their answer!");
      }
      stu.setAnswer(answer);
    }

  }
}*/

}
